package CodeX.modelo;

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
    public void agregar(Articulo articulo) {
        lista.add(articulo);
    }
}
