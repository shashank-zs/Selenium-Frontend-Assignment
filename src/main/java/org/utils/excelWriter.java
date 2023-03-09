package org.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.utils.dataPath.EXCEL_SHEET_NAME;
import static org.utils.dataPath.EXCEL_SHEET_PATH;

public class excelWriter {
    public void excelWrite(Map<String,String> data ) throws IOException, InvalidFormatException {

        FileInputStream fis=new FileInputStream(EXCEL_SHEET_PATH);
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet(EXCEL_SHEET_NAME);
        ArrayList<String> keysStored = new ArrayList();

        Set<String> keys = data.keySet();
        for (String key : keys) {
            keysStored.add(key);
        }
        for (int i=0;i<keysStored.size();i++){
            Row row = sh.createRow(i+1);
            Cell cell1 = row.createCell(0);
            Cell cell2 =row.createCell(1);
            cell1.setCellValue(keysStored.get(i));
            cell2.setCellValue(data.get(keysStored.get(i)));
        }
        FileOutputStream fos = new FileOutputStream(EXCEL_SHEET_PATH);
        wb.write(fos);
        wb.close();
    }
}
