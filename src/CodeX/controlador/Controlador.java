package CodeX.controlador;
import CodeX.modelo.*;
import CodeX.vista.GestionOS;

import java.util.List;

public class Controlador {
        private Datos datos;
        public Controlador() {
            datos = new Datos ();
        }

    public void agregarCliente(ClienteEstandard cliente) {
        String tipocliente;
        tipocliente = GestionOS.seleccionartipocliente();
        if tipocliente == "Premium"{
            ClienteEstandard nuevocliente;
            nuevocliente = agregarClientePremium();

        }

    }
    public void agregarArticulo(){
        datos.crearArticulo();
    }
    public void eliminarArticulo(){
        datos.eliminarArticulo();
    }
    public String listarArticulos(){
        return datos.listArticulos();
    }

// TO-BE-DONE
   /* private ListaClientes listaClientes;
    private ListaArticulos listaArticulos;
    private ListaPedidos listaPedidos;

    public Controlador() {
        listaClientes = new ListaClientes();
        listaArticulos = new ListaArticulos();
        listaPedidos = new ListaPedidos();
    }*/

/*    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Artículos");
            System.out.println("3. Realizar Pedidos");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarClientes();
                    break;
                case 2:
                    gestionarArticulos();
                    break;
                case 3:
                    realizarPedidos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }*/

/*
    private void gestionarClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcionClientes;

        do {
            System.out.println("----- Gestionar Clientes -----");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Editar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            opcionClientes = scanner.nextInt();

            switch (opcionClientes) {
                case 1:
                    // Implementa la lógica para agregar un cliente.///////////////////////
                    private void agregarCliente() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Agregar Cliente -----");
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingrese el tipo de cliente (Estandar/Premium): ");
                    String tipoCliente = scanner.nextLine();

                    // Validar el tipo de cliente ingresado
                    if (!tipoCliente.equalsIgnoreCase("Estandar") && !tipoCliente.equalsIgnoreCase("Premium")) {
                        System.out.println("Tipo de cliente no válido. Use 'Estandar' o 'Premium'.");
                        return;
                    }

                    // Crear una instancia del cliente según el tipo
                    Cliente nuevoCliente;
                    if (tipoCliente.equalsIgnoreCase("Estandar")) {
                        nuevoCliente = new ClienteEstandar(nombre, apellido);
                    } else {
                        nuevoCliente = new ClientePremium(nombre, apellido);
                    }

                    // Agregar el cliente a la lista de clientes
                    listaClientes.agregarCliente(nuevoCliente);

                    System.out.println("Cliente agregado con éxito.");
                }
                    break;
                case 2:
                    // Implementa la lógica para editar un cliente.///////////////////////
                    private void editarCliente() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Editar Cliente -----");
                    System.out.print("Ingrese el ID del cliente que desea editar: ");
                    int idCliente = scanner.nextInt();

                    // Buscar el cliente por ID en la lista de clientes
                    Cliente clienteAEditar = listaClientes.buscarClientePorID(idCliente);

                    if (clienteAEditar == null) {
                        System.out.println("Cliente no encontrado. Verifique el ID del cliente.");
                        return;
                    }

                    System.out.println("Cliente encontrado:");
                    System.out.println("ID: " + clienteAEditar.getId());
                    System.out.println("Nombre: " + clienteAEditar.getNombre());
                    System.out.println("Apellido: " + clienteAEditar.getApellido());
                    System.out.println("Tipo de Cliente: " + clienteAEditar.getTipo());

                    System.out.println("----- Nuevo Registro -----");
                    System.out.print("Ingrese el nuevo nombre (deje en blanco para mantener el actual): ");
                    String nuevoNombre = scanner.nextLine().trim();
                    if (!nuevoNombre.isEmpty()) {
                        clienteAEditar.setNombre(nuevoNombre);
                    }

                    System.out.print("Ingrese el nuevo apellido (deje en blanco para mantener el actual): ");
                    String nuevoApellido = scanner.nextLine().trim();
                    if (!nuevoApellido.isEmpty()) {
                        clienteAEditar.setApellido(nuevoApellido);
                    }

                    System.out.print("Ingrese el nuevo tipo de cliente (deje en blanco para mantener el actual): ");
                    String nuevoTipo = scanner.nextLine().trim();
                    if (!nuevoTipo.isEmpty()) {
                        // Validar el tipo de cliente ingresado
                        if (!nuevoTipo.equalsIgnoreCase("Estandar") && !nuevoTipo.equalsIgnoreCase("Premium")) {
                            System.out.println("Tipo de cliente no válido. Use 'Estandar' o 'Premium'.");
                            return;
                        }

                        clienteAEditar.setTipo(nuevoTipo);
                    }

                    System.out.println("Cliente editado con éxito.");
                }


                break;
                case 3:
                    // Implementa la lógica para eliminar un cliente.///////////////////////
                    private void eliminarCliente() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Eliminar Cliente -----");
                    System.out.print("Ingrese el ID del cliente que desea eliminar: ");
                    int idCliente = scanner.nextInt();

                    // Buscar el cliente por ID en la lista de clientes
                    Cliente clienteAEliminar = listaClientes.buscarClientePorID(idCliente);

                    if (clienteAEliminar == null) {
                        System.out.println("Cliente no encontrado. Verifique el ID del cliente.");
                        return;
                    }

                    System.out.println("Cliente encontrado:");
                    System.out.println("ID: " + clienteAEliminar.getId());
                    System.out.println("Nombre: " + clienteAEliminar.getNombre());
                    System.out.println("Apellido: " + clienteAEliminar.getApellido());
                    System.out.println("Tipo de Cliente: " + clienteAEliminar.getTipo());

                    System.out.print("¿Está seguro de que desea eliminar este cliente? (S/N): ");
                    String confirmacion = scanner.next();

                    if (confirmacion.equalsIgnoreCase("S")) {
                        // Eliminar el cliente de la lista de clientes
                        listaClientes.eliminarCliente(clienteAEliminar);
                        System.out.println("Cliente eliminado con éxito.");
                    } else {
                        System.out.println("Cliente no eliminado.");
                    }
                }

                break;
                case 4:
                    // Implementa la lógica para listar clientes.///////////////////////
                    private void listarClientes() {
                    System.out.println("----- Lista de Clientes -----");

                    // Obtener la lista de clientes desde la clase ListaClientes
                    ArrayList<Cliente> clientes = listaClientes.getListaClientes();

                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.println("ID: " + cliente.getId());
                            System.out.println("Nombre: " + cliente.getNombre());
                            System.out.println("Apellido: " + cliente.getApellido());
                            System.out.println("Tipo de Cliente: " + cliente.getTipo());
                            System.out.println("----------------------");
                        }
                    }
                }

                break;
                case 5:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcionClientes != 5);

        scanner.close();
    }*/

