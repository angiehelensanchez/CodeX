package CodeX.modelo;

import java.util.Scanner;
import java.util.*;
import CodeX.DAO.ArticuloDAO;

import CodeX.DAO.ClienteDAO;
import CodeX.DAO.PedidosDAO;


public class Datos {

    private ListaClientes listaClientes;
    private ListaArticulos listaArticulos;
    private ListaPedidos listaPedidos;

    public Datos() {
        this.listaClientes = new ListaClientes();
        this.listaArticulos = new ListaArticulos();
        this.listaPedidos = new ListaPedidos();
    }
    public String seleccionartipocliente(){
        Scanner scanner = new Scanner(System.in);
        String tipocliente = "";
        int optio;
        do {
            System.out.println("\n═════════════════════════════════════════════");
            System.out.println("════════ Seleccionar tipo de cliente ════════");
            System.out.println("1. Estandar");
            System.out.println("2. Premium -- Indicar cuota anual de 30€ y ventajas en un 20% de descuento en gastos de envío");
            System.out.println("3. Salir");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                scanner.next(); // Descarta la entrada incorrecta
            }
            optio = scanner.nextInt();
            switch (optio) {
                case 1:
                    tipocliente = "Estandar";
                    return tipocliente;
                case 2:
                    tipocliente = "Premium";
                    return tipocliente;
                case 3:
                    System.out.println("Cancelando...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }while (optio != 3);
        return null;
    }
    // CLIENTES
    public void agregarCliente(String tipocliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Agregar Cliente -----");
        System.out.print("Ingrese el nombre del Cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese domicilio del Cliente: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingrese el email del Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el nif del Cliente: ");
        String nif = scanner.nextLine();

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente;
        if (tipocliente.equals("Estandar")) {
            cliente = new ClienteEstandar(nombre, domicilio, email, nif);
        } else {
            cliente = new ClientePremium(nombre, domicilio, email, nif);
        }
        clienteDAO.addCliente(cliente);
    }

    public void eliminarCliente(String email) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.getClienteByEmail(email);
        if (cliente != null) {
            clienteDAO.deleteCliente(cliente.getNif());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public Cliente buscarCliente(String email) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getClienteByEmail(email);
    }

    public void listarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        for (Cliente cliente : clienteDAO.listClientes()) {
            System.out.println(cliente.toString());
        }
    }

    public void listarClientesFiltro(String tipo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        for (Cliente cliente : clienteDAO.listClientesFiltradosPorTipo(tipo)) {
            System.out.println(cliente.toString());
        }
    }

    public Cliente getCliente(String nif) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getCliente(nif);
    }

