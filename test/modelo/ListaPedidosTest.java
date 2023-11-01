package modelo;

import CodeX.modelo.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListaPedidosTest {

    private ListaPedidos listaPedidos;

    @Before
    public void setUp() {
        listaPedidos = new ListaPedidos();
    }

    @Test
    public void testAgregarPedido() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        Articulo articulo = new Articulo("123","Test 1", 123f, 45f,35);
        Pedidos pedido = new Pedidos("01_1220_1521120", clienteEstandar, articulo,13);
        listaPedidos.agregarPedido(pedido);
        assertEquals(1, listaPedidos.obtenerLista().size());
    }

    @Test
    public void testEliminarPedido() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        Articulo articulo = new Articulo("123","Test 1", 123f, 45f,35);
        Pedidos pedido = new Pedidos("01_1220_1521120", clienteEstandar, articulo,13);
        listaPedidos.agregarPedido(pedido);
        listaPedidos.eliminarPedido(pedido);
        assertTrue(listaPedidos.estaVacia());
    }

    @Test
    public void testObtenerPedido() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        Articulo articulo = new Articulo("123","Test 1", 123f, 45f,35);
        Pedidos pedido = new Pedidos("01_1220_1521120", clienteEstandar, articulo,13);
        listaPedidos.agregarPedido(pedido);
        assertEquals(pedido, listaPedidos.obtenerPedido(0));
    }

    @Test
    public void testLimpiarLista() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        Articulo articulo = new Articulo("123","Test 1", 123f, 45f,35);
        Pedidos pedido = new Pedidos("01_1220_1521120", clienteEstandar, articulo,13);
        listaPedidos.limpiarLista();
        assertTrue(listaPedidos.estaVacia());
    }

    @Test
    public void testBuscarPorId() {
        ClienteEstandar clienteEstandar = new ClienteEstandar("Daniel", "Casa teste Daniel", "2@gmail.com", "12987765");
        Articulo articulo = new Articulo("123","Test 1", 123f, 45f,35);
        Pedidos pedido = new Pedidos("01_1220_1521120", clienteEstandar, articulo,13);
        listaPedidos.agregarPedido(pedido);
        assertEquals(pedido, listaPedidos.buscarPorId("01_1220_1521120"));
    }

    @Test
    public void testBuscarPorIdInexistente() {
        assertNull(listaPedidos.buscarPorId("123"));
    }

}

