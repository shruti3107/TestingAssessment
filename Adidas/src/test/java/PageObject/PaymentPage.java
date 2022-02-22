package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentPage {

	public WebDriver driver;
	

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='payment-method' and @value= 'CREDIT_CARD']")
	public WebElement creditCartPayment;
	

	@FindBy(xpath = "//input[@name='payment-method' and @value= 'PAYPAL']")
	public WebElement paypalPayment;

	public void verifyCreditCardPaymentOption() {
		Assert.assertTrue(creditCartPayment.isEnabled(),"Credit card payment method is not available" );;
	}

	public void verifyPaypalPaymentOption() {
		Assert.assertTrue(paypalPayment.isEnabled(), "Paypal payment method is not available");;
	}	
}