    /*private void gestionarArticulos() {
        Scanner scanner = new Scanner(System.in);
        int opcionArticulos;

        do {
            System.out.println("----- Gestionar Artículos -----");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Editar Artículo");
            System.out.println("3. Eliminar Artículo");
            System.out.println("4. Listar Artículos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            opcionArticulos = scanner.nextInt();

            switch (opcionArticulos) {
                case 1:
                    // Implementa la lógica para agregar un artículo.///////////////////////
                    private void agregarArticulo() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Agregar Artículo -----");
                    System.out.print("Ingrese el nombre del artículo: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la descripción del artículo: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Ingrese el precio del artículo: ");
                    double precio = scanner.nextDouble();

                    // Crear una instancia del artículo
                    Articulo nuevoArticulo = new Articulo(nombre, descripcion, precio);

                    // Agregar el artículo a la lista de artículos
                    listaArticulos.agregarArticulo(nuevoArticulo);

                    System.out.println("Artículo agregado con éxito.");
                }

                break;
                case 2:
                    // Implementa la lógica para editar un artículo.///////////////////////
                    private void editarArticulo() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Editar Artículo -----");
                    System.out.print("Ingrese el ID del artículo que desea editar: ");
                    int idArticulo = scanner.nextInt();

                    // Buscar el artículo por ID en la lista de artículos
                    Articulo articuloAEditar = listaArticulos.buscarArticuloPorID(idArticulo);

                    if (articuloAEditar == null) {
                        System.out.println("Artículo no encontrado. Verifique el ID del artículo.");
                        return;
                    }

                    System.out.println("Artículo encontrado:");
                    System.out.println("ID: " + articuloAEditar.getId());
                    System.out.println("Nombre: " + articuloAEditar.getNombre());
                    System.out.println("Descripción: " + articuloAEditar.getDescripcion());
                    System.out.println("Precio: " + articuloAEditar.getPrecio());

                    System.out.println("----- Nuevo Registro -----");
                    System.out.print("Ingrese el nuevo nombre (deje en blanco para mantener el actual): ");
                    String nuevoNombre = scanner.nextLine().trim();
                    if (!nuevoNombre.isEmpty()) {
                        articuloAEditar.setNombre(nuevoNombre);
                    }

                    System.out.print("Ingrese la nueva descripción (deje en blanco para mantener la actual): ");
                    String nuevaDescripcion = scanner.nextLine().trim();
                    if (!nuevaDescripcion.isEmpty()) {
                        articuloAEditar.setDescripcion(nuevaDescripcion);
                    }

                    System.out.print("Ingrese el nuevo precio (deje en blanco para mantener el actual): ");
                    String nuevoPrecioStr = scanner.nextLine().trim();
                    if (!nuevoPrecioStr.isEmpty()) {
                        try {
                            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                            articuloAEditar.setPrecio(nuevoPrecio);
                        } catch (NumberFormatException e) {
                            System.out.println("Precio no válido. Ingrese un número válido.");
                            return;
                        }
                    }

                    System.out.println("Artículo editado con éxito.");
                }

                break;
                case 3:
                    // Implementa la lógica para eliminar un artículo.///////////////////////
                    private void eliminarArticulo() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Eliminar Artículo -----");
                    System.out.print("Ingrese el ID del artículo que desea eliminar: ");
                    int idArticulo = scanner.nextInt();

                    // Buscar el artículo por ID en la lista de artículos
                    Articulo articuloAEliminar = listaArticulos.buscarArticuloPorID(idArticulo);

                    if (articuloAEliminar == null) {
                        System.out.println("Artículo no encontrado. Verifique el ID del artículo.");
                        return;
                    }

                    System.out.println("Artículo encontrado:");
                    System.out.println("ID: " + articuloAEliminar.getId());
                    System.out.println("Nombre: " + articuloAEliminar.getNombre());
                    System.out.println("Descripción: " + articuloAEliminar.getDescripcion());
                    System.out.println("Precio: " + articuloAEliminar.getPrecio());

                    System.out.print("¿Está seguro de que desea eliminar este artículo? (S/N): ");
                    String confirmacion = scanner.next();

                    if (confirmacion.equalsIgnoreCase("S")) {
                        // Eliminar el artículo de la lista de artículos
                        listaArticulos.eliminarArticulo(articuloAEliminar);
                        System.out.println("Artículo eliminado con éxito.");
                    } else {
                        System.out.println("Artículo no eliminado.");
                    }
                }

                break;
                case 4:
                    // Implementa la lógica para listar artículos.///////////////////////
                    private void listarArticulos() {
                    System.out.println("----- Lista de Artículos -----");

                    // Obtener la lista de artículos desde la clase ListaArticulos
                    ArrayList<Articulo> articulos = listaArticulos.getListaArticulos();

                    if (articulos.isEmpty()) {
                        System.out.println("No hay artículos registrados.");
                    } else {
                        for (Articulo articulo : articulos) {
                            System.out.println("ID: " + articulo.getId());
                            System.out.println("Nombre: " + articulo.getNombre());
                            System.out.println("Descripción: " + articulo.getDescripcion());
                            System.out.println("Precio: " + articulo.getPrecio());
                            System.out.println("----------------------");
                        }
                    }
                }

                break;
                case 5:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcionArticulos != 5);

        scanner.close();
    }

    private void realizarPedidos() {
        Scanner scanner = new Scanner(System.in);
        int opcionPedidos;

        do {
            System.out.println("----- Realizar Pedidos -----");
            System.out.println("1. Crear Pedido");
            System.out.println("2. Editar Pedido");
            System.out.println("3. Eliminar Pedido");
            System.out.println("4. Listar Pedidos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            opcionPedidos = scanner.nextInt();

            switch (opcionPedidos) {
                case 1:
                    // Implementa la lógica para crear un pedido.///////////////////////
                    private void crearPedido() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Crear Pedido -----");

                    // Solicitar el ID del cliente que realiza el pedido
                    System.out.print("Ingrese el ID del cliente que realiza el pedido: ");
                    int idCliente = scanner.nextInt();

                    // Buscar el cliente por ID en la lista de clientes
                    Cliente cliente = listaClientes.buscarClientePorID(idCliente);

                    if (cliente == null) {
                        System.out.println("Cliente no encontrado. Verifique el ID del cliente.");
                        return;
                    }

                    System.out.println("Cliente encontrado:");
                    System.out.println("ID: " + cliente.getId());
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("Apellido: " + cliente.getApellido());
                    System.out.println("Tipo de Cliente: " + cliente.getTipo());

                    // Crear una lista para los artículos seleccionados en el pedido
                    ArrayList<Articulo> articulosSeleccionados = new ArrayList<>();

                    // Solicitar los artículos que se agregarán al pedido
                    while (true) {
                        System.out.print("Ingrese el ID del artículo a agregar al pedido (0 para finalizar): ");
                        int idArticulo = scanner.nextInt();

                        if (idArticulo == 0) {
                            break;
                        }

                        // Buscar el artículo por ID en la lista de artículos
                        Articulo articulo = listaArticulos.buscarArticuloPorID(idArticulo);

                        if (articulo == null) {
                            System.out.println("Artículo no encontrado. Verifique el ID del artículo.");
                        } else {
                            // Agregar el artículo a la lista de artículos seleccionados en el pedido
                            articulosSeleccionados.add(articulo);
                        }
                    }

                    // Calcular el monto total del pedido
                    double montoTotal = 0;
                    for (Articulo articulo : articulosSeleccionados) {
                        montoTotal += articulo.getPrecio();
                    }

                    // Crear un nuevo pedido
                    Pedido nuevoPedido = new Pedido(cliente, articulosSeleccionados, montoTotal);

                    // Agregar el pedido a la lista de pedidos
                    listaPedidos.agregarPedido(nuevoPedido);

                    System.out.println("Pedido creado con éxito.");
                }

                break;
                case 2:
                    // Implementa la lógica para editar un pedido.///////////////////////
                    private void editarPedido() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Editar Pedido -----");
                    System.out.print("Ingrese el ID del pedido que desea editar: ");
                    int idPedido = scanner.nextInt();

                    // Buscar el pedido por ID en la lista de pedidos
                    Pedido pedidoAEditar = listaPedidos.buscarPedidoPorID(idPedido);

                    if (pedidoAEditar == null) {
                        System.out.println("Pedido no encontrado. Verifique el ID del pedido.");
                        return;
                    }

                    System.out.println("Pedido encontrado:");
                    System.out.println("ID: " + pedidoAEditar.getId());
                    System.out.println("Cliente: " + pedidoAEditar.getCliente().getNombre() + " " + pedidoAEditar.getCliente().getApellido());
                    System.out.println("Monto Total: " + pedidoAEditar.getMontoTotal());

                    // Mostrar los artículos en el pedido
                    System.out.println("Artículos en el pedido:");
                    for (Articulo articulo : pedidoAEditar.getArticulos()) {
                        System.out.println("- " + articulo.getNombre() + " (ID: " + articulo.getId() + ")");
                    }

                    System.out.println("----- Nuevo Registro -----");

                    // Solicitar la edición del monto total (opcional)
                    System.out.print("Ingrese el nuevo monto total (deje en blanco para mantener el actual): ");
                    String nuevoMontoTotalStr = scanner.nextLine().trim();
                    if (!nuevoMontoTotalStr.isEmpty()) {
                        try {
                            double nuevoMontoTotal = Double.parseDouble(nuevoMontoTotalStr);
                            pedidoAEditar.setMontoTotal(nuevoMontoTotal);
                        } catch (NumberFormatException e) {
                            System.out.println("Monto total no válido. Ingrese un número válido.");
                            return;
                        }
                    }

                    // Solicitar la edición de los artículos en el pedido (opcional)
                    System.out.println("¿Desea editar los artículos en el pedido? (S/N): ");
                    String editarArticulos = scanner.next();

                    if (editarArticulos.equalsIgnoreCase("S")) {
                        // Crear una lista temporal de artículos para el pedido editado
                        ArrayList<Articulo> nuevosArticulos = new ArrayList<>();

                        while (true) {
                            System.out.print("Ingrese el ID del artículo a agregar al pedido (0 para finalizar): ");
                            int idArticulo = scanner.nextInt();

                            if (idArticulo == 0) {
                                break;
                            }

                            // Buscar el artículo por ID en la lista de artículos
                            Articulo articulo = listaArticulos.buscarArticuloPorID(idArticulo);

                            if (articulo == null) {
                                System.out.println("Artículo no encontrado. Verifique el ID del artículo.");
                            } else {
                                // Agregar el artículo a la lista de artículos seleccionados en el pedido editado
                                nuevosArticulos.add(articulo);
                            }
                        }

                        // Actualizar la lista de artículos en el pedido editado
                        pedidoAEditar.setArticulos(nuevosArticulos);
                    }

                    System.out.println("Pedido editado con éxito.");
                }

                break;
                case 3:
                    // Implementa la lógica para eliminar un pedido.///////////////////////
                    private void eliminarPedido() {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("----- Eliminar Pedido -----");
                    System.out.print("Ingrese el ID del pedido que desea eliminar: ");
                    int idPedido = scanner.nextInt();

                    // Buscar el pedido por ID en la lista de pedidos
                    Pedido pedidoAEliminar = listaPedidos.buscarPedidoPorID(idPedido);

                    if (pedidoAEliminar == null) {
                        System.out.println("Pedido no encontrado. Verifique el ID del pedido.");
                        return;
                    }

                    System.out.println("Pedido encontrado:");
                    System.out.println("ID: " + pedidoAEliminar.getId());
                    System.out.println("Cliente: " + pedidoAEliminar.getCliente().getNombre() + " " + pedidoAEliminar.getCliente().getApellido());
                    System.out.println("Monto Total: " + pedidoAEliminar.getMontoTotal());

                    // Mostrar los artículos en el pedido
                    System.out.println("Artículos en el pedido:");
                    for (Articulo articulo : pedidoAEliminar.getArticulos()) {
                        System.out.println("- " + articulo.getNombre() + " (ID: " + articulo.getId() + ")");
                    }

                    System.out.print("¿Está seguro de que desea eliminar este pedido? (S/N): ");
                    String confirmacion = scanner.next();

                    if (confirmacion.equalsIgnoreCase("S")) {
                        // Eliminar el pedido de la lista de pedidos
                        listaPedidos.eliminarPedido(pedidoAEliminar);
                        System.out.println("Pedido eliminado con éxito.");
                    } else {
                        System.out.println("Pedido no eliminado.");
                    }
                }

                break;
                case 4:
                    // Implementa la lógica para listar pedidos.///////////////////////
                    private void listarPedidos() {
                    System.out.println("----- Lista de Pedidos -----");

                    // Obtener la lista de pedidos desde la clase ListaPedidos
                    ArrayList<Pedido> pedidos = listaPedidos.getListaPedidos();

                    if (pedidos.isEmpty()) {
                        System.out.println("No hay pedidos registrados.");
                    } else {
                        for (Pedido pedido : pedidos) {
                            System.out.println("ID del Pedido: " + pedido.getId());
                            System.out.println("Cliente: " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido());
                            System.out.println("Monto Total: " + pedido.getMontoTotal());

                            System.out.println("Artículos en el Pedido:");
                            for (Articulo articulo : pedido.getArticulos()) {
                                System.out.println("- " + articulo.getNombre() + " (ID: " + articulo.getId() + ")");
                            }

                            System.out.println("----------------------");
                        }
                    }
                }

                break;
                case 5:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcionPedidos != 5);

        scanner.close();
    }
*/

}
