package lab5.modelo;

import java.util.Date;

import javax.persistence.*;

import lab5.modelo.enums.CategoriaCnh;

@Embeddable
public class Cnh {
	
	private String numero;
	
	private Date validade;
	
	private CategoriaCnh categoria;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public CategoriaCnh getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaCnh categoria) {
		this.categoria = categoria;
	}
	
}
