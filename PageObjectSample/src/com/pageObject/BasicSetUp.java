package com.pageObject;

import java.text.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicSetUp {
	
	protected static WebDriver driver;
	protected String baseUrl;
	protected WebDriverWait wait;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();		
		baseUrl = "http://192.168.3.16/ls/";	
		wait = new WebDriverWait(driver, 20);
		startTest();
	}
	
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
	
	public static void waitBetween(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
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
	
	public static void startTest(){
		writeText("============================");
		writeText("Test Started @ " + getDate());
		System.out.println("============================");
		System.out.println("Test Started @ " + getDate());
	}
	
	


}
