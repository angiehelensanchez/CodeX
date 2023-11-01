package modelo;


import CodeX.modelo.Datos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControladorTest {
    private Datos datos;

    @Test
    public void agregarCliente() {
        String tipocliente = datos.seleccionartipocliente();
        datos.agregarCliente(tipocliente);

    }
    @Test
    public void eliminarCliente(String email){
        datos.eliminarCliente(email);
    }

    @Test
    public void agregarArticulo(){
        datos.crearArticulo();
    }
}
