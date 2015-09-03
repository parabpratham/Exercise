package ClientServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket serverSocket = new ServerSocket(8881);
		Socket socket = serverSocket.accept();
		String[] quo = {"1.","2.","3.","4.","5.","6."};
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		java.io.DataInputStream dis = new java.io.DataInputStream(socket.getInputStream());
		
		int quoteNo = Integer.parseInt(dis.readUTF());
		dos.writeUTF(quo[quoteNo -1]);
	}
	

}
