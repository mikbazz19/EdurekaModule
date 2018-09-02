package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right profile pull-right']/li[1]/a[1]/img")
	private WebElement userImage;
	
	@FindBy(xpath="//ul[@class='dropdown-menu user-menu profile-xs hidden-sm hidden-xs']/li[1]/a")
	private WebElement myProfileLink;
	
	public void userImageClick() {
		userImage.click();
	}
	
	public void myProfileLinkClick() {
		myProfileLink.click();
	}

}
