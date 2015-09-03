package JavaGui;

import java.awt.Color;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	JLabel label1,label2;
	JTextField field1,field2;
	JButton button;
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		
		setBounds(200,200,500,400);
		setBackground(Color.yellow);
		label1 = new JLabel("First Name");
		field1 = new JTextField(10);
				
		label2 = new JLabel("Last Name");
		field2 = new JTextField(10);
		
		button = new JButton("Click");
		
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
		
		getContentPane().add(panel);
		setVisible(true);
		
		
	}
	
	

}
