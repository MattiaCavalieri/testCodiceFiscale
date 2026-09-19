package AutoMATion.CodiceFiscale;

import org.testng.annotations.Test;

import codiceFiscale.FiscalCode;
import testComponents.BaseTest;

public class GeneraCodiceFiscale extends BaseTest {
	
	
	@Test
	public void generateFiscalCode() {
		
		FiscalCode fiscalCode = launchAutomation();
		fiscalCode.accettaConsensi();
		fiscalCode.insertData();
		fiscalCode.calcolaCF();
		System.out.println(fiscalCode.recuperaCF());
	}

}
