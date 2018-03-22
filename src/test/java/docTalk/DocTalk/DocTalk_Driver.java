package docTalk.DocTalk;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DocTalk_Driver {

	public  static String Sign_Up_Execute_status;
	public  static String Sign_In_Execute_status;

	@SuppressWarnings("resource")
	public static void main(String args[]) throws Throwable
	{
		DocTalk_Functional dt = new DocTalk_Functional();

		//Creating a sheet where user has put his test cases---
		String path = System.getProperty("user.dir")+"\\TestSheet\\DocTalk.xlsx";
		File file = new File(path);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook inputExcel = new XSSFWorkbook(inputstream);
		Sheet data = inputExcel.getSheet("DocTalk_Run");


		Sign_Up_Execute_status = data.getRow(1).getCell(1).getStringCellValue();
		Sign_In_Execute_status = data.getRow(2).getCell(1).getStringCellValue();

		System.out.println("Execution Status for the Sign_Up Test case --> "+ Sign_Up_Execute_status);
		System.out.println("Execution Status for the Sign_In Test case --> "+ Sign_In_Execute_status);

		// checking for the SignUp test case

		if (Sign_Up_Execute_status.equals("Yes"))
		{
			dt.signUP();
		}
		else
		{
			System.out.println("Relative SignUp Test Case is not selected");
		}

		// checking for the SignIn test case

		if(Sign_In_Execute_status.equals("Yes"))
		{
			dt.signIn();
		}
		else
		{
			System.out.println("Relative SignIn Test Case is not selected");
		}
	}}