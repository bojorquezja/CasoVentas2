package pe.edu.utp.data.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CabGuiaRem {
    private String codGuiaRem;
    private LocalDate fechaEmi;
    private Empresa empresa;
    private Cliente cliente;
    private String almacenero;
    private Integer bultos;
    private List<DetGuiaRem> detGuiaRem;

    public CabGuiaRem() {
        this.bultos = 0;
        this.detGuiaRem = new ArrayList<>();
    }

    public CabGuiaRem(String codGuiaRem, LocalDate fechaEmi, Empresa empresa, Cliente cliente, String almacenero, Integer bultos) {
        this.codGuiaRem = codGuiaRem;
        this.fechaEmi = fechaEmi;
        this.empresa = empresa;
        this.cliente = cliente;
        this.almacenero = almacenero;
        this.bultos = bultos;
        this.detGuiaRem = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CabGuiaRem{" + "codGuiaRem=" + codGuiaRem + ", fechaEmi=" + fechaEmi + ", empresa=" + empresa + ", cliente=" + cliente + ", almacenero=" + almacenero + ", bultos=" + bultos + ", detGuiaRem=" + detGuiaRem + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codGuiaRem);
        hash = 23 * hash + Objects.hashCode(this.fechaEmi);
        hash = 23 * hash + Objects.hashCode(this.empresa);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.almacenero);
        hash = 23 * hash + Objects.hashCode(this.bultos);
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
        if (!Objects.equals(this.almacenero, other.almacenero)) {
            return false;
        }
        if (!Objects.equals(this.fechaEmi, other.fechaEmi)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
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
