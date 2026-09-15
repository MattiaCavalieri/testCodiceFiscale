package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutoMATion.CodiceFiscale.FiscalCode;

public class AbstractComponent {

	WebDriver driver;
	FiscalCode fiscalCode;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebDriver initializeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void waitForElementToAppear(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void goTo() {
		driver.get("https://www.codicefiscaleonline.com/");
	}
	
	
	public FiscalCode launchAutomation() {
		WebDriver driver = initializeDriver();
		FiscalCode fiscalCode = new FiscalCode(driver);
		fiscalCode.goTo();
		return fiscalCode;
	}

}
