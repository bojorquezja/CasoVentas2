package pe.edu.utp.model;

import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.Empresa;

public class EmpresaModel implements MVPModel{
    private Dao<Empresa> daoCG;

    public EmpresaModel(Dao<Empresa> daoCG) {
        this.daoCG = daoCG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("InsertCab")) {
            //params: Empresa 

            Empresa ent = (Empresa) params[0];
            daoCG.insert(ent);
        }
        if (subject.equalsIgnoreCase("UpdateCab")) {
            //params: Empresa
            Empresa ent = (Empresa) params[0];
            daoCG.update(ent);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Cab")) {
            //params: pk EmpresaDao
            String pk = (String) params[0];
            Empresa ent = daoCG.getEntity(pk).orElse(null);
            
            return new Object[]{ent};
        }
        return null;
    }
    
}
