package Files;

import java.awt.*;
import java.awt.Event.*;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.*;

public class MySearchFrame extends JFrame{
	
	JLabel label1,label2 ;
	JTextField field1,field2,fieldPath;
	JButton stopButton;
	JButton searchButton;
	JTextArea textArea;
	Thread searchThread,endthread;
	JButton temp = new JButton();
	String tempString = "Files Found:";
	String  label;
	boolean isFinished,isStop;
	Thread tStop;
	
	public MySearchFrame()
	{
		setBounds(100,100,100000,10000000);
		setBackground(Color.yellow);
		label1 = new JLabel("Enter Location:");
		field1 = new JTextField(30);
		label2 = new JLabel("Enter file name:");
		field2 = new JTextField(30);
		fieldPath = new JTextField(50);
		fieldPath.setText("FILE:");
		stopButton = new JButton("Stop");
		searchButton = new JButton("Search");
		stopButton.setEnabled(false);
		textArea = new JTextArea("Files Found: \n",40,80);
		textArea.setAutoscrolls(false);
		JPanel panel = new JPanel();
		//ActionListener event;
		SearchClasEvent event;
		event = new SearchClasEvent();
		searchButton.addActionListener(event);
		stopButton.addActionListener(event);
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(new JSeparator(SwingConstants.VERTICAL));
		panel.add(searchButton);
		panel.add(stopButton);
		panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		panel.add(textArea);
		textArea.setLocation(0, 0);
		panel.add(fieldPath);
		//panel.add(scroll);
		getContentPane().add(panel);
		setVisible(true);
	}
	
	class SearchClasEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{	
			if(e.getSource() == searchButton)
			{
				isFinished = false;
				searchButton.setEnabled(false);
				File rootFile = new File(field1.getText());
				textArea.setText("Files found :\n");
				//tStop.destroy();
				if(rootFile.exists())
				{			
					searchThread = new Thread(new FileSearch(rootFile,field2.getText()));
					searchThread.setPriority(Thread.MIN_PRIORITY);
					searchThread.setDaemon(true);
					searchThread.setName("Search");
					searchThread.start();
					tStop = new Thread(new EndSearch());
					tStop.start();
					stopButton.setEnabled(true);
				}
				else
				{
					System.out.print("No file found");
					
				}
				
			}
			if(e.getSource() == stopButton)
			{
				searchThread.stop();
				searchThread.destroy();
				stopButton.setEnabled(false);
				searchButton.setEnabled(true);
				tStop.stop();
				tStop.destroy();
			}
		}
	}
	public class EndSearch implements Runnable
	{

		public void run() {
			
			while(!isFinished)
			{}
			searchButton.setEnabled(true);
			stopButton.setEnabled(false);
			fieldPath.setText("");
		}
		
	}
	public class FileSearch implements Runnable{
		
		LinkedList<String> filesFound = new LinkedList<String>();		
		File rootFile;
		String searchName;
		
		public FileSearch(File rootFile,String searchName) {
		
			this.rootFile = rootFile;
			this.searchName = searchName;
			
		}
		
		public boolean searchFile(File rootFile,String searchName)
		{
			
			File[] files = rootFile.listFiles();
			
			for(File searchFile:files)
			{
				String fileName = searchFile.getName();
				fieldPath.setText(searchFile.getAbsolutePath());
				if(fileName.contains(searchName))
					{
						filesFound.add(searchFile.getAbsolutePath());
						textArea.append("\n"+searchFile.getAbsolutePath());
						tempString = tempString + "\n"+searchFile.getAbsolutePath();
						System.out.println(searchFile.getAbsolutePath());
						return false;
					}
			}
			
			//Try subDirectory
			File[] childFiles = rootFile.listFiles();
			for(File childFile:childFiles)
			{

				String fileName = childFile.getName();				
				if(!childFile.isFile())
					try
					{
						
						if(searchFile(childFile,searchName))
								return false;
							
					}
				catch(Exception ex)
					{
				        System.out.println("Error AT: ");
						System.out.println(childFile.getAbsolutePath());
							return false;
					}
			}
			return false;
		}

		public void run() {
			
			searchFile(rootFile, searchName);
			fieldPath.setText("Finished");
			isFinished = true;
			searchButton.setEnabled(true);
			stopButton.setEnabled(false);
		}
	}
}