package Automation.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver d;
	public static WebDriver getDriver(String browser)
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
		return d;
	}
	public static WebDriver closeDriver()
	{
		d.close();
		return d;
	}
	
}
