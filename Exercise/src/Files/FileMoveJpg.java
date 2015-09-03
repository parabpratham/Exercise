package Files;

import java.io.*;
import java.util.LinkedList;

public class FileMoveJpg {
	
	public static void main(String[] args)
	{
		File file;
		String add = "E:/FilePrath/";
		file = new File(add + "/A/" );
		try
		{
			file.exists();
			File[] files =  file.listFiles();

			File newloc = new File(add+"/B/");
			 for(File fileS:files)
			 {
				 String filename =fileS.getName();
				 System.out.println(filename);
				 if(filename.endsWith(".jpg"))
				 {
					 File temp = new File(add+"B/"+filename);
					 
					 boolean b=fileS.renameTo(temp);
					 System.out.println(add+"B/"+filename + " "+b);
					
				 }
				 
			 }
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
