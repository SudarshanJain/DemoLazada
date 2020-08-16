package com.excel
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static org.apache.poi.ss.usermodel.CellStyle.*
import static org.apache.poi.ss.usermodel.IndexedColors.*

import java.awt.*;

import org.apache.poi.hssf.usermodel.*
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData


public class WriteExcel {


	@Keyword
	public void demoKey(String name) throws IOException{

		FileInputStream fis = new FileInputStream("C:\\Katalon Automation\\BerjayaSompoInsurance\\Data Files\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("ExecutionFile");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Row row = sheet.createRow(rowCount+1);
		Cell cell = row.createCell(0);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(name);
		FileOutputStream fos = new FileOutputStream("C:\\Katalon Automation\\BerjayaSompoInsurance\\Data Files\\TestData.xlsx");
		workbook.write(fos);
		fos.close();
	}
	//}


	//'Read data from excel'
	//String Data_fromCell=sheet.getRow(1).getCell(1).getStringCellValue();
	//'Write data to excel'
	//sheet.getRow(1).createCell(1).setCellValue("Mahesh2");
	@Keyword
	private static int findRow(String inputSheetname,String cellContent) {
		TestData accounts = findTestData('DataFile')
		//	println accounts.getSourceUrl()
		FileInputStream fis = new FileInputStream(accounts.getSourceUrl());
		//FileInputStream fis = new FileInputStream("C:\\Automation\\Takaful\\ProposalCreation\\Data Files\\InputData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(inputSheetname);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
						//	JOptionPane.showMessageDialog(null, "Message goes here" + row.getRowNum());
						return row.getRowNum();
					}
				}
			}
		}
		return 0;
	}

	@Keyword
	public void WriteResulttoExcel(String inputSheetname, String name, String tcName) throws IOException{
		//	FileInputStream fis = new FileInputStream("C:\\Automation\\Takaful\\ProposalCreation\\Data Files\\InputData.xlsx");
		TestData accounts = findTestData('DataFile')
		//	println accounts.getSourceUrl()
		FileInputStream fis = new FileInputStream(accounts.getSourceUrl());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(inputSheetname);
		int icolumnnumber = 4;
		//	int rowCount =  findRow(tcName);
		//	Row row = sheet.createRow(rowCount);
		//	Cell cell = row.createCell(3);
		//	cell.setCellType(cell.CELL_TYPE_STRING);
		//	cell.setCellValue(name);
		//	sheet.getRow(rowCount).createCell(3).setCellValue(name);
		//	XSSFFont cellfont= workbook.createFont();
		//	XSSFFont cellfont= sheet.getRow(rowCount).createFont();
		//	cellfont.setColor("GREEN");
		int rowCount =  findRow(inputSheetname,tcName);


		XSSFCellStyle my_style = workbook.createCellStyle();
		/* Create XSSFFont object from the workbook */
		XSSFFont my_font=workbook.createFont();
		/* set the weight of the font */


		my_font.setBold(true);


		//my_font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);


		/* Also make the font color to RED */
		//	my_font.setColor(XSSFFont.COLOR_BLUE);
		if (name.equals('PASSED'))
		{
			my_font.setColor(new XSSFColor(Color.GREEN));
			icolumnnumber = 3;
			/* attach the font to the style created earlier */
		}

		else
		{
			my_font.setColor(new XSSFColor(Color.RED));
			icolumnnumber = 3;

		}

		my_style.setFont(my_font);

		//	int rowCount =  findRow(tcName);
		//	sheet.getRow(rowCount).createCell(3).setCellValue(name);

		//	Row row = workbook.createRow(0);
		/* Create a cell */


		/* Create a cell */
		Cell cell = sheet.getRow(rowCount).createCell(icolumnnumber);

		cell.setCellValue(name);
		/* Attach the style to the cell */
		cell.setCellStyle(my_style);
		/* Write changes to the workbook */


		//	XSSFFont font = (XSSFFont) wb.createFont();
		//	font.setColor(new XSSFColor( Color.decode("#7CFC00")));

		FileOutputStream fos = new FileOutputStream(accounts.getSourceUrl());
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	public void WriteResulttoExcel(String inputSheetname, String name, String tcName,Integer columnNumber) throws IOException{
		//	FileInputStream fis = new FileInputStream("C:\\Automation\\Takaful\\ProposalCreation\\Data Files\\InputData.xlsx");
		TestData accounts = findTestData('DataFile')
		//	println accounts.getSourceUrl()
		FileInputStream fis = new FileInputStream(accounts.getSourceUrl());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(inputSheetname);
		int icolumnnumber = columnNumber;
		//	int rowCount =  findRow(tcName);
		//	Row row = sheet.createRow(rowCount);
		//	Cell cell = row.createCell(3);
		//	cell.setCellType(cell.CELL_TYPE_STRING);
		//	cell.setCellValue(name);
		//	sheet.getRow(rowCount).createCell(3).setCellValue(name);
		//	XSSFFont cellfont= workbook.createFont();
		//	XSSFFont cellfont= sheet.getRow(rowCount).createFont();
		//	cellfont.setColor("GREEN");
		int rowCount =  findRow(inputSheetname,tcName);


		XSSFCellStyle my_style = workbook.createCellStyle();
		/* Create XSSFFont object from the workbook */
		XSSFFont my_font=workbook.createFont();
		/* set the weight of the font */

		my_font.setBold(true);
		//my_font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		/* Also make the font color to RED */
		//	my_font.setColor(XSSFFont.COLOR_BLUE);
		if (name.equals('PASSED'))
		{
			my_font.setColor(new XSSFColor(Color.GREEN));
			icolumnnumber = 3;
			/* attach the font to the style created earlier */
		}

		if (name.equals('Incomplete Execution - Failed'))
		{
			my_font.setColor(new XSSFColor(Color.RED));
			icolumnnumber = 3;
			/* attach the font to the style created earlier */
		}

		my_style.setFont(my_font);

		//	int rowCount =  findRow(tcName);
		//	sheet.getRow(rowCount).createCell(3).setCellValue(name);

		//	Row row = workbook.createRow(0);
		/* Create a cell */


		/* Create a cell */
		Cell cell = sheet.getRow(rowCount).createCell(icolumnnumber);

		cell.setCellValue(name);
		/* Attach the style to the cell */
		cell.setCellStyle(my_style);
		/* Write changes to the workbook */


		//	XSSFFont font = (XSSFFont) wb.createFont();
		//	font.setColor(new XSSFColor( Color.decode("#7CFC00")));

		FileOutputStream fos = new FileOutputStream(accounts.getSourceUrl());
		workbook.write(fos);
		fos.close();
	}

}




