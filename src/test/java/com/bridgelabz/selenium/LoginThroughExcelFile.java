package com.bridgelabz.selenium;
import com.bridgelabz.seleniumdriver.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginThroughExcelFile extends BaseTest
{
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Cell cell;

    @Test
    public void testLoginThroughExcelFile() throws IOException
    {
        // Storing the Application Url in the String variable
        String webURL="http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        // Load the file
        FileInputStream fileInputStream=new FileInputStream(LOGIN_DATA_XLSX);
        // Load he workbook
        workbook=new XSSFWorkbook(fileInputStream);
        // Load the sheet in which data is stored
        sheet=workbook.getSheetAt(0);
        for (int i=1;i<sheet.getLastRowNum();i++)
        {
            // Import data for Email
            cell=sheet.getRow(i).getCell(1);
            cell.setCellType(CellType.STRING);
            driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
            // Import data for password
            cell=sheet.getRow(i).getCell(1);
            cell.setCellType(CellType.STRING);
            driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue());
            FileOutputStream fileOutputStream=new FileOutputStream(LOGIN_DATA_XLSX);
            String message="Data Imported Successfully";
            sheet.getRow(i).createCell(3).setCellValue(message);
            FileOutputStream fileOutputStream1=new FileOutputStream(LOGIN_DATA_XLSX);
            workbook.write(fileOutputStream1);
            fileOutputStream1.close();
        }
    }
}
