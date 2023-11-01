package CodeX.modelo;

public class ListaClientes extends Lista<Cliente>{
    //private ArrayList<Cliente> listaClientes;

    //public ListaClientes() {
    //    listaClientes = new ArrayList<>();
    //}
    public ListaClientes(){
        super();
    }

    public int getSize() {
        return lista.size();
    }

    public void agregarclienteEstandar(ClienteEstandar cliente) {
        int c = lista.size();
        boolean check = false;
        for (int i = 0; i < c; i++) {
            if (lista.get(i).getEmail().equals(cliente.getEmail())) {
                check = true;
            }
        }
        if (check) {
            System.out.println("Ya hay un cliente registrado con el email: " + cliente.getEmail());
        } else {
            lista.add(cliente);
        }
    }
    public Cliente existeCliente(String email){
        int c = lista.size();
        for(int i = 0; i<c; i++){
            if ( lista.get(i).getEmail().equals(email)) {
                return lista.get(i);
            }
        }
        return null;
    }
    public Cliente listarCliente(int i){
        return lista.get(i);
    }
    public Cliente listarClienteFiltro(int i, String tipo){
        if (lista.get(i).tipoCliente().equals(tipo)){
            return lista.get(i);
        }else {
            return null;
        }
    }
    public void agregarclientesPremium(ClientePremium cliente){
        int c = lista.size();
        boolean check = false;
        for(int i = 0; i<c; i++){
            if ( lista.get(i).getEmail().equals(cliente.getEmail())){
                check = true;
            }
        }
        if(check){
            System.out.println("Ya hay un cliente registrado con el email: " + cliente.getEmail());
        }else {
            lista.add(cliente);
        }

    }

    public void eliminar(Cliente cliente) {
        lista.remove(cliente);
        System.out.println("Cliente eliminado con exito.");
    }
    public String tipos(int i){
        return lista.get(i).tipoCliente();
    }
    public Cliente buscarPorMail(String email) {
        for (Cliente cliente : lista) {
            if (cliente.getEmail().equals(email)) { // Suponiendo que la clase Cliente tiene un método getEmail
                return cliente;
            }
        }
        return null;
    }



}
