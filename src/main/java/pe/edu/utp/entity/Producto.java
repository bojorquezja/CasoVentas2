package pe.edu.utp.entity;

import java.util.Objects;

public class Producto {
    private String codigoProd;
    private String descrProd;
    private double precUnit;

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
        hash = 47 * hash + Objects.hashCode(this.codigoProd);
        hash = 47 * hash + Objects.hashCode(this.descrProd);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.precUnit) ^ (Double.doubleToLongBits(this.precUnit) >>> 32));
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
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precUnit) != Double.doubleToLongBits(other.precUnit)) {
            return false;
        }
        if (!Objects.equals(this.codigoProd, other.codigoProd)) {
            return false;
        }
        if (!Objects.equals(this.descrProd, other.descrProd)) {
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

    public double getPrecUnit() {
        return precUnit;
    }

    public void setPrecUnit(double precUnit) {
        this.precUnit = precUnit;
    }
    
}
