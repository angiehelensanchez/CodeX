package CodeX.modelo;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Pedidos {

    private String idPedido; // Identificador único del pedido
    private Cliente cliente; // El cliente que hizo el pedido
    private Articulo articulos; // Lista de artículos en el pedido
    private Date fecha; // Fecha en que se hizo el pedido
    private int candidadarticulo;
    private float total;
    public  float pEnvio;

    public Pedidos (String idPedido, Cliente cliente, Articulo articulos, int candidadarticulo) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.articulos = articulos;
        this.candidadarticulo = candidadarticulo;
        this.fecha = new Date(); // La fecha actual
        this.pEnvio = precioEnvio();
        calcularTotal();

    }

    private void calcularTotal() {
        float totalsindescuento = articulos.getPrecio() * candidadarticulo;
        float descuento = totalsindescuento * cliente.descuentoEnv()/100f;
        total = totalsindescuento - descuento;

    }
    public float precioEnvio(){
       float pEnviSinDes = articulos.getGastosenvio();
       float decuento = pEnviSinDes * cliente.descuentoEnv()/100f;
       pEnvio = pEnviSinDes - decuento;
       return pEnvio;
    }
    public boolean pedidoEnviado(){
        int minutos = articulos.getTpreparacion();
        Date fechaPedido = fecha;
        Date fechaAhora = new Date();
        Long dTiempo = fechaAhora.getTime() - fechaPedido.getTime();
        int mcomparar = (int)(dTiempo/(1000*60));
        return mcomparar >= minutos;
    }

    // Getter para idPedidos
    public String getIdPedido() {
        return idPedido;
    }

    // Setter para idPedido
    public void setIdPedido(String idPedidos) {
        this.idPedido = idPedidos;
    }

    // Getter para cliente
    public Cliente getCliente() {
        return cliente;
    }

    // Setter para cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return  "| | Pedido " + idPedido + " Fecha: "+ fecha+ '\n' +
                "    |*  Nombre: " + cliente.getNombre() + "\n"+
                "    |*  NIF: "+ cliente.getNif() +"\n"+
                "     ---------------\n"+
                "    |*  Codigo: " + articulos.getCodigo() + "\n"+
                "    |*  Descripcion: "+ articulos.getDescripcion() +"\n"+
                "    |*  Cantidad: "+ candidadarticulo +"\n"+
                "    |*  Precio: "+ articulos.getPrecio() +"\n"+
                "    |*  Costes Envio: "+ pEnvio +"\n"+
                "    |*  Total: "+total +"\n"+
                "    |*  Enviado: "+ pedidoEnviado() +"\n";
    }
}


