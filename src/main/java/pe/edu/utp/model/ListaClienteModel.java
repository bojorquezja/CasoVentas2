package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.Cliente;

public class ListaClienteModel implements MVPModel{
    private Dao<Cliente> daoCG;

    public ListaClienteModel(Dao<Cliente> daoCG) {
        this.daoCG = daoCG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("DeleteCab")) {
            //params: pk ClienteDao
            String pk = (String) params[0];
            daoCG.delete(pk);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Listar1")) {
            List<Cliente> lista1 = daoCG.getListOfEntities01(params);
            return new Object[]{lista1};
        }
        return null;
    }
    
}
