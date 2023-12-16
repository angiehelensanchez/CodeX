package CodeX.DAO;

import CodeX.modelo.Pedidos;
import CodeX.dbutilidad.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PedidosDAO {

    // Agregar un nuevo pedido
    public void addPedido(Pedidos pedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Obtener un pedido por su ID
    public Pedidos getPedido(String idPedido) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Pedidos.class, idPedido);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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

    // Eliminar un pedido
    public void deletePedido(String idPedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Pedidos pedido = session.get(Pedidos.class, idPedido);
            if (pedido != null) {
                session.delete(pedido);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para listar todos los pedidos
    public List<Pedidos> listarTodosLosPedidos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from pedidos", Pedidos.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
