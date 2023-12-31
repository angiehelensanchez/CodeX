package CodeX.modelo;


import CodeX.DAO.ArticuloDAO;
import CodeX.DAO.ClienteDAO;
import CodeX.DAO.PedidosDAO;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


public class Datos {

    // CLIENTES----------------------------------------------------------------
    public void agregarCliente(String tipocliente, String nombre, String domicilio, String email, String nif) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente;
        if (tipocliente.equals("Estandar")) {
            cliente = new ClienteEstandar(nombre, domicilio, email, nif);
        } else {
            cliente = new ClientePremium(nombre, domicilio, email, nif);
        }
        clienteDAO.addCliente(cliente);
    }

    public void eliminarCliente(String email) throws Exception{
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.getCliente(email);
        if (cliente != null) {
            clienteDAO.deleteCliente(email);
        } else {
            throw new Exception("Cliente no encontrado.");
        }
    }

    public List<Cliente> listarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.listClientes();
    }


    public List<Cliente> listarClientesFiltro(String tipo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        if ("Estandar".equalsIgnoreCase(tipo)) {
            return clienteDAO.listClientesEstandar();
        } else if ("Premium".equalsIgnoreCase(tipo)) {
            return clienteDAO.listClientesPremium();
        } else {
            // Opcionalmente puedes manejar un caso por defecto
            // Por ejemplo, devolver todos los clientes si el tipo no coincide
            return clienteDAO.listClientes();
        }
    }

/*
    public List<Cliente> listarClientesFiltro(String tipo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.listClientesFiltradosPorTipo(tipo);
    }
*/
    /*
    public ArrayList<String> listarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaClientes = clienteDAO.listClientes();
        ArrayList<String> datos = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            datos.add(cliente.toString());
        }
        return datos;
    }

     */
/*
    public ArrayList<String> listarClientesFiltro(String tipo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaClientes = clienteDAO.listClientesFiltradosPorTipo(tipo);
        ArrayList<String> datos = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            datos.add(cliente.toString());
        }
        return datos;
    }

 */

    public Cliente getCliente(String email) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getCliente(email);
    }


    // ARTÍCULOS ---------------------------------------------------------------------

    public void crearArticulo(String codigo, String descripcion, Float precio, Float gastosenvios, int tpreparacion) throws Exception {
        Articulo nuevoArticulo = new Articulo(codigo, descripcion, precio, gastosenvios, tpreparacion);
        agregarArticulo(nuevoArticulo);
    }

    public void agregarArticulo(Articulo articulo) throws Exception {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        if (articuloDAO.getArticulo(articulo.getCodigo()) == null) {
            articuloDAO.addArticulo(articulo);
        } else {
            throw new Exception("El articulo ya existe.");
        }
    }


    // Método para eliminar un Articulo
    public void eliminarArticulo(String id) throws Exception {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        if (articuloDAO.getArticulo(id) != null) {
            articuloDAO.deleteArticulo(id);
        } else {
           throw new Exception("Artículo no encontrado.");
        }
    }

    //Metodo para listar un Articulo

    public List<Articulo> listArticulos() {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        List<Articulo> articulos = articuloDAO.listArticulos();
        System.out.println("Articulos en Datos: " + articulos);
        return articuloDAO.listArticulos(); // Suponiendo que este método devuelve List<Articulo>
    }

   /* public ArrayList<String> listArticulos() {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ArrayList<String> datos = new ArrayList<String>();
        //Suponiendo que ArticuloDAO tiene un método listArticulos() que devuelve List<Articulo>
        for (Articulo arti : articuloDAO.listArticulos()) {
            datos.add(arti.toString());
        }
        return datos;
    }

    */

    public Articulo getArticulo(String codigo) {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        return articuloDAO.getArticulo(codigo);
    }


    // PEDIDOS ------------------------------------------------------------

    // HACER PEDIDO NUEVO
    public void hacerPedidos(String arti, int cantidad, String emailCliente) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        Cliente cli = getCliente(emailCliente);
        if (cli == null) {
            // Manejar la situación si no se encuentra el cliente
            return;
        }
        Articulo art = getArticulo(arti);
        if (art == null) {
            // Manejar la situación si no se encuentra el artículo
            return;
        }
        String idPedido = generarIdPedido(cli);
        Pedidos pedido = new Pedidos(idPedido, cli, art, cantidad);
        pedidosDAO.addPedido(pedido);
    }

    private String generarIdPedido(Cliente cliente) {
        Calendar fecha = Calendar.getInstance();
        return cliente.getNif() + "_" + fecha.get(Calendar.DAY_OF_YEAR) + "_" +
                fecha.get(Calendar.YEAR) + "_" + fecha.get(Calendar.HOUR_OF_DAY) +
                fecha.get(Calendar.MINUTE) + fecha.get(Calendar.MILLISECOND);
    }


    public void eliminarPedidos(String id) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        Pedidos ped = buscarPedidos(id);
        if (ped != null) {
            pedidosDAO.deletePedido(id);
        } else {
            System.out.println("Pedido no encontrado o datos incompletos.");
        }
    }


    public Pedidos buscarPedidos(String id) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        return pedidosDAO.getPedido(id);
    }


    public List<Pedidos> listarPedidosPendientes(String email) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List<Pedidos> todosLosPedidos = pedidosDAO.listarTodosLosPedidos();
        return todosLosPedidos.stream()
                .filter(pedido -> !pedido.pedidoEnviado() && (email == null || pedido.getCliente().getEmail().equals(email)))
                .collect(Collectors.toList());
    }

    public List<Pedidos> listarPedidosEnviados(String email) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List<Pedidos> todosLosPedidos = pedidosDAO.listarTodosLosPedidos();
        return todosLosPedidos.stream()
                .filter(pedido -> pedido.pedidoEnviado() && (email == null || pedido.getCliente().getEmail().equals(email)))
                .collect(Collectors.toList());
    }



}

