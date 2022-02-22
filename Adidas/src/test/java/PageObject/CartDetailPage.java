package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.WaitHelper;

public class CartDetailPage {

	public WebDriver driver;
	WaitHelper waitHelper;

	public CartDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-auto-id = 'glass-checkout-button-right-side']")
	public WebElement checkOutCTA;

	@FindBy(xpath = "//h3[@data-auto-id = 'glass-cart-title']")
	public WebElement yourBagTitle;

	public void cartTitleIsDisplayed() {
		Assert.assertEquals(yourBagTitle.getText(), "YOUR BAG");
	}

}
