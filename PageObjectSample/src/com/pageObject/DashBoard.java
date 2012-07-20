package com.pageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard extends BasicSetUp{
	
	protected final WebDriver driver;
	
	public DashBoard(WebDriver driver) throws Exception{
		this.driver=driver;
		verifyLogIn();
	}
	
	public void verifyLogIn() throws Exception{
		try { 
			waitBetween(10);
			driver.findElement(By.id("setup.title"));
			writeText("LogIn Successful @ "+ getDate());
			System.out.println("LogIn successful @ "+ getDate() );
			
			
		}
		catch(Exception e){
			captureScreen("login_error");
			writeText("Error: login not successful @ "+ getDate());
			System.out.println("Error: login not successful @ "+ getDate() );
		}
	}
	
	public void gotoCallCenterProfile(){
		driver.findElement(By.id("PROFILE_SUBMENU")).click(); 
	}
	
	
	public AgentPage goToAgentPage() throws Exception{
		waitBetween(10);
		driver.findElement(By.id("menu_members")).click();
		return new AgentPage(driver);
	}

}
