package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.WaitHelper;

public class ProductDetailPage {

	public WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-auto-id = 'view-bag-desktop']")
	public WebElement viewBagCTA;

	@FindBy(xpath = "//button[@data-auto-id = 'add-to-bag']")
	public WebElement addToBag;

	@FindBy(xpath = "//h5[@data-auto-id = 'added-to-bag-modal-title']")
	public WebElement confrimationMessage;

	@FindBy(xpath = "//button[@class = 'gl-modal__close']")
	public WebElement crossButton;

	public void verifyURL(String url1) {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, url1);
	}

	public void verifyProductIsAddedToCart() {
		Assert.assertTrue(confrimationMessage.isDisplayed(), "Product is not added to cart");
	}

	public void selectSize(String str) {
		List<WebElement> allOptions = driver
				.findElements(By.xpath("//div[@data-auto-id = 'size-selector']/button/span"));
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(str)) {
				allOptions.get(i).click();
				break;

			}

		}

	}
}
