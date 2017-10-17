package com.freecrm.uiAutomation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public File f;
	public FileInputStream fis;

	public XSSFWorkbook wbWorkBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelUtil() throws Exception {
		f = new File(ResourceUtil.getResourcePath("TestData.xlsx"));
		fis = new FileInputStream(f);
		wbWorkBook = new XSSFWorkbook(fis);
	}

	public String getDataFromExcel(String sheetname, String col, int rowindex) {
		try {
			sheet = wbWorkBook.getSheet(sheetname);
			row = sheet.getRow(0);
			int colIndex = 0;
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(col)) {
					colIndex = i;
					// System.out.println("i = "+i);
					break;
				}
			}
			row = sheet.getRow(rowindex);
			cell = row.getCell(colIndex);
			return cell.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String[][] getTestData(String sheetName) {
		String dataset[][] = null;
		try {
			sheet = wbWorkBook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum() + 1;
			int colCount = sheet.getRow(0).getLastCellNum();
			// System.out.println(rowCount+","+colCount);
			dataset = new String[rowCount - 1][colCount];
			for (int i = 1; i < rowCount; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					cell = row.getCell(j);
					dataset[i - 1][j] = cell.getStringCellValue();
					// System.out.println(cell.getStringCellValue());
				}
			}
			return dataset;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * public static void main(String[] args) throws Exception { ExcelUtil obj =
	 * new ExcelUtil(); System.out.println(obj.getTestData("NewContact"));
	 * 
	 * }
	 */

}
