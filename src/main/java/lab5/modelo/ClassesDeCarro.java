package lab5.modelo;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.*;

import lab5.modelo.enums.NomeDaClasse;

@Entity @Table(name = "classes_de_carro")
public class ClassesDeCarro{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private NomeDaClasse nome;
	
	@Column(name = "valor_diaria")
	private BigDecimal valorDiaria = BigDecimal.ZERO;
	
	@OneToMany(mappedBy = "classeDoCarro")
    private Set<Carros> carros;

	//Getters and Setters
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public BigDecimal getValorDiaria() { return valorDiaria; }

	public void setValorDiaria(BigDecimal valorDiaria) { this.valorDiaria = valorDiaria; }

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
		ClassesDeCarro other = (ClassesDeCarro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
