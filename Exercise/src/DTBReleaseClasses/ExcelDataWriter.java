package DTBReleaseClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataWriter{
	
	private HSSFWorkbook workBook;
	private HSSFSheet sheet;
	public Integer rowNumber = 0;
//	private Short SheetNumber; 
	private FileOutputStream fos;
	private Boolean writeColumnHeading = false;
	
	Map<String,String> headerMap = new HashMap<String, String>();
	
	public ExcelDataWriter(String fileName)
	{
		try {
			
			headerMap.put("File Name","1");
			headerMap.put("Path","2");
			headerMap.put("Folder inside the Codepatch","3");
			headerMap.put("size","4");
			
			
			fos = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workBook = new HSSFWorkbook();
		sheet = workBook.createSheet("sheet1");	
	}
	
	public void writeHeaderRow(Map<String, String> fields) throws Exception {
		Set<String> set = fields.keySet();
		if(rowNumber == 0 ) {
			
			HSSFRow row = sheet.createRow(rowNumber);
//			Integer cNo =0;
//			for (String cellNo : set) 
//			{
//				cNo++;
//				writeCell(row,cNo.toString(),cellNo);
//			}
		}
		rowNumber = rowNumber+1;
		HSSFRow row = sheet.createRow(rowNumber);
		Integer cNo =0;
		for (String cellNo : set) 
		{
			cNo++;
			writeCell(row,cNo.toString(),fields.get(cellNo));
		}

	}
	
	
	public  void writeRow(Map<String, String> fields) throws Exception {
		Set<String> set = fields.keySet();
		if(rowNumber < 0 )
		{
			rowNumber = 0;
		}
		if(rowNumber == 0 ) {
			HSSFRow row = sheet.createRow(rowNumber);
			Integer cNo =0;
//			for (String cellNo : set) 
//			{
//				cNo++;
//				writeCell(row,cNo.toString(),cellNo);
//			}
		}
		rowNumber = rowNumber+1;
		HSSFRow row = sheet.createRow(rowNumber);
		Integer cNo =0;
		for (String cellHeader : set) 
		{
			String cellNo=headerMap.get(cellHeader);
			writeCell(row,cellNo.toString(),fields.get(cellHeader));
		}

	}
	
	private void writeCell(HSSFRow row, String cellNo, String value)throws Exception {
		
		HSSFCell cell = row.createCell(new Short(""+(Integer.parseInt(cellNo)-1)));
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(value);
	}
	
	public void flush()
	{
		try{
			fos.flush();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {

		if(workBook != null)
			try {
				workBook.write(fos);
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}