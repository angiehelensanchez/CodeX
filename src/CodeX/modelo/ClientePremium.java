package CodeX.modelo;

import java.io.Serializable;

public class ClientePremium extends Cliente{

    private Float desEnvio;

    // Este atributo no es necesario al saber ya el tipo por la clase.
    // private String tipoUsuario;


    public ClientePremium(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }

    @Override
    public String tipoCliente() {
        return "Premium";
    }

    @Override
    public float calcAnual() {
        return 0;
    }

    @Override
    public float descuentoEnv() {
        return desEnvio;
    }
}
