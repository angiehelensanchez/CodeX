package CodeX.vista;

import CodeX.controlador.Controlador;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionOS {
    private Controlador controlador;
    public GestionOS() {
        controlador = new Controlador();
    }
    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("\n═════════════════════════════════════════════");
            System.out.println("══════════════ Menu Inicial ═════════════════");
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    menuArticulos();
                    break;
                case '2':
                    gestionarClientes();
                    break;
                case '3':
                    menuPedidos();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    char pedirOpcion() {
        Scanner scanner = new Scanner(System.in);
        String resp;
        System.out.print("Elige una opción (1,2,3 o 0): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Debes ingresar un número.");
            scanner.next(); // Descarta la entrada incorrecta
        }
        resp = scanner.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
    private String escribirErrores(Exception e){
        String errores = e.getMessage();
        return errores;
    }
// ARTICULOS
    private void menuArticulos() {
        Scanner scanner = new Scanner(System.in);
        int opcionArticulos;

        do {
            System.out.println("\n═════════════════════════════════════════════");
            System.out.println("════════════ Gestionar Artículos ═════════════");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Eliminar Artículo");
            System.out.println("3. Listar Artículos");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                scanner.next(); // Descarta la entrada incorrecta
            }
            opcionArticulos = scanner.nextInt();

            switch (opcionArticulos) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    eliminarArticulo();
                    break;
                case 3:
                    listarArticulo();
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }while (opcionArticulos != 4);
    }
    // Menu de solicitud de datos para agregar un nuevo articulo
    private  void agregarArticulo(){
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
        try {
            controlador.aNuevoArticulo(codigo, descripcion, precio, gastosenvios, tpreparacion);
        }
        catch (Exception e){
            System.out.println(escribirErrores(e));
        }
    }
    private void eliminarArticulo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del artículo: ");
        String id = scanner.nextLine();
        try{
            controlador.eArticulo(id);
        }
        catch (Exception e){
            System.out.println(escribirErrores(e));
        }
    }
    private void listarArticulo(){
        ArrayList<String> articulos = controlador.lArticulo();
        for(String arti:articulos){
            System.out.println(arti);
        }
    }

    //CLIENTES
    private void gestionarClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcionClientes;

        do {
            System.out.println("\n═════════════════════════════════════════════");
            System.out.println("════════════ Gestionar Clientes ═════════════");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Estandar");
            System.out.println("4. Mostrar Clientes Premium");
            System.out.println("5. Eliminar Cliente");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                scanner.next(); // Descarta la entrada incorrecta
            }
            opcionClientes = scanner.nextInt();
            scanner.nextLine();

            switch (opcionClientes) {
                case 1:
                    agregarCliente();
                break;
                case 2:
                    listarCliente();
                break;
                case 3:
                    String tipo1 = "Estandar";
                    listarCLienteFiltro(tipo1);
                break;
                case 4:
                    String tipo2 = "Premium";
                    listarCLienteFiltro(tipo2);
                break;
                case 5:
                    eliminarCLiente();
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcionClientes != 6);
    }
    public String sTipoCliente(){
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
    public void agregarCliente(){
        String tipo = sTipoCliente();
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
        controlador.aNuevoCliente(tipo,nombre,domicilio,email,nif);
    }
    public void eliminarCLiente(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor introduzca el email del cliente: ");
        String email = scanner.nextLine();
        try{
          controlador.eCliente(email);
        }
        catch (Exception e){
            System.out.println(escribirErrores(e));
        }
    }

    public void listarCliente(){
        ArrayList<String> Clientes = controlador.lClientes();
        for(String cliente:Clientes){
            System.out.println(cliente);
        }
    }
    public void listarCLienteFiltro(String tipo){
        ArrayList<String> Clientes = controlador.lcFiltro(tipo);
        for(String cliente:Clientes){
            System.out.println(cliente);
        }
    }

// Pedidos
    private void menuPedidos() {
        Scanner scanner = new Scanner(System.in);
        int opcionpedidos;

        do {
            System.out.println("\n═════════════════════════════════════════════");
            System.out.println("════════════ Gestionar Pedidos ═════════════");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Eliminar pedido");
            System.out.println("3. Mostrar pedidos pendientes");
            System.out.println("4. Mostar pedidos enviados");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                scanner.next(); // Descarta la entrada incorrecta
            }
            opcionpedidos = scanner.nextInt();

            switch (opcionpedidos) {
                case 1:
                    agregarPedido();
                    break;
                case 2:
                    eliminarPedido();
                    break;
                case 3:
                    listarPendiente();
                    break;
                case 4:
                    listarEnviado();
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }while (opcionpedidos != 5);
    }
    public void agregarPedido(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el codigo del articulo: ");
        String codigo = scanner.nextLine();
        if(controlador.bArticulo(codigo) != null){
            System.out.print("Ingrese la cantidad del articulo: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el email del cliente: ");
            String email = scanner.nextLine();
            if (controlador.bCliente(email) == null){
                String tipo = sTipoCliente();
                System.out.print("Ingrese el nombre del Cliente: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese domicilio del Cliente: ");
                String domicilio = scanner.nextLine();
                System.out.print("Ingrese el nif del Cliente: ");
                String nif = scanner.nextLine();
                controlador.aNuevoCliente(tipo,nombre,domicilio,email,nif);
            }
            controlador.aPedido(codigo,cantidad,email);
        } else{
            System.out.println("No existe el articulo indicado");
        }
    }
    public void eliminarPedido(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del pedido: ");
        String id = scanner.nextLine();
        if (controlador.bPedido(id) != null && !controlador.bPedido(id).pedidoEnviado()) {
            controlador.ePedido(id);
            System.out.println("Pedido eliminado.");
        } else {
            System.out.println("Pedido no encontrado o fuera de plazo.");
        }
    }
    public String filtroCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n═════════════════════════════════════════════");
        System.out.println("════════ ¿Desea filtrar por cliente? ════════");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.print("Indique el email del cliente: ");
            String email = scanner.nextLine();
            if (controlador.bCliente(email) != null) {
                return email;
            } else {
                System.out.println("Cliente no registrado.");
            }
        }
        return null;
    }
    public void listarPendiente(){
        ArrayList<String> Pendientes = controlador.lPendientes(filtroCliente());
        System.out.println("Los pedidos pendientes son los siguientes:");
        System.out.println("═════════════════════════════════════════════");
        for(String pedido:Pendientes){
            System.out.println(pedido);
        }
    }
    public void listarEnviado(){
        ArrayList<String> Enviados = controlador.lEnviados(filtroCliente());
        System.out.println("Los pedidos enviados son los siguientes:");
        System.out.println("═════════════════════════════════════════════");
        for(String pedido:Enviados){
            System.out.println(pedido);
        }
    }

}


