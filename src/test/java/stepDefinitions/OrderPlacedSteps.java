package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Base;
import pages.OrderProcessPages;

public class OrderPlacedSteps {
	
	WebDriver driver = Base.getDriver();
	OrderProcessPages orderPage = new OrderProcessPages(driver);
	
	@And("^user add an item (.+) to cart from Menu")
	public void user_add_an_item_to_cart_from_menu(String productName) {
	    orderPage.hoverFragnance();
	    orderPage.clickMenOption();
//	    orderPage.clickOnProductStream(productName);
	    orderPage.clickOnProduct1(productName);
//	    orderPage.clickAddToCartIcon();
	    orderPage.addProduct();
	}

	@And("confirm the order via checkout")
	public void confirm_the_order_via_checkout() {
	    orderPage.moveToCheckout();
	    orderPage.orderConfirmed();
	}

	@Then("order should get placed successfully")
	public void order_should_get_placed_successfully() throws InterruptedException {
	    Thread.sleep(2000);
		orderPage.verifyOrderSuccess();
	}
	
}
