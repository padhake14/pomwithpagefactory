package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.automation.uiAutomation.excelReader.Excel_Reader;
import com.test.automation.uiAutomation.uiAction.HomePage;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	String Url = "http://automationpractice.com/index.php";
	String browser = "chrome";
	Excel_Reader excel;

	public void init() {
		if (driver == null) {
			selectBrowser(browser);
		}
		getUrl(Url);
		PropertyConfigurator.configure("log4j.properties");

	}

	public void selectBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			// For Windows system
			System.setProperty("webdriver.chrome.driver",
					"D:\\eclipse-jee-neon-R-win32-x86_64\\workspace\\uiAutomation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		}
	}

	public void getUrl(String url) {

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiAutomation/data/"
				+ excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

}
