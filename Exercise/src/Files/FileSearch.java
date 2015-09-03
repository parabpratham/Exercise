package Files;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;

import javax.swing.event.ListDataEvent;

public class FileSearch implements Runnable{
	
	static LinkedList<String> filesFound = new LinkedList<String>();
	
	static int noOfMatchingFiles =1;
	File rootFile;
	String searchName;
	ListDataEvent de;
	public FileSearch(File rootFile,String searchName) {
		// TODO Auto-generated constructor stub
		this.rootFile = rootFile;
		this.searchName = searchName;
	}
	public boolean searchFile(File rootFile,String searchName)
	{
		
		File[] files = rootFile.listFiles();
		for(File searchFile:files)
		{
			String fileName = searchFile.getName();
			//System.out.println(fileName);
			if(fileName.contains(searchName))
				{
					//filesFound.add(searchFile.getAbsolutePath());
						
				}
			//return false;
		}
		
		//Try subDirectory
		File[] childFiles = rootFile.listFiles();
		for(File childFile:childFiles)
		{

			String fileName = childFile.getName();
		//	System.out.println(childFile.getAbsolutePath());
			
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
		// TODO Auto-generated method stub
		searchFile(rootFile, searchName);
		
	}

//	public static void main(String[] args)
//	{
//		String searchName = javax.swing.JOptionPane.showInputDialog("Input File Name");
//		File root = new File("E:");
//		boolean found=false;
//		
//		found =searchFile(root,searchName);
//		System.out.println("");
//		
//		if(!(filesFound.size()==0))
//		{
//			System.out.println("File found at :");
//			int cnt=1;
//			for(String fileName:filesFound)
//			{
//				
//				System.out.println((cnt++)+ "> " + fileName);
//			}
//		}
//		else
//		{
//			System.out.println(" No File found");
//			
//		}
//		
//	}

	
}
