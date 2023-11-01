package modelo;

import CodeX.modelo.Datos;
import CodeX.modelo.ListaClientes;
import CodeX.modelo.ClienteEstandar;
import CodeX.modelo.ClientePremium;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class DatosTest {

    private Datos datos;

    @Before
    public void setUp() {
        datos = new Datos();
    }

    @Test
    public void agregarCliente(String tipocliente, ListaClientes listaClientes) {
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

}
