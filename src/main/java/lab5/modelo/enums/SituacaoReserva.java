package lab5.modelo.enums;

public enum SituacaoReserva {
	
	ATIVA ("Ativa"),
	ATRASADA ("Atrasada"),
	FINALIZADA ("Finalizada");
	
	private String situacao;

	private SituacaoReserva(String situacao) { this.situacao = situacao; }

	public String getSituacao() { return situacao; }

}
