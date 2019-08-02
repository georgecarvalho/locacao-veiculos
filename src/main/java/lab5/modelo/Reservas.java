package lab5.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lab5.modelo.enums.SituacaoReserva;

@Entity @Table(name = "reservas")
public class Reservas implements EntidadeBase {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_reserva")
	private String numeroReserva;
	
	@Column(name = "quantidade_diarias")
	private Integer quantidadeDiarias;
	
	@Column(name = "data_locacao")
	@Temporal(TemporalType.DATE)
	private Date dataLocacao;
	
	@Column(name = "data_retorno")
	@Temporal(TemporalType.DATE)
	private Date dataRetorno;
	
	@Column(name = "quilometros_rodados")
	private double quilometrosRodados;
	
	private BigDecimal multa = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	private SituacaoReserva situacao;
	
	private BigDecimal valorTotal;
	
	@ManyToOne  
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
	private Clientes cliente;
	
	@ManyToOne 
	@JoinColumn(name = "carro_id", referencedColumnName = "id", nullable = false)
	private Carros carro;
	
	@ManyToOne  
	@JoinColumn(name = "sede_id", referencedColumnName = "id", nullable = false)
	private Sedes sedeDeLocacao;
	
	@ManyToOne  
	@JoinColumn(name = "sede_id", referencedColumnName = "id", nullable = false)
	private Sedes sedeDeDevolucao;

	//Getters and Setters
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getNumeroReserva() { return numeroReserva; }

	public void setNumeroReserva(String numeroReserva) { this.numeroReserva = numeroReserva; }

	public Integer getQuantidadeDiarias() { return quantidadeDiarias; }

	public void setQuantidadeDiarias(Integer quantidadeDiarias) { this.quantidadeDiarias = quantidadeDiarias; }

	public Date getDataLocacao() { return dataLocacao; }

	public void setDataLocacao(Date dataLocacao) { this.dataLocacao = dataLocacao; }

	public Date getDataRetorno() { return dataRetorno; }

	public void setDataRetorno(Date dataRetorno) { this.dataRetorno = dataRetorno; }

	public double getQuilometrosRodados() { return quilometrosRodados; }

	public void setQuilometrosRodados(double quilometrosRodados) { this.quilometrosRodados = quilometrosRodados; }

	public BigDecimal getMulta() { return multa; }

	public BigDecimal getValorTotal() { return valorTotal; }
	
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
		Reservas other = (Reservas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
