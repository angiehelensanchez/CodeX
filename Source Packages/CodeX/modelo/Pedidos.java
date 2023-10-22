package CodeX.modelo;

public class Pedidos {

    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private int idPedido; // Identificador único del pedido
    private Cliente cliente; // El cliente que hizo el pedido
    private List<Articulo> articulos; // Lista de artículos en el pedido
    private Date fecha; // Fecha en que se hizo el pedido
    private double total; // Total del pedido

    public Pedido(int idPedido, Cliente cliente, List<Articulo> articulos) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.articulos = articulos;
        this.fecha = new Date(); // La fecha actual
        calcularTotal();

    //public Datos (){
        //listaArticulos = new ListaArticulos ();
        //listaClientes = new ListaClientes();
        //listaPedidos = new ListaPedidos ();
    }

    // Método para calcular el total del pedido ¿se calcula en la lista articulos? si es el caso no seria necesario en clase pedidos
    private void calcularTotal() {
        total = 0;
        for(Articulo articulo : articulos) {
            total += articulo.getPrecio(); // Suponiendo que Articulo tiene un método getPrecio()
        }
    }
        // Getter para idPedidos
        public int getIdPedido() {
            return idPedido;
        }

        // Setter para idPedido
        public void setIdPedido(int idPedidos) {
            this.idPedidos = idPedidos;
        }

        // Getter para cliente
        public Cliente getCliente() {
            return cliente;
        }

        // Setter para cliente
        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        // Getter para articulos
        public List<Articulo> getArticulos() {
            return articulos;
        }

        // Setter para articulos
        public void setArticulos(List<Articulo> articulos) {
            this.articulos = articulos;
            calcularTotal();  // recalcula el total si la lista de artículos cambia
        }

        // Getter para fecha
        public Date getFecha() {
            return fecha;
        }

        // Setter para fecha
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        // Getter para total
        public double getTotal() {
            return total;
        }

        // No incluiría un setter para "total", ya que este valor se calcula a partir de la lista de artículos.
    }

}
