package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiAction.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	HomePage homepage;
		
		@BeforeTest
		public void setUp(){
			init();
		}
		
		@Test
		public void verifyLoginWithInvalidCredentials(){
			log.info("============= Starting TC001_VerifyLoginWithInvalidCredentials test=============");
			homepage = new HomePage(driver);
			homepage.loginToApplication("test@gmail.com", "password");
			Assert.assertEquals(homepage.getInvalidLoginDetail(), "Authentication failed.");
			log.info("============= Finished TC001_VerifyLoginWithInvalidCredentials test ==================");

		}
		
		
	}



