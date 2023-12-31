package CodeX.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo {
    @Id
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private float precio;
    @Column(name = "gastosEnvio")
    private float gastosenvio;
    @Column(name = "tpreparacion")
    private int tpreparacion;

    // Constructor por defecto necesario para Hibernate
    public Articulo() {
    }

    // Constructor con parámetros
    public Articulo(String codigo, String descripcion, float precio, float gastosenvio, int tpreparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosenvio = gastosenvio;
        this.tpreparacion = tpreparacion;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float getGastosenvio() {
        return gastosenvio;
    }
    public void setGastosenvio(float gastosenvio) {
        this.gastosenvio = gastosenvio;
    }
    public int getTpreparacion() {
        return tpreparacion;
    }
    public void setTpreparacion(int tpreparacion) {
        this.tpreparacion = tpreparacion;
    }

    @Override
    public String toString() {
        return "| * Codigo=" + codigo  +
                ", descripcion=" + descripcion +
                ", precio=" + precio +
                ", gastos de envio=" + gastosenvio +
                ", tiempo de preparacion=" + tpreparacion;
    }
}
