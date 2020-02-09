package pe.edu.utp.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CabFactura {
    private String codigoFac;
    private LocalDate fechaEmi;
    private CabGuiaRem cabGuiaRem;
    private Empresa empresa;
    private Cliente cliente;
    private String cajero;
    private Double subTotal;
    private Double igv;
    private Double total;
    private List<DetFactura> detFactura;

    public CabFactura() {
        this.subTotal = 0.0;
        this.igv = 0.0;
        this.total = 0.0;
        this.detFactura = new ArrayList<>();
    }

    public CabFactura(String codigoFac, LocalDate fechaEmi, CabGuiaRem cabGuiaRem, Empresa empresa, Cliente cliente, String cajero, Double subTotal, Double igv, Double total) {
        this.codigoFac = codigoFac;
        this.fechaEmi = fechaEmi;
        this.cabGuiaRem = cabGuiaRem;
        this.empresa = empresa;
        this.cliente = cliente;
        this.cajero = cajero;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.detFactura = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CabFactura{" + "codigoFac=" + codigoFac + ", fechaEmi=" + fechaEmi + ", cabGuiaRem=" + cabGuiaRem + ", empresa=" + empresa + ", cliente=" + cliente + ", cajero=" + cajero + ", subTotal=" + subTotal + ", igv=" + igv + ", total=" + total + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codigoFac);
        hash = 41 * hash + Objects.hashCode(this.fechaEmi);
        hash = 41 * hash + Objects.hashCode(this.cabGuiaRem);
        hash = 41 * hash + Objects.hashCode(this.empresa);
        hash = 41 * hash + Objects.hashCode(this.cliente);
        hash = 41 * hash + Objects.hashCode(this.cajero);
        hash = 41 * hash + Objects.hashCode(this.subTotal);
        hash = 41 * hash + Objects.hashCode(this.igv);
        hash = 41 * hash + Objects.hashCode(this.total);
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
        final CabFactura other = (CabFactura) obj;
        if (!Objects.equals(this.codigoFac, other.codigoFac)) {
            return false;
        }
        if (!Objects.equals(this.cajero, other.cajero)) {
            return false;
        }
        if (!Objects.equals(this.fechaEmi, other.fechaEmi)) {
            return false;
        }
        if (!Objects.equals(this.cabGuiaRem, other.cabGuiaRem)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.subTotal, other.subTotal)) {
            return false;
        }
        if (!Objects.equals(this.igv, other.igv)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
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

    public LocalDate getFechaEmi() {
        return fechaEmi;
    }

    public void setFechaEmi(LocalDate fechaEmi) {
        this.fechaEmi = fechaEmi;
    }

    public CabGuiaRem getCabGuiaRem() {
        return cabGuiaRem;
    }

    public void setCabGuiaRem(CabGuiaRem cabGuiaRem) {
        this.cabGuiaRem = cabGuiaRem;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetFactura> getDetFactura() {
        return detFactura;
    }

    public void setDetFactura(List<DetFactura> detFactura) {
        this.detFactura = detFactura;
    }

    
}
