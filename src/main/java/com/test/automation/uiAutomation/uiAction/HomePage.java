package com.test.automation.uiAutomation.uiAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationfailed;
	
	
	public HomePage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String emailAddress, String password){
		signIn.click();
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		submitButton.click();
		
	}
	
	public String getInvalidLoginDetail(){
		return authenticationfailed.getText();
	}
	
}
