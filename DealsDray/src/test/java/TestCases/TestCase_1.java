package TestCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_1 {

	private WebDriver driver;

	@Test
	public void testCase1_Chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.getcalley.com/page-sitemap.xml");

		String browserName = "Chrome";
		int[][] dimensions = { { 1920, 1080 }, { 1366, 768 }, { 1536, 864 }, { 360, 640 }, { 414, 896 }, { 375, 667 } };

		for (int[] dimension : dimensions) {
			String dimensionFolder = dimension[0] + "x" + dimension[1];
			File directory = new File(browserName + File.separator + dimensionFolder);
			directory.mkdirs();

			for (int i = 1; i <= 5; i++) {
				String xpath = "//table/tbody/tr[" + i + "]/td[1]//a";

				driver.findElement(By.xpath(xpath)).click();
				driver.manage().window().setSize(new org.openqa.selenium.Dimension(dimension[0], dimension[1]));

				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
				String dateTime = dateFormat.format(new Date());

				String screenshotPath = directory.getAbsolutePath() + File.separator + "Screenshot-" + dateTime
						+ ".png";
				screenshotFile.renameTo(new File(screenshotPath));

				driver.navigate().back();
			}
		}

		driver.quit();
	}

	@Test
	public void testCase1_FireFox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.getcalley.com/page-sitemap.xml");

		String browserName = "Chrome";
		int[][] dimensions = { { 1920, 1080 }, { 1366, 768 }, { 1536, 864 }, { 360, 640 }, { 414, 896 }, { 375, 667 } };

		for (int[] dimension : dimensions) {
			String dimensionFolder = dimension[0] + "x" + dimension[1];
			File directory = new File(browserName + File.separator + dimensionFolder);
			directory.mkdirs();

			for (int i = 1; i <= 5; i++) {
				String xpath = "//table/tbody/tr[" + i + "]/td[1]//a";

				driver.findElement(By.xpath(xpath)).click();
				driver.manage().window().setSize(new org.openqa.selenium.Dimension(dimension[0], dimension[1]));

				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
				String dateTime = dateFormat.format(new Date());

				String screenshotPath = directory.getAbsolutePath() + File.separator + "Screenshot-" + dateTime
						+ ".png";
				screenshotFile.renameTo(new File(screenshotPath));

				driver.navigate().back();
			}
		}

		driver.quit();
	}

	@Test
	public void testCase1_Safari() {
		WebDriverManager.safaridriver().setup();
		WebDriver driver = new SafariDriver();
		driver.get("https://www.getcalley.com/page-sitemap.xml");

		String browserName = "Chrome";
		int[][] dimensions = { { 1920, 1080 }, { 1366, 768 }, { 1536, 864 }, { 360, 640 }, { 414, 896 }, { 375, 667 } };

		for (int[] dimension : dimensions) {
			String dimensionFolder = dimension[0] + "x" + dimension[1];
			File directory = new File(browserName + File.separator + dimensionFolder);
			directory.mkdirs();

			for (int i = 1; i <= 5; i++) {
				String xpath = "//table/tbody/tr[" + i + "]/td[1]//a";

				driver.findElement(By.xpath(xpath)).click();
				driver.manage().window().setSize(new org.openqa.selenium.Dimension(dimension[0], dimension[1]));

				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
				String dateTime = dateFormat.format(new Date());

				String screenshotPath = directory.getAbsolutePath() + File.separator + "Screenshot-" + dateTime
						+ ".png";
				screenshotFile.renameTo(new File(screenshotPath));

				driver.navigate().back();
			}
		}

		driver.quit();
	}
}
