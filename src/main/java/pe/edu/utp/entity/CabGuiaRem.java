package pe.edu.utp.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CabGuiaRem {
    private String codGuiaRem;
    private LocalDate fechaEmi;
    private String rucEmpresa;
    private String razSocEmpresa;
    private String rucCliente;
    private String razSocCliente;
    private String direcCliente;
    private String almacenero;
    private Integer bultos;
    List<DetGuiaRem> detGuiaRem;

    public CabGuiaRem() {
        this.bultos = 0;
        this.detGuiaRem = new ArrayList<>();
    }

    public CabGuiaRem(String codGuiaRem, LocalDate fechaEmi, String rucEmpresa, String razSocEmpresa, String rucCliente, String razSocCliente, String direcCliente, String almacenero, Integer bultos) {
        this.codGuiaRem = codGuiaRem;
        this.fechaEmi = fechaEmi;
        this.rucEmpresa = rucEmpresa;
        this.razSocEmpresa = razSocEmpresa;
        this.rucCliente = rucCliente;
        this.razSocCliente = razSocCliente;
        this.direcCliente = direcCliente;
        this.almacenero = almacenero;
        this.bultos = bultos;
        this.detGuiaRem = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CabGuiaRem{" + "codGuiaRem=" + codGuiaRem + ", fechaEmi=" + fechaEmi + ", rucEmpresa=" + rucEmpresa + ", razSocEmpresa=" + razSocEmpresa + ", rucCliente=" + rucCliente + ", razSocCliente=" + razSocCliente + ", direcCliente=" + direcCliente + ", almacenero=" + almacenero + ", bultos=" + bultos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.codGuiaRem);
        hash = 59 * hash + Objects.hashCode(this.fechaEmi);
        hash = 59 * hash + Objects.hashCode(this.rucEmpresa);
        hash = 59 * hash + Objects.hashCode(this.razSocEmpresa);
        hash = 59 * hash + Objects.hashCode(this.rucCliente);
        hash = 59 * hash + Objects.hashCode(this.razSocCliente);
        hash = 59 * hash + Objects.hashCode(this.direcCliente);
        hash = 59 * hash + Objects.hashCode(this.almacenero);
        hash = 59 * hash + Objects.hashCode(this.bultos);
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
        final CabGuiaRem other = (CabGuiaRem) obj;
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
        if (!Objects.equals(this.almacenero, other.almacenero)) {
            return false;
        }
        if (!Objects.equals(this.fechaEmi, other.fechaEmi)) {
            return false;
        }
        if (!Objects.equals(this.bultos, other.bultos)) {
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

    public LocalDate getFechaEmi() {
        return fechaEmi;
    }

    public void setFechaEmi(LocalDate fechaEmi) {
        this.fechaEmi = fechaEmi;
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

    public String getAlmacenero() {
        return almacenero;
    }

    public void setAlmacenero(String almacenero) {
        this.almacenero = almacenero;
    }

    public Integer getBultos() {
        return bultos;
    }

    public void setBultos(Integer bultos) {
        this.bultos = bultos;
    }

    public List<DetGuiaRem> getDetGuiaRem() {
        return detGuiaRem;
    }

    public void setDetGuiaRem(List<DetGuiaRem> detGuiaRem) {
        this.detGuiaRem = detGuiaRem;
    }
    
    
}
