package Files;

import java.io.File;
import java.io.IOException;

public class SongsPk
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String filePath = "C:\\Users\\user\\Desktop\\songs\\";
		File root = new File(filePath);
		if (root.isDirectory())
			renameDirectory(root);
		else
			try
			{
				renameSongs(root, getFileName(root));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static int renameSongs(File songs, File parentFolder) throws IOException
	{
		if (!parentFolder.exists())
			parentFolder.mkdir();
		System.out.println(songs.getAbsolutePath() + " -- " + parentFolder.getAbsolutePath() + "\\" + getSongName(songs));
		/*
		 * try { new
		 * File(parentFolder.getAbsolutePath()+"//"+getSongName(songs)).createNewFile(); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		// songs.renameTo(new
		// File(parentFolder.getAbsolutePath()+"//"+getSongName(songs)));
		// FileCopy copy = new FileCopy(songs,new
		// File(parentFolder.getAbsolutePath()+"//"+getSongName(songs)));
		// copy.Copy();
		FileCopy1 copy1 = new FileCopy1();
		copy1.copy(songs.getAbsolutePath(), parentFolder.getAbsolutePath() + "//" + getSongName(songs));
		songs.delete();
		return 1;
	}

	private static String getSongName(File song)
	{
		String songName = song.getName();
		String[] split = songName.split("-");
		for (String string : split)
		{
			songName = string.trim();
		}
		return songName;
	}

	private static File getFileName(File directory)
	{
		String directoryName = directory.getName();
		directoryName = directoryName.replace("2013", "");
		directoryName = directoryName.replace("2014", "");
		directoryName = directoryName.replace("-", " ");
		directoryName = directoryName.replace("(Songs.PK)", "");
		directoryName = directoryName.replace("320Kbps", "");
		return new File(directory.getParent() + "\\" + directoryName.trim());
	}

	private static void renameDirectory(File directory)
	{
		File parentDirectory = getFileName(directory);
		System.out.println(parentDirectory.getName().trim());
		int renameSongs;
		// System.out.println(directory.getParent()+"\\"+directoryName.trim());y
		File[] listFiles = directory.listFiles();
		for (File file : listFiles)
		{
			if (file.getName().contains("Zip") || file.getName().contains("zip"))
				continue;
			{
				if (file.isDirectory())
					renameDirectory(file);
				else
					try
					{
						renameSongs = renameSongs(file, parentDirectory);
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		directory.delete();
	}

}
