package AutoMATion.CodiceFiscale;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiscalCode {

	public static void main(String[] args) {
		
		// inizializzazione driver
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		// landing page
		driver.get("https://www.codicefiscaleonline.com/");

		// accetta i consensi
		driver.findElement(By.className("fc-cta-consent")).click();

		// inserimento dei dati
		driver.findElement(By.id("input_cognome")).sendKeys("Cavalieri Manasse");
		driver.findElement(By.id("input_nome")).sendKeys("Mattia");
		driver.findElement(By.name("luogo")).sendKeys("Milano");
		driver.findElement(By.name("prov")).sendKeys("Mi");

		// seleziona il giorno di nascita
		WebElement giornoNascita = driver
				.findElement(By.cssSelector("#calcolo > div.field.data > div.input > select:nth-child(1)"));
		Select giorno = new Select(giornoNascita);
		giorno.selectByVisibleText("06");

		// seleziona il mese di nascita
		WebElement meseNascita = driver
				.findElement(By.cssSelector("#calcolo > div.field.data > div.input > select:nth-child(2)"));
		Select mese = new Select(meseNascita);
		mese.selectByVisibleText("12");

		// seleziona l'anno di nascita
		WebElement annoNascita = driver
				.findElement(By.cssSelector("#calcolo > div.field.data > div.input > select:nth-child(3)"));
		Select anno = new Select(annoNascita);
		anno.selectByVisibleText("1980");
		
		// calcola codice fiscale
		driver.findElement(By.cssSelector("#calcolo > div.submit > input[type=submit]")).click();
		
		// recupera il codice fiscale generato
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#calcolo > div.field.cf > div.input")));
		String CF = driver.findElement(By.cssSelector("#calcolo > div.field.cf > div.input")).getText();
		System.out.println("Il codice fiscale generato è: " + CF);
	}

}
