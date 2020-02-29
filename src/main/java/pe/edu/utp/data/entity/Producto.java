package pe.edu.utp.data.entity;

import java.util.Objects;

public class Producto {
    private String codigoProd;
    private String descrProd;
    private Double precUnit;

    public Producto() {
    }

    public Producto(String codigoProd, String descrProd, double precUnit) {
        this.codigoProd = codigoProd;
        this.descrProd = descrProd;
        this.precUnit = precUnit;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProd=" + codigoProd + ", descrProd=" + descrProd + ", precUnit=" + precUnit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigoProd);
        hash = 37 * hash + Objects.hashCode(this.descrProd);
        hash = 37 * hash + Objects.hashCode(this.precUnit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigoProd, other.codigoProd)) {
            return false;
        }
        if (!Objects.equals(this.descrProd, other.descrProd)) {
            return false;
        }
        if (!Objects.equals(this.precUnit, other.precUnit)) {
            return false;
        }
        return true;
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

    public Double getPrecUnit() {
        return precUnit;
    }

    public void setPrecUnit(Double precUnit) {
        this.precUnit = precUnit;
    }
    
}
