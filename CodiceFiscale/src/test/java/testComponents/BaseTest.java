package testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import codiceFiscale.FiscalCode;

public class BaseTest {
	WebDriver driver;
	FiscalCode fiscalCode;

	public WebDriver initializeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public FiscalCode launchAutomation() {
		WebDriver driver = initializeDriver();
		fiscalCode = new FiscalCode(driver);
		fiscalCode.goTo();
		return fiscalCode;
	}

}
