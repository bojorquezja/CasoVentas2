package pe.edu.utp.dao;

import pe.edu.utp.util.DataBaseUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.entity.Empresa;

public class EmpresaDao implements Dao<Empresa>{

    @Override
    public Optional<Empresa> getEntity(Object pk) {
        Objects.requireNonNull(pk, "RUC Empresa no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT rucEmpresa, razSocEmpresa " +
                    "FROM Empresa " +
                    "WHERE rucEmpresa = ?";
        Object[] valores = {(String) pk};
        List<Empresa> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                Empresa cb = new Empresa(u.getString(1), u.getString(2));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<Empresa> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "RUC Empresa no debe ser nulo");
        Objects.requireNonNull(valores[1], "Razon Social Empresa no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};
        String sql = "SELECT rucEmpresa, razSocEmpresa " +
                    "FROM Empresa " +
                    "WHERE rucEmpresa like ? AND razSocEmpresa like ?";
        valores[0] = "%"+valores[0]+"%";
        valores[1] = "%"+valores[1]+"%";
        List<Empresa> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                Empresa cb = new Empresa(u.getString(1), u.getString(2));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(Empresa entidad) {
        String sqlA = "INSERT Empresa (rucEmpresa, razSocEmpresa) "
                + "VALUES (?,?) ";
        
        Class[] tipoObjetoA = {String.class, String.class};
        Object[] valoresA = {entidad.getRucEmpresa(), entidad.getRazSocEmpresa()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(Empresa entidad) {
        String sqlA = "UPDATE Empresa "
                + "SET razSocEmpresa = ? "
                + "WHERE rucEmpresa = ?";
        
        Class[] tipoObjetoA = {String.class, String.class};
        Object[] valoresA = {entidad.getRazSocEmpresa(), entidad.getRucEmpresa()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "RUC Empresa no debe ser nulo");
        String sqlA = "DELETE FROM Empresa "
                + "WHERE rucEmpresa = ?";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
}
