package lab5.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import lab5.modelo.Reservas;

public class ReservasRepository {
	private final EntityManager manager;
    private DAOGenerico<Reservas> daoGenerico;

    public ReservasRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Reservas>(manager);
    }

    public Reservas buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Reservas.class, id);
    }

    public List<Reservas> buscaPor(String numeroReserva) {
        return this.manager.createQuery("from Reservas " +
                "where upper(numero_reserva) like :numero_reserva", Reservas.class)
                .setParameter("numero_reserva", numeroReserva.toUpperCase() + "%")
                .getResultList();
    }

    public Reservas salvaOuAtualiza(Reservas cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);
    }

    public void remove(Reservas cliente) {
        daoGenerico.remove(cliente );
    }
}
