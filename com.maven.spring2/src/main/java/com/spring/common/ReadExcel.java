package com.spring.common;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.io.File;

/**
 * @author Lee
 * @create 2019/2/22 15:06
 */
public class ReadExcel {
    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

//            for (int j = 0; j < sheet.getColumns(); j++) {
//                for (int i = 0; i < sheet.getRows(); i++) {
//                    Cell cell = sheet.getCell(j, i);
//                    CellType type = cell.getType();
//                    if (type == CellType.LABEL) {
//                        System.out.println("I got a label "
//                                + cell.getContents());
//                    }
//
//                    if (type == CellType.NUMBER) {
//                        System.out.println("I got a number "
//                                + cell.getContents());
//                    }
//
//                }
//            }

           // System.out.println(sheet.getColumns());
            //System.out.println(sheet.getRows());
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    System.out.println(cell.getContents());
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel();
        test.setInputFile("d:/temp/text.xls");
        test.read();
    }

}
