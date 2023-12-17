package CodeX.controlador;
import CodeX.modelo.*;

public class Controlador {
        private Datos datos;
        public Controlador() {
            datos = new Datos ();
        }
/*
    //CLIENTES
    public void aNuevoCliente(String tipocliente, String nombre, String domicilio, String email, String nif){
        datos.agregarCliente(tipocliente, nombre, domicilio, email, nif);

    }
    public void eCliente(String email) throws Exception{
        datos.eliminarCliente(email);
    }
    public ArrayList<String> lClientes(){
        return datos.listarClientes();
    }
    public ArrayList<String> lcFiltro(String tipo){
        return datos.listarClientesFiltro(tipo);
    }
    public Cliente bCliente(String mail){
        return datos.getCliente(mail);
    }



 */
    //ARTICULOS
    /*
    public void aNuevoArticulo(String codigo, String descripcion, Float precio, Float gastosenvios, int tpreparacion) throws Exception{
        datos.crearArticulo(codigo, descripcion, precio, gastosenvios, tpreparacion);
    }
    public void eArticulo(String id) throws Exception{
        datos.eliminarArticulo(id);
    }

     */
    public ArrayList<String> lArticulo(){
        return datos.listArticulos();
    }
    /*
    public Articulo bArticulo(String codigo){
        return datos.getArticulo(codigo);
    }

    //PEDIDOS
    public void aPedido(String arti, int cantidad, String cliente){ datos.hacerPedidos(arti,cantidad,cliente);}
    public Pedidos bPedido(String id){ return datos.buscarPedidos(id);}
    public void ePedido(String id){
        datos.eliminarPedidos(id);
    }
    public ArrayList<String> lPendientes(String email){
        return datos.listarPedidosPendientes(email);
    }
    public ArrayList<String> lEnviados(String email){
        return datos.listarPedidosEnviados(email);
    }
    


     */
}
