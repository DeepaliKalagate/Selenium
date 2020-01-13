package com.bridgelabz.selenium;
import com.bridgelabz.seleniumdriver.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadDataFromExcelFile extends BaseTest
{
    @Test
    public void testReadDataFromExcelFile_ShouldReturnDataFromFileSuccessfully()
    {
        try
        {
            FileInputStream fileInputStream=new FileInputStream(new File(FILE_PATH));
            Workbook workbook=new XSSFWorkbook(fileInputStream);
            Sheet employeeDataSheet=workbook.getSheetAt(0);
            Iterator<Row> iterator=employeeDataSheet.iterator();
            while (iterator.hasNext())
            {
                Row row=iterator.next();
                Iterator<Cell> cellIterator=row.iterator();
                while (cellIterator.hasNext())
                {
                    Cell cell=cellIterator.next();
                    if (cell.getCellTypeEnum()== CellType.STRING)
                    {
                        System.out.print(cell.getStringCellValue()+"  ");
                    }
                    System.out.print("\n");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
