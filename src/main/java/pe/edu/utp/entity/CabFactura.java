package pe.edu.utp.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CabFactura {
    private String codigoFac;
    private LocalDate fechaEmi;
    private String codGuiaRem;
    private String rucEmpresa;
    private String razSocEmpresa;
    private String rucCliente;
    private String razSocCliente;
    private String direcCliente;
    private String cajero;
    private Double subTotal;
    private Double igv;
    private Double total;
    List<DetFactura> detFactura;

    public CabFactura() {
        this.subTotal = 0.0;
        this.igv = 0.0;
        this.total = 0.0;
        this.detFactura = new ArrayList<>();
    }

    public CabFactura(String codigoFac, LocalDate fechaEmi, String codGuiaRem, String rucEmpresa, String razSocEmpresa, String rucCliente, String razSocCliente, String direcCliente, String cajero, Double subTotal, Double igv, Double total) {
        this.codigoFac = codigoFac;
        this.fechaEmi = fechaEmi;
        this.codGuiaRem = codGuiaRem;
        this.rucEmpresa = rucEmpresa;
        this.razSocEmpresa = razSocEmpresa;
        this.rucCliente = rucCliente;
        this.razSocCliente = razSocCliente;
        this.direcCliente = direcCliente;
        this.cajero = cajero;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.detFactura = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CabFactura{" + "codigoFac=" + codigoFac + ", fechaEmi=" + fechaEmi + ", guiaRem=" + codGuiaRem + ", rucEmpresa=" + rucEmpresa + ", razSocEmpresa=" + razSocEmpresa + ", rucCliente=" + rucCliente + ", razSocCliente=" + razSocCliente + ", direcCliente=" + direcCliente + ", cajero=" + cajero + ", subTotal=" + subTotal + ", igv=" + igv + ", total=" + total + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codigoFac);
        hash = 71 * hash + Objects.hashCode(this.fechaEmi);
        hash = 71 * hash + Objects.hashCode(this.codGuiaRem);
        hash = 71 * hash + Objects.hashCode(this.rucEmpresa);
        hash = 71 * hash + Objects.hashCode(this.razSocEmpresa);
        hash = 71 * hash + Objects.hashCode(this.rucCliente);
        hash = 71 * hash + Objects.hashCode(this.razSocCliente);
        hash = 71 * hash + Objects.hashCode(this.direcCliente);
        hash = 71 * hash + Objects.hashCode(this.cajero);
        hash = 71 * hash + Objects.hashCode(this.subTotal);
        hash = 71 * hash + Objects.hashCode(this.igv);
        hash = 71 * hash + Objects.hashCode(this.total);
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
        if (!Objects.equals(this.codGuiaRem, other.codGuiaRem)) {
            return false;
        }
        if (!Objects.equals(this.rucEmpresa, other.rucEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.razSocEmpresa, other.razSocEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.rucCliente, other.rucCliente)) {
            return false;
        }
        if (!Objects.equals(this.razSocCliente, other.razSocCliente)) {
            return false;
        }
        if (!Objects.equals(this.direcCliente, other.direcCliente)) {
            return false;
        }
        if (!Objects.equals(this.cajero, other.cajero)) {
            return false;
        }
        if (!Objects.equals(this.fechaEmi, other.fechaEmi)) {
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

    public String getCodGuiaRem() {
        return codGuiaRem;
    }

    public void setCodGuiaRem(String codGuiaRem) {
        this.codGuiaRem = codGuiaRem;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getRazSocEmpresa() {
        return razSocEmpresa;
    }

    public void setRazSocEmpresa(String razSocEmpresa) {
        this.razSocEmpresa = razSocEmpresa;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getRazSocCliente() {
        return razSocCliente;
    }

    public void setRazSocCliente(String razSocCliente) {
        this.razSocCliente = razSocCliente;
    }

    public String getDirecCliente() {
        return direcCliente;
    }

    public void setDirecCliente(String direcCliente) {
        this.direcCliente = direcCliente;
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

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public List<DetFactura> getDetFactura() {
        return detFactura;
    }

    public void setDetFactura(List<DetFactura> detFactura) {
        this.detFactura = detFactura;
    }
    
}
