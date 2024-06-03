package com.solarLadder.pages.addProject;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Actions.AllAction;

public class SolarLadderAddProjectPage {
	// Step1: Variable declaration
	@FindBy(xpath = "//select[@name='customerType']")
	private WebElement selCustType;
	@FindBy(xpath = "//input[@name='projectSize']")
	private WebElement size;
	@FindBy(xpath = "//input[@name='customerName']")
	private WebElement nameInp;
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement mobNoInp;
	@FindBy(xpath = "//input[@name='location']")
	private WebElement addressInp;
	@FindBy(xpath = "(//input[@type='search'])[1]")
	private WebElement cityInp;
	@FindBy(xpath = "//div[@role='listbox']/child::div")
	private List<WebElement> cityList;
	@FindBy(xpath = "//div[@role='listbox']/child::div")
	private WebElement city;
	@FindBy(xpath = "//h5[text()='Additional Optional Details']")
	private WebElement addOptBtn;
	
	@FindBy(xpath = "//input[@name='electricityBill']")
	private WebElement eleBillInp;
	
	@FindBy(xpath = "//button[text()='Add Project']")
	private WebElement submitBtn;
	// Step2: Variable initialization
	Actions act;

	public SolarLadderAddProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		this.act = new Actions(driver);
	}

	// Step3: Variable usage
	public void selSolarLadderAddProjectPageCustomerType(String custtyp) throws IOException {
		AllAction.selectMethod(selCustType, custtyp);
	}

	public void inpSolarLadderAddProjectPageSize(String sizekw) {
		size.clear();
		size.sendKeys(sizekw);
	}

	public void inpSolarLadderAddProjectPageName(String Name) {
		nameInp.sendKeys(Name);
	}

	public void inpSolarLadderAddProjectPageMobNo(String MobNo) {
		mobNoInp.sendKeys(MobNo);
	}

	public void inpSolarLadderAddProjectPageAddress(String add) {
		addressInp.sendKeys(add);
	}

	public void inpAndSelSolarLadderAddProjectPageCity(String City) throws InterruptedException {
		cityInp.sendKeys(City);
		Thread.sleep(2000);
		for (WebElement c : cityList) {
			if (c.getAttribute("aria-label").equals(City)) {	
				 act.sendKeys(Keys.ENTER).perform();		
				break;
			}
		}
	}
	
	public void inpSolarLadderAddProjectPageEleBill(String bill) {
		eleBillInp.sendKeys(bill);
	}
	public void clickSolarLadderAddProjectPageAddOptBtn() {
		addOptBtn.click();
	}
	
	
	public void clickSolarLadderAddProjectPageSubmitBtn() {
		submitBtn.click();
	}
}
