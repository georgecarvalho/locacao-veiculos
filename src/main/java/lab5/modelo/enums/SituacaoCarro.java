package lab5.modelo.enums;

public enum SituacaoCarro {
	
	DISPONIVEL ("Disponivel"),
	ALUGADO ("Alugado"),
	FORA_DO_PONTO_DE_ORIGEM("Fora do ponto de origem");
	
	private String situacao;

	private SituacaoCarro(String situacao) { this.situacao = situacao; }

	public String getSituacao() { return situacao; }
	
}
