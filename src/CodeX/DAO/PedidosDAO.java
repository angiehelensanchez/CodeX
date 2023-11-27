package CodeX.DAO;

import CodeX.modelo.Pedidos;
import CodeX.modelo.Cliente;
import CodeX.modelo.Articulo;
import CodeX.dbutilidad.utilidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;



public class PedidosDAO {


    // Método para agregar un pedido
    public void addPedido(Pedidos pedido) {
        String sql = "INSERT INTO Pedidos (idPedido, nifCliente, codigoArticulo, cantidadArticulo, fechaPedido, emailCliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pedido.getIdPedido());
            pstmt.setString(2, pedido.getCliente().getNif());
            pstmt.setString(3, pedido.getArticulo().getCodigo());
            pstmt.setInt(4, pedido.getCantidadArticulo());
            pstmt.setTimestamp(5, new Timestamp(pedido.getFecha().getTime()));
            pstmt.setString(6, pedido.getCliente().getEmail()); // Añade el email del cliente

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Método para obtener un pedido por ID
    public Pedidos getPedido(String idPedido) {
        String sql = "SELECT * FROM Pedidos WHERE idPedido = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idPedido);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nifCliente = rs.getString("nifCliente");
                String codigoArticulo = rs.getString("codigoArticulo");
                int cantidad = rs.getInt("cantidadArticulo");
                Timestamp fechaPedidoTS = rs.getTimestamp("fechaPedido");

                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.getCliente(nifCliente);
                if (cliente == null) {
                    // Cliente no encontrado, se debe manejar esta situación.
                    return null;
                }

                ArticuloDAO articuloDAO = new ArticuloDAO();
                Articulo articulo = articuloDAO.getArticulo(codigoArticulo);
                if (articulo == null) {
                    // Artículo no encontrado, se debe manejar esta situación.
                    return null;
                }

                Pedidos pedido = new Pedidos(idPedido, cliente, articulo, cantidad);
                if (fechaPedidoTS != null) {
                    pedido.setFecha(new Date(fechaPedidoTS.getTime())); // Establece la fecha del pedido
                }

                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Método para eliminar un pedido
    public void deletePedido(String idPedido) {
        String sql = "DELETE FROM Pedidos WHERE idPedido = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idPedido);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para listar todos los pedidos
    public List<Pedidos> listarTodosLosPedidos() {
        List<Pedidos> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedidos";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String idPedido = rs.getString("idPedido");
                String nifCliente = rs.getString("nifCliente");
                String codigoArticulo = rs.getString("codigoArticulo");
                int cantidad = rs.getInt("cantidadArticulo");
                Timestamp fechaPedidoTS = rs.getTimestamp("fechaPedido");
                String emailCliente = rs.getString("emailCliente");

                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.getCliente(nifCliente);
                if (cliente == null) {
                    continue; // Omitir este pedido si el cliente es nulo
                }

                ArticuloDAO articuloDAO = new ArticuloDAO();
                Articulo articulo = articuloDAO.getArticulo(codigoArticulo);
                if (articulo == null) {
                    continue; // Omitir este pedido si el artículo es nulo
                }

                Pedidos pedido = new Pedidos(idPedido, cliente, articulo, cantidad);
                if (fechaPedidoTS != null) {
                    pedido.setFecha(new Date(fechaPedidoTS.getTime()));
                }
                cliente.setEmail(emailCliente); // Asignar el email al cliente

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }


}