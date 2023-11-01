package modelo;

import CodeX.modelo.Articulo;
import CodeX.modelo.Lista;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListaArticulosTest extends Lista<Articulo> {

    @Test
    public void agregarArticulo(Articulo articulo) {
        lista.add(articulo);
    }


    @Test
    public void eliminarArticulo(Articulo articulo){
        lista.remove(articulo);
    }
}

