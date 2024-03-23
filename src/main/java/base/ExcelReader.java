package base;

import org.apache.poi.ss.usermodel.*;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();

    public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
        try {
            File fis = new File(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
            /*if (sh == null) {
                sh = wb.createSheet(SheetName);
            }*/

            this.excelFilePath = ExcelPath;
            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCellData(int rownum, int colnum) throws Exception {
        try {
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        CellData = String.valueOf(cell.getDateCellValue());
                    } else {
                        CellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }

    public String getCellData(String columnName, int rownum) throws Exception {
        return getCellData(rownum, columns.get(columnName));
    }

    public static void main(String[] args) throws Exception {
        ExcelReader excel = new ExcelReader();
        /*excel.setExcelFile("./testData.xlsx", "Sheet1");
        System.out.println(excel.getCellData("fullname", 1));
        System.out.println(excel.getCellData("email", 1));
        System.out.println(excel.getCellData("telephone", 1));*/
        //excel.getCellData(1,1);
        excel.setExcelFile("./testData.xlsx", "Sheet2");
        Object obj[][] = excel.to2DArray();excel.setExcelFile("./testData.xlsx", "Sheet1");
        for(int i=0; i< obj.length;i++){
            for(int j=0;j<obj[i].length;j++){
                System.out.println(obj[i][j]);
            }
        }
    }

    public int getNoOfRows(){
        return sh.getPhysicalNumberOfRows();
    }

    public int getNoOfColumns(){
        return sh.getRow(0).getLastCellNum();
    }

    public Object[][] to2DArray() throws Exception {
        int noOfRows = getNoOfRows()-1;
        int noOfCells = getNoOfColumns();
        Object obj[][] = new Object[noOfRows][noOfCells];

        for(int i=0; i<noOfRows; i++){ //i = 0 1 2
            //row = sh.getRow(i);
            for(int j=0; j<noOfCells; j++){
                obj[i][j] = getCellData(i+1,j); //i = 1 2 3
            }
        }
        return obj;
    }


}