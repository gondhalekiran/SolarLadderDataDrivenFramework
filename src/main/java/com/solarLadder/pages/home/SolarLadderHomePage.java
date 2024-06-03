package com.solarLadder.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SolarLadderHomePage {
	// Step1: Variable declaration
	@FindBy(xpath = "//button[text()='Project']")
	private WebElement addProjectBtn; 
	@FindBy(xpath = "//span[text()='Successfully created project!']")
	private WebElement toastMsg; 
	
	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[3]")
	private WebElement closeMoreInfoPopBtn; 
	@FindBy(xpath = "(//div[@class='smooth-dnd-draggable-wrapper'])[1]")
	private WebElement enq; 
	@FindBy(xpath = "(//div[@class='smooth-dnd-container vertical'])[2]")
	private WebElement siteVisit; 
	@FindBy(xpath = "(//section[@title='Site Visit']//div[@class='crm-projectcard'])[1]")
	private WebElement card; 

	// public WebDriver driver;
	public Actions Act; // global declaration of instance of action class

	// Step2: Variable initialization
	public SolarLadderHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		// this.driver = driver;
		this.Act = new Actions(driver); // initialize instance of action class with webdriver instance as parameter
	}

	// Step3: Variable usage
	public void clickSolarLadderHomePageAddProjectButton() {
		addProjectBtn.click();
	}

	public void clickSolarLadderHomePagecloseMoreInfoPop() {
		closeMoreInfoPopBtn.click();
	}

	public void dragNDropSolarLadderHomePage() throws InterruptedException {
		Thread.sleep(5000);
		Act.clickAndHold(enq).moveToElement(siteVisit).release(siteVisit).perform();
	}

	public WebElement getCard() {
		return card;
	}
	public WebElement getToastMsg() {
		return toastMsg;
	}
}
