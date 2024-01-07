package CodeX.DAO;

import CodeX.modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final SessionFactory factory;
    public ClienteDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
    }

    public void addCliente(Cliente cliente) {
        try (Session session =  factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Método para obtener un cliente por Email
    public Cliente getCliente(String email) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, email);
            session.getTransaction().commit();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para eliminar un cliente
    public void deleteCliente(String email) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, email);
            if (cliente != null) {
                session.delete(cliente);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos los clientes
    public List<Cliente> listClientes() {
        try (Session session =  factory.getCurrentSession()) {
            session.beginTransaction();
            List<Cliente> clientes = session.createQuery("from Cliente", Cliente.class).getResultList();
            session.getTransaction().commit();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> listClientesEstandar() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Cliente> clientes = session.createQuery("from ClienteEstandar", Cliente.class).getResultList();
            session.getTransaction().commit();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public List<Cliente> listClientesPremium() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Cliente> clientes = session.createQuery("from ClientePremium", Cliente.class).getResultList();
            session.getTransaction().commit();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    // Método para listar clientes filtrados por tipo
    /*
    public List<Cliente> listClientesFiltradosPorTipo(String tipo) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Cliente> clientes = session.createQuery("from Cliente where tipoCliente = :tipo", Cliente.class).setParameter("tipo",tipo).getResultList();
            session.getTransaction().commit();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

     */

}


