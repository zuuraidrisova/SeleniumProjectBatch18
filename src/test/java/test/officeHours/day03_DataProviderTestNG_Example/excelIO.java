package test.officeHours.day03_DataProviderTestNG_Example;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class excelIO {


    @Test
    public void readExcelFile(){

        try(FileInputStream file = new FileInputStream("VytrackTestUsers.xlsx")){

            //Workbook is an interface implemented XSSWorkBook and HSSWorkBook
            //XSSWorkBook - create an object of .xlsx file
            //HSSWorkBook = create an object of .xls file
            Workbook workbook = WorkbookFactory.create(file);

            //object of Sheet used to represent excel file page
            //because 1 excel document can have many spreadsheets
            Sheet sheet = workbook.getSheet("QA1-short");

            //read first row
            Row row = sheet.getRow(0);

            //read a cell
            Cell cell = row.getCell(0);

            //read a value from first row and first column
            System.out.println(cell);

            int columnNumber = row.getPhysicalNumberOfCells();

            //print every cell in first row
            for (int i = 0; i < columnNumber; i++){

                System.out.print(row.getCell(i)+" ");

            }

            System.out.println();

            //to get number of rows
            int rowNumber = sheet.getPhysicalNumberOfRows();

            //print all rows of first, second and third columns
            for(int i = 0; i < rowNumber; i++){

                System.out.print(sheet.getRow(i).getCell(0)+"                          ");
                System.out.print(sheet.getRow(i).getCell(1)+"                ");
                System.out.println(sheet.getRow(i).getCell(2));
            }

            System.out.println("=============================================================");

            //to store data of excel file into 2d array
            String [][] dataTable = new String[rowNumber][columnNumber];

            for(int rowIndex = 0; rowIndex < rowNumber; rowIndex++){


                for(int cellIndex = 0; cellIndex < columnNumber; cellIndex++){

                    String value = sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();

                    System.out.format("%15s",value);

                    dataTable[rowIndex][cellIndex] = value;
                }

                System.out.println();
            }

            System.out.println("======================================================");

            System.out.println(Arrays.deepToString(dataTable));
        }catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
   public void writeToExcelFile(){

        //input == read
        //output == write

        try (FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx")){

            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheet("QA1-short");

            Row row = sheet.getRow(1);//get second row

            row.getCell(5).setCellValue("passed");


              FileOutputStream fileOutputStream = new FileOutputStream("VytrackTestUsers.xlsx");

              workbook.write(fileOutputStream);

              fileOutputStream.close();


        }catch (Exception e){

            e.printStackTrace();
        }

   }

}
