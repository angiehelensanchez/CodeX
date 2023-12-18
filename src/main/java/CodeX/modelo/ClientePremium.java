package CodeX.modelo;


import javax.persistence.*;

@Entity
@DiscriminatorValue("Premium")
public class ClientePremium extends Cliente {

    // Constructor vacío protegido para Hibernate
    protected ClientePremium() {
        super();
    }
    public ClientePremium(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }

    @Override
    public float calcAnual() {
        return 30f;
    }

    @Override
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
