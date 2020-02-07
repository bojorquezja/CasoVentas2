package pe.edu.utp.dao;

import pe.edu.utp.util.DataBaseUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.entity.DetFactura;

public class DetFacturaDao implements Dao<DetFactura>{

    @Override
    public Optional<DetFactura> getEntity(Object[] pks) {
        Objects.requireNonNull(pks[0], "Codigo Factura no debe ser nulo");
        Objects.requireNonNull(pks[1], "Codigo Producto no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};

        String sql = "SELECT codigoFac, codigoProd, descrProd, " +
                    "cantidad, precUnit, valorVenta " +
                    "FROM DetFactura " +
                    "WHERE codigoFac = ? AND codigoProd = ? ";
        Object[] valores = {(String) pks[0], (String) pks[1]};
        List<DetFactura> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                DetFactura cb = new DetFactura(u.getString(1), u.getString(2), u.getString(3),
                        u.getInt(4), u.getDouble(5), u.getDouble(6));
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
        String sql = "SELECT codigoFac, codigoProd, descrProd, " +
                    "cantidad, precUnit, valorVenta " +
                    "FROM DetFactura " +
                    "WHERE codigoFac = ? ";
        List<DetFactura> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                DetFactura cb = new DetFactura(u.getString(1), u.getString(2), u.getString(3),
                        u.getInt(4), u.getDouble(5), u.getDouble(6));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(DetFactura entidad) {
        String sqlA = "INSERT DetFactura (codigoFac, codigoProd, descrProd, " +
                    "cantidad, precUnit, valorVenta) "
                + "VALUES (?,?,?, "
                + "?,?,?) ";
        
        Class[] tipoObjetoA = {String.class, String.class, String.class, 
                Integer.class, Double.class, Double.class};
        Object[] valoresA = {entidad.getCodigoFac(), entidad.getCodigoProd(), entidad.getDescrProd(), 
                            entidad.getCantidad(), entidad.getPrecUnit(), entidad.getValorVenta()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(DetFactura entidad) {
        String sqlA = "UPDATE DetFactura "
                + "SET descrProd = ?, "
                + "cantidad = ?, precUnit = ?, valorVenta = ? "
                + "WHERE codigoFac = ? AND codigoProd = ? ";
        
        Class[] tipoObjetoA = {String.class, 
                            Integer.class, Double.class, Double.class, 
                            String.class, String.class};
        Object[] valoresA = {entidad.getDescrProd(), 
                            entidad.getCantidad(), entidad.getPrecUnit(), entidad.getValorVenta(), 
                            entidad.getCodigoFac(), entidad.getCodigoProd()};
        
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
