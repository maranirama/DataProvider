package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	WebDriver driver;
	@BeforeClass
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/login-page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test (dataProvider="logindata")
	public void loginUser(String user,String password)
	{
		WebElement logintxt=driver.findElement(By.xpath("//input[@id='username']"));
		logintxt.sendKeys(user);
		logintxt.clear();
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys(password);
		pwd.clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@DataProvider(name="logindata")
	public String[][] dataProvider()
	{
		String logindata[][]= {{"user1@gmail.com","pass1"},
		{"user2@gmail.com","pass2"},
		{"user3@gmail.com","pass3"},
		{"user4@gmail.com","pass4"}};
		
		return logindata;
	}
	
	
}
