package lab5.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import lab5.modelo.Clientes;

public class ClientesRepository {

    private final EntityManager manager;
    private DAOGenerico<Clientes> daoGenerico;

    public ClientesRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Clientes>(manager);
    }

    public Clientes buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Clientes.class, id);
    }

    public List<Clientes> buscaPor(String nome) {
        return this.manager.createQuery("from Clientes " +
                "where upper(nome) like :nome", Clientes.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Clientes salvaOuAtualiza(Clientes cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);
    }

    public void remove(Clientes cliente) {
        daoGenerico.remove(cliente );
    }
}
