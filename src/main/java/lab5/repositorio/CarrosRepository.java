package lab5.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import lab5.modelo.Carros;

public class CarrosRepository {
	 private final EntityManager manager;
	    private DAOGenerico<Carros> daoGenerico;

	    public CarrosRepository(EntityManager manager) {
	        this.manager = manager;
	        daoGenerico = new DAOGenerico<Carros>(manager);
	    }

	    public Carros buscaPor(Integer id) {
	        return daoGenerico.buscaPorId(Carros.class, id);
	    }

	    public List<Carros> buscaPor(String modelo) {
	        return this.manager.createQuery("from Carros " +
	                "where upper(modelo) like :modelo", Carros.class)
	                .setParameter("modelo", modelo.toUpperCase() + "%")
	                .getResultList();
	    }

	    public Carros salvaOuAtualiza(Carros cliente) {
	        return daoGenerico.salvaOuAtualiza(cliente);
	    }

	    public void remove(Carros cliente) {
	        daoGenerico.remove(cliente );
	    }
}
