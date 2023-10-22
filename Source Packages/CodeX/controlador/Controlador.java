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
        // Implementa la lógica para gestionar clientes (agregar, editar, eliminar, listar, etc.).
    }

    private void gestionarArticulos() {
        // Implementa la lógica para gestionar artículos (agregar, editar, eliminar, listar, etc.).
    }

    private void realizarPedidos() {
        // Implementa la lógica para realizar pedidos.
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}

