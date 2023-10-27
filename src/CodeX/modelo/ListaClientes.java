package CodeX.modelo;

import java.util.ArrayList;

public class ListaClientes {
    private ArrayList<Cliente> listaClientes;

    public ListaClientes() {
        listaClientes = new ArrayList<>();
    }

    public int getSize() {
        return listaClientes.size();
    }

    public void agregarclienteEstandar(ClienteEstandard cliente) {
        listaClientes.add(cliente);
    }

    public void eliminar(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public Cliente buscarPorMail(String index) {
        if (index >= 0 && index < listaClientes.size()) {
            return listaClientes.get(index);
        }
        return null;
    }

    public void clear() {
        listaClientes.clear();
    }

    public boolean isEmpty() {
        return listaClientes.isEmpty();
    }

    public ArrayList<Cliente> getListado() {
        return new ArrayList<>(listaClientes);
    }
}
