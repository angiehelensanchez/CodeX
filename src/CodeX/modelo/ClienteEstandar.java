package CodeX.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Estandar")
public class ClienteEstandar extends Cliente {

    // Constructor vacío protegido para Hibernate
    protected ClienteEstandar() {
        super();
    }
    @Column(name = "tipoCliente")
    private String tipoCliente;

    public ClienteEstandar(String nombre, String domicilio, String email, String nif) {
        super(nombre, domicilio, email, nif);
        this.tipoCliente=tipoCliente;
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
