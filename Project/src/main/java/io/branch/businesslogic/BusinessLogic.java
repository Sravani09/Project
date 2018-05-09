package io.branch.businesslogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.branch.dto.AllEmployeeBeans;
import io.branch.pageobjects.PageObject;

public class BusinessLogic {

	WebDriver driver;
	PageObject pageObject;
	List<AllEmployeeBeans> employeeDetailsList;
	List<String> superEmployeeList;
	Set<String> departmentSet;

	public BusinessLogic(WebDriver driver, PageObject pageObject) {
		this.driver = driver;
		this.pageObject = pageObject;
	}

	public void googleSearch() {
		pageObject.getGoogleTextBox().sendKeys("branch website");
		pageObject.getGoogleTextBox().sendKeys(Keys.TAB);
		pageObject.getGoogleSearch().click();
		wait(3000);
		pageObject.getBranchWebsite().click();
		wait(3000);
	}

	public void branchPageController() {
		scrollToView(pageObject.getTeamLink());
		driver.navigate().to(pageObject.getTeamLink().getAttribute("href"));
		wait(3000);

		employeeDetailsList = new ArrayList<>();
		List<WebElement> employeeList = pageObject.getEmployees();
		departmentSet = new HashSet<>();
		for (WebElement employee : employeeList) {
			scrollToView(employee);
			AllEmployeeBeans allEmployeeBeans = new AllEmployeeBeans();
			allEmployeeBeans.setEmployeeName(employee.findElement(By.xpath("h2")).getText().trim());
			allEmployeeBeans.setEmployeeDepartment(employee.findElement(By.xpath("h4")).getText().trim());
			employeeDetailsList.add(allEmployeeBeans);
			departmentSet.add(employee.findElement(By.xpath("h4")).getText().trim());
		}

		superEmployeeList = new ArrayList<>();

		scrollUp();
		wait(2000);
		pageObject.getDataLink().click();
		int dataEmployeeCount = pageObject.getEmployeeDataList().size();
		Map<String, String> dataEmployees = new HashMap<>();
		for (int index = 0; index < dataEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeeDataList().get(index));
			dataEmployees.put(
					pageObject.getEmployeeDataList().get(index).findElement(By.xpath("h2")).getText().toString().trim(),
					pageObject.getEmployeeDataList().get(index).findElement(By.xpath("h4")).getText().toString()
							.trim());
			superEmployeeList.add(pageObject.getEmployeeDataList().get(index).findElement(By.xpath("h2")).getText()
					.toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, dataEmployees),
				"Mismatch with Data Group of Employees");

