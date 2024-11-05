package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import pages.Base;
import pages.LoginPage;
import pages.OrderProcessPages;

public class OrderPlaceTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		Base base = new Base();
		driver = Base.getDriver();
		base.initiateBrowser();
		LoginPage login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login.loginOrRegister();
		login.userName("shubham.rana").password("Qwerty123").login();
		OrderProcessPages order = new OrderProcessPages(driver);
		order.hoverFragnance();
		order.clickMenOption();
		order.clickOnProduct1("Pour Homme Eau de Toilette");
		order.addProduct();
		order.moveToCheckout();
		order.orderConfirmed();
		Thread.sleep(2000);
		login.logOut();
		driver.quit();
	}

}
