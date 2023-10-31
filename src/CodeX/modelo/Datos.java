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

    public void listarClientes() {
        int cLista = listaClientes.getSize();
        if (cLista >= 1){
            System.out.println("Los clientes disponibles son los siguientes");
            System.out.println("═════════════════════════════════════════════");
            for(int i = 0;i < cLista;i++){
                Cliente cListar = listaClientes.listarCliente(i);
                System.out.println(cListar.toString());
            }
        } else {
            System.out.println("No hay clientes registrados...");
        }
    }
    public void listarClientesFiltro(String tipo){
        int cLista = listaClientes.getSize();
        boolean check = false;
        if (cLista >= 1){
            for(int i = 0;i < cLista;i++){
                Cliente cListar = listaClientes.listarClienteFiltro(i, tipo);
                if (cListar != null){
                    if(!check){
                        System.out.println("Los clientes "+ tipo + " disponibles son los siguientes");
                        System.out.println("═════════════════════════════════════════════");
                        check = true;
                    }
                    System.out.println(cListar.toString());
                }
            }
            if (!check){
                System.out.println("═════════════════════════════════════════════");
                System.out.println("No hay clientes " + tipo + " registrados...");
            }
        } else {
            System.out.println("═════════════════════════════════════════════");
            System.out.println("No hay clientes " + tipo + " registrados...");
        }
    }

    // ARTÍCULOS

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
                Articulo arti = listaArticulos.getAt(i);
                System.out.println(arti.toString());

            }
        } else {
            System.out.println("No hay artículos en el inventario...");
        }

    }


    // PEDIDOS
    public void hacerPedido() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el codigo del pedido: ");
        String id = scanner.nextLine();
        for (Pedidos ped: listaPedidos.lista){


        System.out.print("Ingrese el codigo del articulo: ");
        String codigo = scanner.nextLine();
        Articulo arti = null;
        if (buscarArticulo(codigo)!=null){
            for (Articulo articulo: listaArticulos.lista){
                if (articulo.getCodigo().equals(codigo)){
                    arti = articulo;
                }
            }
        }
        System.out.print("Ingrese la cantidad del articulo: ");
        int cantidad  = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduzca el email del ciente: ");
        String email = scanner.nextLine();
        Cliente cliente = listaClientes.existeCliente(email);
        if (cliente == null){
            System.out.print("Ingrese el nombre del Cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese domicilio del Cliente: ");
            String domicilio = scanner.nextLine();
            System.out.print("Ingrese el nif del Cliente: ");
            String nif = scanner.nextLine();
            String tipocliente = seleccionartipocliente();
            if (tipocliente.equals("Estandar")){
                ClienteEstandar cnuevo = new ClienteEstandar(nombre, domicilio, email, nif);
                listaClientes.agregarclienteEstandar(cnuevo);
                Pedidos pedido = new Pedidos()
            } else if (tipocliente.equals("Premium")) {
                ClientePremium cnuevo = new ClientePremium(nombre, domicilio, email, nif);
                listaClientes.agregarclientesPremium(cnuevo);
            }
        }
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

