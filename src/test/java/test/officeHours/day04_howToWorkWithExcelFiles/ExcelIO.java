package test.officeHours.day04_howToWorkWithExcelFiles;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExcelIO {


    @Test
    public void readExcelFile(){

        try{

            //we pass the path of our excel file into constructor
            FileInputStream file = new FileInputStream("VytrackTestUsers.xlsx");

            //XSSFWorkbook - to create an object of .xlsx files
            //HSSFWorkbook - to create an object of  .xls files
            //Workbook is an interface that is implemented by XSSFWorkbook and HSSFWorkbook

            // workbook represents whole excel file
            Workbook workbook = WorkbookFactory.create(file);

            // sheets represents each page in excel file, one excel file can have many sheets
            Sheet sheet = workbook.getSheet("QA1-short");

            //to read first row
            Row row = sheet.getRow(0);//indexes start from 0

            //to read  first cell
            Cell cell = row.getCell(0);

            //print the value of 1st row and 1st column

            System.out.println("cell value = " + cell);

            System.out.println("=============================================================");

            //to get the  number of cells in the row
            int columnNumber = row.getPhysicalNumberOfCells(); //to get how many cells in row

            System.out.println("columnNumber = " + columnNumber);

            System.out.println("=============================================================");

            for (int i = 0; i < columnNumber; i++){

                System.out.print(row.getCell(i)+" ");
            }

            System.out.println();
            System.out.println("=============================================================");

            //to get row numbers
            int rowNumber = sheet.getPhysicalNumberOfRows();//to get how many rows in sheet

            System.out.println("rowNumber = " + rowNumber);
            System.out.println("=============================================================");


            //print all rows of first, second and third columns
            for (int i = 0; i < rowNumber; i++){

                System.out.print(sheet.getRow(i).getCell(0)+"               ");
                System.out.print(sheet.getRow(i).getCell(1)+"               ");
                System.out.print(sheet.getRow(i).getCell(2)+"               ");
                System.out.println();
            }

            System.out.println();
            System.out.println("=============================================================");

            //nested loop is for printing entire table with all rows and cells in it
            for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++){
                //outer for loop is responsible for switching  row indexes

                for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++){
                    //inner for loop is responsible for switching  cell indexes

                    System.out.print(sheet.getRow(rowIndex).getCell(columnIndex)+"  ");

                }

                System.out.println();
            }

            System.out.println("=============================================================");

            //to save sheet information into 2D array
            String [][] dataTable = new String[rowNumber][columnNumber];

            //nested loop is for storing table into 2D ARRAY
            for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++){
                //outer for loop is responsible for switching  row indexes

                for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++){
                    //inner for loop is responsible for switching  cell indexes

                    String value =sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();

                   System.out.format("%15s", value);

                    dataTable[rowIndex][columnIndex] = value;

                }

                System.out.println();
            }

            System.out.println("=============================================================");

            System.out.println(Arrays.deepToString( dataTable));

            System.out.println("=============================================================");



            //we have to close the file we opened
            file.close();

        }catch (IOException e){

            e.printStackTrace();
        }



    }


    @Test
    public void writeIntoExcelFile(){

        //read = inputStream
        //write = outputStream

        //always close excel file while writing otherwise it will crash

        try (FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx");){

            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheet("QA1-short");

            Row row = sheet.getRow(2);//will get second row

            //write Passed to second row sixth column
            row.getCell(5).setCellValue("Passed!");


            FileOutputStream fileOutputStream = new FileOutputStream("VytrackTestUsers.xlsx");

            workbook.write(fileOutputStream);//to write updates to the file

            fileOutputStream.close();


        }catch (IOException e){

            e.printStackTrace();
        }
    }



}
