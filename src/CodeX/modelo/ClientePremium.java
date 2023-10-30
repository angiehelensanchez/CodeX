package CodeX.modelo;

public class ClientePremium extends Cliente{

    private Float desEnvio;

    public ClientePremium(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
        this.desEnvio = 30f;
    }


    public float calcAnual() {
        return 0;
    }

    public float descuentoEnv() {
        return desEnvio;
    }

    public String tipoCliente() {
        String tipocliente = "Premium";
        return tipocliente ;
    }

    @Override
    public String toString() {
        return "ClientePremium{" +
                "desEnvio=" + desEnvio +
                "} " + super.toString();
    }
}