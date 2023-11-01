package modelo;

import CodeX.modelo.Lista;
import CodeX.modelo.ListaClientes;
import CodeX.modelo.ClienteEstandar;
import CodeX.modelo.ClientePremium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaClientesTest {

    private ListaClientes listaClientes;
    @Before
    public void setUp() throws Exception {
        listaClientes = new ListaClientes();
    }
    @Test
    public void testAgregarclienteEstandar() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Angie Helen Rodas Sánchez", "Casa teste", "1@gmail.com", "12123123");
        listaClientes.agregarclienteEstandar(clienteEstandar);
        assertEquals(1, listaClientes.getSize());

        // Prueba de agregar cliente existente
        listaClientes.agregarclienteEstandar(clienteEstandar);
        assertEquals(1, listaClientes.getSize());
    }

    @Test
    public void testExisteCliente() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Angie Helen Rodas Sánchez", "Casa teste", "1@gmail.com", "12123123");
        listaClientes.agregarclienteEstandar(clienteEstandar);
        assertNotNull(listaClientes.existeCliente("1@gmail.com"));
        assertNull(listaClientes.existeCliente("no1@email.com"));
    }

    @Test
    public void testListarCliente() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Angie Helen Rodas Sánchez", "Casa teste", "1@gmail.com", "12123123");
        listaClientes.agregarclienteEstandar(clienteEstandar);
        assertEquals(clienteEstandar, listaClientes.listarCliente(0));
    }

    @Test
    public void testListarClienteFiltro() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Angie Helen Rodas Sánchez", "Casa teste", "1@gmail.com", "12123123");
        listaClientes.agregarclienteEstandar(clienteEstandar);
        assertNotNull(listaClientes.listarClienteFiltro(0, "Estandar"));
        assertNull(listaClientes.listarClienteFiltro(0, "Premium"));
    }

    @Test
    public void testAgregarclientesPremium() {
        ClientePremium clientePremium = new ClientePremium("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        listaClientes.agregarclientesPremium(clientePremium);
        assertEquals(1, listaClientes.getSize());

        // Prueba de agregar cliente existente
        listaClientes.agregarclientesPremium(clientePremium);
        assertEquals(1, listaClientes.getSize());
    }

    @Test
    public void testEliminar() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        listaClientes.agregarclienteEstandar(clienteEstandar);
        assertEquals(1, listaClientes.getSize());

        listaClientes.eliminar(clienteEstandar);
        assertEquals(0, listaClientes.getSize());
    }


}
