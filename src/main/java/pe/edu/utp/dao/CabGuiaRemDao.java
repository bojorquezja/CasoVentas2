package pe.edu.utp.dao;

import pe.edu.utp.util.DataBaseUtil;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static pe.edu.utp.util.DataBaseUtil.toLocalDate;
import pe.edu.utp.entity.CabGuiaRem;

public class CabGuiaRemDao implements Dao<CabGuiaRem>{

    @Override
    public Optional<CabGuiaRem> getEntity(Object pk) {
        Objects.requireNonNull(pk, "Codigo Guia Remision no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT codGuiaRem, fechaEmi, rucEmpresa, " +
                    "razSocEmpresa, rucCliente, razSocCliente, direcCliente, " +
                    "almacenero, bultos " +
                    "FROM CabGuiaRem " +
                    "WHERE codGuiaRem = ?";
        Object[] valores = {(String) pk};
        List<CabGuiaRem> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabGuiaRem cb = new CabGuiaRem(u.getString(1), toLocalDate(u.getDate(2)), u.getString(3), 
                        u.getString(4), u.getString(5), u.getString(6), u.getString(7), 
                        u.getString(8), u.getInt(9));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<CabGuiaRem> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "Codigo Guia Remision no debe ser nulo");
        Objects.requireNonNull(valores[1], "Razon Social Cliente no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};
        String sql = "SELECT codGuiaRem, fechaEmi, rucEmpresa, " +
                    "razSocEmpresa, rucCliente, razSocCliente, direcCliente, " +
                    "almacenero, bultos " +
                    "FROM CabGuiaRem " +
                    "WHERE codGuiaRem like ? AND razSocCliente like ?";
        valores[0] = "%"+valores[0]+"%";
        valores[1] = "%"+valores[1]+"%";
        List<CabGuiaRem> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabGuiaRem cb = new CabGuiaRem(u.getString(1), toLocalDate(u.getDate(2)), u.getString(3), 
                        u.getString(4), u.getString(5), u.getString(6), u.getString(7), 
                        u.getString(8), u.getInt(9));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(CabGuiaRem entidad) {
        String sqlA = "INSERT CabGuiaRem (codGuiaRem, fechaEmi, rucEmpresa, " +
                    "razSocEmpresa, rucCliente, razSocCliente, direcCliente, " +
                    "almacenero, bultos) "
                + "VALUES (?,?,?, "
                + "?,?,?,?, "
                + "?,?) ";
        
        Class[] tipoObjetoA = {String.class, LocalDate.class, String.class,  
                String.class, String.class, String.class, String.class, 
                String.class, Integer.class};
        Object[] valoresA = {entidad.getCodGuiaRem(), entidad.getFechaEmi(), entidad.getRucEmpresa(), 
                            entidad.getRazSocEmpresa(), entidad.getRucCliente(), entidad.getRazSocCliente(), entidad.getDirecCliente(), 
                            entidad.getAlmacenero(), entidad.getBultos()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(CabGuiaRem entidad) {
        String sqlA = "UPDATE CabGuiaRem "
                + "SET fechaEmi = ?, rucEmpresa = ?, "
                + "razSocEmpresa = ?, rucCliente = ?, razSocCliente = ?, "
                + "direcCliente = ?, almacenero = ?, bultos = ? "
                + "WHERE codGuiaRem = ?";
        
        Class[] tipoObjetoA = {LocalDate.class, String.class,
                            String.class, String.class, String.class, 
                            String.class, String.class, Integer.class,
                            String.class};
        Object[] valoresA = {entidad.getFechaEmi(), entidad.getRucEmpresa(), 
                            entidad.getRazSocEmpresa(), entidad.getRucCliente(), entidad.getRazSocCliente(),
                            entidad.getDirecCliente(), entidad.getAlmacenero(), entidad.getBultos(),
                            entidad.getCodGuiaRem()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "Codigo Guia Remision no debe ser nulo");
        String sqlA = "DELETE FROM CabGuiaRem "
                + "WHERE codGuiaRem = ?";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
}
