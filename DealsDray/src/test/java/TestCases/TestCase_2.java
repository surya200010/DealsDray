package TestCases;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_2 {

	private WebDriver driver;

	@Test
	public void testCase2_Chrome() throws Throwable {
		
		/*
		 * We should use explicit wait for the visibility of a web element, but I have
		 * used the Thread.sleep function due to a time constraint
		 */

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.dealsdray.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("C:\\surya\\web\\src\\test\\java\\resources\\demo-data.xlsx");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		screenshotFile.renameTo(new File("Screenshot_TestCase2.png"));
		driver.quit();

		/*
		 * We should use explicit wait for the visibility of a web element, but I have
		 * used the Thread.sleep function due to a time constraint
		 */
	}
}
