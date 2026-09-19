package codiceFiscale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import abstractComponent.AbstractComponent;
import data.Persona;

public class FiscalCode extends AbstractComponent {

	WebDriver driver;
	Persona persona;

	@FindBy(className = "fc-cta-consent")
	WebElement accettaConsensi;

	By cognome = By.id("input_cognome");
	By nome = By.id("input_nome");
	By luogoNascita = By.name("luogo");
	By provinciaNascita = By.name("prov");
	By sesso = By.name("sesso");
	By giornoNascita = By.cssSelector("#calcolo > div.field.data > div.input > select:nth-child(1)");
	By meseNascita = By.cssSelector("#calcolo > div.field.data > div.input > select:nth-child(2)");
	By annoNascita = By.cssSelector("#calcolo > div.field.data > div.input > select:nth-child(3)");

	@FindBy(css = "#calcolo > div.submit > input[type=submit]")
	WebElement calcolaCodiceFiscale;

	By codiceFiscaleGenerato = By.cssSelector("#calcolo > div.field.cf > div.input");

	public FiscalCode(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		persona = generaPersona();
	}

	public void goTo() {
		driver.get("https://www.codicefiscaleonline.com/");
	}
	
	public void accettaConsensi() {
		accettaConsensi.click();
	}

	public void insertData() {
		driver.findElement(cognome).sendKeys(persona.getCognome());
		driver.findElement(nome).sendKeys(persona.getNome());
		driver.findElement(luogoNascita).sendKeys("Roma");
		driver.findElement(provinciaNascita).sendKeys("RM");
		
		// sesso
		Select sessoP = new Select(driver.findElement(sesso));
		sessoP.selectByVisibleText(persona.getSesso().getValoreForm());
		
		// giorno
		WebElement giorno = driver.findElement(giornoNascita);
		Select giornoN = new Select(giorno);
		giornoN.selectByVisibleText("12");
		// mese
		WebElement mese = driver.findElement(meseNascita);
		Select meseN = new Select(mese);
		meseN.selectByVisibleText("12");
		// anno
		WebElement anno = driver.findElement(annoNascita);
		Select annoN = new Select(anno);
		annoN.selectByVisibleText("1980");
	}

	public void calcolaCF() {
		calcolaCodiceFiscale.click();
	}

	public String recuperaCF() {
		waitForElementToAppear(codiceFiscaleGenerato);
		String CF = driver.findElement(codiceFiscaleGenerato).getText();
		return CF;
	}

}
