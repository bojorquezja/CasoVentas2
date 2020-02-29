package pe.edu.utp.ui.model;

import java.util.List;
import pe.edu.utp.data.dao.Dao;
import pe.edu.utp.data.entity.CabFactura;
import pe.edu.utp.data.entity.DetFactura;

public class ListaFacturaModel implements MVPModel{
    private Dao<CabFactura> daoCF;
    private Dao<DetFactura> daoDF;

    public ListaFacturaModel(Dao<CabFactura> daoCF, Dao<DetFactura> daoDF) {
        this.daoCF = daoCF;
        this.daoDF = daoDF;
    }
    
    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("DeleteCabDet")) {
            //params: pk CabFacturaDao
            String pk = (String) params[0];
            daoDF.delete(pk);
            daoCF.delete(pk);
        }
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Listar1")) {
            //params: codigo FAC, cliente
            List<CabFactura> lista1 = daoCF.getListOfEntities01(params);
            return new Object[]{lista1};
        }
        if (subject.equalsIgnoreCase("Entidad")) {
            //params: pk CabFactura
            String pk = (String) params[0];
            CabFactura ent = daoCF.getEntity(pk).orElse(null);
            return new Object[]{ent};
        }
        return null;
    }
    
}
