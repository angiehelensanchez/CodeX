package CodeX.DAO;


import CodeX.modelo.Pedidos;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PedidosDAO {
    private final SessionFactory factory;
    public PedidosDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pedidos.class).buildSessionFactory();
    }
    // Agregar un nuevo pedido
    public void addPedido(Pedidos pedido) {
        try (Session session =  factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener un pedido por su ID
    public Pedidos getPedido(String idPedido) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Pedidos pedido = session.get(Pedidos.class, idPedido);
            session.getTransaction().commit();
            return pedido;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
/*
    // Actualizar un pedido existente
    public void updatePedido(Pedidos pedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(pedido);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

 */

    // Eliminar un pedido
    public void deletePedido(String idPedido) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Pedidos pedido = session.get(Pedidos.class, idPedido);
            if (pedido != null) {
                session.delete(pedido);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos los pedidos
    public List<Pedidos> listarTodosLosPedidos() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Pedidos> pedidos = session.createQuery("from Pedidos", Pedidos.class).list();
            for (Pedidos pedido : pedidos) {
                Hibernate.initialize(pedido.getCliente());
                Hibernate.initialize(pedido.getArticulo());
            }
            session.getTransaction().commit();
            return pedidos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
