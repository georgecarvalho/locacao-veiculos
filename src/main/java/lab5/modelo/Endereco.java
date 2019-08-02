package lab5.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String logradouro;

    private String numero;

    private String cep;

    @ManyToOne
    @JoinColumn(name = "sedes_id", nullable = false)
    private Sedes sedes;

    //Getters and Setters
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getLogradouro() { return logradouro; }

    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

	public Sedes getSedes() { return sedes; }

	public void setSedes(Sedes sedes) { this.sedes = sedes; }

	//Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
