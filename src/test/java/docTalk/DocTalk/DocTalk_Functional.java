package docTalk.DocTalk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocTalk_Functional {

	public  final By CreatNewAcc = By.xpath("//*[contains(text(),'Create an account')]");
	public  final By Name = By.xpath("//*[@id='name']");
	public  final By Email= By.xpath("//*[@id='email']"); 
	public  final By Password = By.xpath("//*[@id='password']");
	public  final By SecretKey = By.xpath("//*[@id='doctorUid']"); 
	public  final By Sign_In_Email = By.xpath("//*[@name='username']");
	public  final By Sign_In_Password = By.xpath("//*[@name='password']");
	public  final By Sign_Up = By.xpath("//*[@class='ant-btn ant-btn-primary']");
	public  final By Sign_In = By.xpath("//*[@class='ant-btn ant-btn-primary']");
	public  final By Welcome_User =By.xpath("//*[@class='isoComponentTitle']");
	String Username = "Akshay_Gupta2";
	String Email_id = "akshaygupta524@gmail.com";
	String pswrd = "qwerty123";
	WebDriver driver;

	String URL = "https://receptionist-dev.getdoctalk.com/signin";
	String path = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";

	public void signUP() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver",path);	
		driver = new ChromeDriver();
		driver.get(URL);	
		driver.manage().window().maximize();
		Thread.sleep(5000);

		driver.findElement(CreatNewAcc).click();
		
		Thread.sleep(3000);

		driver.findElement(Name).sendKeys(Username);
		driver.findElement(Email).sendKeys(Email_id);
		driver.findElement(Password).sendKeys(pswrd);
		driver.findElement(SecretKey).sendKeys("OtNie2zo4PfGMIJWrnldETabpis1");
		driver.findElement(Sign_Up).click();

		String Title_name = driver.getTitle();
		System.out.println("Title of the page :" + Title_name);
		
		Thread.sleep(2000);
		driver.close();
	}

	public void signIn() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver",path);	
		driver = new ChromeDriver();
		driver.get(URL);

		driver.findElement(Sign_In_Email).sendKeys(Email_id);
		driver.findElement(Sign_In_Password).sendKeys(pswrd);
		driver.findElement(Sign_In).click();
		
		WebDriverWait wait = new WebDriverWait(driver,500000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Welcome_User)); 
		
		System.out.println("Home Page is Displayed");
		
		Thread.sleep(5000);
		driver.close();
	}
}