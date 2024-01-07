package CodeX.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @Column(name = "idPedido")
    private String idPedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nombreCliente", referencedColumnName = "nombre")
    @JoinColumn(name = "emailCliente", referencedColumnName = "email")
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoArticulo", referencedColumnName = "codigo")
    private Articulo articulos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaPedido")
    private Date fecha;

    @Column(name = "cantidadArticulo")
    private int cantidadArticulo;

    @Transient
    private float total;

    @Transient
    public float pEnvio;
    protected Pedidos() {
    }

    public Pedidos(String idPedido, Cliente cliente, Articulo articulos, int cantidadArticulo) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.articulos = articulos;
        this.cantidadArticulo = cantidadArticulo;
        this.fecha = new Date(); // Establece la fecha actual al crear el pedido
        this.pEnvio = precioEnvio();
        calcularTotal();
    }

    private void calcularTotal() {
        float totalSinDescuento = articulos.getPrecio() * cantidadArticulo;
        float descuento = totalSinDescuento * cliente.descuentoEnv() / 100f;
        total = totalSinDescuento - descuento;
    }

    public float precioEnvio() {
        float precioEnvioSinDescuento = articulos.getGastosenvio();
        float descuento = precioEnvioSinDescuento * cliente.descuentoEnv() / 100f;
        pEnvio = precioEnvioSinDescuento - descuento;
        return pEnvio;
    }

    public boolean pedidoEnviado() {
        int minutos = articulos.getTpreparacion();
        Date fechaAhora = new Date();
        long diferenciaTiempo = fechaAhora.getTime() - this.fecha.getTime();
        int minutosComparar = (int) (diferenciaTiempo / (1000 * 60));
        return minutosComparar >= minutos;
    }

    // Getters, Setters, y otros métodos

    @Override
    public String toString() {
        return "| | Pedido " + idPedido + " Fecha: " + fecha + '\n' +
                "    |*  Nombre: " + cliente.getNombre() + "\n" +
                "    |*  EMAIL: " + cliente.getEmail() + "\n" +
                "     ---------------\n" +
                "    |*  Codigo: " + articulos.getCodigo() + "\n" +
                "    |*  Descripcion: " + articulos.getDescripcion() + "\n" +
                "    |*  Cantidad: " + cantidadArticulo + "\n" +
                "    |*  Precio: " + articulos.getPrecio() + "\n" +
                "    |*  Costes Envio: " + pEnvio + "\n" +
                "    |*  Total: " + total + "\n" +
                "    |*  Enviado: " + pedidoEnviado() + "\n";
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Articulo getArticulo() {
        return articulos;
    }
}
