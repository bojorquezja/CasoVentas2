package pe.edu.utp.model;

import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.Cliente;

public class ClienteModel implements MVPModel{
    private Dao<Cliente> daoCG;

    public ClienteModel(Dao<Cliente> daoCG) {
        this.daoCG = daoCG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("InsertCab")) {
            //params: Cliente 

            Cliente ent = (Cliente) params[0];
            daoCG.insert(ent);
        }
        if (subject.equalsIgnoreCase("UpdateCab")) {
            //params: Cliente
            Cliente ent = (Cliente) params[0];
            daoCG.update(ent);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Cab")) {
            //params: pk ClienteDao
            String pk = (String) params[0];
            Cliente ent = daoCG.getEntity(pk).orElse(null);
            
            return new Object[]{ent};
        }
        return null;
    }
    
}
