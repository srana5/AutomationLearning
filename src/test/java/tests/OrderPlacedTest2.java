package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import pages.Base;
import pages.LoginPage;
import pages.OrderProcessPages;

public class OrderPlacedTest2 {

	public static void main(String[] args) throws InterruptedException {
//		a[data-id='63']
		WebDriver driver = null;
		Base base = new Base();
		driver = Base.getDriver();
		base.initiateBrowser();
		LoginPage login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login.loginOrRegister();
		OrderProcessPages order = login.userName("shubham.rana").password("Qwerty123").login();
		order.hoverFragnance();
		order.clickMenOption();
		order.clickAddToCartIcon();
		order.addProduct();
		order.moveToCheckout();
		order.orderConfirmed();
		Thread.sleep(2000);
		login.logOut();
		driver.quit();

	}

}
