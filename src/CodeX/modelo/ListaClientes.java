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

    public void agregarclienteEstandar(ClienteEstandar cliente) {
        listaClientes.add(cliente);
    }
    public void agregarclientesPremium(ClientePremium cliente){
        listaClientes.add(cliente);
    }

    public void eliminar(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public Cliente buscarPorMail(String email) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email)) { // Suponiendo que la clase Cliente tiene un método getEmail
                return cliente;
            }
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
