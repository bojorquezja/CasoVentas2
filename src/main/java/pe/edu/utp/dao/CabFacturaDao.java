package pe.edu.utp.dao;

import pe.edu.utp.util.DataBaseUtil;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static pe.edu.utp.util.DataBaseUtil.toLocalDate;
import pe.edu.utp.entity.CabFactura;

public class CabFacturaDao implements Dao<CabFactura>{

    @Override
    public Optional<CabFactura> getEntity(Object pk) {
        Objects.requireNonNull(pk, "Codigo Factura no debe ser nulo");
        Class[] tipoObjeto = {String.class};
        String sql = "SELECT codigoFac, fechaEmi, codGuiaRem, rucEmpresa, " +
                    "razSocEmpresa, rucCliente, razSocCliente, direcCliente, " +
                    "cajero, subTotal, igv, total " +
                    "FROM CabFactura " +
                    "WHERE codigoFac = ?";
        Object[] valores = {(String) pk};
        List<CabFactura> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabFactura cb = new CabFactura(u.getString(1), toLocalDate(u.getDate(2)), u.getString(3), u.getString(4),
                        u.getString(5), u.getString(6), u.getString(7), u.getString(8), 
                        u.getString(9), u.getDouble(10), u.getDouble(11), u.getDouble(12));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista.stream().findFirst();
    }

    @Override
    public List<CabFactura> getListOfEntities01(Object[] valores) {
        Objects.requireNonNull(valores[0], "Codigo Factura no debe ser nulo");
        Objects.requireNonNull(valores[1], "Razon Social Cliente no debe ser nulo");
        Class[] tipoObjeto = {String.class, String.class};
        String sql = "SELECT codigoFac, fechaEmi, codGuiaRem, rucEmpresa, " +
                    "razSocEmpresa, rucCliente, razSocCliente, direcCliente, " +
                    "cajero, subTotal, igv, total " +
                    "FROM CabFactura " +
                    "WHERE codigoFac like ? AND razSocCliente like ?";
        valores[0] = "%"+valores[0]+"%";
        valores[1] = "%"+valores[1]+"%";
        List<CabFactura> tlista = DataBaseUtil.traeListaBD(sql, tipoObjeto, valores, (t, u) -> {
            try{
                CabFactura cb = new CabFactura(u.getString(1), toLocalDate(u.getDate(2)), u.getString(3), u.getString(4),
                        u.getString(5), u.getString(6), u.getString(7), u.getString(8), 
                        u.getString(9), u.getDouble(10), u.getDouble(11), u.getDouble(12));
                t.add(cb);
            }catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        });
        return tlista;
    }

    @Override
    public boolean insert(CabFactura entidad) {
        String sqlA = "INSERT CabFactura (codigoFac, fechaEmi, codGuiaRem, rucEmpresa, "
                + "razSocEmpresa, rucCliente, razSocCliente, direcCliente, "
                + "cajero, subTotal, igv, total) "
                + "VALUES (?,?,?,?, "
                + "?,?,?,?, "
                + "?,?,?,?) ";
        
        Class[] tipoObjetoA = {String.class, LocalDate.class, String.class, String.class, 
                String.class, String.class, String.class, String.class, 
                String.class, Double.class, Double.class, Double.class};
        Object[] valoresA = {entidad.getCodigoFac(), entidad.getFechaEmi(), entidad.getCodGuiaRem(), entidad.getRucEmpresa(), 
                            entidad.getRazSocEmpresa(), entidad.getRucCliente(), entidad.getRazSocCliente(), entidad.getDirecCliente(), 
                            entidad.getCajero(), entidad.getSubTotal(), entidad.getIgv(), entidad.getTotal()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean update(CabFactura entidad) {
        String sqlA = "UPDATE CabFactura "
                + "SET fechaEmi = ?, codGuiaRem = ?, rucEmpresa = ?, "
                + "razSocEmpresa = ?, rucCliente = ?, razSocCliente = ?, "
                + "direcCliente = ?, cajero = ?, subTotal = ?, "
                + "igv = ?, total = ? "
                + "WHERE codigoFac = ?";
        
        Class[] tipoObjetoA = {LocalDate.class, String.class, String.class,
                            String.class, String.class, String.class, 
                            String.class, String.class, Double.class, 
                            Double.class, Double.class, 
                            String.class};
        Object[] valoresA = {entidad.getFechaEmi(), entidad.getCodGuiaRem(), entidad.getRucEmpresa(), 
                            entidad.getRazSocEmpresa(), entidad.getRucCliente(), entidad.getRazSocCliente(),
                            entidad.getDirecCliente(), entidad.getCajero(), entidad.getSubTotal(),
                            entidad.getIgv(), entidad.getTotal(),
                            entidad.getCodigoFac()};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }

    @Override
    public boolean delete(Object pk) {
        Objects.requireNonNull(pk, "Codigo Factura no debe ser nulo");
        String sqlA = "DELETE FROM CabFactura "
                + "WHERE codigoFac = ?";
        
        Class[] tipoObjetoA = {String.class};
        Object[] valoresA = {(String) pk};
        
        String[] sql = {sqlA};
        Class[][] tipoObjeto = {tipoObjetoA};
        Object[][] valores = {valoresA};
        return DataBaseUtil.grabaTransaccionBD(sql, tipoObjeto, valores);
    }
    
}
