package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.CabFactura;
import pe.edu.utp.entity.DetFactura;

public class FacturaModel implements MVPModel{
    private Dao<CabFactura> daoCF;
    private Dao<DetFactura> daoDF;

    public FacturaModel(Dao<CabFactura> daoCF, Dao<DetFactura> daoDF) {
        this.daoCF = daoCF;
        this.daoDF = daoDF;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("InsertCabDet")) {
            //params: CabFactura con Det
            CabFactura ent = (CabFactura) params[0];
            daoCF.insert(ent);
            ent.getDetFactura().forEach((item) -> {
                daoDF.insert(item);
            });
        }
        if (subject.equalsIgnoreCase("UpdateCabDet")) {
            //params: CabFactura con Det
            CabFactura ent = (CabFactura) params[0];
            daoCF.update(ent);
            daoDF.delete(ent.getCodigoFac());
            ent.getDetFactura().forEach((item) -> {
                daoDF.insert(item);
            });
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("CabDet")) {
            //params: pk CabFacturaDao
            String pk = (String) params[0];
            CabFactura ent = daoCF.getEntity(pk).orElse(null);
            
            if (ent != null){
                List<DetFactura> lista1 = daoDF.getListOfEntities01(new Object[]{pk});
                ent.setDetFactura(lista1);
            }
            
            return new Object[]{ent};
        }
        return null;
    }
    
}
