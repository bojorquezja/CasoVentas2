package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.Producto;

public class ListaProductoModel implements MVPModel{
    private Dao<Producto> daoCG;

    public ListaProductoModel(Dao<Producto> daoCG) {
        this.daoCG = daoCG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("DeleteCab")) {
            //params: pk ProductoDao
            String pk = (String) params[0];
            daoCG.delete(pk);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Listar1")) {
            List<Producto> lista1 = daoCG.getListOfEntities01(params);
            return new Object[]{lista1};
        }
        if (subject.equalsIgnoreCase("Entidad")) {
            Producto ent = daoCG.getEntity(params).orElse(null);
            return new Object[]{ent};
        }
        return null;
    }
    
}
