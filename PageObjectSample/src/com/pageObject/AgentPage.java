package com.pageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AgentPage extends BasicSetUp{
	
	protected final WebDriver driver;
	
	public AgentPage(WebDriver driver) throws Exception{
		this.driver=driver;
		verifyPage();
	}
	
	public void verifyPage() throws Exception{
		try{
			waitBetween(10);
//			wait.until(ExpectedConditions.elementToBeClickable(By.id("add_member")));
			driver.findElement(By.id("add_member"));
			System.out.println("Agent Page Loaded @ "+ getDate());
			writeText("Agent Page Loaded @ "+ getDate());
		}
		catch(Exception e){
			captureScreen("agent_page_error");
			System.out.println("Error: Agent Page didn't Load @ "+ getDate());
			writeText("Error: Agent Page didn't Load @ "+ getDate());
			
		}
		
	}
	
	
	
}
