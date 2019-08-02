package lab5.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import lab5.modelo.Sedes;

public class SedesRepository {
	
	 private final EntityManager manager;
	    private DAOGenerico<Sedes> daoGenerico;

	    public SedesRepository(EntityManager manager) {
	        this.manager = manager;
	        daoGenerico = new DAOGenerico<Sedes>(manager);
	    }

	    public Sedes buscaPor(Integer id) {
	        return daoGenerico.buscaPorId(Sedes.class, id);
	    }

	    public List<Sedes> buscaPor(String nome) {
	        return this.manager.createQuery("from Sedes " +
	                "where upper(nome) like :nome", Sedes.class)
	                .setParameter("nome", nome.toUpperCase() + "%")
	                .getResultList();
	    }

	    public Sedes salvaOuAtualiza(Sedes cliente) {
	        return daoGenerico.salvaOuAtualiza(cliente);
	    }

	    public void remove(Sedes cliente) {
	        daoGenerico.remove(cliente );
	    }
	
}
