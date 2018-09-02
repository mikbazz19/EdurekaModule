package com.edureka.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.edureka.base.TestBase;
import com.edureka.pages.EditProfilePage;
import com.edureka.pages.HomePage;
import com.edureka.pages.LoginPage;
import com.edureka.pages.MyProfilePage;
import com.edureka.utils.TestUtils;

public class TestMain extends TestBase {
	public TestMain() {
		super();
	}
	//public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		initialization();
	}
	
	@Test (priority = 1)
	public void loginEdureka() {
		try {
			LoginPage loginPage = new LoginPage(driver); 
			loginPage.startLogin();
			try {
				Thread.sleep(TestUtils.SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			loginPage.typeEmailid(properties.getProperty("email_id"));
			loginPage.typePassword(properties.getProperty("password"));
			loginPage.enterLogin();
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (priority = 2)
	public void goToMyProfilePage() {
		try {
			HomePage homePage = new HomePage(driver);
			homePage.userImageClick();
			homePage.myProfileLinkClick();
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test (priority = 3)
	public void editIconClick() {
		try {
			MyProfilePage myProfilePage = new MyProfilePage(driver);
			myProfilePage.iconClick();
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test (priority = 4)
	public void uploadPicture() {
		try {
			EditProfilePage editProfilePage = new EditProfilePage(driver);
			editProfilePage.cameraIconClick();
			Thread.sleep(TestUtils.SLEEP_TIME);
			editProfilePage.chooseFile();
			Thread.sleep(TestUtils.SLEEP_TIME);
			editProfilePage.runAutoIt();
			Thread.sleep(TestUtils.SLEEP_TIME);
			editProfilePage.clickPhotoSubmit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.navigate().back();
		try {
			Thread.sleep(TestUtils.SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		
	}
	

}
