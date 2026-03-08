package com.automation.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getLoginData() throws Exception {

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/LoginData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {

            for (int j = 0; j < colCount; j++) {

                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();

            }
        }

        workbook.close();
        return data;
    }
}