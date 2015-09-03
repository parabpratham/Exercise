//package com.aurionpro.cashpro.paypro.transactions.processors.interfaces.qph.constants;
//
//import java.io.FileInputStream;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Set;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//
//import com.aurionpro.cashpro.commons.dataparser.bo.DataLayoutFieldBO;
//import com.aurionpro.cashpro.commons.dataparser.exceptions.ValidationException;
//
//public class ExcelReader {
//
//	private static String filePath = "";
//	FileInputStream fs = null;
//
//	public static void main(String[] args) {
//		FileInputStream fs =null;
//		try {
//			fs = new FileInputStream(filePath);
//			POIFSFileSystem pfs = new POIFSFileSystem(fs);
//			HSSFWorkbook wb = new HSSFWorkbook(pfs);
//
//			Boolean dataNotFound = true;
//			for (int sheetcount = 0; sheetcount < wb.getNumberOfSheets(); sheetcount++) {
//
//				HSSFSheet sheets = (HSSFSheet) wb.getSheetAt(sheetcount);
//				Iterator rows = sheets.rowIterator();
//
//				// to skip for the header lines
//				while (rows.hasNext()) {
//					HSSFRow row = (HSSFRow) rows.next();
//					LinkedHashMap<String, String> map = getNextData(row);
//					addElement(map);
//					dataNotFound = false;
//				}
//
//			}
//
//			// if no data in the file.
//			if (dataNotFound == true)
//				throw new ValidationException("No Data in the file");
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw ex;
//		} finally {
//			fs.close();
//			// WebUtils.delterFileFromServer(filePath);
//
//		}
//
//	}
//
//	private static LinkedHashMap<String, String> getNextData(HSSFRow row)
//			throws ValidationException {
//		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//
//
//		for (DataLayoutFieldBO fieldBO : dataFields) {
//			short column = Short.parseShort(""
//					+ (fieldBO.getSequenceNumber() - 1));
//
//			HSSFCell cell = row.getCell(column);
//
//			if (cell == null) {
//				map.put("" + column, "");
//				continue;
//				// throw new
//				// ValidationException(fieldBO.getDataFieldDispName()+" Not
//				// Found at Sequence "+ (column+1));
//			}
//
//			String dataType = fieldBO.getDataType();
//			int cellType = cell.getCellType();
//
//			// since HSFFCell returning 0(numeric) for date also, need to
//			// findout
//			// the datatype based on DataLayout
//			if (dataType.equals("4")) { // for date cell
//
//				try {
//					map.put("" + cell.getCellNum(), formatDate(cell
//							.getDateCellValue()));
//				} catch (NumberFormatException e) {
//					map.put("" + cell.getCellNum(), cell.getStringCellValue());
//				}
//			} else if (cellType == 0) // for numeric cell
//			{
//				map.put("" + cell.getCellNum(), convertToNumber(cell
//						.getNumericCellValue(), fieldBO.getDataType()));
//
//			}
//
//			else if (cellType == 1) // for String cell
//			{
//				map.put("" + cell.getCellNum(), cell.getStringCellValue());
//			} else if (cellType == 2)
//				System.out.println(cellType + "  " + cell.getCellNum()
//						+ " Formula");
//
//			else if (cellType == 3) // for blank cell
//			{
//				map.put("" + cell.getCellNum(), "  ");
//			} else if (cellType == 4) // for Boolean cell
//			{
//				map
//						.put("" + cell.getCellNum(), ""
//								+ cell.getBooleanCellValue());
//			}
//
//			else if (cellType == 5) // for error cell
//			{
//				throw new ValidationException("The cell at row number "
//						+ row.getRowNum() + "and cell number:"
//						+ cell.getCellNum()
//						+ "is currepted or not readed properly");
//			}
//
//		}
//
//		return map;
//
//	}
//
//}
