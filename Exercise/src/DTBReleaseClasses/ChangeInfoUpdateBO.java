package DTBReleaseClasses;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ChangeInfoUpdateBO {

	public static void main(String[] args) {

		String filePath = "";
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			File file = new File(filePath);
			if (file != null && file.isFile()) {
				fis = new FileInputStream(file);
				StringBuffer line = new StringBuffer("");
				line = new StringBuffer(dis.readLine());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
