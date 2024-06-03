package DataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataSupplier {
	int startRow = 1; // positive mandatory 1-2, DataType 3-7,
	int endRow = 1; // Length 8-11, Number 12-13

	@DataProvider(name = "dataContainer1")
	// @Test
	public String[][] excelDataSupplier() throws IOException {
		FileInputStream file = new FileInputStream(
				"D:\\Eclipsework\\SolarLadderAssignment\\TestData\\SolarLadderExcel.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = Workbook.getSheet("Unit");
		int row = endRow - startRow + 1;
        //int row= sheet.getPhysicalNumberOfRows();
        //System.out.println(row);
		int col = sheet.getRow(0).getLastCellNum();
        //System.out.println(col);
		String[][] data = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + startRow + 1).getCell(j));

			}
			System.out.println();
		}
//		for (String[] s1 : data) {
//			System.out.println(Arrays.toString(s1));
//		}

		Workbook.close();
		file.close();
		return data;
	}

	@DataProvider(name = "dataContainer") 	
	public String[][] excelDS() throws IOException {
		FileInputStream file = new FileInputStream(
				"D:\\Eclipsework\\SolarLadderAssignment\\TestData\\SolarLadderExcel.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = Workbook.getSheet("Integration");

		int row = sheet.getPhysicalNumberOfRows();
		// System.out.println(row);
		int col = sheet.getRow(0).getLastCellNum();
		// System.out.println(col);
		String[][] data = new String[row - 2][col];
		for (int i = 0; i < row - 2; i++) {
			for (int j = 0; j < col; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 2).getCell(j));
			}
			System.out.println();
		}
//		for (String[] s1 : data) {
//			System.out.println(Arrays.toString(s1));
//		}
		Workbook.close();
		file.close();
		return data;
	}
}
