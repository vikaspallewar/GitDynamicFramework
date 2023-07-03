package Common_API_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_Utility_Method {

	public static void EvidenceCreator(String Filename, String RequestBody, String ResponseBody, int statusCode)
			throws IOException {

		File TextFile = new File("D:\\MS Square\\Automation Testing\\RestAssured\\Evidence\\" + Filename + ".txt");
		System.out.println("New Blank Text File of Name : " + TextFile.getName());

		FileWriter dataWrite = new FileWriter(TextFile);

		dataWrite.write("Request Body is :  " + RequestBody + "\n\n");
		dataWrite.write("Status Code  is :  " + statusCode + "\n\n");
		dataWrite.write("Response Body is : " + ResponseBody + "\n\n");

		dataWrite.close();
		System.out.println("Request Body and Response Body Written In Text File : " + TextFile.getName());
	}

	public static ArrayList<String> ReadDataExcel(String sheetname, String Testcasename) throws IOException {

		ArrayList<String> ArrayData = new ArrayList<String>();
		// Create the object of file input stream to locate the excel file
		FileInputStream Fis = new FileInputStream(
				"D:\\MS Square\\Automation Testing\\RestAssured\\TestCase\\File.xlsx");

		// Open the excel file by creating the Object XSSF Workbook
		XSSFWorkbook Workbook = new XSSFWorkbook(Fis);

		// Open desired Sheet
		int countofsheet = Workbook.getNumberOfSheets();
		for (int i = 0; i < countofsheet; i++) {
			String Sheetname = Workbook.getSheetName(i);
			// Access the desired Sheet
			if (Sheetname.equalsIgnoreCase(sheetname)) {
				// use XSSF Sheet to save the sheet into the variable
				XSSFSheet Sheet = Workbook.getSheetAt(i);

				// create iterator through rows and find out in which column test case names are
				// found
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();

				// create the iterator through the cells of first row to find out which cell
				// contains test case name
				Iterator<Cell> CellsOfFirstRow = FirstRow.cellIterator();
				int k = 0;
				int TC_Column = 0;
				while (CellsOfFirstRow.hasNext()) {
					Cell CellValue = CellsOfFirstRow.next();
					if (CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						TC_Column = k;
						// System.out.println("expected column for TestCase Name:" +k);
						break;
					}
					k++;
				}
				// verify the row where the desired test case is found and fetch the entire row
				while (Rows.hasNext()) {
					Row DataRow = Rows.next();
					String TCName = DataRow.getCell(TC_Column).getStringCellValue();
					if (TCName.equalsIgnoreCase(Testcasename)) {
						Iterator<Cell> CellValues = DataRow.cellIterator();
						while (CellValues.hasNext()) {
							// String Data = CellValues.next().getStringCellValue();
							// ArrayData.add(Data);

							String Data = "";
							Cell CurrentCell = CellValues.next();
							try {
								String StringData = CurrentCell.getStringCellValue();
								Data = StringData;
							} catch (IllegalStateException e) {
								double doubledata = CurrentCell.getNumericCellValue();
								Data = Double.toString(doubledata);
							}
							ArrayData.add(Data);

						}
						break;
					}
				}

			}

		}
		return ArrayData;

	}
}
