package CodeX.modelo;

public class ClienteEstandard extends Cliente {

    public ClienteEstandard(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);

    }


    public String tipoCliente() {
        return null;
    }

    public float calcAnual() {
        return 0;
    }

    public float descuentoEnv() {
        return 0;
    }
}
