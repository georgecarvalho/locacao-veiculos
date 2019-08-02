package lab5.modelo.enums;

public enum CategoriaCnh {
	
	A ('A'),
	B ('B'),
	C ('C'),
	D ('D'),
	E ('E');
	
	private char categoria;

	private CategoriaCnh(char categoria) {
		this.categoria = categoria;
	}

	public char getCategoria() {
		return categoria;
	}
	
}
