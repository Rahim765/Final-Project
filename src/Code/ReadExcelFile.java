package Code;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ReadExcelFile {
    boolean tekrar;
    ArrayList<String> list = new ArrayList<String>();

    public void readexcelfile(String path,ArrayList<String> arrayList)
    {
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
        try
        {
            File file = new File(path);   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext())
                {

                    Cell cell = cellIterator.next();
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                            for (int i = 0; i <list.size() ; i++) {
                                if (cell.getStringCellValue().equals(list.get(i)))
                                {
                                    tekrar=true;
                                }
                            }
                            if (tekrar==false) {
                                PrintWriter printWriter = new PrintWriter(new FileWriter("Files/Form_SabtName.txt", true));
                                printWriter.print(cell.getStringCellValue() + " ");
                                printWriter.flush();
                                break;
                            }
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                            PrintWriter printWriter1 = new PrintWriter(new FileWriter("Files/Form_SabtName.txt",true));
                            DataFormatter fmt = new DataFormatter();
                            String valueAsSeenInExcel1 = fmt.formatCellValue(cell);
                            arrayList.add(valueAsSeenInExcel1);
                            if (tekrar==false) {
                                String valueAsSeenInExcel = fmt.formatCellValue(cell);
                                printWriter1.print(valueAsSeenInExcel + " ");
                                printWriter1.print(valueAsSeenInExcel + " ");
                                printWriter1.println(valueAsSeenInExcel);
                                printWriter1.flush();
                                break;
                            }
                            break;

                        default:
                    }

                }
                tekrar=false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public void readexcelfile2(String path)
    {

        try
        {
            File file = new File(path);   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType())
                    {

                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                            BufferedReader bufferedReader = new BufferedReader(new FileReader("Files/Form_SabtName.txt"));
                            DataFormatter fmt = new DataFormatter();
                            while (true)
                            {
                                String line = bufferedReader.readLine();

                                if (line==null) {
                                    break;
                                }

                                String[] s = line.split(" ");
                                String valueAsSeenInExcel = fmt.formatCellValue(cell);
                                if (valueAsSeenInExcel.equals(s[3]))
                                {
                                    list.add(s[0]);
                                }



                            }
                            break;
                        default:
                    }
                }

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
