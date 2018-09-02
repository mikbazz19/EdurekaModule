package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.edureka.base.TestBase;

public class EditProfilePage extends TestBase{
	public EditProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/app-root/app-onboarding-main/div/div/div[1]/div[2]/div[2]/app-onboarding-personal-details/div[1]/div/div/div/div/div/div[2]/a/i")
	private WebElement cameraIcon;
	
	@FindBy(xpath="//div[@class='file-upload']/input[@id='custom-input']")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath="//button[@class='submitbtn']")
	private WebElement submitBtn;
	
	public void cameraIconClick() {
		try {
			cameraIcon.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void chooseFile() {
		chooseFileBtn.click();
	}
	
	public void runAutoIt() {
		try {
			String strFilePath = properties.getProperty("user_photo_location");
			String strPath = properties.getProperty("autoit_exe_location");
			String strParameter = strPath+" "+strFilePath;
			Runtime.getRuntime().exec(strParameter);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickPhotoSubmit() {
		try {
			submitBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
