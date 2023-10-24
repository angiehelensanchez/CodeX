package CodeX.modelo;

import java.io.Serializable;
import java.util.List;

public class Articulo {
    public String codigo;
    private String descripcion;
    private float precio;
    private float gastosenvio;

    public Articulo(String codigo, String descripcion, float precio, float gastosenvio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosenvio = gastosenvio;
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

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", gastosenvio=" + gastosenvio +
                '}';
    }
}
