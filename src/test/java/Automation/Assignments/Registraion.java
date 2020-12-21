package Automation.Assignments;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Registraion
{
	public WebDriver d;
	RegistrationPage rp;
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeM(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			d=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			d=new FirefoxDriver();
		}
		else
		{
			d=new ChromeDriver();
		}
		rp=new RegistrationPage(d);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		d.get("https://dineshvelhal.github.io/testautomation-playground/register.html");
	}
	
	 @DataProvider
	 public Object[][] getTestdata()
	 {
	 return new Object[][] {{"Shweta","chougale","shwetachougale@gmail.com","shweta","shweta"},
		 {"Pallavi","chougale","","pallavi","pallavi"},
		 {"Asha","","AshaPasle@gmail","Asha","Asha"},
		 {"Snehal","Dhavale","Snehal","Snehal",""}};
	 }
	
	 //Method for reading data from excel
	/*@DataProvider 
	public Iterator<Object[]> getTestdata() throws IOException
	{
		ArrayList<Object[]> testdata = XLReader.getDataFromExcel();
		return testdata.iterator();
	}*/
	 
	 @Test (dataProvider = "getTestdata")
	public void display(String name,String lname,String email,String pass,String cpass) throws IOException
	{	
		rp.Fname().sendKeys(name);
		rp.Lname().sendKeys(lname);
		rp.email().sendKeys(email);
		rp.pass().sendKeys(pass);
		rp.Cpass().sendKeys(cpass);
		rp.Term().click();
		rp.submit().click();
		Assert.assertEquals(d.getTitle(), "Confirmation!");
		screenShot("Picture");
	}
	public void screenShot(String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)d;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path="E:\\Document\\BNFS\\New folder\\Assignments\\ScreenShot\\";
		File dest = new File(path+name+".jpg");
		FileHandler.copy(src, dest);
	}
	@AfterMethod
	public void after()
	{
		d.close();
	}
}
