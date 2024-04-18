package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh= wb.getSheet(sheetName);
	 String value=sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
	 return value;
}


public int readDataFromExcelRowCount(String SheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	 Workbook wb = WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet(SheetName);
	int rowCount=sh.getLastRowNum();
	return rowCount;
}

public int readDataFromExcelCellCount(String SheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	 Workbook wb = WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet(SheetName);
	int cellCount=sh.getRow(0).getLastCellNum();
	return cellCount;
}

public void writeDataIntoExcelString (String SheetName, int rowNo, int cellNo, String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(SheetName);
	sh.createRow(rowNo).createCell(cellNo).setCellValue(data);
	FileOutputStream fOut = new FileOutputStream(IPathConstant.ExcelPath);
	wb.write(fOut);
	wb.close();
}

public HashMap<String,String> readMultipleData(String sheetName, int cellNO) throws EncryptedDocumentException, IOException
{
FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int rowCount = sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
	for(int i=0; i<+rowCount; i++) 
	{
		String key = sh.getRow(i).getCell(cellNO).getStringCellValue();
		String value = sh.getRow(i).getCell(cellNO).getStringCellValue();
		map.put(key, value);
	}
		return map;
	}
}
