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
	private static WebDriverWait wait;

	private String baseUrl;
	public static String username = "sscrackers1@gmail.com";
	public static String password = "12345678";
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
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

	
	// Log in at callcenter
	@Test
	public void testLogIn() throws Exception {
		
		writeText("============================");
		writeText("Test Started @ " + getDate());
		System.out.println("============================");
		System.out.println("Test Started @ " + getDate());
		
		driver.get(baseUrl + "");
		
		try {
		driver.findElement(By.id("j_username")).clear();
		
		driver.findElement(By.id("j_username")).sendKeys(username);
		
		driver.findElement(By.id("j_password")).clear();
		
		driver.findElement(By.id("j_password")).sendKeys(password);
		
		driver.findElement(By.id("signin")).click();
		
				try { 
					driver.findElement(By.id("menu_home"));
					System.out.println("Login Succesful @ " + getDate());
					writeText("Login Successful @ " + getDate());
				}
				catch (Exception e){
					captureScreen("login_error");
					System.out.println("Error during Login @ " +getDate());
					writeText("Error during Login @ " + getDate());
				}
				
				
		
		}
		
		
		catch(Exception e){
			captureScreen("page_load");
			System.out.println(e);
		
			
			System.out.println("Error: Login Page didnot load @ " +getDate());
			writeText("Error: Login Page didnot load @ " + getDate());
		}
		
		
		
		
		System.out.println("LogIn test is completed @ "+ getDate());
		writeText("LogIn test is completed @ "+getDate());
//		addAgent("sachin" , "" , "", "");
		testCCProfile();
	}
	
	public void testCCProfile() throws IOException{
		String oldpassword = "12345679";
		String newpassword = "12345678";
		String confirmnewpassword="12345678";
		String email = "sachin1@3clogic.com";
		String fullname="";
		String address = "";
		String city="";
		String state="";
		String country="";
		String pincode="";
		String phone="";
		String timezone="";
		String language="";
		String curreny="";
		try{
		driver.findElement(By.id("PROFILE_SUBMENU")).click();
		
		// Old Password
		driver.findElement(By.id("oldpassword")).clear();
		driver.findElement(By.id("oldpassword")).sendKeys(oldpassword);
		
		//New Password
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(newpassword);
		
		// Confirm new Password
		driver.findElement(By.id("password0")).clear();	
	    driver.findElement(By.id("password0")).sendKeys(confirmnewpassword);
		
		
		
		
//		driver.findElement(By.id("email")).clear();		
//		driver.findElement(By.id("email")).sendKeys(email);
		
//		driver.findElement(By.id("oldpassword")).clear();
//		driver.findElement(By.id("oldpassword")).sendKeys(oldpassword);
	
//		driver.findElement(By.id("contact_country")).sendKeys(country);
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.id("updateprofile")).click();
		
		try{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/span[2]")));
		System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/span[2]")).getText() + "@" + getDate());
		writeText(driver.findElement(By.xpath("/html/body/div/div[2]/div/span[2]")).getText() + "@" + getDate());
		}
		catch(Exception e){
			captureScreen("profile_update");
			System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span[2]")).getText());
			writeText(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span[2]")).getText());
			writeText("Error: Profile can not be updated @ "+ getDate());
			System.out.println("Error: Profile can not be updated @ "+ getDate());
			
		}
		
		}
//		WebElement myDynamicElement = (new WebDriverWait(driver, 100))
//		  .until(new ExpectedCondition<WebElement>(){
//			@Override
//			public WebElement apply(WebDriver d) {
//				return driver.findElement(By.xpath("/html/body/div/div[2]/div/span[2]"));
//			}});
		catch(Exception e){
			System.out.println("Some unexpected error durign testing:(");
		}
		
		
//	
		
		
		System.out.println("Its done! ");
					    
	   
	    
	}
	
	public void addAgent(String agentName, String agentUserName, String agentPassword, String email) throws IOException{
		try{
		driver.findElement(By.id("menu_members")).click();
		driver.findElement(By.id("add_member")).click();
		driver.findElement(By.id("newmember_name")).sendKeys(agentName);
		driver.findElement(By.id("newuser_name")).sendKeys(agentUserName);
		driver.findElement(By.id("newmember_password")).sendKeys(agentPassword);
		driver.findElement(By.id("newmember_cpassword")).sendKeys(agentPassword);
		driver.findElement(By.id("newmember_add")).click();
		
		
		
		
		
		try {
			 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]")));
			System.out.println("AgentUserName:"+driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]")).getText() + "is added successfully @ " + getDate());
			writeText("AgentUserName: '"+ driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]")).getText() + "' is added successfully @" + getDate());
		}
		
		catch(Exception e){
			captureScreen("add_agent_error");
			System.out.println("Error: Agent is not added @" + getDate());
			writeText("Error: Agent is not added @" + getDate());
			
		}
		
		}
		
		catch(Exception e){
			captureScreen("add_agent_error");
			System.out.println("Error: Agent is not added @" + getDate());
			writeText("Error: Agent is not added @" + getDate());
			
		}
		
		
		
		
		
	}
	
	public void waitBetween(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
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
