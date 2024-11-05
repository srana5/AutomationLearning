package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.HomePage;
import pages.Base;

public class HomePageSteps {

    WebDriver driver = Base.getDriver();
    HomePage homePage = new HomePage(driver);

    @When("user clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        homePage.clickCartIcon();
    }
}