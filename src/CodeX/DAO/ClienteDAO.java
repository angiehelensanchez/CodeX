package CodeX.DAO;

import CodeX.modelo.Cliente;
import CodeX.dbutilidad.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
import java.util.ArrayList;


public class ClienteDAO {

    // Método para agregar un cliente

    public void addCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    // Método para obtener un cliente por Email
    public Cliente getCliente(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Utiliza HQL (Hibernate Query Language) para buscar el cliente
            String hql = "FROM Cliente WHERE email = :email";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);
            query.setParameter("email", email);
            List<Cliente> result = query.getResultList();
            if (!result.isEmpty()) {
                // Retorna el primer cliente encontrado con ese email
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente getClienteByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Cliente where email = :email", Cliente.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Método para actualizar un cliente
    public void updateCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    // Método para eliminar un cliente
    public void deleteCliente(String nif) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, nif);
            if (cliente != null) {
                session.delete(cliente);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para listar todos los clientes
       public List<Cliente> listClientes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Utiliza HQL para obtener todos los clientes
            String hql = "FROM Cliente";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para listar clientes filtrados por tipo
    public List<Cliente> listClientesFiltradosPorTipo(String tipo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Cliente> query = session.createQuery("from Cliente where tipoCliente = :tipo", Cliente.class);
            query.setParameter("tipo", tipo);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}

