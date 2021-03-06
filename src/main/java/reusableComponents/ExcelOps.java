package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOps {
	
	Sheet sh;
	
	public ExcelOps(){
		String filePath = System.getProperty("user.dir")+"/src/test/resources/TC_Excel.xlsx";
		File file = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(file);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		sh = wb.getSheet("Sheet1");
	}
	
	
	
	public HashMap<String,String> getTestDataInMap(int rowNum) throws EncryptedDocumentException, IOException {		
		HashMap<String,String> hm = new HashMap<String,String>();
		for(int i=0; i< sh.getRow(0).getLastCellNum();i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		return hm;
	}
	
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}
	/*
	 * public static void main(String[] args) throws EncryptedDocumentException,
	 * IOException { ExcelOps exc = new ExcelOps();
	 * System.out.println(exc.getTestData(3)); }
	 */

}
