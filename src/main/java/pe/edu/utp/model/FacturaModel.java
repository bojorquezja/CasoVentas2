package pe.edu.utp.model;

import java.util.List;
import pe.edu.utp.dao.Dao;
import pe.edu.utp.entity.CabFactura;
import pe.edu.utp.entity.Cliente;
import pe.edu.utp.entity.DetFactura;
import pe.edu.utp.entity.Empresa;
import pe.edu.utp.entity.Producto;

public class FacturaModel implements MVPModel{
    private Dao<CabFactura> daoCF;
    private Dao<DetFactura> daoDF;
    private Dao<Empresa> daoEm;
    private Dao<Cliente> daoCl;
    private Dao<Producto> daoPr;

    public FacturaModel(Dao<CabFactura> daoCF, Dao<DetFactura> daoDF,  
            Dao<Empresa> daoEm, Dao<Cliente> daoCl, Dao<Producto> daoPr) {
        this.daoCF = daoCF;
        this.daoDF = daoDF;
        this.daoEm = daoEm;
        this.daoCl = daoCl;
        this.daoPr = daoPr;
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
        if (subject.equalsIgnoreCase("CargaCliente")) {
            //params: pk Cliente
            String pk = (String) params[0];
            Cliente ent = daoCl.getEntity(pk).orElse(null);
            return new Object[]{ent};
        }
        if (subject.equalsIgnoreCase("CargaEmpresa")) {
            //params: pk Empresa
            String pk = (String) params[0];
            Empresa ent = daoEm.getEntity(pk).orElse(null);
            return new Object[]{ent};
        }
        if (subject.equalsIgnoreCase("CargaProducto")) {
            //params: pk Producto
            String pk = (String) params[0];
            Producto ent = daoPr.getEntity(pk).orElse(null);
            return new Object[]{ent};
        }
        return null;
    }
    
}
