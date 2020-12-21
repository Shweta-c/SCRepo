package Automation.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage 
{
	public RegistrationPage(WebDriver d)
	{
		this.d=d;
	}
	WebDriver d;
	By Fname= By.xpath("//*[@name='first_name']");
	By Lname= By.xpath("//*[@name='last_name']");
	By email= By.xpath("//*[@name='email']");
	By pass= By.xpath("//*[@name='password']");
	By Cpass= By.xpath("//*[@name='confirm_password']");
	By Term= By.xpath("//*[@name='terms']");
	By submit= By.xpath("//*[@name='submit_button']");
	
	public WebElement Fname()
	{
		return d.findElement(Fname);
	}
	public WebElement Lname()
	{
		return d.findElement(Lname);
	}
	public WebElement email()
	{
		return d.findElement(email);
	}
	public WebElement pass()
	{
		return d.findElement(pass);
	}
	public WebElement Cpass()
	{
		return d.findElement(Cpass);
	}
	public WebElement Term()
	{
		return d.findElement(Term);
	}
	public WebElement submit()
	{
		return d.findElement(submit);
	}
	
}
