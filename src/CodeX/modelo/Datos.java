package CodeX.modelo;

import java.util.*;
import CodeX.DAO.ArticuloDAO;
import CodeX.DAO.ClienteDAO;
import CodeX.DAO.PedidosDAO;

public class Datos {

    // CLIENTES
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
        Cliente cliente = clienteDAO.getClienteByEmail(email);
        if (cliente != null) {
            clienteDAO.deleteCliente(cliente.getNif());
        } else {
            throw new Exception("Artículo no encontrado.");
        }
    }
    public ArrayList<String> listarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<String> datos = new ArrayList<String>();
        for (Cliente cliente : clienteDAO.listClientes()) {
            datos.add(cliente.toString());
        }
        return datos;
    }

    public ArrayList<String> listarClientesFiltro(String tipo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<String> datos = new ArrayList<String>();
        for (Cliente cliente : clienteDAO.listClientesFiltradosPorTipo(tipo)) {
            datos.add(cliente.toString());
        }
        return datos;
    }

    public Cliente getCliente(String email) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getCliente(email);
    }

    public void updateCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.updateCliente(cliente);
    }


    // ARTÍCULOS

    // Método para crear y agregar un nuevo Articulo
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
    public ArrayList<String> listArticulos() {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ArrayList<String> datos = new ArrayList<String>();
        //Suponiendo que ArticuloDAO tiene un método listArticulos() que devuelve List<Articulo>
        for (Articulo arti : articuloDAO.listArticulos()) {
            datos.add(arti.toString());
        }
        return datos;
    }
    public Articulo getArticulo(String codigo) {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        return articuloDAO.getArticulo(codigo);
    }

    // PEDIDOS
    public void hacerPedidos(Articulo arti, int cantidad, Cliente cliente) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        String idPedido = generarIdPedido(cliente);
        Pedidos pedido = new Pedidos(idPedido, cliente, arti, cantidad);
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


    public ArrayList<String> listarPedidosPendientes(String email) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List<Pedidos> todosLosPedidos = pedidosDAO.listarTodosLosPedidos();
        ArrayList<String> datos = new ArrayList<String>();
        for (Pedidos pedido : todosLosPedidos) {
            if (!pedido.pedidoEnviado() && (email == null || pedido.getCliente().getEmail().equals(email))) {
                datos.add(pedido.toString());
            }
        }
        return datos;
    }

    public ArrayList<String> listarPedidosEnviados(String email) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List<Pedidos> todosLosPedidos = pedidosDAO.listarTodosLosPedidos();
        ArrayList<String> datos = new ArrayList<String>();
        for (Pedidos pedido : todosLosPedidos) {
            if (pedido.pedidoEnviado() && (email == null || pedido.getCliente().getEmail().equals(email))) {
                datos.add(pedido.toString());
            }
        }
        return datos;
    }
}

