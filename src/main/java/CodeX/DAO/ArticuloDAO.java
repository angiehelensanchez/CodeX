package CodeX.DAO;

import CodeX.modelo.Articulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ArticuloDAO {
    private final SessionFactory factory;
    public ArticuloDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulo.class).buildSessionFactory();
    }
    // Agregar un nuevo artículo

    public void addArticulo(Articulo articulo) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(articulo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // Obtener un artículo por su código ----------dudas
    public Articulo getArticulo(String codigo) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Articulo articulo = session.get(Articulo.class, codigo);
            session.getTransaction().commit();
            return articulo;
        } catch (Exception e) {
            return null;
        }
    }
    /*

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
*/

    // Eliminar un artículo
    public void deleteArticulo(String codigo) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Articulo articulo = session.get(Articulo.class, codigo);
            if (articulo != null) {
                session.delete(articulo);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos los artículos
    public List<Articulo> listArticulos() {
        // Obtiene la sesión actual
        try (Session session = factory.getCurrentSession()) {
            // Inicia la transacción
            session.beginTransaction();

            // Recupera todos los artículos de la base de datos
            List<Articulo> articulos = session.createQuery("from Articulo", Articulo.class).getResultList();
            // Commit de la transacción
            session.getTransaction().commit();

            return articulos; // Devuelve la lista de artículos
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    // Método para cerrar la fábrica de sesiones (debería llamarse al finalizar la aplicación)
    public void cerrarFactory() {
        if (factory != null && !factory.isClosed()) {
            factory.close();
        }
    }

}