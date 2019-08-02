package lab5.modelo;

import java.util.Set;

import javax.persistence.*;

import lab5.modelo.enums.SituacaoCarro;

@Entity @Table(name = "carros")
public class Carros implements EntidadeBase {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private String modelo;
	
	private Integer ano;
	
	private double quilometragem;
	
	@Column(columnDefinition = "text")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private SituacaoCarro situacao;
	
	@ManyToOne
	@JoinColumn(name = "classeDoCarro_id", referencedColumnName = "id", nullable = false)
	private ClassesDeCarro classeDoCarro;
	
	@OneToMany(mappedBy = "carro")
    private Set<Reservas> reservas;
	
	@ManyToOne  
	@JoinColumn(name = "sede_id", referencedColumnName = "id", nullable = false)
	private Sedes localizacaoAtual;
	
	@ManyToOne  
	@JoinColumn(name = "sede_id", referencedColumnName = "id", nullable = false)
	private Sedes pontoDeOrigem;
	
	//Getters and Setters
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getPlaca() { return placa; }

	public void setPlaca(String placa) { this.placa = placa; }

	public String getModelo() { return modelo; }

	public void setModelo(String modelo) { this.modelo = modelo; }

	public Integer getAno() { return ano; }

	public void setAno(Integer ano) { this.ano = ano; }

	public double getQuilometragem() { return quilometragem; }

	public void setQuilometragem(double quilometragem) { this.quilometragem = quilometragem; }

	public String getDescricao() { return descricao; }

	public void setDescricao(String descricao) { this.descricao = descricao; }

	//HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carros other = (Carros) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
