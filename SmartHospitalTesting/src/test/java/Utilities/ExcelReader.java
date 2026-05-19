package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String getData(String testcase, String columnName) {

		String path = "C:\\Users\\dhars\\Documents\\SmartHospitalTestingProject\\SmartHospitalTesting\\src\\test\\resources\\TestData.xlsx";

		try {
			FileInputStream fis = new FileInputStream(path);

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet("Sheet1");

			Row headerRow = sheet.getRow(0);

			int columnIndex = -1;

			for (int i = 0; i < headerRow.getLastCellNum(); i++) {

				if (headerRow.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {

					columnIndex = i;
					break;
				}
			}

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);

				if (row.getCell(0).getStringCellValue().equals(testcase)) {

					return row.getCell(columnIndex).toString();
				}
			}
			
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
}