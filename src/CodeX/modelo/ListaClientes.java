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
    public Cliente listarCliente(int i){
        return listaClientes.get(i);
    }
    public void agregarclientesPremium(ClientePremium cliente){
        listaClientes.add(cliente);
    }

    public void eliminar(Cliente cliente) {
        listaClientes.remove(cliente);
        System.out.println("Cliente eliminado con exito.");
    }
    public String tipos(int i){
        return listaClientes.get(i).tipoCliente();
    }
    public Cliente buscarPorMail(String email) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email)) { // Suponiendo que la clase Cliente tiene un método getEmail
                return cliente;
            }
        }
        return null;
    }



}