    public void updateCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.updateCliente(cliente);
    }


    // ARTÍCULOS

    // Método para crear y agregar un nuevo Articulo
    public void crearArticulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Agregar Artículo -----");
        System.out.print("Ingrese el codigo del artículo: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese la descripción del artículo: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el precio del artículo: ");
        while (!scanner.hasNextFloat()) {
            System.out.println("Entrada no válida. Debes ingresar un número flotante.");
            scanner.next(); // Descarta la entrada incorrecta
        }
        float precio = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Ingrese el importe de gastos de envios: ");
        while (!scanner.hasNextFloat()) {
            System.out.println("Entrada no válida. Debes ingresar un número flotante.");
            scanner.next(); // Descarta la entrada incorrecta
        }
        float gastosenvios = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Ingrese el tiempo de preparacion: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Debes ingresar un número entero.");
            scanner.next(); // Descarta la entrada incorrecta
        }
        int tpreparacion = scanner.nextInt();
        scanner.nextLine();

        Articulo nuevoArticulo = new Articulo(codigo, descripcion, precio, gastosenvios, tpreparacion);
        agregarArticulo(nuevoArticulo);
    }

    // Método para agregar un Articulo usando ArticuloDAO
    public void agregarArticulo(Articulo articulo) {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        if (articuloDAO.getArticulo(articulo.getCodigo()) == null) {
            articuloDAO.addArticulo(articulo);
        } else {
            System.out.println("Artículo ya existe.");
        }
    }

    // Método para buscar un Articulo
    public Articulo buscarArticulo(String codigo) {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        return articuloDAO.getArticulo(codigo);
    }

    // Método para eliminar un Articulo
    public void eliminarArticulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del artículo: ");
        String id = scanner.nextLine();

        ArticuloDAO articuloDAO = new ArticuloDAO();
        if (articuloDAO.getArticulo(id) != null) {
            articuloDAO.deleteArticulo(id);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }


    public void listArticulos() {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        // Suponiendo que ArticuloDAO tiene un método listArticulos() que devuelve List<Articulo>
        for (Articulo arti : articuloDAO.listArticulos()) {
            System.out.println(arti.toString());
        }
    }


    // PEDIDOS
    public void hacerPedidos() {
        Scanner scanner = new Scanner(System.in);
        PedidosDAO pedidosDAO = new PedidosDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();

        System.out.print("Ingrese el codigo del articulo: ");
        String codigo = scanner.nextLine();
        Articulo arti = articuloDAO.getArticulo(codigo); // Busca el artículo en la base de datos

        if (arti != null) {
            System.out.print("Ingrese la cantidad del articulo: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el email del cliente: ");
            String email = scanner.nextLine();
            Cliente cliente = clienteDAO.getClienteByEmail(email); // Busca el cliente en la base de datos

            if (cliente == null) {
                // Crear un nuevo cliente
                System.out.print("Ingrese el nombre del Cliente: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese domicilio del Cliente: ");
                String domicilio = scanner.nextLine();
                System.out.print("Ingrese el nif del Cliente: ");
                String nif = scanner.nextLine();
                cliente = new ClienteEstandar(nombre, domicilio, email, nif); // O ClientePremium, según la lógica
                clienteDAO.addCliente(cliente); // Agrega el cliente a la base de datos
            }

            String idPedido = generarIdPedido(cliente); // Implementa la lógica para generar ID del pedido
            Pedidos pedido = new Pedidos(idPedido, cliente, arti, cantidad);
            pedidosDAO.addPedido(pedido);
            System.out.println("Pedido agregado correctamente");
        } else {
            System.out.println("No existe el artículo indicado.");
        }
    }

    private String generarIdPedido(Cliente cliente) {
        Calendar fecha = Calendar.getInstance();
        return cliente.getNif() + "_" + fecha.get(Calendar.DAY_OF_YEAR) + "_" +
                fecha.get(Calendar.YEAR) + "_" + fecha.get(Calendar.HOUR_OF_DAY) +
                fecha.get(Calendar.MINUTE) + fecha.get(Calendar.MILLISECOND);
    }

    public void eliminarPedidos() {
        Scanner scanner = new Scanner(System.in);
        PedidosDAO pedidosDAO = new PedidosDAO();

        System.out.print("Ingrese el id del pedido: ");
        String id = scanner.nextLine();

        // Primero verifica si el pedido existe en la base de datos
        Pedidos ped = pedidosDAO.getPedido(id);
        if (ped != null) {
            // Si el pedido existe, procede a eliminarlo
            pedidosDAO.deletePedido(id);
            System.out.println("Pedido eliminado.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public Pedidos buscarPedidos(String id) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        return pedidosDAO.getPedido(id);
    }

    public String filtroCliente() {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("\n═════════════════════════════════════════════");
        System.out.println("════════ ¿Desea filtrar por cliente? ════════");
        System.out.println("1. Si");
        System.out.println("2. No");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Indique el email del cliente: ");
            String email = scanner.nextLine();

            // Usa ClienteDAO para buscar el cliente en la base de datos
            Cliente cliente = clienteDAO.getClienteByEmail(email);

            if (cliente != null) {
                return email;
            } else {
                System.out.println("Cliente no registrado.");
            }
        }
        return null;
    }

    public void listarPedidosPendientes() {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List<Pedidos> todosLosPedidos = pedidosDAO.listarTodosLosPedidos();
        String filtroEmail = filtroCliente();

        System.out.println("Los pedidos pendientes son los siguientes:");
        System.out.println("═════════════════════════════════════════════");

        for (Pedidos pedido : todosLosPedidos) {
            if (!pedido.pedidoEnviado() && (filtroEmail == null || pedido.getCliente().getEmail().equals(filtroEmail))) {
                System.out.println(pedido.toString());
            }
        }
    }

    public void listarPedidosEnviados() {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List<Pedidos> todosLosPedidos = pedidosDAO.listarTodosLosPedidos();
        String filtroEmail = filtroCliente();

        System.out.println("Los pedidos enviados son los siguientes:");
        System.out.println("═════════════════════════════════════════════");

        for (Pedidos pedido : todosLosPedidos) {
            if (pedido.pedidoEnviado() && (filtroEmail == null || pedido.getCliente().getEmail().equals(filtroEmail))) {
                System.out.println(pedido.toString());
            }
        }
    }

}

