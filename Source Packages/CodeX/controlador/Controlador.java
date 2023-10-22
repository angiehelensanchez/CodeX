package CodeX.controlador;

import java.util.Scanner;

public class Controlador {
    private ListaClientes listaClientes;
    private ListaArticulos listaArticulos;
    private ListaPedidos listaPedidos;

    public Controlador() {
        listaClientes = new ListaClientes();
        listaArticulos = new ListaArticulos();
        listaPedidos = new ListaPedidos();
    }

    public void iniciar() {
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
    }

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
                    // Implementa la lógica para agregar un cliente.
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
                    // Implementa la lógica para editar un cliente.
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
                    // Implementa la lógica para eliminar un cliente.
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
                    // Implementa la lógica para listar clientes.
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
    }

    private void gestionarArticulos() {
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
                    // Implementa la lógica para agregar un artículo.
                    break;
                case 2:
                    // Implementa la lógica para editar un artículo.
                    break;
                case 3:
                    // Implementa la lógica para eliminar un artículo.
                    break;
                case 4:
                    // Implementa la lógica para listar artículos.
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
                    // Implementa la lógica para crear un pedido.
                    break;
                case 2:
                    // Implementa la lógica para editar un pedido.
                    break;
                case 3:
                    // Implementa la lógica para eliminar un pedido.
                    break;
                case 4:
                    // Implementa la lógica para listar pedidos.
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

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}
