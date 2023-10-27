package CodeX.modelo;

import java.util.List;

public class ListaArticulos extends Lista<Articulo> {
    public ListaArticulos(){
        super();
    }

    public Articulo buscarPorCodigo(String codigo) {
        for (Articulo articulo : lista) {
            if (articulo.getCodigo().equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
    public void agregarArticulo(Articulo articulo) {
        lista.add(articulo);
    }
    public void eliminarArticulo(Articulo articulo){
        lista.remove(articulo);
    }

}
