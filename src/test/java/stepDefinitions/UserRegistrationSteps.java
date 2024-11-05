package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegistrationSteps {

	Base base = new Base();

	WebDriver driver = Base.getDriver();

	public RegistrationPage regPage;
	public LoginPage loginPage;

	@Given("the web browser is open")
	public void openBrowser() {
		base.initiateBrowser();
	}

	@When("user navigate to registration page")
	public void user_navigate_to_registration_page() {
//		driver = initiateBrowser();
		loginPage = new LoginPage(Base.getDriver());
		regPage = new RegistrationPage(Base.getDriver());
		loginPage.loginOrRegister();
		regPage.clickRegisterRadioButton();
		regPage.clickContinueButton();
	}

	@And("fill exiting user details")
	public void fill_exiting_user_details() {
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

	@Then("user should get an error on submit")
	public void user_should_get_an_error_on_submit() {
		regPage.verifyErrorMessage();
	}

	@When("fill new user details")
	public void fill_new_user_details() {
		regPage.inputRandomFirstAndLastName();
		regPage.inputRandomEmail();
		regPage.enterTelephone("999-999-9999");
		regPage.enterFax("999-999");
		regPage.enterCompany("Centric Consulting");
		regPage.enterAddress1("Gurugram");
		regPage.enterCity("Gurugram");
		regPage.selectZone("Swansea");
		regPage.enterPostcode("110038");
		regPage.generateAndInputUsername();
		regPage.enterPassword("Qwerty123");
		regPage.enterConfirmPassword("Qwerty123");
		regPage.checkAgreeCheckbox();
		regPage.clickContinueButton();
	}

	@Then("user should get registered")
	public void user_should_get_registered() {
		regPage.verifyRegistrationSuccess();
	}

	@Then("log out the user")
	public void log_out_the_user() {
		base.logOut();
	}
}