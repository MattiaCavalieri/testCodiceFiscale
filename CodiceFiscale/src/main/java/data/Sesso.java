package data;

public enum Sesso {

	MASCHILE("M"), FEMMINILE("F");

	private final String valoreForm;

	private Sesso(String valoreForm) {
		this.valoreForm = valoreForm;
	}

	public String getValoreForm() {
		return valoreForm;
	}

}
