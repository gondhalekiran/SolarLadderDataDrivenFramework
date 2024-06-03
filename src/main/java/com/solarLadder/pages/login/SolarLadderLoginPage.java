package com.solarLadder.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SolarLadderLoginPage {
	// Step1: Variable declaration
	@FindBy(xpath = "//input[@name='email']")
	private WebElement uNInp; 
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pWDInp; 
	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement singnInBtn; 

	// Step2: Variable initialization
	public SolarLadderLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
	}

	// Step3: Variable usage
	public void inpSolarLadderLoginPageEmail(String username) {
		uNInp.sendKeys(username);
	}

	public void inpSolarLadderLoginPagePassword(String password) {
		pWDInp.sendKeys(password);
	}

	public void clickSolarLadderLoginPageLoginBtn() {
		singnInBtn.click();
	}
}
