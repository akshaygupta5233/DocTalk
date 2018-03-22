package docTalk.DocTalk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DocTalk_Functional {

	public  final By CreatNewAcc = By.xpath("//*[contains(text(),'Create an account')]");
	public  final By Name = By.xpath("//*[@id='name']");
	public  final By Email= By.xpath("//*[@id='email']"); 
	public  final By Password = By.xpath("//*[@id='password']");
	public  final By SecretKey = By.xpath("//*[@id='doctorUid']"); 
	public  final By Sign_Up = By.xpath("//*[@class='ant-btn ant-btn-primary']");
	public  final By Sign_In = By.xpath("//*[@class='ant-btn ant-btn-primary']");
	//public  final By Welcome_User = By.xpath("//*[contains(text(),'Welcome')]");
	public  final By Welcome_User = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/h1");
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
		Thread.sleep(1000);

		driver.findElement(CreatNewAcc).click();

		driver.findElement(Name).sendKeys(Username);
		driver.findElement(Email).sendKeys(Email_id);
		driver.findElement(Password).sendKeys(pswrd);
		driver.findElement(SecretKey).sendKeys("OtNie2zo4PfGMIJWrnldETabpis1");
		driver.findElement(Sign_Up).click();

		String Title_name = driver.getTitle();
		System.out.println("Title of the page :" + Title_name);
		
		/*WebElement Welcome_Text = driver.findElement(Welcome_User);
		Welcome_Text.getText();*/
		//System.out.println("Printing "+TxtBoxContent);
		
		//String Welcome_Text = driver.findElement(Welcome_User).getText();
		//System.out.println(".............." +Welcome_Text );

		/*if(Welcome_Text.equals(Username))
		{
			System.out.println("User enters into the Welcome Screen");
		}

		else
		{
			System.out.println("User is not able to signIN");
		}*/

		Thread.sleep(2000);
		driver.close();
	}

	public void signIn() throws Throwable
	{
		driver.get(URL);

		driver.findElement(Email).sendKeys(Email_id);
		driver.findElement(Password).sendKeys(pswrd);
		driver.findElement(Sign_In).click();

		Thread.sleep(2000);
		driver.close();
	}
}