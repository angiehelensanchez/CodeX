package CodeX.DAO;

import CodeX.modelo.Articulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ArticuloDAO {
    private final SessionFactory factory;
    public ArticuloDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulo.class).buildSessionFactory();
    }

    // Agregar un nuevo artículo
    /*
    public void addArticulo(Articulo articulo) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(articulo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

          try (Session session = factory.getCurrentSession()) {
            // Inicia la transacción
            session.beginTransaction();

            // Recupera todos los artículos de la base de datos
            List<Articulo> articulos = session.createQuery("from Articulo", Articulo.class).getResultList();

            // Imprime los artículos
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }

            // Commit de la transacción
            session.getTransaction().commit();

            return articulos; // Devuelve la lista de artículos
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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


     */



    // Método para listar todos los artículos
    public List<Articulo> listArticulos() {
        // Obtiene la sesión actual
        try (Session session = factory.getCurrentSession()) {
            // Inicia la transacción
            session.beginTransaction();

            // Recupera todos los artículos de la base de datos
            List<Articulo> articulos = session.createQuery("from Articulo", Articulo.class).getResultList();

            // Imprime los artículos
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }

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
