package modelo;

import CodeX.modelo.ListaPedidos;
import CodeX.modelo.Pedidos;

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
        Pedidos pedido = new Pedidos(); // Asumo que la clase Pedidos tiene un constructor con id como parámetro.
        listaPedidos.agregarPedido(pedido);
        assertEquals(1, listaPedidos.obtenerLista().size());
    }

    @Test
    public void testEliminarPedido() {
        Pedidos pedido = new Pedidos("002");
        listaPedidos.agregarPedido(pedido);
        listaPedidos.eliminarPedido(pedido);
        assertTrue(listaPedidos.estaVacia());
    }

    @Test
    public void testObtenerPedido() {
        Pedidos pedido = new Pedidos("003");
        listaPedidos.agregarPedido(pedido);
        assertEquals(pedido, listaPedidos.obtenerPedido(0));
    }

    @Test
    public void testLimpiarLista() {
        listaPedidos.agregarPedido(new Pedidos("004"));
        listaPedidos.agregarPedido(new Pedidos("005"));
        listaPedidos.limpiarLista();
        assertTrue(listaPedidos.estaVacia());
    }

    @Test
    public void testBuscarPorId() {
        Pedidos pedido = new Pedidos("006");
        listaPedidos.agregarPedido(pedido);
        assertEquals(pedido, listaPedidos.buscarPorId("006"));
    }

    @Test
    public void testBuscarPorIdInexistente() {
        assertNull(listaPedidos.buscarPorId("999"));
    }

}

