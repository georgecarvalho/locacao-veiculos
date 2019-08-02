package lab5.modelo;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

@Entity @Table(name = "sedes")
public class Sedes implements EntidadeBase {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "sedes", cascade = CascadeType.ALL)
    private Set<Endereco> enderecos = new LinkedHashSet<Endereco>();
	
	@ElementCollection
    @Column(name = "telefone", nullable = false)
    @CollectionTable(name = "telefones", joinColumns = @JoinColumn(name = "cliente_id", nullable = false))
    private Set<String> telefones = new LinkedHashSet<String>();
	
	private String gerente;
	
	@Column(name = "multa")
	private BigDecimal multaPorEntregaEmOutroPonto = BigDecimal.ZERO;
	
	@OneToMany(mappedBy = "sede")
    private Set<Carros> carros;
	
	@OneToMany(mappedBy = "sede")
    private Set<Reservas> reservas;
	
	//Getters and Setters
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public String getGerente() { return gerente; }

	public void setGerente(String gerente) { this.gerente = gerente; }

	public BigDecimal getMultaPorEntregaEmOutroPonto() { return multaPorEntregaEmOutroPonto; }

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
		Sedes other = (Sedes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
