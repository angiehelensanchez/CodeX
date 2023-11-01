package CodeX.modelo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedidos {

    private String idPedido; // Identificador único del pedido
    private Cliente cliente; // El cliente que hizo el pedido
    private Articulo articulos; // Lista de artículos en el pedido
    private Date fecha; // Fecha en que se hizo el pedido
    private int candidadarticulo;
    private float total;

    public Pedidos (String idPedido, Cliente cliente, Articulo articulos, int candidadarticulo) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.articulos = articulos;
        this.candidadarticulo = candidadarticulo;
        this.fecha = new Date(); // La fecha actual
        calcularTotal();

    }

    // Método para calcular el total del pedido ¿se calcula en la lista articulos? si es el caso no seria necesario en clase pedidos
    private void calcularTotal() {
        float totalsindescuento = articulos.getPrecio() * candidadarticulo;
        float descuento = totalsindescuento * cliente.descuentoEnv()/100f;
        total = totalsindescuento - descuento;

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
        return  "| | Pedido " + idPedido + '\n' +
                "    " + cliente +
                "\n   " + articulos +
                "\n   Candidadarticulo=" + candidadarticulo +
                "\n   Fecha=" + fecha +
                "\n   Total=" + total;
    }
}


