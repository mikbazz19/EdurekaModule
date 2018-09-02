package com.edureka.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.edureka.utils.TestUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public TestBase() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\EdurekaModule\\src\\main\\java\\com\\edureka\\properties\\config.properties");
			properties.load(ip);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		String browserName = properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Downloads\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			String browserError = properties.getProperty("browserError");
			System.out.println(browserError);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

}
