package CodeX.modelo;

public abstract class Cliente {

    private String nombre;
    private String domicilio;
    public String email;
    private String nif;

    public Cliente(String nombre, String domicilio, String email, String nif) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public abstract float calcAnual();

    public abstract float descuentoEnv();
}