		scrollUp();
		wait(2000);
		pageObject.getEngineeringLink().click();
		int engineeringEmployeeCount = pageObject.getEmployeeEngineeringList().size();
		Map<String, String> engineeringEmployees = new HashMap<>();
		for (int index = 0; index < engineeringEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeeEngineeringList().get(index));
			engineeringEmployees.put(
					pageObject.getEmployeeEngineeringList().get(index).findElement(By.xpath("h2")).getText().toString()
							.trim(),
					pageObject.getEmployeeEngineeringList().get(index).findElement(By.xpath("h4")).getText().toString()
							.trim());
			superEmployeeList.add(pageObject.getEmployeeEngineeringList().get(index).findElement(By.xpath("h2"))
					.getText().toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, engineeringEmployees),
				"Mismatch with Engineering Group of Employees");

		scrollUp();
		wait(2000);
		pageObject.getMarketingLink().click();
		int marketingEmployeeCount = pageObject.getEmployeeMarketingList().size();
		Map<String, String> marketingEmployees = new HashMap<>();
		for (int index = 0; index < marketingEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeeMarketingList().get(index));
			marketingEmployees.put(
					pageObject.getEmployeeMarketingList().get(index).findElement(By.xpath("h2")).getText().toString()
							.trim(),
					pageObject.getEmployeeMarketingList().get(index).findElement(By.xpath("h4")).getText().toString()
							.trim());
			superEmployeeList.add(pageObject.getEmployeeMarketingList().get(index).findElement(By.xpath("h2")).getText()
					.toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, marketingEmployees),
				"Mismatch with Marketing Group of Employees");

		scrollUp();
		wait(2000);
		pageObject.getOperationsLink().click();
		int operationsEmployeeCount = pageObject.getEmployeeOperationList().size();
		Map<String, String> operationEmployees = new HashMap<>();
		for (int index = 0; index < operationsEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeeOperationList().get(index));
			operationEmployees.put(
					pageObject.getEmployeeOperationList().get(index).findElement(By.xpath("h2")).getText().toString()
							.trim(),
					pageObject.getEmployeeOperationList().get(index).findElement(By.xpath("h4")).getText().toString()
							.trim());
			superEmployeeList.add(pageObject.getEmployeeOperationList().get(index).findElement(By.xpath("h2")).getText()
					.toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, operationEmployees),
				"Mismatch with Operations Group of Employees");

		scrollUp();
		wait(2000);
		pageObject.getPartnerGrowthLink().click();
		int partnerGrowthEmployeeCount = pageObject.getEmployeePartnerGrowthList().size();
		Map<String, String> partnerGrowthEmployees = new HashMap<>();
		for (int index = 0; index < partnerGrowthEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeePartnerGrowthList().get(index));
			partnerGrowthEmployees.put(
					pageObject.getEmployeePartnerGrowthList().get(index).findElement(By.xpath("h2")).getText()
							.toString().trim(),
					pageObject.getEmployeePartnerGrowthList().get(index).findElement(By.xpath("h4")).getText()
							.toString().trim());
			superEmployeeList.add(pageObject.getEmployeePartnerGrowthList().get(index).findElement(By.xpath("h2"))
					.getText().toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, partnerGrowthEmployees),
				"Mismatch with Partner Growth Group of Employees");

		scrollUp();
		wait(2000);
		pageObject.getProductLink().click();
		int productEmployeeCount = pageObject.getEmployeeProductList().size();
		Map<String, String> productEmployees = new HashMap<>();
		for (int index = 0; index < productEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeeProductList().get(index));
			productEmployees.put(
					pageObject.getEmployeeProductList().get(index).findElement(By.xpath("h2")).getText().toString()
							.trim(),
					pageObject.getEmployeeProductList().get(index).findElement(By.xpath("h4")).getText().toString()
							.trim());
			superEmployeeList.add(pageObject.getEmployeeProductList().get(index).findElement(By.xpath("h2")).getText()
					.toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, productEmployees),
				"Mismatch with Product Growth Group of Employees");

		scrollUp();
		wait(2000);
		pageObject.getRecruitingLink().click();
		int recruitingEmployeeCount = pageObject.getEmployeeRecruitingList().size();
		Map<String, String> recruitingEmployees = new HashMap<>();
		for (int index = 0; index < recruitingEmployeeCount; index++) {
			scrollToView(pageObject.getEmployeeRecruitingList().get(index));
			recruitingEmployees.put(
					pageObject.getEmployeeRecruitingList().get(index).findElement(By.xpath("h2")).getText().toString()
							.trim(),
					pageObject.getEmployeeRecruitingList().get(index).findElement(By.xpath("h4")).getText().toString()
							.trim());
			superEmployeeList.add(pageObject.getEmployeeRecruitingList().get(index).findElement(By.xpath("h2"))
					.getText().toString().trim());
		}
		Assert.assertTrue(checkEmployeeDetails(employeeDetailsList, recruitingEmployees));

		scrollUp();
		wait(2000);

		System.out.println("LISTED EMPLOYEES : " + " #DATA : " + dataEmployeeCount + " #ENGINEERING : "
				+ engineeringEmployeeCount + " #MARKETING : " + marketingEmployeeCount + "#OPERATIONS : "
				+ operationsEmployeeCount + " #PARTNER GROWTH : " + partnerGrowthEmployeeCount + " #PRODUCT : "
				+ productEmployeeCount + " #RECRUITING : " + recruitingEmployeeCount);

	}

	public void validateListedEmployeeCount() {
		Assert.assertFalse(employeeDetailsList.size()==superEmployeeList.size());

	}

	public void validateavailableDepartments() {
		Assert.assertFalse(departmentSet.size()==pageObject.getCategoryList().size());

	}

	public void getUnListedEmployees() {
		for (AllEmployeeBeans employeeDetails : employeeDetailsList) {
			boolean flag = false;
			for (String employee : superEmployeeList) {
				if (employeeDetails.getEmployeeName().equals(employee)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("EMPLOYEE NAME : " + employeeDetails.getEmployeeName() + " ## DEPARTMENT : "
						+ employeeDetails.getEmployeeDepartment());
			}

		}
	}

	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollUp() {
		((JavascriptExecutor)

		driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public boolean checkEmployeeDetails(List<AllEmployeeBeans> employeeDetailsList, Map<String, String> employeesMap) {

		for (String employee : employeesMap.keySet()) {
			boolean flag = false;
			for (AllEmployeeBeans employeeDetails : employeeDetailsList) {
				if (employee.equals(employeeDetails.getEmployeeName())
						&& employeeDetails.getEmployeeDepartment().contains(employeesMap.get(employee))) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}

		}
		return true;

	}

}
