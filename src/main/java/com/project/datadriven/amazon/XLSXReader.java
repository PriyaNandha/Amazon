package com.project.datadriven.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {

	public static String value;
	public static String particularData(String sheet, int row, int cell) throws InvalidFormatException, IOException {
		
		
		
		File f= new File("E:\\Java 2022\\ipt project\\Project.xlsx");
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fi);
		
		Sheet s = w.getSheet(sheet);
		
		Row r = s.getRow(row);
		
		Cell c = r.getCell(cell);
		
		CellType ct = c.getCellType();
		
		if (ct.equals(CellType.STRING)) {
			
			value = c.getStringCellValue();
			
			System.out.println(value);
			
		} else if (ct.equals(CellType.NUMERIC)) {
			
			double d = c.getNumericCellValue();
			int a = (int) d;
			
			System.out.println(a);
		} 
		return value;	
	}
	
}
