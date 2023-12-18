package CodeX.modelo;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Estandar")
public class ClienteEstandar extends Cliente {

    // Constructor vacío protegido para Hibernate
    protected ClienteEstandar() {
        super();
    }

    public ClienteEstandar(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
    }

    @Override
    public float calcAnual() {
        return 0;
    }

    @Override
    public float descuentoEnv() {
        return 0f;
    }

    public String tipoCliente() {
        return "Estandar";
    }

    @Override
    public String toString() {
        return "| * Cliente: " + super.toString();
    }
}
