package com.test.automation.uiAutomation.homepage;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiAction.HomePage;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase{


	HomePage homepage;
String emailAddress = "automation@gmail.com";
String password = "password";
	
	

	@BeforeClass
	public void setUp() throws IOException {
     init();
    
	}

	@Test
	public void verifyLoginWithDifferentRecords() {
	
		homepage = new HomePage(driver);
		homepage.loginToApplication(emailAddress, password);
	}

	@AfterClass
	public void endTest() {
       driver.close();
	}
}
