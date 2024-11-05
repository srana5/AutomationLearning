package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RegistrationPage;

public class UserRegistrationTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();

		// Instantiate the RegistrationPage
		RegistrationPage regPage = new RegistrationPage(driver);

		// Perform actions using the methods in the Registration Page class
		regPage.clickMyAccountLink();
		regPage.clickRegisterRadioButton();
		regPage.clickContinueButton();

		regPage.enterFirstName("John");
		regPage.enterLastName("Doe");
		regPage.enterEmail("jdoe@test.com");
		regPage.enterTelephone("999-999-9999");
		regPage.enterFax("999-999");
		regPage.enterCompany("Centric Consulting");
		regPage.enterAddress1("Gurugram");
		regPage.enterCity("Gurugram");
		regPage.selectZone("Swansea");
		regPage.enterPostcode("110038");
		regPage.enterLoginName("shubham.rana");
		regPage.enterPassword("Qwerty123");
		regPage.enterConfirmPassword("Qwerty123");
		regPage.checkAgreeCheckbox();
		regPage.clickContinueButton();
	}
}
