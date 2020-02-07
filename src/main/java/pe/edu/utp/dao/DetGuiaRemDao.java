package pe.edu.utp.dao;

import pe.edu.utp.util.DataBaseUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.entity.DetGuiaRem;

public class DetGuiaRemDao implements Dao<DetGuiaRem>{

    @Override
    public Optional<DetGuiaRem> getEntity(Object[] pks) {
        Objects.requireNonNull(pks[0], "Codigo Guia Remision no debe ser nulo");
        Objects.requireNonNull(pks[1], "Codigo Producto no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};

        String sql = "SELECT codGuiaRem, codigoProd, descrProd, " +
                    "cantidad " +
                    "FROM DetGuiaRem " +
                    "WHERE codGuiaRem = ? AND codigoProd = ? ";
        Object[] valores = {(String) pks[0], (String) pks[1]};
        List<DetGuiaRem> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                DetGuiaRem cb = new DetGuiaRem(u.getString(1), u.getString(2), u.getString(3),
                        u.getInt(4));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<DetGuiaRem> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "Codigo Guia Remision no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT codGuiaRem, codigoProd, descrProd, " +
                    "cantidad " +
                    "FROM DetGuiaRem " +
                    "WHERE codGuiaRem = ? ";
        List<DetGuiaRem> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                DetGuiaRem cb = new DetGuiaRem(u.getString(1), u.getString(2), u.getString(3),
                        u.getInt(4));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(DetGuiaRem entidad) {
        String sqlA = "INSERT DetGuiaRem (codGuiaRem, codigoProd, descrProd, " +
                    "cantidad) "
                + "VALUES (?,?,?, "
                + "?) ";
        
        Class[] tipoObjetoA = {String.class, String.class, String.class, 
                Integer.class};
        Object[] valoresA = {entidad.getCodGuiaRem(), entidad.getCodigoProd(), entidad.getDescrProd(), 
                            entidad.getCantidad()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(DetGuiaRem entidad) {
        String sqlA = "UPDATE DetGuiaRem "
                + "SET descrProd = ?, "
                + "cantidad = ? "
                + "WHERE codGuiaRem = ? AND codigoProd = ? ";
        
        Class[] tipoObjetoA = {String.class, 
                            Integer.class, 
                            String.class, String.class};
        Object[] valoresA = {entidad.getDescrProd(), 
                            entidad.getCantidad(), 
                            entidad.getCodGuiaRem(), entidad.getCodigoProd()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object[] pks) {
        Objects.requireNonNull(pks[0], "Codigo Guia Remision no debe ser nulo");
        Objects.requireNonNull(pks[1], "Codigo Producto no debe ser nulo");
        String sqlA = "DELETE FROM DetGuiaRem "
                + "WHERE codGuiaRem = ? AND codigoProd = ? ";
        
        Class[] tipoObjetoA = {String.class, String.class};
        Object[] valoresA = {(String) pks[0], (String) pks[1]};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "Codigo Guia Remision no debe ser nulo");
        String sqlA = "DELETE FROM DetGuiaRem "
                + "WHERE codGuiaRem = ? ";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
}
