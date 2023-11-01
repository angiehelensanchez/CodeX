package CodeX.controlador;
import CodeX.modelo.*;

public class Controlador {
        private Datos datos;
        public Controlador() {
            datos = new Datos ();
        }

    //CLIENTES
    public void agregarCliente() {
        String tipocliente = datos.seleccionartipocliente();
        datos.agregarCliente(tipocliente);

    }
    public void eliminarCliente(String email){
        datos.eliminarCliente(email);
    }
    public void listarCliente(){
        datos.listarClientes();
    }
    public void listarCFiltrado(String tipo){
        datos.listarClientesFiltro(tipo);
    }

    //ARTICULOS
    public void agregarArticulo(){
        datos.crearArticulo();
    }
    public void eliminarArticulo(){
        datos.eliminarArticulo();
    }
    public void listarArticulos(){datos.listArticulos();}
    //PEDIDOS
    public void hacerPedido(){ datos.hacerPedidos();}
    public void eliminarPedido(){
        datos.eliminarPedidos();
    }
    public void listarPendientes(){
        datos.listarPedidosPendientes();
    }
    public void listarEnviados(){
        datos.listarPedidosEnviados();
    }
}
