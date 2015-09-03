package Files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;

public class FileCopy implements Runnable {

	File Source;
	File Destination;

	public FileCopy(File Source, File Destination) {
		this.Source = Source;
		this.Destination = Destination;
	}

	public void Copy(File Source, File Destination) {

		
		
		if (Destination.isFile()) {
			try {
				FileInputStream fileRead = new FileInputStream(this.Source);
				FileOutputStream fileWrite = new FileOutputStream(
						this.Destination);
				BufferedInputStream source = new BufferedInputStream(fileRead);
				BufferedOutputStream destination = new BufferedOutputStream(
						fileWrite);
				byte temp;
				int size = source.available();

				while (!(source.read() == -1)) {
					// System.out.print("1");
					destination.write((byte) source.read());
				}
				destination.flush();
				destination.close();
				//System.out.print("Copied");
				return;

			} catch (FileNotFoundException ex1) {
				System.out.print("File Not Found\n");
				return;
			} catch (EOFException ex) {
				System.out.print("Not copied");
				return;
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}
		} else {
			String[] children = Destination.list();
			if(!Source.exists() && children.length>0)
				Source.mkdir();
			
			for (int i = 0; i < children.length; i++) {
				{
					Copy(new File(Source.getAbsolutePath() +"\\"+children[i]),new File( Destination.getAbsolutePath()+"\\"+children[i]));
				}
			}
		}

	}

	public void Copy() {
		Copy(this.Source, this.Destination);
	}

	public void run() {

		Copy();

	}

}
