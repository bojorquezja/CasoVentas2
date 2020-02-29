package pe.edu.utp.data.entity;

import java.util.Objects;

public class Empresa {
    private String rucEmpresa;
    private String razSocEmpresa;

    public Empresa() {
    }

    public Empresa(String rucEmpresa, String razSocEmpresa) {
        this.rucEmpresa = rucEmpresa;
        this.razSocEmpresa = razSocEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "rucEmpresa=" + rucEmpresa + ", razSocEmpresa=" + razSocEmpresa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.rucEmpresa);
        hash = 79 * hash + Objects.hashCode(this.razSocEmpresa);
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
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.rucEmpresa, other.rucEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.razSocEmpresa, other.razSocEmpresa)) {
            return false;
        }
        return true;
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
    
    
}
