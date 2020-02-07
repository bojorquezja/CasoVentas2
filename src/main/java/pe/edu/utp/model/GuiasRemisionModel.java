package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.CabGuiaRem;
import pe.edu.utp.entity.DetGuiaRem;

public class GuiasRemisionModel implements MVPModel{
    private Dao<CabGuiaRem> daoCG;
    private Dao<DetGuiaRem> daoDG;

    public GuiasRemisionModel(Dao<CabGuiaRem> daoCG, Dao<DetGuiaRem> daoDG) {
        this.daoCG = daoCG;
        this.daoDG = daoDG;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("InsertCabDet")) {
            //params: CabGuiaRem con Det

            CabGuiaRem ent = (CabGuiaRem) params[0];
            daoCG.insert(ent);
            ent.getDetGuiaRem().forEach((item) -> {
                daoDG.insert(item);
            });
        }
        if (subject.equalsIgnoreCase("UpdateCabDet")) {
            //params: CabGuiaRem con Det
            CabGuiaRem ent = (CabGuiaRem) params[0];
            daoCG.update(ent);
            daoDG.delete(ent.getCodGuiaRem());
            ent.getDetGuiaRem().forEach((item) -> {
                daoDG.insert(item);
            });
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("CabDet")) {
            //params: pk CabGuiaRemDao
            String pk = (String) params[0];
            CabGuiaRem ent = daoCG.getEntity(pk).orElse(null);
            
            if (ent != null){
                List<DetGuiaRem> lista1 = daoDG.getListOfEntities01(new Object[]{pk});
                ent.setDetGuiaRem(lista1);
            }
            
            return new Object[]{ent};
        }
        return null;
    }
    
}
