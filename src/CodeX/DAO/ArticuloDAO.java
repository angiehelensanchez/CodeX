package CodeX.DAO;

import CodeX.modelo.Articulo;
import CodeX.dbutilidad.utilidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;



public class ArticuloDAO {

    // Agregar un nuevo artículo
    public void addArticulo(Articulo articulo) {
        String sql = "INSERT INTO Articulo (codigo, descripcion, precio, gastosEnvio, tpreparacion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, articulo.getCodigo());
            pstmt.setString(2, articulo.getDescripcion());
            pstmt.setFloat(3, articulo.getPrecio());
            pstmt.setFloat(4, articulo.getGastosenvio());
            pstmt.setInt(5, articulo.getTpreparacion());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener un artículo por su código
    public Articulo getArticulo(String codigo) {
        String sql = "SELECT * FROM Articulo WHERE codigo = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                float gastosEnvio = rs.getFloat("gastosEnvio");
                int tpreparacion = rs.getInt("tpreparacion");

                return new Articulo(codigo, descripcion, precio, gastosEnvio, tpreparacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar un artículo existente
    public void updateArticulo(Articulo articulo) {
        String sql = "UPDATE Articulo SET descripcion = ?, precio = ?, gastosEnvio = ?, tpreparacion = ? WHERE codigo = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, articulo.getDescripcion());
            pstmt.setFloat(2, articulo.getPrecio());
            pstmt.setFloat(3, articulo.getGastosenvio());
            pstmt.setInt(4, articulo.getTpreparacion());
            pstmt.setString(5, articulo.getCodigo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un artículo
    public void deleteArticulo(String codigo) {
        String sql = "DELETE FROM Articulo WHERE codigo = ?";
        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para listar todos los artículos
    public List<Articulo> listArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM Articulo";

        try (Connection conn = utilidad.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                float gastosEnvio = rs.getFloat("gastosEnvio");
                int tpreparacion = rs.getInt("tpreparacion");

                articulos.add(new Articulo(codigo, descripcion, precio, gastosEnvio, tpreparacion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articulos;
    }


}
