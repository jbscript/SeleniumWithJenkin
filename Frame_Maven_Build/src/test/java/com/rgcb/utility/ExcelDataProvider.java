/**
 * 
 */
package com.rgcb.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Jabir Jaleel
 *
 */
public class ExcelDataProvider {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	File src;
	
	
	public ExcelDataProvider() {
		src = new File(".\\TestData\\Data.xlsx");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			//HSSFWORKBOOK USE IF FILE TYPE IS .XLS
		}catch (Exception e) {
			System.out.println("Can NOT Read Excel File " + e.getMessage());
		}
			
		
	}
		
	
	
	

	
	//OVERLOADING SAME METHOD NAME BUT DIFFERENT ARGUMENTS
	public String getStringData(String SheetName,int row,int col) {
	    sheet = wb.getSheet(SheetName);
		String Data=sheet.getRow(row).getCell(col).getStringCellValue();
		return Data;
	}
	
	public String getStringData(int Sheetindex,int row,int col) {
		
		sheet = wb.getSheetAt(Sheetindex);
		String Data=sheet.getRow(row).getCell(col).getStringCellValue();
		return Data;
	}
	
	public int ExcelNumberOfRow(String SheetName) {
		sheet = wb.getSheet(SheetName);
		return sheet.getLastRowNum();
		
	}
	
	
	public void ExcelInsertData(String SheetName,int row,int col,String value) throws Exception {
		sheet= wb.getSheet(SheetName);
		sheet.getRow(row).createCell(col).setCellValue(value);
		FileOutputStream fout =new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		
		
	}

}
