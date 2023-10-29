package CodeX.modelo;

import java.util.ArrayList;

public class ListaPedidos {
    private ArrayList<Pedidos> listaPedidos;

    public ListaPedidos() {
        listaPedidos = new ArrayList<>();
    }

    public int getSize() {
        return listaPedidos.size();
    }

    public void agregarPedido(Pedidos pedido) {
        listaPedidos.add(pedido);
    }

    public void eliminarPedido(Pedidos pedido) {
        listaPedidos.remove(pedido);
    }

    public Pedidos obtenerPedido(int indice) {
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

    public ArrayList<Pedidos> obtenerLista() {
        return new ArrayList<>(listaPedidos);
    }

    public Pedidos buscarPorId(int idPedido) {
        for (Pedidos pedido : listaPedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

}
