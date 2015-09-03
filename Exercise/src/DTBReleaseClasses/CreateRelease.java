package DTBReleaseClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.crypto.Data;

import Files.FileCopy;

public class CreateRelease {

	// Declarations
	public static String basePath = "G:\\Office\\DTB release\\";
	public static String workspacePath = "G:\\Office\\DTBv10.0.01\\";

	public static String[] filesInSrcDirectory = {};
	public static String[] destSuffix = { "cashProWeb", "commons-base",
			"commons-distribution", "PayPro", "corporateWeb", "cashProWeb.jar" };
	public static String[] srcSuffix = { "CashProWeb", "Commons", "PayPro",
			"CorporateWeb" };

	public static String releaseFolderPath;
	public static String srcFolderPath;

	public static String destFolder = "";
	public static ExcelDataWriter filePathXLS;

	public static Map<String, String> fieldsMap = new HashMap<String, String>();
	public static Map<String, String[]> srcFilesMap = new HashMap<String, String[]>();
	
	public static String issue = "DTB 54";

	// Initialise Paths
	private static void assignFilepaths() {
		srcFolderPath = basePath + "src\\";
		releaseFolderPath = basePath + "release\\";
	}

	// Create filePath.xls & headers
	public static void fillHeaderFieldMap() throws Exception {

		filePathXLS = new ExcelDataWriter(releaseFolderPath + "FilePath.xls");

		System.out.println("--------Release XLS Created at location---------");
		System.out.println(releaseFolderPath + "FilePath.xls");
		System.out.println("-----------------");

		Map<String, String> headerFieldsMap = new HashMap<String, String>();
		headerFieldsMap.put("File Name", "File Name");
		headerFieldsMap.put("Path", "Path");
		headerFieldsMap.put("Folder inside the Codepatch",
				"Folder inside the Codepatch");
		headerFieldsMap.put("size", "size");

		filePathXLS.writeRow(headerFieldsMap);
		incrRow();
	}

	private static void incrRow() {
		filePathXLS.rowNumber++;
	}

	public static void createReleaseDirectory() throws Exception {
		try {

			assignFilepaths();
			File releaseDirectory = new File(releaseFolderPath);

			System.out.print("--------Deleting release directory ");
			if (releaseDirectory.isDirectory())
				System.out.println(releaseDirectory.delete() + "---------");

			System.out.println("--------ReCreating release directory---------");
			releaseDirectory.mkdir();

			for (String path : destSuffix) {
				File newDir = new File(releaseFolderPath + path);
				System.out.println(releaseFolderPath + path);
				newDir.mkdir();
			}
			System.out.println("--------Release directory Created---------");

			fillHeaderFieldMap();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		create();
	}

	public static void create() throws Exception {

		createReleaseDirectory();

		for (String detString : destSuffix) {
			System.out.println();
			System.out.println("-----Checking for " + detString);
			destFolder = detString;
			if (detString.equalsIgnoreCase("commons-base")
					|| detString.equalsIgnoreCase("commons-distribution")) {
				detString = "Commons";
			}

			if (detString.equalsIgnoreCase("cashProWeb.jar")) {
				detString = "CashProWeb";
			}

			File srcDirectory = new File(srcFolderPath + destFolder + "\\");
			File releaseDirectory = new File(releaseFolderPath + destFolder);
			createRelease(srcDirectory, releaseDirectory, detString);

			incrRow();
		}

		filePathXLS.close();
		copyRelease();
	}

	private static void copyRelease() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
		String todaysDate = dateFormat.format(Calendar.getInstance().getTime());
		String releaseFoldersName = basePath+"\\"+todaysDate+"\\";
		File release = new File(releaseFoldersName);
		release.mkdir();
		releaseFoldersName += issue+"\\";
		release = new File(releaseFoldersName);
		release.mkdir();
		release = new File(releaseFoldersName + "SRN\\");
		release.mkdir();
		release = new File(releaseFoldersName +"CodePatch\\");
		release.mkdir();
		File releaseDirectory = new File(releaseFolderPath);
		FileCopy copy = new FileCopy(release,releaseDirectory);
		copy.Copy();
	}

	private static void fillFieldMap(String fileName, String path, String fic,
			String size) {
		fieldsMap.put("File Name", fileName);
		fieldsMap.put("Path", path);
		fieldsMap.put("Folder inside the Codepatch", fic);
		fieldsMap.put("size", size);
	}

	public static void createRelease(File srcDirectory, File releaseDirectory,
			String detString) {
		filesInSrcDirectory = srcDirectory.list();
		Map<String, String[]> map = new HashMap<String, String[]>();
		System.out.println("--------Traversed "
				+ srcDirectory.getAbsolutePath() + " List size -- "
				+ filesInSrcDirectory.length + "----------");

		if (filesInSrcDirectory != null && filesInSrcDirectory.length > 0) {
			for (String srcFile : filesInSrcDirectory) {
				String[] temp = {};
				srcFilesMap.put(srcFile, temp);
			}
			File workSpaceDirectory = new File(workspacePath + detString
					+ "\\bin");
			visitAllDirs(workSpaceDirectory, detString, map);
		}
		if (map.size() > 0)
			createReleaseDocs(map, detString);
		System.out.println("--------Traversed End----------");
	}

	public String[] getReleaseList(File releaseDirectory) {
		return releaseDirectory.list();
	}

