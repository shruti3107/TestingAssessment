package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObject.HomePage;
import utilities.WaitHelper;

public class TestBase {

	public WebDriver driver;
	public Properties prop;
	WaitHelper waitHelper = null;
	HomePage homePage ;

	
	
	public WebDriver initializeDriver() throws IOException, InterruptedException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/utilities/data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			homePage = new HomePage(driver);
			homePage.radioButtonUK.click();
			homePage.continueToSiteCTA.click();
			waitHelper = new WaitHelper(driver);
			waitHelper.applyImpicitWait();
			homePage.acceptCookieCTA.click();
			/*
			 * JavascriptExecutor executor = (JavascriptExecutor) driver;
			 * executor.executeScript("arguments[0].click();",);
			 */
			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		
		waitHelper.applyImpicitWait();
		return driver;

	}

}
