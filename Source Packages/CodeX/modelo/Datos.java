package CodeX.modelo;

public class Datos {

    private ListaClientes listaClientes;
    private ListaArticulos listaArticulos;
    private ListaPedidos listaPedidos;

    public Datos() {
        this.listaClientes = new ListaClientes();
        this.listaArticulos = new ListaArticulos();
        this.listaPedidos = new ListaPedidos();
    }

    // CLIENTES -------------------------------------
    public void agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getId()) == null) {
            listaClientes.agregar(cliente);
        } else {
            System.out.println("Cliente ya existe.");
        }
    }

    public void eliminarCliente(int id) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {
            listaClientes.eliminar(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public Cliente buscarCliente(int id) {
        return listaClientes.buscarPorId(id); // ListaClientes debe tener un método buscarPorId
    }

    public List<Cliente> listarClientes() {
        return listaClientes.getListado(); // ListaClientes debe tener un método getListado
    }

    // ARTÍCULOS -------------------------------------
    public void agregarArticulo(Articulo articulo) {
        if (buscarArticulo(articulo.getId()) == null) {
            listaArticulos.agregar(articulo);
        } else {
            System.out.println("Artículo ya existe.");
        }
    }

    public void eliminarArticulo(int id) {
        Articulo articulo = buscarArticulo(id);
        if (articulo != null) {
            listaArticulos.eliminar(articulo);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    public Articulo buscarArticulo(int id) {
        return listaArticulos.buscarPorId(id); // ListaArticulos debe tener un método buscarPorId
    }

    public List<Articulo> listarArticulos() {
        return listaArticulos.getListado(); // ListaArticulos debe tener un método getListado
    }

    // PEDIDOS -------------------------------------
    public void hacerPedido(Pedido pedido) {
        listaPedidos.agregar(pedido);
    }

    public void eliminarPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            listaPedidos.eliminar(pedido);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public Pedido buscarPedido(int idPedido) {
        return listaPedidos.buscarPorId(idPedido); // ListaPedidos debe tener un método buscarPorId
    }

    public List<Pedido> listarPedidos() {
        return listaPedidos.getListado(); // ListaPedidos debe tener un método getListado
    }
}

