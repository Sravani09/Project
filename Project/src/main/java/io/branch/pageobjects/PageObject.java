package io.branch.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='q']")
	WebElement googleTextBox;

	@FindBy(xpath = "//input[@value='Google Search']")
	WebElement googleSearch;

	@FindBy(xpath = "//a[@href='https://branch.io/']")
	WebElement branchWebsite;

	@FindBy(xpath = "//a[text()='Team']")
	WebElement teamLink;

	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']")
	List<WebElement> employees;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Marketing')]")
	List<WebElement> marketingFromAllMember;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Data')]")
	List<WebElement> dataFromAllMember;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Operations')]")
	List<WebElement> operationsFromAllMember;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Partner Growth')]")
	List<WebElement> patternGrowthFromAllMember;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Product')]")
	List<WebElement> productFromAllMember;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Recruiting')]")
	List<WebElement> recruitingFromAllMember;
	@FindBy(xpath = "//div[@class='row row-centered']//div[@class='info-block']/h4[contains(text(),'Engineering')]")
	List<WebElement> engineeringFromAllMember;

	@FindBy(xpath = "//a[text()='Data']")
	WebElement dataLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeeDataList;
	@FindBy(xpath = "//a[text()='Engineering']")
	WebElement engineeringLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeeEngineeringList;
	@FindBy(xpath = "//a[text()='Marketing']")
	WebElement marketingLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeeMarketingList;
	@FindBy(xpath = "//a[text()='Operations']")
	WebElement operationsLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeeOperationList;
	@FindBy(xpath = "//a[text()='Partner Growth']")
	WebElement partnerGrowthLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeePartnerGrowthList;
	@FindBy(xpath="//ul[@class='team-categories']//a[not(text()='All')]")
	List<WebElement> categoryList;
	
	public List<WebElement> getCategoryList() {
		return categoryList;
	}

	public List<WebElement> getEmployeeDataList() {
		return employeeDataList;
	}

	public List<WebElement> getEmployeeEngineeringList() {
		return employeeEngineeringList;
	}

	public List<WebElement> getEmployeeMarketingList() {
		return employeeMarketingList;
	}

	public List<WebElement> getEmployeeOperationList() {
		return employeeOperationList;
	}

	public List<WebElement> getEmployeePartnerGrowthList() {
		return employeePartnerGrowthList;
	}

	public List<WebElement> getEmployeeProductList() {
		return employeeProductList;
	}

	public List<WebElement> getEmployeeRecruitingList() {
		return employeeRecruitingList;
	}

	@FindBy(xpath = "//a[text()='Product']")
	WebElement productLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeeProductList;
	@FindBy(xpath = "//a[text()='Recruiting']")
	WebElement recruitingLink;
	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'inline')]//div[@class='info-block']")
	List<WebElement> employeeRecruitingList;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMarketingLink() {
		return marketingLink;
	}

	public WebElement getOperationsLink() {
		return operationsLink;
	}

	public WebElement getPartnerGrowthLink() {
		return partnerGrowthLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getRecruitingLink() {
		return recruitingLink;
	}

	public WebElement getEngineeringLink() {
		return engineeringLink;
	}

	public WebElement getDataLink() {
		return dataLink;
	}

	public List<WebElement> getEmployees() {
		return employees;
	}

	public List<WebElement> getEngineeringFromAllMember() {
		return engineeringFromAllMember;
	}

	public List<WebElement> getDataFromAllMember() {
		return dataFromAllMember;
	}

	public List<WebElement> getMarketingFromAllMember() {
		return marketingFromAllMember;
	}

	public List<WebElement> getOperationsFromAllMember() {
		return operationsFromAllMember;
	}

	public List<WebElement> getPatternGrowthFromAllMember() {
		return patternGrowthFromAllMember;
	}

	public List<WebElement> getProductFromAllMember() {
		return productFromAllMember;
	}

	public List<WebElement> getRecruitingFromAllMember() {
		return recruitingFromAllMember;
	}

	public WebElement getTeamLink() {
		return teamLink;
	}

	public WebElement getBranchWebsite() {
		return branchWebsite;
	}

	public WebElement getGoogleTextBox() {
		return googleTextBox;
	}

	public WebElement getGoogleSearch() {
		return googleSearch;
	}

}
