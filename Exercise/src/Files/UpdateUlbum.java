package Files;

import java.io.File;

import javax.media.Format;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

import org.farng.mp3.MP3File;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;

public class UpdateUlbum
{

	public static void main(String[] args)
	{
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder", new Format[]
		{ input1, input2 }, new Format[]
		{ output }, PlugInManager.CODEC);
		File directory = new File("F:/Songs/Marathi/New Movies And Albums/AJAY ATUL/");
		listSongDetails(directory);
	}

	public static void listSongDetails(File directory)
	{
		File[] listFiles = directory.listFiles();
		for (File file : listFiles)
		{
			if (file.isDirectory())
			{
				listSongDetails(file);
			}
			else
			{
				try
				{
					if (file.getName().contains(".mp3"))
					{
						MP3File mp3 = new MP3File(file.getAbsolutePath());
						System.out.print(file.getName().replace(".mp3", ""));
						ID3v1 tag = mp3.getID3v1Tag();
						AbstractID3v2 tag2 = mp3.getID3v2Tag();
						tag.setArtist("AJAY ATUL");
						tag.setTitle(file.getName().replace(".mp3", ""));
						tag2.setLeadArtist("AJAY ATUL");
						mp3.setID3v1Tag(tag);
						mp3.setID3v2Tag(tag2);
						mp3.save();
						// System.out.print(" ---- "+tag2.getLeadArtist());
						System.out.println();
					}
				}
				catch (Exception e)
				{
					System.out.println("  ----  " + e.getMessage());
				}
			}// TODO: handle exception
		}
	}
}
