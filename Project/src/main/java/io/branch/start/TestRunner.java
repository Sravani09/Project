package io.branch.start;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.branch.businesslogic.BusinessLogic;
import io.branch.pageobjects.PageObject;

public class TestRunner {
	public static WebDriver driver;
	PageObject pageObject;
	BusinessLogic businessLogic;
	
	@Parameters({ "url", "browser" })
	@BeforeTest
	public void startUp(String url, String browser) {
		
		switch (browser.toLowerCase()) {

		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/driver/IEDriverServer");
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//@Test
	public void check() {
		System.out.println("TEST");
	}
	
	@Test
	public void controlTest() {
		pageObject = new PageObject(driver);
		businessLogic = new BusinessLogic(driver, pageObject);
		businessLogic.googleSearch();
		businessLogic.branchPageController();
	}
	
	@Test
	public void employeeExistenceTest() {
		businessLogic.getUnListedEmployees();
	}
	
	@Test
	public void listedEmployeesCount() {
		businessLogic.validateListedEmployeeCount();
	}
	
	@Test
	public void listedDepartments() {
		businessLogic.validateavailableDepartments();
	}
	
	
	
	

	@AfterTest
	public void close() {
		driver.quit();
	}
}
