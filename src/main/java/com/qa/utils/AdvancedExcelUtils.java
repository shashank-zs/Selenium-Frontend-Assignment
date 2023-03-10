package com.qa.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class AdvancedExcelUtils {

    public static Object[][] getDataXssf(String path,String sheetName) throws IOException {
        try {
            int rowIndex=0,columnIndex=0;
            FileInputStream file = new FileInputStream(new File(path));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            Iterator<Row> rowIterator = sheet.iterator();
            Row row=rowIterator.next();
            while (rowIterator.hasNext())
            {
                row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType())
                    {
                        case NUMERIC:
                            if (cell.getNumericCellValue() % 1 == 0 ) {
                                if(Integer.MIN_VALUE > cell.getNumericCellValue() || Integer.MAX_VALUE< cell.getNumericCellValue()){
                                    data[rowIndex][columnIndex]= (long) cell.getNumericCellValue();
                                }else{
                                    data[rowIndex][columnIndex] = (int) cell.getNumericCellValue();
                                }
                            }else if(Float.MIN_VALUE<=cell.getNumericCellValue() &&  cell.getNumericCellValue()<=Float.MAX_VALUE){
                                data[rowIndex][columnIndex]=(float)cell.getNumericCellValue();
                            }else{
                                data[rowIndex][columnIndex]=cell.getNumericCellValue();
                            }
                            break;
                        case STRING:
                            if(cell.getStringCellValue().equalsIgnoreCase("null")) {
                                data[rowIndex][columnIndex]=null;
                            }else if(cell.getStringCellValue().startsWith("“") && cell.getStringCellValue().endsWith("”")) {
                                data[rowIndex][columnIndex]= cell.getStringCellValue().substring(1,cell.getStringCellValue().length()-1);
                            }else {
                                data[rowIndex][columnIndex]= cell.getStringCellValue();
                            }
                            break;
                        case BOOLEAN:
                            data[rowIndex][columnIndex]=cell.getBooleanCellValue();
                            break;
                        case BLANK:
                            data[rowIndex][columnIndex]=null;
                            break;
                    }
                    columnIndex=columnIndex+1;
                }
                rowIndex=rowIndex+1;
                columnIndex=0;
            }
            file.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

