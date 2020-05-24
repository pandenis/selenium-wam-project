package inputdata;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    private String filePath;
    private String fileName;
    private String sheetName;
//    private int rowNum;

    public ExcelReader(String filePath, String fileName, String sheetName) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.sheetName = sheetName;
    }

    private Sheet readExcel(String filePath, String fileName, String sheetName) {

        File file = new File(filePath + "//" + fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Input file isn't exist!");
            e.printStackTrace();

        }
        XSSFWorkbook workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xlsx")) {
            try {
                workbook = new XSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                System.out.println("Please check your input file format");
            }
        } else {

        }

        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }

     public String readRow(int rowNum) {
        Row row = readExcel(filePath, fileName, sheetName).getRow(rowNum);
        int cellNum = 1;
        String value = row.getCell(cellNum).getStringCellValue();
        return value;
    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

}
