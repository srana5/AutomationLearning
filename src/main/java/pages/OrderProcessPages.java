package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderProcessPages extends Base {
	private Actions actions;
	WebDriver driver;

	@FindBy(xpath = "//nav/ul/li/a[contains(text(), 'Fragrance')]")
	private WebElement Fragnance;

	@FindBy(xpath = "//div[@class='subcategories']/ul/li/a[contains(@href, '49_51')]")
	private WebElement fragMen;

	@FindBy(css = "a[data-id='63']")
	private WebElement clickAddToCartIcon;

	@FindBy(css = "a.prdocutname[title*='Pour Homme E']")
	private WebElement product;

	@FindBy(css = "a.cart[onclick]")
	private WebElement addToCart;

	@FindBy(css = "a#cart_checkout1")
	private WebElement checkout;

	@FindBy(css = "button#checkout_btn")
	private WebElement orderCnf;

	@FindBy(css = "span.maintext")
	private WebElement orderConfirmMessage;

	By itemsList = By.cssSelector("a.prdocutname");

	@FindBy(css = "a.prdocutname")
	private List<WebElement> productsList;

//	Constructor declaration
	public OrderProcessPages(WebDriver driver) {
		super();
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public void hoverFragnance() {
		actions.moveToElement(Fragnance).build().perform();
	}

	public void clickMenOption() {
		fragMen.click();
	}

	public void clickAddToCartIcon() {
		clickAddToCartIcon.click();
	}

//	public void clickOnProduct() {
//		product.click();
//	}

	public void addProduct() {
		addToCart.click();
	}

	public void moveToCheckout() {
		checkout.click();
	}

	public void orderConfirmed() {
		orderCnf.click();
	}

	public void verifyOrderSuccess() throws InterruptedException {
		String orderCnfMessage = orderConfirmMessage.getText().trim();
		Thread.sleep(2000);
		Assert.assertEquals(orderCnfMessage, "YOUR ORDER HAS BEEN PROCESSED!");
		Base base = new Base();
		base.logOut();
	}

	public void clickOnProduct1(String productName) {
		driver = Base.getDriver();
		WebElement productLink = driver
				.findElement(By.xpath("//div[@class=\"fixed_wrapper\"]//*[contains(text(),'" + productName + "')]"));
		productLink.click();
	}

	public void clickOnProductStream(String productName) {
		driver = Base.getDriver();
		List<WebElement> products = driver
				.findElements(By.xpath("//div[@class='fixed_wrapper']//*[contains(text(), '')]"));

		WebElement productLink = products.stream().filter(element -> element.getText().equalsIgnoreCase(productName))
				.findFirst().orElseThrow(() -> new RuntimeException("Product not found: " + productName));

		productLink.click();
	}
}
