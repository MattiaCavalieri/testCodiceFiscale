package codiceFiscale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodiceFiscale {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FiscalCode cf = new FiscalCode(driver);
		cf.goTo();
		cf.accettaConsensi();
		cf.insertData();
		cf.calcolaCF();
		cf.stampaDatiCF();
	}

}
