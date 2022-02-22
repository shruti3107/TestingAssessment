package PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class HomePage {

	public WebDriver driver;
	WaitHelper waitHelper;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@data-auto-id = 'searchinput']")
	public WebElement searchTextField;

	@FindBy(xpath = "//button[@data-auto-id = 'add-to-bag']")
	public WebElement addToCartCTA;
	
	@FindBy(xpath = "//button[@data-auto-id = 'glass-gdpr-default-consent-accept-button']")
	public WebElement acceptCookieCTA;
	
	@FindBy(xpath = "//span[contains(text() , 'United Kingdom') and @class = 'gl-radio-input__label']")
	public WebElement radioButtonUK;
	
	@FindBy(xpath = "//button[@data-auto-id = 'choose-delivery-country']")
	public WebElement continueToSiteCTA;
	

	
	public void enterSearchText(String  searchText) {
		searchTextField.sendKeys(searchText);
		searchTextField.sendKeys(Keys.ENTER);
	}



	public void selectProductFromPLP(String str) {
		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@data-auto-id = 'glass-search-products']//li//span"));
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(str)) {
				allOptions.get(i).click();
				break;
			}

		}
	}

	
}
