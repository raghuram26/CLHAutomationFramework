package com.clh.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
   private static Workbook ExcelWBook;
   private static Sheet ExcelWSheet;
   private static org.apache.poi.ss.usermodel.Cell Cell;

   // This method is to set the File path and to open the Excel file, Pass Excel
   // Path and Sheetname as Arguments to this method
   public static void setExcelFile(String Path, String SheetName)
         throws Exception {
      try {
         // Open the Excel file
         FileInputStream ExcelFile = new FileInputStream(Path);
         // Access the required test data sheet
         ExcelWBook = WorkbookFactory.create(ExcelFile);
         ExcelWSheet = ExcelWBook.getSheet(SheetName);
      } catch (Exception e) {
         throw (e);
      }
   }

   
   public static Object[][] getTableArray(String FilePath, String SheetName)
         throws Exception {
      String[][] tabArray = null;
      try {
         FileInputStream ExcelFile = new FileInputStream(FilePath);
         ExcelWBook = WorkbookFactory.create(ExcelFile);
         ExcelWSheet = ExcelWBook.getSheet(SheetName);
         int startCol = 1;
         int totalRows = getRowUsed();
         int totalCols = 2;
         tabArray = new String[totalRows][totalCols];
         for (int ci = 0; ci < totalRows; ci++) {
            for (int cj = 0, j = startCol; j <= totalCols; j++, cj++) {
               tabArray[ci][cj] = getStringCellData(ci + 1, j);
            }
         }
      } catch (FileNotFoundException e) {
         System.out.println("Could not read the Excel sheet");
         e.printStackTrace();
      } catch (IOException e) {
         System.out.println("Could not read the Excel sheet");
         e.printStackTrace();
      }
      return (tabArray);
   }

   public static String getStringCellData(int RowNum, int ColNum) throws Exception {
      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      String CellData = Cell.getStringCellValue();
      return CellData;
   }

   public static int getIntegerCellData(int RowNum, int ColNum)
         throws Exception {
      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      int CellData = (int) Cell.getNumericCellValue();
      return CellData;
   }

   //Getting the count of Rows used
   public static int getRowCount(String filePath, String sheetName) throws Exception{
      setExcelFile(filePath, sheetName);
      return ReadExcel.getRowUsed();
   }
   
   public static int getColumnCount(String filePath, String sheetName) throws Exception{
      setExcelFile(filePath, sheetName);
      Row r = ExcelWSheet.getRow(1);
      return (r.getLastCellNum()-1);
   }
   
   public static int getRowContains(String sTestCaseName, int colNum)
         throws Exception {
      int i;
      try {
         int rowCount = ReadExcel.getRowUsed();
         for (i = 0; i < rowCount; i++) {
            if (ReadExcel.getStringCellData(i, colNum)
                  .equalsIgnoreCase(sTestCaseName)) {
               break;
            }
         }
         return i;
      } catch (Exception e) {
         throw (e);
      }
   }

   public static int getRowUsed() throws Exception {
      try {
         int RowCount = ExcelWSheet.getLastRowNum();
         return RowCount;
      } catch (Exception e) {
         System.out.println(e.getMessage());
         throw (e);
      }

   }

   public static int getColUsed() throws Exception {
      try {
         int ColCount = ExcelWSheet.getColumnWidth(1);
         return ColCount;
      } catch (Exception e) {
         System.out.println(e.getMessage());
         throw (e);
      }

   }
}