package InitialInformation;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadData {
	
	//This method reads the excel file which must contain data related to the testcases
	public static String[] readData(String fileName, String testName) {
		
		System.out.println("==============Reading Data=============");
		String array[];
		array = new String[16];//This is the number of cell in each row of the excel file, but it is irrelevant the quantity
		
	    try
	    {

	        FileInputStream file = new FileInputStream(new File(fileName));
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext())
	        {
	            Row row = rowIterator.next();
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();
	            
	            int count = 0;

	            Cell test = cellIterator.next();
	            if(!test.getStringCellValue().equals(testName)) {
                	continue;
                }
	            while (cellIterator.hasNext()) 
	            {
	                Cell cell = cellIterator.next();
	                //Check the cell type and format accordingly
	                
	                switch (cell.getCellType()) 
	                {
	                    case Cell.CELL_TYPE_NUMERIC:
	                    	array[count++] = String.valueOf((int)cell.getNumericCellValue());
	                    	//System.out.print(cell.getNumericCellValue() + " ");
	                        break;
	                    case Cell.CELL_TYPE_STRING:
	                    	array[count++] = cell.getStringCellValue();
	                    	
	                    	//System.out.print(cell.getStringCellValue() + " ");
	                        break;
	                }
	            }
	            //System.out.println(Arrays.toString(array));
	            }
	  
	        //System.out.println(Arrays.toString(array));
	        	workbook.close();
	            file.close();
	            return array;
	        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		return null;
	}
}

