package utilities;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtility {

    public File file;
    public FileInputStream fi;
    public FileOutputStream FO;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;

    static String path;
    public ExcelUtility(String path){
        this.path=path;
    }
    public int getRowNum(String sheetName) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetName);
        workbook.close();
        fi.close();
        return sheet.getLastRowNum();
    }
    public int CellNum(String sheetName, int rowNum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetName);
        workbook.close();
        fi.close();
        return sheet.getRow(rowNum).getLastCellNum();
    }
public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {

    fi=new FileInputStream(path);
    workbook=new XSSFWorkbook(fi);
    sheet= workbook.getSheet(sheetName);
    workbook.close();
    fi.close();
    String ob= String.valueOf(sheet.getRow(rowNum).getCell(cellNum));
    return ob;
}
}
