package com.selenium.test;

import java.text.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;


public class TestWeb {
	
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public String baseUrl;
	public static String username = "sscrackers1@gmail.com";
	public static String password = "12345678";
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
	// Load Home Page
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		baseUrl = "http://192.168.3.16/ls/";		
		
	}
	
	
	//write message in text file
	public static void writeText(String s){
			FileWriter fWriter = null;
			BufferedWriter writer = null;
				try {
						fWriter = new FileWriter("info.txt", true);
						writer = new BufferedWriter(fWriter);
						writer.append(s);
						writer.newLine();
						writer.close();
				} catch (Exception e) {
				}
	}	

	
	public void waitBetween(){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public static String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		    return dateFormat.format(date);
	}
	
	
	
	public static void captureScreen(String err) throws IOException {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
      File scrFile = ((TakesScreenshot)augmentedDriver).
                          getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\"+err+".png"));
	}
	
	
	
	
	
	
	


}
