package StepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import PageObject.CartDetailPage;
import PageObject.DeliveryPage;
import PageObject.HomePage;
import PageObject.PLPPage;
import PageObject.PaymentPage;
import PageObject.ProductDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.WaitHelper;

public class CheckoutFlow extends TestBase {
	WebDriver driver = null;
	WaitHelper waitHelper;
	HomePage homePage;
	ProductDetailPage productdetailPage;
	CartDetailPage cartDetailPage;
	DeliveryPage deliveryPage;
	PaymentPage paymentPage;
	String storeName = "New Oxford Street";
	
	@After
    public void burnDown(){
        System.out.println("Closing the test");
        driver.quit();
    }

	@Given("I am on the Adidas homepage")
	public void i_am_on_the_Adidas_homepage() throws IOException, InterruptedException {
		driver = initializeDriver();
		homePage = new HomePage(driver);

	}

	@Then("I search for any word and from the opened page PLP click on the first product")
	public void i_search_for_any_word_and_from_the_opened_page_PLP_click_on_the_first_product() {
		homePage.enterSearchText("Running");
		waitHelper = new WaitHelper(driver);
		waitHelper.applyImpicitWait();
		PLPPage plp = new PLPPage(driver);
		plp.selectProductFromPLP("Shoes");

	}

	@When("I pick a size and click on Add to Bag button")
	public void i_pick_a_size_and_click_on_Add_to_Bag_button() {
		productdetailPage = new ProductDetailPage(driver);
		productdetailPage.verifyURL("https://www.adidas.co.uk/ultraboost-4.0-dna-shoes/FY9120.html");
		waitHelper.applyImpicitWait();
		productdetailPage.crossButton.click();
		productdetailPage.selectSize("5");
		productdetailPage.addToBag.click();
		productdetailPage.verifyProductIsAddedToCart();

	}

	@When("I click on View Bag button and navigate to the cart page")
	public void i_click_on_View_Bag_button_and_navigate_to_the_cart_page() {
		productdetailPage.viewBagCTA.click();
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
		cartDetailPage = new CartDetailPage(driver);
		cartDetailPage.cartTitleIsDisplayed();
		cartDetailPage.checkOutCTA.click();
	}

	@Then("from the Get Your Order module click From A Collection Point option")
	public void from_the_Get_Your_Order_module_click_From_A_Collection_Point_option() {
		deliveryPage = new DeliveryPage(driver);
		deliveryPage.verifyDeliveryPage("https://www.adidas.co.uk/delivery");
		deliveryPage.selectDeliveryOption("FROM A COLLECTION POINT");
	}

	@Then("type London in the location text box")
	public void type_London_in_the_location_text_box() {
		deliveryPage.enterCity("London");
	}

	@Then("click Search for Collection Points button")
	public void click_Search_for_Collection_Points_button() {
		deliveryPage.searchForCollectionsPointCTA.click();
	}

	@Then("from the list pick any collection point")
	public void from_the_list_pick_any_collection_point() throws InterruptedException {
		deliveryPage.selecLocation(storeName);
		waitHelper.WaitForElement(deliveryPage.selectedPointDetail, 5);
		deliveryPage.verifyCorrectStoreName(storeName);

	}

	@Then("Proceed to the payment step by Review and Pay button")
	public void proceed_to_the_payment_step_by_Review_and_Pay_button() {
		deliveryPage.fillContactInformationForm("Michael", "Smith", "Baker Street", "London", "RM163LH",
				"abc@gmail.com");
		deliveryPage.reviewAndPayCTA.click();
	}

	@Then("verify that major payment methods PayPal and Credit Card are present")
	public void verify_that_major_payment_methods_PayPal_and_Credit_Card_are_present() {
		paymentPage = new PaymentPage(driver);
		paymentPage.verifyCreditCardPaymentOption();
		paymentPage.verifyPaypalPaymentOption();
	}

}
