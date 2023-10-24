package CodeX.modelo;

import java.util.ArrayList;

public class ListaPedidos {
    private ArrayList<Pedido> listaPedidos;

    public ListaPedidos() {
        listaPedidos = new ArrayList<>();
    }

    public int getSize() {
        return listaPedidos.size();
    }

    public void agregarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public void eliminarPedido(Pedido pedido) {
        listaPedidos.remove(pedido);
    }

    public Pedido obtenerPedido(int indice) {
        if (indice >= 0 && indice < listaPedidos.size()) {
            return listaPedidos.get(indice);
        }
        return null;
    }

    public void limpiarLista() {
        listaPedidos.clear();
    }

    public boolean estaVacia() {
        return listaPedidos.isEmpty();
    }

    public ArrayList<Pedido> obtenerLista() {
        return new ArrayList<>(listaPedidos);
    }
}
