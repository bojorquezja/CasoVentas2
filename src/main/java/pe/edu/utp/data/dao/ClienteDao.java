package pe.edu.utp.data.dao;

import pe.edu.utp.service.DataBaseUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import pe.edu.utp.data.entity.Cliente;

public class ClienteDao implements Dao<Cliente>{

    @Override
    public Optional<Cliente> getEntity(Object pk) {
        Objects.requireNonNull(pk, "Codigo Factura no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT rucCliente, razSocCliente, direcCliente " +
                    "FROM Cliente " +
                    "WHERE rucCliente = ?";
        Object[] valores = {(String) pk};
        List<Cliente> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                Cliente cb = new Cliente(u.getString(1), u.getString(2), u.getString(3));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<Cliente> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "RUC Cliente no debe ser nulo");
        Objects.requireNonNull(valores[1], "Razon Social Cliente no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};
        String sql = "SELECT rucCliente, razSocCliente, direcCliente " +
                    "FROM Cliente " +
                    "WHERE rucCliente like ? AND razSocCliente like ?";
        valores[0] = "%"+valores[0]+"%";
        valores[1] = "%"+valores[1]+"%";
        List<Cliente> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                Cliente cb = new Cliente(u.getString(1), u.getString(2), u.getString(3));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(Cliente entidad) {
        String sqlA = "INSERT Cliente (rucCliente, razSocCliente, direcCliente) "
                + "VALUES (?,?,?) ";
        
        Class[] tipoObjetoA = {String.class, String.class, String.class};
        Object[] valoresA = {entidad.getRucCliente(), entidad.getRazSocCliente(), entidad.getDirecCliente()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(Cliente entidad) {
        String sqlA = "UPDATE Cliente "
                + "SET razSocCliente = ?, direcCliente = ? "
                + "WHERE rucCliente = ?";
        
        Class[] tipoObjetoA = {String.class, String.class, String.class};
        Object[] valoresA = {entidad.getRazSocCliente(), entidad.getDirecCliente(), entidad.getRucCliente()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "RUC Cliente no debe ser nulo");
        String sqlA = "DELETE FROM Cliente "
                + "WHERE rucCliente = ?";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
}
