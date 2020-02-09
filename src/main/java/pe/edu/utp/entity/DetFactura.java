package pe.edu.utp.entity;

import java.util.Objects;

public class DetFactura {
    private CabFactura cabFactura;
    private Producto producto;
    private Integer cantidad;
    private Double valorVenta;

    public DetFactura() {
        this.cantidad = 0;
        this.valorVenta = 0.0;
    }

    public DetFactura(CabFactura cabFactura, Producto producto, Integer cantidad, Double valorVenta) {
        this.cabFactura = cabFactura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorVenta = valorVenta;
    }

    @Override
    public String toString() {
        return "DetFactura{" + "cabFactura=" + cabFactura + ", producto=" + producto + ", cantidad=" + cantidad + ", valorVenta=" + valorVenta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.cabFactura);
        hash = 89 * hash + Objects.hashCode(this.producto);
        hash = 89 * hash + Objects.hashCode(this.cantidad);
        hash = 89 * hash + Objects.hashCode(this.valorVenta);
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
        final DetFactura other = (DetFactura) obj;
        if (!Objects.equals(this.cabFactura, other.cabFactura)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.valorVenta, other.valorVenta)) {
            return false;
        }
        return true;
    }

    public CabFactura getCabFactura() {
        return cabFactura;
    }

    public void setCabFactura(CabFactura cabFactura) {
        this.cabFactura = cabFactura;
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

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    
}