	// Process only directories under dir
	public static void visitAllDirs(File workSpaceDirectory, String suffix,
			Map<String, String[]> map) {

		if (workSpaceDirectory.isDirectory()) {
			map = createMap(workSpaceDirectory, map);
			String[] children = workSpaceDirectory.list();
			for (int i = 0; i < children.length; i++) {
				visitAllDirs(new File(workSpaceDirectory, children[i]), suffix,
						map);
			}

		}
	}

	public static Map<String, String[]> createMap(File dir,
			Map<String, String[]> map) {
		String listFilenames = "";
		try { // read one text file
			String filesInWorkDire[] = dir.list();
			for (int i = 0; i < filesInWorkDire.length; i++) {

				String fileName = filesInWorkDire[i];
				if (fileName.contains("class"))
					fileName = fileName.replace("class", "java");
				if (srcFilesMap.containsKey(fileName)) {

					Double size = (new File(dir.getPath() + "\\" + fileName))
							.length() / 1024.0;
					String[] temp = { dir.getPath(),
							"" + (size.longValue() + 1) };
					if (fileName.endsWith("java")) {
						fileName = fileName.replace("java", "class");
					}
					System.out.println(dir.getPath() + "\\" + fileName);
					map.put(fileName, temp);
				}

				for (String string : filesInSrcDirectory) {
					if (listFilenames.equalsIgnoreCase(string)) {
						Double size = (new File(dir.getPath() + "\\" + string))
								.length() / 1024.0;
						String[] temp = { dir.getPath(),
								"" + (size.longValue() + 1) };
						if (string.endsWith("java")) {
							string = string.replace("java", "class");
						}
						map.put(string, temp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void createReleaseDocs(Map<String, String[]> map,
			String suffix) {
		BufferedWriter bufferedWriter = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String tempText = destFolder + ".jar";
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(
					releaseFolderPath + destFolder + "\\" + tempText + ".txt",
					true));
			Set<String> keySet = map.keySet();
			String temp = "";
			for (String fileName : keySet) {
				fileReader = new FileReader(releaseFolderPath + destFolder
						+ "\\" + tempText + ".txt");
				bufferedReader = new BufferedReader(fileReader);
				boolean istrue = true;
				while (true) {
					String record = bufferedReader.readLine();
					if (record == null || record.length() == 0)
						break;

					if (record.contains(fileName))
						istrue = false;
				}

				if (istrue) {
					if (suffix.equalsIgnoreCase("Commons")
							|| suffix.equalsIgnoreCase("PayPro")) {
						String[] tempArray = map.get(fileName);

						String filePath = tempArray[0].replace(workspacePath
								+ "" + suffix + "\\bin", "");
						filePath = filePath.replace("\\src", "");
						filePath = filePath.replace("\\bin", "");
						filePath = filePath.replace("\\build", "");
						temp = "Copy " + fileName + " in " + tempText
								+ ".jar at following location " + filePath;
						bufferedWriter.append(temp);
						bufferedWriter.newLine();
						String path = "Kindly follow the following steps for replacing file in "
								+ destFolder
								+ ".jar as given in the file:StepsForThe"
								+ tempText + ".txt";
						fillFieldMap(fileName, path, "Inside " + destFolder,
								tempArray[1]);
						filePathXLS.writeRow(fieldsMap);

					}

					if (suffix.equalsIgnoreCase("cashProWeb")
							|| suffix.equalsIgnoreCase("corporateWeb")) {
						if (fileName.contains(".class")) {
							// C:\Icashpro\KenyaTest\Web\Tomcat6\webapps\cashProWeb\WEB-INF\classes\
							String[] tempArray = map.get(fileName);
							String filePath = tempArray[0].replace(
									workspacePath + "" + suffix, "");
							filePath = filePath.replace("\\src", "");
							filePath = filePath.replace("\\bin", "");
							filePath = filePath.replace("\\build", "");
							temp = "Copy " + fileName + " in " + suffix
									+ ".jar at following location " + filePath;
							bufferedWriter.append(temp);
							bufferedWriter.newLine();

							if (!destFolder.equalsIgnoreCase("cashProWeb.jar")) {
								temp = "C:\\Icashpro\\KenyaTest\\Web\\Tomcat6\\webapps\\"
										+ suffix
										+ "\\WEB-INF\\classes\\"
										+ filePath;
								fillFieldMap(fileName, temp,
										"Inside " + suffix, tempArray[1]);
								filePathXLS.writeRow(fieldsMap);
							}
							String path = "Kindly follow the following steps for replacing file in "
									+ suffix
									+ ".jar as given in the file:StepsForThe"
									+ suffix + ".jar.txt";
							fillFieldMap(fileName, path, "Inside " + suffix,
									tempArray[1]);
							filePathXLS.writeRow(fieldsMap);
						} else if (fileName.contains(".jsp")
								|| fileName.contains(".xml")
								|| fileName.contains(".js")
								|| fileName.contains("struts")) {
							String[] tempArray = map.get(fileName);
							String filePath = tempArray[0].replace(
									workspacePath + "" + suffix, "");
							filePath = filePath.replace("\\src", "");
							filePath = filePath.replace("\\bin", "");
							filePath = filePath.replace("\\build", "");
							temp = "C:\\Icashpro\\KenyaTest\\Web\\Tomcat6\\webapps\\"
									+ suffix + filePath;
							fillFieldMap(fileName, temp, "Inside " + suffix,
									tempArray[1]);
							filePathXLS.writeRow(fieldsMap);
						}
					}
				}
			}

			if (bufferedWriter != null) {
				bufferedWriter.flush();
				bufferedWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
