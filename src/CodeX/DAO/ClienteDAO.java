package CodeX.DAO;

import CodeX.modelo.Cliente;
import CodeX.dbutilidad.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
        String sql = "SELECT * FROM Cliente WHERE email = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String nif = rs.getString("nif");
                String tipoCliente = rs.getString("tipoCliente");

                Cliente cliente;
                if ("Estandar".equals(tipoCliente)) {
                    cliente = new ClienteEstandar(nombre, domicilio, email, nif);
                } else if ("Premium".equals(tipoCliente)) {
                    cliente = new ClientePremium(nombre, domicilio, email, nif);
                } else {
                    // Manejar situación si el tipo de cliente no es ni Estandar ni Premium
                    return null;
                }
                // Asignar el email recuperado de la base de datos al cliente
                cliente.setEmail(email);
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String email = rs.getString("email");
                String nif = rs.getString("nif");
                String tipoCliente = rs.getString("tipoCliente");

                if ("Estandar".equals(tipoCliente)) {
                    clientes.add(new ClienteEstandar(nombre, domicilio, email, nif));
                } else if ("Premium".equals(tipoCliente)) {
                    clientes.add(new ClientePremium(nombre, domicilio, email, nif));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente getClienteByEmail(String email) {
        String sql = "SELECT * FROM Cliente WHERE email = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String nif = rs.getString("nif");
                String tipoCliente = rs.getString("tipoCliente");

                if ("Estandar".equals(tipoCliente)) {
                    return new ClienteEstandar(nombre, domicilio, email, nif);
                } else if ("Premium".equals(tipoCliente)) {
                    return new ClientePremium(nombre, domicilio, email, nif);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Cliente> listClientesFiltradosPorTipo(String tipo) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE tipoCliente = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String email = rs.getString("email");
                String nif = rs.getString("nif");

                if ("Estandar".equals(tipo)) {
                    clientes.add(new ClienteEstandar(nombre, domicilio, email, nif));
                } else if ("Premium".equals(tipo)) {
                    clientes.add(new ClientePremium(nombre, domicilio, email, nif));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

}

