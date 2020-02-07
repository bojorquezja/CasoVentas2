package pe.edu.utp.entity;

import java.util.Objects;

public class DetFactura {
    private String codigoFac;
    private String codigoProd;
    private String descrProd;
    private Integer cantidad;
    private Double precUnit;
    private Double valorVenta;

    public DetFactura() {
        this.cantidad = 0;
        this.precUnit = 0.0;
        this.valorVenta = 0.0;
    }

    public DetFactura(String codigoFac, String codigoProd, String descrProd, Integer cantidad, Double precUnit, Double valorVenta) {
        this.codigoFac = codigoFac;
        this.codigoProd = codigoProd;
        this.descrProd = descrProd;
        this.cantidad = cantidad;
        this.precUnit = precUnit;
        this.valorVenta = valorVenta;
    }

    @Override
    public String toString() {
        return "DetFactura{" + "codigoFac=" + codigoFac + ", codigoProd=" + codigoProd + ", descrProd=" + descrProd + ", cantidad=" + cantidad + ", precUnit=" + precUnit + ", valorVenta=" + valorVenta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigoFac);
        hash = 97 * hash + Objects.hashCode(this.codigoProd);
        hash = 97 * hash + Objects.hashCode(this.descrProd);
        hash = 97 * hash + Objects.hashCode(this.cantidad);
        hash = 97 * hash + Objects.hashCode(this.precUnit);
        hash = 97 * hash + Objects.hashCode(this.valorVenta);
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
        if (!Objects.equals(this.codigoFac, other.codigoFac)) {
            return false;
        }
        if (!Objects.equals(this.codigoProd, other.codigoProd)) {
            return false;
        }
        if (!Objects.equals(this.descrProd, other.descrProd)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.precUnit, other.precUnit)) {
            return false;
        }
        if (!Objects.equals(this.valorVenta, other.valorVenta)) {
            return false;
        }
        return true;
    }

    public String getCodigoFac() {
        return codigoFac;
    }

    public void setCodigoFac(String codigoFac) {
        this.codigoFac = codigoFac;
    }

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getDescrProd() {
        return descrProd;
    }

    public void setDescrProd(String descrProd) {
        this.descrProd = descrProd;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecUnit() {
        return precUnit;
    }

    public void setPrecUnit(Double precUnit) {
        this.precUnit = precUnit;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }
    
}
