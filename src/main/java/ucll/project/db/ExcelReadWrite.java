package ucll.project.db;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ucll.project.domain.user.Gender;
import ucll.project.domain.user.Role;
import ucll.project.domain.user.User;

import java.io.*;
import java.util.*;


public class ExcelReadWrite {

    public ExcelReadWrite() {

    }

    public static void read() {
        try {
            File excel = new File("src/main/java/resources/Map1.xlsx");
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            while (itr.hasNext()) {
                Row row = itr.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(List<User> users) {
        try {
            File excel = new File("src/main/java/resources/Map1.xlsx");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            XSSFWorkbook book = new XSSFWorkbook();
            XSSFSheet sheet = book.createSheet("Users");
            Map<Integer, User> newData = new HashMap<>();

            int counter = 1;

            for (User user : users) {
                newData.put(counter, user);
                counter++;
            }
            Set<Integer> newRows = newData.keySet();
            int rownum = sheet.getLastRowNum();
            for (Integer key : newRows) {
                Row row = sheet.createRow(rownum++);
                User objArr = newData.get(key);
                int cellnum = 0;

                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(objArr.getUserId());

                Cell cell2 = row.createCell(cellnum++);
                cell2.setCellValue(objArr.getUserName());

                Cell cell3 = row.createCell(cellnum++);
                cell3.setCellValue(objArr.getFirstName());

                Cell cell4 = row.createCell(cellnum++);
                cell4.setCellValue(objArr.getLastName());

                Cell cell5 = row.createCell(cellnum++);
                cell5.setCellValue(objArr.getEmail());

                Cell cell6 = row.createCell(cellnum++);
                cell6.setCellValue(objArr.getGender().getGender());

                Cell cell7 = row.createCell(cellnum++);
                cell7.setCellValue(objArr.getRole().getRole());

                Cell cell8 = row.createCell(cellnum++);
                cell8.setCellValue(objArr.getHashedPassword());
            }

            book.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
