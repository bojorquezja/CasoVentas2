package pe.edu.utp.data.entity;

import java.util.Objects;

public class Cliente {
    private String rucCliente;
    private String razSocCliente;
    private String direcCliente;

    public Cliente() {
    }

    public Cliente(String rucCliente, String razSocCliente, String direcCliente) {
        this.rucCliente = rucCliente;
        this.razSocCliente = razSocCliente;
        this.direcCliente = direcCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rucCliente=" + rucCliente + ", razSocCliente=" + razSocCliente + ", direcCliente=" + direcCliente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.rucCliente);
        hash = 53 * hash + Objects.hashCode(this.razSocCliente);
        hash = 53 * hash + Objects.hashCode(this.direcCliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.rucCliente, other.rucCliente)) {
            return false;
        }
        if (!Objects.equals(this.razSocCliente, other.razSocCliente)) {
            return false;
        }
        if (!Objects.equals(this.direcCliente, other.direcCliente)) {
            return false;
        }
        return true;
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
    
    
    
}
