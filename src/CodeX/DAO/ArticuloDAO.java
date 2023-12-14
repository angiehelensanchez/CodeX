package CodeX.DAO;

import CodeX.modelo.Articulo;
import CodeX.dbutilidad.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ArticuloDAO {

    // Agregar un nuevo artículo
    public void addArticulo(Articulo articulo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(articulo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Obtener un artículo por su código
    public Articulo getArticulo(String codigo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Articulo.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Actualizar un artículo existente
    public void updateArticulo(Articulo articulo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(articulo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Eliminar un artículo
    public void deleteArticulo(String codigo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Articulo articulo = session.get(Articulo.class, codigo);
            if (articulo != null) {
                session.delete(articulo);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para listar todos los artículos
    public List<Articulo> listArticulos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Articulo", Articulo.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
