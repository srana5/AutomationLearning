package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Base {

	WebDriver driver;
	
//	public LoginPage() {}
	
	public LoginPage(WebDriver driver) {
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul[id='customer_menu_top'] li a")
	WebElement myAccountLink;
	
	@FindBy(xpath = "//input[@name='loginname']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(css = "button[title='Login']")
	WebElement login;
	
	@FindBy(xpath = "//div[@class='menu_text']")
	WebElement loginMessage;
	
	@FindBy(css = "div.alert-error")
	WebElement errorMsg;

	public LoginPage userName(String usrName) {
		userName.sendKeys(usrName);
		return this;
	}

	public LoginPage password(String psw) {
		password.sendKeys(psw);
		return this;
	}

	public OrderProcessPages login() {
		login.click();
		return new OrderProcessPages(driver);
	}

    public void loginOrRegister() {
        myAccountLink.click();
    }
    
    public void verifyLoginSuccess() {
    	String message = loginMessage.getText();
		String assertText = message.split(" ")[0].trim();
		String expectedText = "Welcome";
		Assert.assertEquals(assertText, expectedText, "User is not logged in");
    }
    
    public void verifyLoginFailure() {
    	String error = errorMsg.getText().trim();
    	String actualError = error.split("×")[1].trim();
    	String expError = "Error: Incorrect login or password provided.";
    	Assert.assertEquals(actualError, expError);
    }
}
