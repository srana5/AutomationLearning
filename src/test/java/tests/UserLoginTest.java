package tests;

import org.openqa.selenium.WebDriver;

import pages.Base;
import pages.LoginPage;

public class UserLoginTest {

	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		Base base = new Base();
		driver = Base.getDriver();
		base.initiateBrowser();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginOrRegister();
		loginPage.userName("shubham.rana").password("Qwerty123").login();
		base.logOut();
		driver.quit();

	}
}

//public static void main(String args[]) {
//
//		WebDriver driver;
//		Base base = new Base(null);
//		driver = base.initiateBrowser();
//		LoginPage loginPage = new LoginPage(driver);
//		base.loginOrRegister();
//		loginPage.userName("shubham.rana").password("Qwerty123").login();
//		base.logOut();
//		driver.quit();
//	}