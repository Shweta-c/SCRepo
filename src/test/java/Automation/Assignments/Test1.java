package Automation.Assignments;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1
{

	public static void main(String[] args)
	{
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://dineshvelhal.github.io/testautomation-playground/frames.html");
		
		//Default frame
		d.switchTo().frame(0);
		d.findElement(By.xpath("//*[@class='row']/div/button")).click();
		Assert.assertEquals("CLICKED", d.findElement(By.xpath("//*[@class='row']/div/button")).getText());
		
		//1st child Frame
		d.switchTo().frame(0);
		d.findElement(By.xpath("//*[@id='button']")).click();
		Assert.assertEquals("CLICKED", d.findElement(By.xpath("//*[@id='button']")).getText());
		
		
		d.switchTo().parentFrame();
		
		//2nd child Frame
		d.switchTo().frame(1);
		
		//child Frame Inside Frame 1
		d.switchTo().frame(0);
		d.findElement(By.xpath("//*[@id='button']")).click();
		Assert.assertEquals("CLICKED", d.findElement(By.xpath("//*[@id='button']")).getText());
		d.close();
	}
	
}
