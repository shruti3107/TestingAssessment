package PageObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeliveryPage {

	public WebDriver driver;

	public DeliveryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id = 'pickpoint-search-input']")
	public WebElement pickupPoint;

	@FindBy(xpath = "//button[@data-auto-id = 'pickup-point-search-button']")
	public WebElement searchForCollectionsPointCTA;

	@FindBy(xpath = "//button[@data-auto-id = 'review-and-pay-button']")
	public WebElement reviewAndPayCTA;

	@FindBy(id = "billingAddress-firstName")
	public WebElement firstName;

	@FindBy(id = "billingAddress-lastName")
	public WebElement lastName;

	@FindBy(id = "billingAddress-address1")
	public WebElement address;

	@FindBy(id = "billingAddress-city")
	public WebElement city;

	@FindBy(id = "billingAddress-zipcode")
	public WebElement zipcode;

	@FindBy(id = "billingAddress-emailAddress")
	public WebElement emailAddress;

	@FindBy(xpath = "//h4[@data-auto-id = 'selected-store-header']")
	public WebElement selectedPointDetail;

	@FindBy(xpath = "//div[@data-auto-id = 'store-name']")
	public WebElement storeName;

	public void enterCity(String str) {
		pickupPoint.sendKeys(str);
	}

	public void verifyCorrectStoreName(String str) {
		Assert.assertEquals(storeName.getText(), str);
	}

	public void fillContactInformationForm(String fname, String lname, String addressName, String cityName,
			String zipcodeNum, String email) {
		HashMap<WebElement, String> form = new HashMap<WebElement, String>();
		form.put(firstName, fname);
		form.put(lastName, lname);
		form.put(address, addressName);
		form.put(city, cityName);
		form.put(zipcode, zipcodeNum);
		form.put(emailAddress, email);

		for (Entry<WebElement, String> objValue : form.entrySet())
			objValue.getKey().sendKeys(objValue.getValue());

	}

	public void verifyDeliveryPage(String url1) {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, url1);
	}

	public void selectDeliveryOption(String str) {
		List<WebElement> allOptions = driver.findElements(By.xpath("//p[contains(@class ,'delivery-option__title')]"));
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(str)) {
				System.out.println(allOptions.get(i).getText());
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", allOptions.get(i));
				break;

			}
		}
	}

	public void selecLocation(String str) {
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@data-auto-id = 'store-name']"));
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(str)) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", allOptions.get(i));
				executor.executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//button[@data-auto-id = 'select-store-button']")));
				break;

			}

		}

	}
}
