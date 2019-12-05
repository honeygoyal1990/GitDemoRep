package Demo.NewProject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class UpskillsAdmin {
	String url,username,password;
	WebDriver driver;
	@BeforeTest
	public void getData() throws IOException
	{
		FileReader fr= new FileReader("Credential.properties");
	Properties prop=new Properties();
	prop.load(fr);
	url=prop.getProperty("AdminURL");
	username=prop.getProperty("AdminUsername");
	password=prop.getProperty("AdminPassword");
	
	}
	@BeforeClass
	public void setupBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.navigate().to(url);
		System.out.println("Welcome to Before Test");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}
	
	@Test(priority=1,enabled=false)
	public void Customer() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[6]"))).build().perform();
		Thread.sleep(1000);
		int i,countOfElement;
		String[] expectedEle= {"Customers","Customer Groups","Custom Fields"};
		countOfElement=driver.findElements(By.xpath("//ul[@id='menu']/li[6]/ul/li")).size();
	
		for(i=1;i<=countOfElement;i++) {
			Assert.assertEquals(expectedEle[i-1],driver.findElement(By.xpath("//ul[@id='menu']/li[6]/ul/li["+i+"]")).getText());
			
		}
		act.moveToElement(driver.findElement(By.xpath("//a[@class='parent']")),150,100).click().build().perform();
		Thread.sleep(1000);
	driver.findElement(By.id("input-name")).sendKeys("Neha");
	driver.findElement(By.id("button-filter")).click();
	if(driver.findElements(By.xpath("//form[@id='form-customer']/div/table/tbody/tr")).size()==1) 
	{
		if(driver.findElements(By.xpath("//form[@id='form-customer']/div/table/tbody/tr/td")).size()==1)
		System.out.println("No Result Found");
		else
			System.out.println("1 result found");
	}
	else
		System.out.println(driver.findElements(By.xpath("//form[@id='form-customer']/div/table/tbody/tr")).size()+" results found");
	Thread.sleep(1000);
	driver.findElement(By.id("input-email")).sendKeys("neha1@gmail.com");
	driver.findElement(By.id("button-filter")).click();

		if(driver.findElements(By.xpath("//form[@id='form-customer']/div/table/tbody/tr")).size()==1) 
		{
			if(driver.findElements(By.xpath("//form[@id='form-customer']/div/table/tbody/tr/td")).size()==1)
			System.out.println("No Result Found");
			else
				System.out.println("1 result found");
		}
		else
			System.out.println(driver.findElements(By.xpath("//form[@id='form-customer']/div/table/tbody/tr")).size()+" results found");
		
	}
	@Test(priority=2,enabled=false)
	public void Sales() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[9]"))).build().perform();
		Thread.sleep(1000);
		
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[9]/ul/li[1]"))).click().build().perform();
		Thread.sleep(1000);
		int i,countOfElement;
		String[] expectedEle= {"Orders","Tax","Shipping","Returns","Coupons"};
		countOfElement=driver.findElements(By.xpath("//ul[@id='menu']/li[9]/ul/li[1]/ul/li")).size();
	
		for(i=1;i<=countOfElement;i++) {
			Assert.assertEquals(expectedEle[i-1],driver.findElement(By.xpath("//ul[@id='menu']/li[9]/ul/li[1]/ul/li["+i+"]")).getText());
			
		}
	
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[9]/ul/li[1]/ul/li[4]"))).click().build().perform();
		Thread.sleep(1000);
	
		
	}

	@Test(enabled=false)
	public void shoppingCart() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[5]"))).build().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[5]/ul/li[2]"))).click().build().perform();
		Thread.sleep(1000);
	driver.findElement(By.id("input-order-recurring-id")).sendKeys("1");
	driver.findElement(By.id("button-filter")).click();
	Thread.sleep(1000);
	if(driver.findElements(By.xpath("//form[@id='form']/div/table/tbody/tr/td")).size()==1) {
		System.out.println("0 Result Found");
	}

	else
		System.out.println(driver.findElements(By.xpath("//form[@id='form']/div/table/tbody/tr")).size()+" result found");
					
	}
	@Test(priority=3)
	public void productReturn() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[5]"))).build().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[5]/ul/li[3]"))).click().build().perform();
		Thread.sleep(1000);
	driver.findElement(By.id("input-return-id")).sendKeys("207");
	driver.findElement(By.id("button-filter")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("input-customer")).sendKeys("Renu");
	driver.findElement(By.id("button-filter")).click();
	Thread.sleep(1000);
	
	if(driver.findElements(By.xpath("//form[@id='form-return']/div/table/tbody/tr/td")).size()==1) {
		System.out.println("0 Result Found");
	}

	else
		System.out.println(driver.findElements(By.xpath("//form[@id='form-return']/div/table/tbody/tr")).size()+" result found");
					
	}
	@AfterClass
	public void logout() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']")).click();
		
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(500);
		driver.close();
	}
	
}
