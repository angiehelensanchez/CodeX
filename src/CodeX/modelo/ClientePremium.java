package CodeX.modelo;

public class ClientePremium extends Cliente{

    public ClientePremium(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }


    public float calcAnual() {
        return 30f;
    }

    public float descuentoEnv() {
        return 20f;
    }

    public String tipoCliente() {
        return "Premium";
    }

    @Override
    public String toString() {
        return "| * Cliente: " + super.toString();
    }
}