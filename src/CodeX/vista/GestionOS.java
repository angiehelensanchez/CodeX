package CodeX.vista;

import CodeX.controlador.Controlador;
import CodeX.modelo.Articulo;
import CodeX.modelo.ListaArticulos;

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
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
// TO-BE-DONE
                    menuArticulos();
                    break;
                case '2':
// TO-BE-DONE
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
        System.out.println("Elige una opción (1,2,3 o 0): ");
                resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    private void menuArticulos() {
        Scanner scanner = new Scanner(System.in);
        int opcionArticulos;

        do {
            System.out.println("----- Gestionar Artículos -----");
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
                    ListadoArticulos(controlador.listarArticulos());
                    break;

            }
        }while (opcionArticulos != 5);
    }

    private void ListadoArticulos(ListaArticulos lista){

        for (Articulo articulo : lista){

        }
    }

    public String seleccionartipocliente(){
        Scanner scanner = new Scanner(System.in);
        String tipocliente = "";
        int optio;
        do {
            System.out.println("----- Seleccionar tipo de cliente -----");
            System.out.println("1. Estandar");
            System.out.println("2. Premium");
            System.out.println("3. Salir");
            optio = scanner.nextInt();
            switch (optio) {
                case 1:
                    tipocliente = "Estandar";
                    //return tipocliente;
                case 2:
                    tipocliente = "Premium";
                    //return tipocliente;
            }
        }while (optio != 3);
        return tipocliente;
    }
    public void agregarclientepremiun(){

    }

}


