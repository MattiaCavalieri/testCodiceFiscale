package data;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import net.datafaker.Faker;

public class GeneratorePersona {

	private final Faker faker;
	private final Random random;
	private static final List<String> NOMI_MASCHILI = List.of("Alessandro", "Andrea", "Antonio", "Davide", "Federico",
			"Francesco", "Gabriele", "Lorenzo", "Luca", "Marco", "Matteo", "Simone");
	private static final List<String> NOMI_FEMMINILI = List.of("Alessandra", "Anna", "Chiara", "Elena", "Federica",
			"Francesca", "Giulia", "Laura", "Martina", "Sara", "Silvia", "Valentina");

	public GeneratorePersona() {
		faker = new Faker(Locale.ITALIAN);
		random = new Random();
	}

	public Persona generaPersona() {
		Sesso sesso = generaSesso();
		String nome = generaNome(sesso);
		String cognome = faker.name().lastName();
		return new Persona(nome, cognome, sesso);
	}

	private Sesso generaSesso() {
		Sesso[] valori = Sesso.values();
		int indice = random.nextInt(valori.length);
		return valori[indice];
	}

	private String generaNome(Sesso sesso) {
		if (sesso == Sesso.MASCHILE) {
			return estraiElemento(NOMI_MASCHILI);
		}
		return estraiElemento(NOMI_FEMMINILI);
	}

	private String estraiElemento(List<String> nomi) {
		int indice = random.nextInt(nomi.size());
		return nomi.get(indice);
	}
}
