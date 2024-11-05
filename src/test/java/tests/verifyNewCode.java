package tests;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import pages.Base;
import pages.RegistrationPage;

public class verifyNewCode {
	
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver();
		RegistrationPage rgPage = new RegistrationPage(driver);
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String[] names = {"Alice", "Bob", "Michael", "Lee", "Jennifer"};
		int randomIndex = random.nextInt(names.length);
		String[] domain = {"@gmail.com", "@test.com", "@example.com", "@demo.com"};
		int randomDomainInd = random.nextInt(domain.length);
		String userName = names[randomIndex] + randomNumber + domain[randomDomainInd];
		System.out.println(userName.toLowerCase());
		rgPage.verifyRegistrationSuccess();
	}
}
