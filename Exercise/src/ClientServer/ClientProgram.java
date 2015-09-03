package ClientServer;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import org.omg.CORBA.DataInputStream;

public class ClientProgram {
	
	public static void main(String[] args) throws Exception	{
		
		Socket socket = new Socket("jcifs.samba.org",80);
		InputStream inputStream = socket.getInputStream();
/*		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		java.io.DataInputStream dis = new java.io.DataInputStream(socket.getInputStream());
		dos.writeUTF(JOptionPane.showInputDialog("Enter qno"));
		System.out.print("asd");
		System.out.print(dis.readUTF());
*/		
		
		
		
	}

}