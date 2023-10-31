package CodeX.modelo;

import java.util.ArrayList;

public class ListaPedidos extends Lista<Pedidos> {

    public ListaPedidos(){
        super();
    }

    public void agregarPedido(Pedidos pedido) {
        lista.add(pedido);
    }

    public void eliminarPedido(Pedidos pedido) {
        lista.remove(pedido);
    }

    public Pedidos obtenerPedido(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    public void limpiarLista() {
        lista.clear();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public ArrayList<Pedidos> obtenerLista() {
        return new ArrayList<>(lista);
    }

    public Pedidos buscarPorId(int idPedido) {
        for (Pedidos pedido : lista ) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

}
