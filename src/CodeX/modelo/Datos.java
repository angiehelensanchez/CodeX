package CodeX.modelo;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

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
    public void agregarClienteEstandar(ClienteEstandard cliente) {
        listaClientes.agregar(cliente);
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

    public void crearArticulo(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("----- Agregar Artículo -----");
            System.out.print("Ingrese el nombre del artículo: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la descripción del artículo: ");
            String descripcion = scanner.nextLine();

            System.out.print("Ingrese el precio del artículo: ");
            float precio = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Ingrese el importe de gastos de envios: ");
            float gastosenvios = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Ingrese el tiempo de preparacion: ");
            int tpreparacion = scanner.nextInt();
            scanner.nextLine();
            // Crear una instancia del artículo
            Articulo nuevoArticulo = new Articulo(nombre, descripcion, precio, gastosenvios, tpreparacion);
            agregarArticulo(nuevoArticulo);
    }
    public void agregarArticulo(Articulo articulo) {
        String id = articulo.getCodigo();
        if (buscarArticulo(id) == null) {
            listaArticulos.agregarArticulo(articulo);
        } else {
            System.out.println("Artículo ya existe.");
        }
    }
    public Articulo buscarArticulo(String  id) {
        return listaArticulos.buscarPorCodigo(id); // ListaArticulos debe tener un método buscarPorId
    }
    public void eliminarArticulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del artículo: ");
        String id = scanner.nextLine();
        Articulo articulo = buscarArticulo(id);
        if (articulo != null) {
            listaArticulos.eliminarArticulo(articulo);

        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    public String listArticulos() {
        int cLista = listaArticulos.getSize();
        for(int i = 0;i<= cLista;i++){
            Articulo arti = listaArticulos.listarInventario(i);
            return  arti.toString();
        }
        return null;
    }





    // PEDIDOS -------------------------------------
    public void hacerPedido(Pedidos pedido) {

        listaPedidos.agregar(pedido);
        //ListaPedidos.agregarPedido(pedido);
    }

    public void eliminarPedido(int idPedido) {
        Pedidos pedido = buscarPedido(idPedido);
        if (pedido != null) {
            listaPedidos.eliminar(pedido);

        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public Pedidos buscarPedido(int idPedido) {
        return listaPedidos.buscarPorId(idPedido); // ListaPedidos debe tener un método buscarPorId
    }

}

