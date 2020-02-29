package pe.edu.utp.data.dao;

import pe.edu.utp.service.DataBaseService;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.data.entity.CabGuiaRem;
import pe.edu.utp.data.entity.DetGuiaRem;
import pe.edu.utp.data.entity.Producto;

public class DetGuiaRemDao implements Dao<DetGuiaRem>{

    @Override
    public Optional<DetGuiaRem> getEntity(Object[] pks) {
        Objects.requireNonNull(pks[0], "Codigo Guia Remision no debe ser nulo");
        Objects.requireNonNull(pks[1], "Codigo Producto no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};

        String sql = "SELECT g.codGuiaRem, g.codigoProd, p.descrProd, " +
                    "g.cantidad " +
                    "FROM DetGuiaRem g " +
                    "LEFT JOIN Producto p on (g.codigoProd = p.codigoProd) " +
                    "WHERE g.codGuiaRem = ? AND g.codigoProd = ? ";
        Object[] valores = {(String) pks[0], (String) pks[1]};
        List<DetGuiaRem> tlista = DataBaseService.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabGuiaRem cg = new CabGuiaRem();
                cg.setCodGuiaRem(u.getString(1));
                Producto pr = new Producto(u.getString(2), u.getString(3), 0);
                DetGuiaRem cb = new DetGuiaRem(cg, pr, u.getInt(4));
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
        String sql = "SELECT g.codGuiaRem, g.codigoProd, p.descrProd, " +
                    "g.cantidad " +
                    "FROM DetGuiaRem g " +
                    "LEFT JOIN Producto p on (g.codigoProd = p.codigoProd) " +
                    "WHERE g.codGuiaRem = ? ";
        List<DetGuiaRem> tlista = DataBaseService.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabGuiaRem cg = new CabGuiaRem();
                cg.setCodGuiaRem(u.getString(1));
                Producto pr = new Producto(u.getString(2), u.getString(3), 0);
                DetGuiaRem cb = new DetGuiaRem(cg, pr, u.getInt(4));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(DetGuiaRem entidad) {
        String sqlA = "INSERT DetGuiaRem (codGuiaRem, codigoProd, " +
                    "cantidad) "
                + "VALUES (?,?, "
                + "?) ";
        
        Class[] tipoObjetoA = {String.class, String.class, 
                Integer.class};
        Object[] valoresA = {entidad.getCabGuiaRem().getCodGuiaRem(), entidad.getProducto().getCodigoProd(),  
                            entidad.getCantidad()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseService.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(DetGuiaRem entidad) {
        String sqlA = "UPDATE DetGuiaRem "
                + "SET cantidad = ? "
                + "WHERE codGuiaRem = ? AND codigoProd = ? ";
        
        Class[] tipoObjetoA = {Integer.class, 
                            String.class, String.class};
        Object[] valoresA = {entidad.getCantidad(), 
                            entidad.getCabGuiaRem().getCodGuiaRem(), entidad.getProducto().getCodigoProd()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseService.grabaTransaccionBD(sql, tipoObjeto, valores);
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
        return DataBaseService.grabaTransaccionBD(sql, tipoObjeto, valores);
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
        return DataBaseService.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
}
