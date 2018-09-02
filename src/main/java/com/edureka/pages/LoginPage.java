package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.base.TestBase;

public class LoginPage extends TestBase {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	};
	
	@FindBy(xpath="//a[text()='Log In']")
	private WebElement loginLink;
	
	@FindBy(xpath="//input[@id='inputName']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='pwd1']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement loginBtn;
	
	
	public void startLogin() {
		loginLink.click();
	}
	
	public void typeEmailid(String eId) {
		emailId.sendKeys(eId);
	}
	
	public void typePassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void enterLogin() {
		loginBtn.click();
	}

}
