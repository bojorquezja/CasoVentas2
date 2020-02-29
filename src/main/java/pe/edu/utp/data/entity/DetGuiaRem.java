package pe.edu.utp.data.entity;

import java.util.Objects;

public class DetGuiaRem {
    private CabGuiaRem cabGuiaRem;
    private Producto producto;
    private Integer cantidad;

    public DetGuiaRem() {
        this.cantidad = 0;
    }

    public DetGuiaRem(CabGuiaRem cabGuiaRem, Producto producto, Integer cantidad) {
        this.cabGuiaRem = cabGuiaRem;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetGuiaRem{" + "cabGuiaRem=" + cabGuiaRem + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.cabGuiaRem);
        hash = 89 * hash + Objects.hashCode(this.producto);
        hash = 89 * hash + Objects.hashCode(this.cantidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetGuiaRem other = (DetGuiaRem) obj;
        if (!Objects.equals(this.cabGuiaRem, other.cabGuiaRem)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        return true;
    }

    public CabGuiaRem getCabGuiaRem() {
        return cabGuiaRem;
    }

    public void setCabGuiaRem(CabGuiaRem cabGuiaRem) {
        this.cabGuiaRem = cabGuiaRem;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
