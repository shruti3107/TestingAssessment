package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLPPage {

	public WebDriver driver;

	public PLPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@data-auto-id = 'glass-checkout-button-right-side']")
	public WebElement checkOutCTA;

	public void selectProductFromPLP(String str) {
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class = 'glass-product-card__details']/p"));
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(str)) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", allOptions.get(i));
				break;

			}

		}

	}
}
