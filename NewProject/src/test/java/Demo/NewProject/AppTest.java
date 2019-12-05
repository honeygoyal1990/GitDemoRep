package Demo.NewProject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
public class AppTest{
	String url,username,password;
	WebDriver driver;
	@BeforeTest
	public void getData() throws IOException
	{
		FileReader fr= new FileReader("Credential.properties");
	Properties prop=new Properties();
	prop.load(fr);
	url=prop.getProperty("URL");
	username=prop.getProperty("Username");
	password=prop.getProperty("password");
	
	}
	@BeforeClass
	public void setupBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.navigate().to(url);
		System.out.println("Welcome to Before Test");
	}
	
	@Test
	public void display() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		Thread.sleep(5000);
		System.out.println("Welcome to Before Class");
			driver.findElement(By.xpath("//li[@class='dropdown myaccount open']//ul//li[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	}
	@AfterClass
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@class='dropdown myaccount']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//li[5]")).click();
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
}