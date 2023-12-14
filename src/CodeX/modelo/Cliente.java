package CodeX.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoCliente", discriminatorType = DiscriminatorType.STRING)
public abstract class Cliente {

    @Id
    @Column(name = "nif")
    private String nif;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "email")
    private String email;

    public Cliente(String nombre, String domicilio, String email, String nif) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.nif = nif;
    }

    // Tus getters y setters

    public abstract float calcAnual();
    public abstract float descuentoEnv();
    public abstract String tipoCliente();

    @Override
    public String toString() {
        return "nombre= " + nombre +
                ", domicilio= " + domicilio +
                ", email= " + email +
                ", nif=" + nif;
    }
}
