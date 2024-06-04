package com.solarLadder.qa.test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solarLadder.LibraryFiles.BaseClass;
import com.solarLadder.LibraryFiles.UtilityClass;
import com.solarLadder.pages.addProject.SolarLadderAddProjectPage;
import com.solarLadder.pages.home.SolarLadderHomePage;
import com.solarLadder.pages.login.SolarLadderLoginPage;

import DataProviders.DataSupplier;
import org.apache.logging.log4j.*;
import net.bytebuddy.utility.RandomString;

public class SolarLadderUnitTC extends BaseClass {
	SolarLadderLoginPage login;
	SolarLadderHomePage home;
	SolarLadderAddProjectPage project;
	String TCID;
	SoftAssert soft;
	Logger log = LogManager.getLogger(SolarLadderUnitTC.class);

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		initializeBrowser();
		login = new SolarLadderLoginPage(driver);
		home = new SolarLadderHomePage(driver);
		project = new SolarLadderAddProjectPage(driver);
		soft = new SoftAssert();

	}

	@BeforeMethod
	public void loginToApp() throws InterruptedException, IOException {
		// Login page method call
		log.info("Signing In..");
		login.inpSolarLadderLoginPageEmail(UtilityClass.getPFData("UN"));
		login.inpSolarLadderLoginPagePassword(UtilityClass.getPFData("PWD"));
		Thread.sleep(200);
		login.clickSolarLadderLoginPageLoginBtn();
		log.info("Sign In succcess");
		Thread.sleep(200);
		home.clickSolarLadderHomePageAddProjectButton();
	}

	@Test(enabled = true, priority = 1, dataProvider = "dataContainer", dataProviderClass = DataSupplier.class)
	public void DragDropProject(String Scenario, String error, String custType, String size, String name, String mobNo,
			String add, String city, String bill, String toastMsg) throws IOException, InterruptedException {
		TCID = RandomString.make(2); // ab cd a1 a5 s4
		// AddProject page method call
		log.info("Filling Form");
		project.selSolarLadderAddProjectPageCustomerType(custType);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageSize(size);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageName(name);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageMobNo(mobNo);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageAddress(add);
		Thread.sleep(200);
		project.inpAndSelSolarLadderAddProjectPageCity(city);
		Thread.sleep(200);
		project.clickSolarLadderAddProjectPageAddOptBtn();
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageEleBill(bill);
		Thread.sleep(2000);
		project.clickSolarLadderAddProjectPageSubmitBtn();
		log.info("Form Submitted");
		Thread.sleep(5000);
		WebElement wb = home.getToastMsg();
		UtilityClass.drawBorder(driver, wb);
		String tm = wb.getText();
		Reporter.log(tm + "<==>" + toastMsg, true);

		// home.dragNDropSolarLadderHomePage(); // code to drag and drop card

		soft.assertEquals(tm, toastMsg);
		soft.assertAll();
	}

	@AfterMethod
	public void logoutFromApp(ITestResult s1,Method m) throws IOException, InterruptedException {

		if (s1.getStatus() == ITestResult.SUCCESS) {
			Thread.sleep(5000);
			UtilityClass.drawBorder(driver, home.getCard()); // code to Draw border on card
			UtilityClass.captureSS(driver, m.getName()); // code to capture SS
		}
	}

	@AfterClass
	public void closeBrowser() {
		// driver.close();
	}
}
