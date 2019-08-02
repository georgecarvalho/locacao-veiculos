package lab5.modelo.enums;

public enum NomeDaClasse {
	
	SUBCOMPACTO ("Subcompacto"),
	COMPACTO ("Compacto"),
	MEDIO ("Medio"),
	GRANDE ("Grande"),
	LUXO ("Luxo");
	
	private String classe;

	private NomeDaClasse(String classe) {
		this.classe = classe;
	}

	public String getClasse() {
		return classe;
	}

}
