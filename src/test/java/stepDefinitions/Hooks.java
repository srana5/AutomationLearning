package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.Base;

public class Hooks {

	Base base = new Base();
	private WebDriver driver;

	@Before
	public void setUp() {
		if (driver == null) {
			driver = Base.getDriver();
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			base.quitDriver();
		}
	}

}
