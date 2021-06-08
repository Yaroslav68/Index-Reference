package ua.com.prologistic.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Apps {

    public static String parse(String fileName) {
        //инициализируем потоки
        String until = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        until += cell.getStringCellValue() + "=";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        until += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        until += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        until += "|";
                        break;
                }
            }
            until += "\n";
        }

        return until;
    }

}