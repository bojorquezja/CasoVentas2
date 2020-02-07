package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.CabGuiaRem;
import pe.edu.utp.entity.DetGuiaRem;

public class ListaGuiasRemisionModel implements MVPModel{
    private Dao<CabGuiaRem> daoCG;
    private Dao<DetGuiaRem> daoDG;

    public ListaGuiasRemisionModel(Dao<CabGuiaRem> daoCG, Dao<DetGuiaRem> daoDG) {
        this.daoCG = daoCG;
        this.daoDG = daoDG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("DeleteCabDet")) {
            //params: pk CabGuiaRemDao
            String pk = (String) params[0];
            daoDG.delete(pk);
            daoCG.delete(pk);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Listar1")) {
            List<CabGuiaRem> lista1 = daoCG.getListOfEntities01(params);
            return new Object[]{lista1};
        }
        return null;
    }
    
}
