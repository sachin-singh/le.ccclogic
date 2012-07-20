package com.pageObject;

import org.junit.Test;


public class Tests extends BasicSetUp{
	
	

	
	@Test
	public void Test() throws Exception{
		LogInPage loginpage = new LogInPage(driver , baseUrl);
		DashBoard dashboard = loginpage.loginAs("sscrackers1@gmail.com", "12345678");
//		dashboard.gotoCallCenterProfile();
		AgentPage agentpage = dashboard.goToAgentPage();
		
	}
}
