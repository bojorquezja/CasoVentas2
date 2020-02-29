package pe.edu.utp.data.dao;

import pe.edu.utp.service.DataBaseUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.data.entity.CabFactura;
import pe.edu.utp.data.entity.DetFactura;
import pe.edu.utp.data.entity.Producto;

public class DetFacturaDao implements Dao<DetFactura>{

    @Override
    public Optional<DetFactura> getEntity(Object[] pks) {
        Objects.requireNonNull(pks[0], "Codigo Factura no debe ser nulo");
        Objects.requireNonNull(pks[1], "Codigo Producto no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};

        String sql = "SELECT f.codigoFac, f.codigoProd, p.descrProd, " +
                    "f.cantidad, p.precUnit, f.valorVenta " +
                    "FROM DetFactura f " +
                    "LEFT JOIN Producto p on (f.codigoProd = p.codigoProd) " +
                    "WHERE codigoFac = ? AND codigoProd = ? ";
        Object[] valores = {(String) pks[0], (String) pks[1]};
        List<DetFactura> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabFactura cf = new CabFactura();
                cf.setCodigoFac(u.getString(1));
                Producto pr = new Producto(u.getString(2), u.getString(3), u.getDouble(5));
                DetFactura cb = new DetFactura(cf, pr, 
                        u.getInt(4), u.getDouble(6));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<DetFactura> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "Codigo Factura no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT f.codigoFac, f.codigoProd, p.descrProd, " +
                    "f.cantidad, p.precUnit, f.valorVenta " +
                    "FROM DetFactura f " +
                    "LEFT JOIN Producto p on (f.codigoProd = p.codigoProd) " +
                    "WHERE codigoFac = ? ";
        List<DetFactura> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabFactura cf = new CabFactura();
                cf.setCodigoFac(u.getString(1));
                Producto pr = new Producto(u.getString(2), u.getString(3), u.getDouble(5));
                DetFactura cb = new DetFactura(cf, pr, 
                        u.getInt(4), u.getDouble(6));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(DetFactura entidad) {
        String sqlA = "INSERT DetFactura (codigoFac, codigoProd, " +
                    "cantidad, valorVenta) "
                + "VALUES (?,?, "
                + "?,?) ";
        
        Class[] tipoObjetoA = {String.class, String.class,  
                Integer.class, Double.class};
        Object[] valoresA = {entidad.getCabFactura().getCodigoFac(), entidad.getProducto().getCodigoProd(),  
                            entidad.getCantidad(), entidad.getValorVenta()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(DetFactura entidad) {
        String sqlA = "UPDATE DetFactura "
                + "SET cantidad = ?, valorVenta = ? "
                + "WHERE codigoFac = ? AND codigoProd = ? ";
        
        Class[] tipoObjetoA = {Integer.class, Double.class, 
                            String.class, String.class};
        Object[] valoresA = {entidad.getCantidad(), entidad.getValorVenta(), 
                            entidad.getCabFactura().getCodigoFac(), entidad.getProducto().getCodigoProd()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object[] pks) {
        Objects.requireNonNull(pks[0], "Codigo Factura no debe ser nulo");
        Objects.requireNonNull(pks[1], "Codigo Producto no debe ser nulo");
        String sqlA = "DELETE FROM DetFactura "
                + "WHERE codigoFac = ? AND codigoProd = ? ";
        
        Class[] tipoObjetoA = {String.class, String.class};
        Object[] valoresA = {(String) pks[0], (String) pks[1]};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "Codigo Factura no debe ser nulo");
        String sqlA = "DELETE FROM DetFactura "
                + "WHERE codigoFac = ? ";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
}
