package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasicSetUp{
	
	protected final WebDriver driver;
	protected String baseUrl;
	
	
	
	public LogInPage(WebDriver driver , String baseUrl){
		this.baseUrl=baseUrl;
		this.driver=driver;
	}
	
	public DashBoard loginAs(String username, String password) throws Exception{
		try{
			
		driver.get(baseUrl + "");
		waitBetween(10);
		driver.findElement(By.id("j_username")).clear();		
		driver.findElement(By.id("j_username")).sendKeys(username);		
		driver.findElement(By.id("j_password")).clear();		
		driver.findElement(By.id("j_password")).sendKeys(password);		
		driver.findElement(By.id("signin")).click();
		
		return new DashBoard(driver);
		}
		catch(Exception e){
			
			return new DashBoard(driver);
		}
	}
	

}
