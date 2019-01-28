package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() 
	{
		File src=new File("E:\\krish mem\\java progroms\\foodcourt\\ApplicationData\\testData.xlsx");
		
		try
		{
		FileInputStream fis=new FileInputStream(src);
		
		
		
		wb=new XSSFWorkbook(fis);
		
		}catch(Exception e)
		{
			System.out.println("eception is "+e.getMessage());
		}
	}
	
	public String getData(int Sheetindex,int row,int column)
	{
	String data=	wb.getSheetAt(Sheetindex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String SheetName,int row,int column)
	{
	String data=	wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}


}
