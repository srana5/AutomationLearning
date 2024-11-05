package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

	WebDriver driver;

	// Define WebElements using @FindBy
	@FindBy(xpath = "//div[@id='customernav']/ul/li/a")
	WebElement myAccountLink;

	@FindBy(css = "input#accountFrm_accountregister")
	WebElement registerRadioButton;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement continueButton;

	@FindBy(css = "input[name='firstname']")
	WebElement firstName;

	@FindBy(css = "input[name='lastname']")
	WebElement lastName;

	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "input[name='telephone']")
	WebElement telephone;

	@FindBy(css = "input[name='fax']")
	WebElement fax;

	@FindBy(css = "input[name='company']")
	WebElement company;

	@FindBy(css = "input[name='address_1']")
	WebElement address1;

	@FindBy(css = "input[name='city']")
	WebElement city;

	@FindBy(css = "select[name='zone_id']")
	WebElement zoneDropdown;

	@FindBy(css = "input[name='postcode']")
	WebElement postcode;

	@FindBy(xpath = "//input[@name='loginname']")
	WebElement loginName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement agreeCheckbox;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement submitBtn;

	@FindBy(css = "div.alert-danger")
	WebElement errorMessage;
	
	@FindBy(css = "span.maintext")
	WebElement successMessage;

	// Constructor to initialize elements

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define methods for interactions
	public void clickMyAccountLink() {
		myAccountLink.click();
	}

	public void clickRegisterRadioButton() {
		registerRadioButton.click();
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmail(String emailAddr) {
		email.sendKeys(emailAddr);
	}

	public void enterTelephone(String tel) {
		telephone.sendKeys(tel);
	}

	public void enterFax(String faxNumber) {
		fax.sendKeys(faxNumber);
	}

	public void enterCompany(String comp) {
		company.sendKeys(comp);
	}

	public void enterAddress1(String addr1) {
		address1.sendKeys(addr1);
	}

	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}

	public void selectZone(String zone) {
		new Select(zoneDropdown).selectByVisibleText(zone);
	}

	public void enterPostcode(String post) {
		postcode.sendKeys(post);
	}

	public void enterLoginName(String login) {
		loginName.sendKeys(login);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterConfirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}

	public void checkAgreeCheckbox() {
		agreeCheckbox.click();
	}

	public void clickOnContinue() {
		submitBtn.click();
	}

	public void verifyErrorMessage() {
		String errorMsg = errorMessage.getText().split("×")[1].trim();
		Assert.assertEquals(errorMsg, "Error: E-Mail Address is already registered!");
	}
	
	public void generateAndInputUsername() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String[] names = {"Alice", "Bob", "Michael", "Lee", "Jennifer"};
		int randomIndex = random.nextInt(names.length);
		String userName = names[randomIndex] + "_" + randomNumber;
		loginName.sendKeys(userName);
	}
	
	public void inputRandomFirstAndLastName() {
		Random random = new Random();
		String[] firstNames = {"Alice", "Bob", "Michael", "Lee", "Jennifer"};
		String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones"};
		int randomIndex = random.nextInt(firstNames.length);
		String frstName = firstNames[randomIndex];
		firstName.sendKeys(frstName);
		int randomInd = random.nextInt(lastNames.length);
		String lstName = lastNames[randomInd];
		lastName.sendKeys(lstName);
	}
	
	public void inputRandomEmail() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String[] names = {"Alice", "Bob", "Michael", "Lee", "Jennifer"};
		int randomIndex = random.nextInt(names.length);
		String[] domain = {"@gmail.com", "@test.com", "@example.com", "@demo.com"};
		int randomDomainInd = random.nextInt(domain.length);
		String usrName = names[randomIndex] + randomNumber + domain[randomDomainInd];
		email.sendKeys(usrName.toLowerCase());
	}
	
	public void verifyRegistrationSuccess() {
		String successMsg = successMessage.getText();
		Assert.assertEquals(successMsg, "YOUR ACCOUNT HAS BEEN CREATED!");
	}
}
