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
		
		File file = new File("C:\\Users\\axg8832\\eclipse-workspace\\DocTalk\\TestSheet\\DocTalk.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		Workbook inputExcel = new XSSFWorkbook(inputstream);
		Sheet data = inputExcel.getSheet("DocTalk_Run");
		int row_num = (data.getLastRowNum()-data.getFirstRowNum())+1;
		
		System.out.print("Number of rows = " + row_num);
		Row row = data.getRow(1);
		Sign_Up_Execute_status = row.getCell(1).getStringCellValue();
		Row row1 = data.getRow(2);
		Sign_In_Execute_status = row1.getCell(1).getStringCellValue();
		
		System.out.println("Execution Status for the Sign_Up Test case --> "+ Sign_Up_Execute_status);
		System.out.println("Execution Status for the Sign_In Test case --> "+ Sign_In_Execute_status);
		
		// checking for the SignIn test case
		if(Sign_Up_Execute_status.equals("Yes"))
		{
			dt.signUP();
		}
		else
		{
		System.out.println("Relative SignUp Test Case is not selected");
		}
		// checking for the SignIn test case
		if(Sign_Up_Execute_status.equals("Yes"))
		{
			dt.signIn();
		}
		else
		{
			System.out.println("Relative SignIn Test Case is not selected");
		}
	}}