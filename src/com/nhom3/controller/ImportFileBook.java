/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.controller;

import com.nhom3.entity.SachImport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class ImportFileBook {

    public List<SachImport> ImportFile(File file) throws FileNotFoundException, IOException {
        List<SachImport> listBooks = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Lấy Iterator cho tất cả các cell của dòng hiện tại.
            Iterator<Cell> cellIterator = row.cellIterator();

            SachImport aBook = new SachImport();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 1:
                        aBook.setTieuDe((String) getCellValue(nextCell));
                        break;
                    case 2:
                        aBook.setNhaXB(getCellValue(nextCell).toString());
                        break;
                    case 3:
                        aBook.setTenTacGia(getCellValue(nextCell).toString());
                        break;
                    case 4:
                        aBook.setMaTheLoai(getCellValue(nextCell).toString());
                        break;
                    case 5:
                        aBook.setSoLuong(getCellValue(nextCell).toString());
                        break;
                    case 6:
                        aBook.setGiaNhap(getCellValue(nextCell).toString());
                        break;
                    case 7:
                        aBook.setGiaBan(getCellValue(nextCell).toString());
                        break;
                    case 8:
                        aBook.setGioiThieuNgan(getCellValue(nextCell).toString());
                        break;
                }
            }
            listBooks.add(aBook);
        }

        workbook.close();
        inputStream.close();

        return listBooks;

    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return String.valueOf(cell.getStringCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
        }

        return null;
    }
}
