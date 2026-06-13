package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders
{
    @DataProvider(name="Login")
    public String[][] getData() throws IOException {
        String path=".\\testData\\LoginData.xlsx";
        ExcelUtility util=new ExcelUtility(path);
        int rowNo= util.getRowNum("Sheet1");
        int cellNo= util.CellNum("Sheet1", rowNo);
        String obj[][]=new String[rowNo][cellNo];
        for(int i=1;i<=rowNo;i++){
            for(int j=0;j<cellNo;j++){
                obj[i-1][j]=util.getCellData("Sheet1",i,j);
            }
        }
        return obj;
    }

//    public static void main(String[] args) throws IOException {
//        String path=".\\testData\\LoginData.xlsx";
//        ExcelUtility util=new ExcelUtility(path);
//        int rowNo= util.getRowNum("Sheet1");
//        int cellNo= util.CellNum("Sheet1", rowNo);
//        System.out.println(rowNo);
//        System.out.println(cellNo);
//        Object obj[][]=new Object[rowNo][cellNo];
//        for(int i=1;i<=rowNo;i++){
//            for(int j=0;j<cellNo;j++){
//                obj[i-1][j]=util.getCellData("Sheet1",i,j);
//            }
//        }
//        for(int i=0;i<rowNo;i++){
//            for(int j=0;j<cellNo;j++){
//                System.out.println(obj[i][j]);
//            }
//        }
//        util.getCellData("Sheet1",rowNo,cellNo);
//        DataProviders data=new DataProviders();
//        System.out.println(data.getData());

    }





