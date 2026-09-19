package testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import codiceFiscale.FiscalCode;
import data.GeneratorePersona;

public class BaseTest {
	WebDriver driver;
	FiscalCode fiscalCode;
	GeneratorePersona generatore;

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
