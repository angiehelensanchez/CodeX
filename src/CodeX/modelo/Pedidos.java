package CodeX.modelo;

import java.util.Date;
public class Pedidos {

    private String idPedido; // Identificador único del pedido
    private Cliente cliente; // El cliente que hizo el pedido
    private Articulo articulos; // Lista de artículos en el pedido
    private Date fecha; // Fecha en que se hizo el pedido
    private int candidadarticulo;
    private float total;
    public float pEnvio;

    public Pedidos(String idPedido, Cliente cliente, Articulo articulos, int candidadarticulo) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.articulos = articulos;
        this.candidadarticulo = candidadarticulo;
        this.fecha = new Date(); // Establece la fecha actual al crear el pedido
        this.pEnvio = precioEnvio();
        calcularTotal();
    }

    private void calcularTotal() {
        float totalsindescuento = articulos.getPrecio() * candidadarticulo;
        float descuento = totalsindescuento * cliente.descuentoEnv() / 100f;
        total = totalsindescuento - descuento;
    }

    public float precioEnvio() {
        float pEnviSinDes = articulos.getGastosenvio();
        float descuento = pEnviSinDes * cliente.descuentoEnv() / 100f;
        pEnvio = pEnviSinDes - descuento;
        return pEnvio;
    }

    public boolean pedidoEnviado() {
        int minutos = articulos.getTpreparacion();
        Date fechaAhora = new Date();
        long dTiempo = fechaAhora.getTime() - this.fecha.getTime();
        int mcomparar = (int) (dTiempo / (1000 * 60));
        return mcomparar >= minutos;
    }

    // Getters y Setters
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulos;
    }

    public void setArticulo(Articulo articulos) {
        this.articulos = articulos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadArticulo() {
        return candidadarticulo;
    }

    public void setCantidadArticulo(int candidadarticulo) {
        this.candidadarticulo = candidadarticulo;
    }

    @Override
    public String toString() {
        return "| | Pedido " + idPedido + " Fecha: " + fecha + '\n' +
                "    |*  Nombre: " + cliente.getNombre() + "\n" +
                "    |*  NIF: " + cliente.getNif() + "\n" +
                "     ---------------\n" +
                "    |*  Codigo: " + articulos.getCodigo() + "\n" +
                "    |*  Descripcion: " + articulos.getDescripcion() + "\n" +
                "    |*  Cantidad: " + candidadarticulo + "\n" +
                "    |*  Precio: " + articulos.getPrecio() + "\n" +
                "    |*  Costes Envio: " + pEnvio + "\n" +
                "    |*  Total: " + total + "\n" +
                "    |*  Enviado: " + pedidoEnviado() + "\n";
    }
}



