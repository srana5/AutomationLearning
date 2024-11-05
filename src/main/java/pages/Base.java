package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

//	private static Base instance = null;
	private static WebDriver driver;

//	private Base() {
//
//	}
	
//	public static Base getInstance() {
//		if(instance == null) {
//			instance = new Base();
//		}
//		return instance;
//	}

	public void initiateBrowser() {
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		if (driver != null) {
			return driver;
		} else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			// options.addArguments("--headless");
			driver = new ChromeDriver(options);
			return driver;
		}
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void exWait(By By) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By));
	}

	public void logOut() {
		Actions action = new Actions(driver);
		WebElement accountsMenu = driver.findElement(By.xpath("//div[@class='menu_text']"));
		action.moveToElement(accountsMenu).build().perform();
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		String lgOffPath = "//div[@id='customernav']/ul/li/ul/li[10]/a";
		WebElement logOffLink = wt.until(ExpectedConditions.elementToBeClickable(By.xpath(lgOffPath)));
		logOffLink.click();
	}
}
