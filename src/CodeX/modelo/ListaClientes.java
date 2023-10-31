package CodeX.modelo;

import java.util.ArrayList;

public class ListaClientes extends Lista<Cliente>{
    private ArrayList<Cliente> listaClientes;

    public ListaClientes() {
        listaClientes = new ArrayList<>();
    }

    public int getSize() {
        return listaClientes.size();
    }

    public void agregarclienteEstandar(ClienteEstandar cliente) {
        int c = listaClientes.size();
        boolean check = false;
        for (int i = 0; i < c; i++) {
            if (listaClientes.get(i).getEmail().equals(cliente.getEmail())) {
                check = true;
            }
        }
        if (check) {
            System.out.println("Ya hay un cliente registrado con el email: " + cliente.getEmail());
        } else {
            listaClientes.add(cliente);
        }
    }
    public Cliente existeCliente(String email){
        int c = listaClientes.size();
        for(int i = 0; i<c; i++){
            if ( listaClientes.get(i).getEmail().equals(email)) {
                return listaClientes.get(i);
            }
        }
        return null;
    }
    public Cliente listarCliente(int i){
        return listaClientes.get(i);
    }
    public Cliente listarClienteFiltro(int i, String tipo){
        if (listaClientes.get(i).tipoCliente().equals(tipo)){
            return listaClientes.get(i);
        }else {
            return null;
        }
    }
    public void agregarclientesPremium(ClientePremium cliente){
        int c = listaClientes.size();
        boolean check = false;
        for(int i = 0; i<c; i++){
            if ( listaClientes.get(i).getEmail().equals(cliente.getEmail())){
                check = true;
            }
        }
        if(check){
            System.out.println("Ya hay un cliente registrado con el email: " + cliente.getEmail());
        }else {
            listaClientes.add(cliente);
        }

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
