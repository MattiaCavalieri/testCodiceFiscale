package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codiceFiscale.FiscalCode;
import data.GeneratorePersona;
import data.Persona;

public class AbstractComponent {

	WebDriver driver;
	FiscalCode fiscalCode;
	GeneratorePersona generatore;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generatore = new GeneratorePersona();
	}

	public void waitForElementToAppear(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public Persona generaPersona() {
		Persona persona = generatore.generaPersona();
		return persona;
	}

}
