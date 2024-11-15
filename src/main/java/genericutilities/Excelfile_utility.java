package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Kavya
 * This class consists of generic methods related to Excel file
 */
public class Excelfile_utility {
	/**
	 * This method read data from Excel file and returns value.
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	
	public String readDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata1.xlsx");
		Workbook Wb=WorkbookFactory.create(fis);
		Sheet sh=Wb.getSheet(sheetName);
		Row rw=	sh.getRow(rowNo);
		Cell cl=rw.getCell(cellNo);
		String value=cl.getStringCellValue();
		return value;
		
	}
}
