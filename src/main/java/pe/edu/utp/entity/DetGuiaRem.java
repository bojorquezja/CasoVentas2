package pe.edu.utp.entity;

import java.util.Objects;

public class DetGuiaRem {
    private String codGuiaRem;
    private String codigoProd;
    private String descrProd;
    private Integer cantidad;

    public DetGuiaRem() {
        this.cantidad = 0;
    }

    public DetGuiaRem(String codGuiaRem, String codigoProd, String descrProd, Integer cantidad) {
        this.codGuiaRem = codGuiaRem;
        this.codigoProd = codigoProd;
        this.descrProd = descrProd;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetGuiaRem{" + "codGuiaRem=" + codGuiaRem + ", codigoProd=" + codigoProd + ", descrProd=" + descrProd + ", cantidad=" + cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codGuiaRem);
        hash = 97 * hash + Objects.hashCode(this.codigoProd);
        hash = 97 * hash + Objects.hashCode(this.descrProd);
        hash = 97 * hash + Objects.hashCode(this.cantidad);
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
        if (!Objects.equals(this.codGuiaRem, other.codGuiaRem)) {
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
        return true;
    }

    public String getCodGuiaRem() {
        return codGuiaRem;
    }

    public void setCodGuiaRem(String codGuiaRem) {
        this.codGuiaRem = codGuiaRem;
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
    
    
}
