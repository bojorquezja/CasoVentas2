package pe.edu.utp.dao;

import pe.edu.utp.util.DataBaseUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.entity.Producto;

public class ProductoDao implements Dao<Producto>{

    @Override
    public Optional<Producto> getEntity(Object pk) {
        Objects.requireNonNull(pk, "Codigo Producto no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT codigoProd, descrProd, precUnit " +
                    "FROM Producto " +
                    "WHERE codigoProd = ?";
        Object[] valores = {(String) pk};
        List<Producto> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                Producto cb = new Producto(u.getString(1), u.getString(2), u.getDouble(3));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<Producto> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "Codigo Producto no debe ser nulo");
        Objects.requireNonNull(valores[1], "Descripcion Producto no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};
        String sql = "SELECT codigoProd, descrProd, precUnit " +
                    "FROM Producto " +
                    "WHERE codigoProd like ? AND descrProd like ?";
        valores[0] = "%"+valores[0]+"%";
        valores[1] = "%"+valores[1]+"%";
        List<Producto> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                Producto cb = new Producto(u.getString(1), u.getString(2), u.getDouble(3));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(Producto entidad) {
        String sqlA = "INSERT Producto (codigoProd, descrProd, precUnit) "
                + "VALUES (?,?,?) ";
        
        Class[] tipoObjetoA = {String.class, String.class, Double.class};
        Object[] valoresA = {entidad.getCodigoProd(), entidad.getDescrProd(), entidad.getPrecUnit()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(Producto entidad) {
        String sqlA = "UPDATE Producto "
                + "SET descrProd = ?, precUnit = ? "
                + "WHERE codigoProd = ?";
        
        Class[] tipoObjetoA = {String.class, Double.class, String.class};
        Object[] valoresA = {entidad.getDescrProd(), entidad.getPrecUnit(), entidad.getCodigoProd()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "Codigo Producto no debe ser nulo");
        String sqlA = "DELETE FROM Producto "
                + "WHERE codigoProd = ?";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
}
