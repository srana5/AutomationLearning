package testsr.sr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistration {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id=\"customernav\"]/ul/li/a")).click();
		driver.findElement(By.cssSelector("input#accountFrm_accountregister")).click();
		driver.findElement(By.xpath("//button[@title='Continue']")).click();

		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("jdoe@test.com");
		driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("999-999-9999");
		driver.findElement(By.cssSelector("input[name='fax']")).sendKeys("999-999");

		driver.findElement(By.cssSelector("input[name='company']")).sendKeys("Centric Consulting");
		driver.findElement(By.cssSelector("input[name='address_1']")).sendKeys("Gurugram");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Gurugram");
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='zone_id']")));
		dropdown.selectByVisibleText("Swansea");
		driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("110038");
//		Select ddn = new Select(driver.findElement(By.cssSelector("select[name='country_id']")));
//		ddn.selectByValue("204");

		driver.findElement(By.xpath("//input[@name='loginname']")).sendKeys("shubham.rana");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty123");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Qwerty123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@title='Continue']")).click();

		//Verify whether getting proper error message using Assert
		String errorMessage = driver.findElement(By.cssSelector("div.alert-danger")).getText().split("×")[1].trim();
		Assert.assertEquals(errorMessage, "Error: E-Mail Address is already registered!");
		if(driver!=null) {
			driver.quit();
		}

	}

}
