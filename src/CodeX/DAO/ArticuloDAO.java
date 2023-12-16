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
        /*
        version 3
        Transaction transaction = null;

        List<Articulo> articulos = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            articulos = session.createNativeQuery("FROM Articulo", Articulo.class).list();
            transaction.commit();
            return articulos;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Error al obtener la lista de artículos: " + e.getMessage());
            return null;
        }
        fin versoin 3
         */

        List<Articulo> articulos = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Realiza tu lógica aquí
            articulos = session.createQuery("FROM Articulo", Articulo.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Error en la transacción: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return articulos;
    }
        /*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object obj = session.createNativeQuery("SELECT VERSION()").getSingleResult();
            System.out.println(obj);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener la lista de artículos: " + e.getMessage());
            return null;
        }

         */

}
