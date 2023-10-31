package CodeX.vista;

import CodeX.controlador.Controlador;


import java.util.Scanner;
public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);
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
// TO-BE-DONE
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    char pedirOpcion() {
        String resp;
        System.out.print("Elige una opción (1,2,3 o 0): ");
                resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
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
            opcionArticulos = scanner.nextInt();

            switch (opcionArticulos) {
                case 1:
                    controlador.agregarArticulo();
                    break;
                case 2:
                    controlador.eliminarArticulo();
                    break;
                case 3:
                    controlador.listarArticulos();
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
            opcionClientes = scanner.nextInt();

            switch (opcionClientes) {
                case 1:
                    controlador.agregarCliente();
                break;
                case 2:
                    controlador.listarCliente();
                break;
                case 3:
                    String tipo1 = "Estandar";
                    controlador.listarCFiltrado(tipo1);
                break;
                case 4:
                    String tipo2 = "Premium";
                    controlador.listarCFiltrado(tipo2);
                break;
                case 5:
                    System.out.print("Por favor introduzca el email del cliente: ");
                    String email = scanner.nextLine();
                    controlador.eliminarCliente(email);
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcionClientes != 6);

        scanner.close();
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
            opcionpedidos = scanner.nextInt();

            switch (opcionpedidos) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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

}


