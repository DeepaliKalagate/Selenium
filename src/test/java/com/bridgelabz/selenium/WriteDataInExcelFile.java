package com.bridgelabz.selenium;
import com.bridgelabz.seleniumdriver.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataInExcelFile extends BaseTest
{
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Cell cell;
    Row row;
    @Test
    public void testWriteDataInExcelFile_ShouldReturnSuccessfullyMessage()
    {
        workbook=new XSSFWorkbook();
        sheet=workbook.createSheet("Employee Data");
        Object[][] employeeData={
                {"FName","Lname","MobNo"},
                {"Deepali","Patil","8412989861"},
                {"Lokesh","Patil","7045026292"},
                {"Guru","Patil","8996773440"}
        };
        int rowNum=0;
        System.out.println("Creating Excel");
        for (Object[] studentData1:employeeData)
        {
           row=sheet.createRow(rowNum++);
            int colNum=0;
            for (Object field:studentData1)
            {
                cell=row.createCell(colNum++);
                if (field instanceof String)
                    cell.setCellValue((String)field);
            }
        }
        try
        {
            FileOutputStream fileOutputStream=new FileOutputStream(FILE_PATH);
            workbook.write(fileOutputStream);
            workbook.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
