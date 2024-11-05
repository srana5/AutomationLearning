package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Base;
import pages.LoginPage;

public class Testing {

	Base base;
	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		base = new Base(); // Create Base instance
		driver = Base.getDriver();
		base.initiateBrowser(); // Initialize browser and open the site
		loginPage = new LoginPage(driver); // Initialize LoginPage with the driver
	}

	@Test
	public void testUserLogin() throws InterruptedException {
		loginPage.loginOrRegister(); // Navigate to Login Page
		loginPage.userName("shubham.rana") // Enter User Name
				.password("Qwerty123") // Enter Password
				.login(); // Click on Login Button
		loginPage.verifyLoginSuccess();

	}

	@AfterMethod
	public void tearDown() {
		base.logOut(); // Log out of the application
		driver.quit(); // Close the browser
	}
}
