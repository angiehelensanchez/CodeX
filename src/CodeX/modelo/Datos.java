package CodeX.modelo;


import java.util.List;
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
        // Crear una instancia del cliente
        if (tipocliente.equals("Estandar")){
            ClienteEstandar cnuevo = new ClienteEstandar(nombre, domicilio, email, nif);
            listaClientes.agregarclienteEstandar(cnuevo);
        } else if (tipocliente.equals("Premium")) {
            ClientePremium cnuevo = new ClientePremium(nombre, domicilio, email, nif);
            listaClientes.agregarclientesPremium(cnuevo);
        }

    }

    public void eliminarCliente(String email) {
        Cliente cliente = buscarCliente(email);
        if (cliente != null) {
            listaClientes.eliminar(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public Cliente buscarCliente(String id) {
        return listaClientes.buscarPorMail(id); // ListaClientes debe tener un método buscarPorId
    }

    public List<Cliente> listarClientes() {
        return listaClientes.getListado(); // ListaClientes debe tener un método getListado
    }

    // ARTÍCULOS -------------------------------------

    public void crearArticulo(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("----- Agregar Artículo -----");
            System.out.print("Ingrese el codigo del artículo: ");
            String codigo = scanner.nextLine();

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
            Articulo nuevoArticulo = new Articulo(codigo, descripcion, precio, gastosenvios, tpreparacion);
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
    public Articulo buscarArticulo(String codigo) {
        return listaArticulos.buscarPorCodigo(codigo); // ListaArticulos debe tener un método buscarPorId
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

    public void listArticulos() {
        int cLista = listaArticulos.getSize();
        if (cLista >= 1){
            System.out.println("Los artículos disponibles son los siguientes");
            System.out.println("═════════════════════════════════════════════");
            for(int i = 0;i < cLista;i++){
                Articulo arti = listaArticulos.listarInventario(i);
                System.out.println(arti.toString());

            }
        } else {
            System.out.println("No hay artículos en el inventario...");
        }

    }





    // PEDIDOS -------------------------------------
    public void hacerPedido(Pedidos pedido) {
        listaPedidos.agregarPedido(pedido);
    }

    public void eliminarPedido(int idPedido) {
        Pedidos pedido = buscarPedido(idPedido);
        if (pedido != null) {
            listaPedidos.eliminarPedido(pedido);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }


    public Pedidos buscarPedido(int idPedido) {
        return listaPedidos.buscarPorId(idPedido); // ListaPedidos debe tener un método buscarPorId
    }

}

