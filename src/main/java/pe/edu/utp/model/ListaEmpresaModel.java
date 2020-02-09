package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.Empresa;

public class ListaEmpresaModel implements MVPModel{
    private Dao<Empresa> daoCG;

    public ListaEmpresaModel(Dao<Empresa> daoCG) {
        this.daoCG = daoCG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("DeleteCab")) {
            //params: pk EmpresaDao
            String pk = (String) params[0];
            daoCG.delete(pk);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Listar1")) {
            List<Empresa> lista1 = daoCG.getListOfEntities01(params);
            return new Object[]{lista1};
        }
        return null;
    }
    
}