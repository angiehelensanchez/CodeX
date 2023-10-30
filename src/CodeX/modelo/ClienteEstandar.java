package CodeX.modelo;

public class ClienteEstandar extends Cliente {

    public ClienteEstandar(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }


    public float calcAnual() {
        return 0;
    }

    public float descuentoEnv() {
        return 0;
    }
}