package CodeX.modelo;

import java.io.Serializable;

public class ClienteEstandard extends Cliente {

    // Este atributo no es necesario al saber ya el tipo por la clase.
    // private String tipoUsuario;
    public ClienteEstandard(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }

    @Override
    public String tipoCliente() {
        return "Estandard";
    }

    @Override
    public float calcAnual() {
        return 0;
    }

    @Override
    public float descuentoEnv() {
        return 0;
    }
}
