package CodeX.vista;

import CodeX.modelo.Articulo;
import java.util.List;
import CodeX.modelo.*;



public class TestDAO {
    public static void main(String[] args) {
        Datos datos = new Datos();
        List<Articulo> articulos = datos.listArticulos();
        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }
}
