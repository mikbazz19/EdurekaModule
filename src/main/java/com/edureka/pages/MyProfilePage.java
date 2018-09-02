package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.base.TestBase;

public class MyProfilePage extends TestBase{
	
	public MyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='personal-details']/a[@class='profile-edit-icon']")
	private WebElement personalDetailsIcon;
	
	public void iconClick() {
		personalDetailsIcon.click();
	}

}
