package GenericUtility;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 protected WebDriver driver;

	@BeforeTest
	public void beforeTest() {
	}

	 @BeforeClass
	    public void beforeClass(String browser) {
	        if ("chrome".equalsIgnoreCase(browser)) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if ("firefox".equalsIgnoreCase(browser)) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } else if ("safari".equalsIgnoreCase(browser)) {
	            driver = new SafariDriver();
	        } else {
	            throw new IllegalArgumentException("Invalid browser provided: " + browser);
	        }

	        driver.manage().window().maximize();
	    }

	@BeforeMethod
	public void beforeMethod() {
		 try {
		        InputStream input = getClass().getClassLoader().getResourceAsStream("resources/credentials.properties");

		        if (input == null) {
		            System.out.println("Sorry, unable to find credentials.properties");
		            return;
		        }

		        Properties properties = new Properties();
		        properties.load(input);

		        String url = properties.getProperty("url");

		        driver.get(url);

		        driver.manage().window().maximize();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterTest
	public void afterTest() {
	}
}
