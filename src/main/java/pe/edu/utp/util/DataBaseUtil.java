package pe.edu.utp.util;

import pe.edu.utp.util.ConfigurationUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class DataBaseUtil {
    private static final String CONNJDBC = getJDBCConnection();
    private static final String USER = getJDBCUser();
    private static final char[] PASS = getJDBCPassword();
    
    
    public static <T> List<T> traeListaBD(String sql, Class[] tipoObjeto, Object[] valores, BiConsumer<List<T>, ResultSet> accion){
        List<T> tlista = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(CONNJDBC,USER,new String(PASS));
            PreparedStatement stat = con.prepareStatement(sql);){
            
            for(int x=0 ; x < tipoObjeto.length ; x++){
                if (tipoObjeto[x].equals(String.class)){
                    if ( valores[x] == null){
                        stat.setNull(x+1, java.sql.Types.VARCHAR);
                    }else{
                        stat.setString(x+1, (String) valores[x]);
                    }
                } else if (tipoObjeto[x].equals(LocalDate.class)){
                    if ( valores[x] == null){
                        stat.setNull(x+1, java.sql.Types.DATE);
                    }else{
                        stat.setDate(x+1, TypeUtil.toSqlDate((LocalDate) valores[x]));
                    }
                } else if (tipoObjeto[x].equals(Integer.class)){
                    if ( valores[x] == null){
                        stat.setNull(x+1, java.sql.Types.INTEGER);
                    }else{
                        stat.setInt(x+1, (Integer) valores[x]);
                    }
                } else if (tipoObjeto[x].equals(Float.class)){
                    if ( valores[x] == null){
                        stat.setNull(x+1, java.sql.Types.FLOAT);
                    }else{
                        stat.setFloat(x+1, (Float) valores[x]);
                    }
                } else if (tipoObjeto[x].equals(Double.class)){
                    if ( valores[x] == null){
                        stat.setNull(x+1, java.sql.Types.DOUBLE);
                    }else{
                        stat.setDouble(x+1, (Double) valores[x]);
                    }
                }
            }
            try (ResultSet rs = stat.executeQuery()) {
                while (rs.next()){
                    accion.accept(tlista, rs);
                }
            } catch(SQLException e){
                throw new UnsupportedOperationException("Error: " + e);
            }
            
        } catch (SQLException e){
            throw new UnsupportedOperationException("Error: " + e);
        }
        return tlista;
    }
    
    public static boolean grabaTransaccionBD(String[] sql, Class[][] tipoObjeto, Object[][] valores){
        boolean resp = false;
        int totReg=0;
        try (Connection con = DriverManager.getConnection(CONNJDBC,USER,new String(PASS));){
            con.setAutoCommit(false);
            for (int z=0 ; z<sql.length ; z++){
                try (PreparedStatement stat = con.prepareStatement(sql[z]);){
                    for(int x=0 ; x < tipoObjeto[z].length ; x++){
                        if (tipoObjeto[z][x].equals(String.class)){
                            if ( valores[z][x] == null){
                                stat.setNull(x+1, java.sql.Types.VARCHAR);
                            }else{
                                stat.setString(x+1, (String) valores[z][x]);
                            }
                        } else if (tipoObjeto[z][x].equals(LocalDate.class)){
                            if ( valores[z][x] == null){
                                stat.setNull(x+1, java.sql.Types.DATE);
                            }else{
                                stat.setDate(x+1, TypeUtil.toSqlDate((LocalDate) valores[z][x]));
                            }
                        } else if (tipoObjeto[z][x].equals(Integer.class)){
                            if ( valores[z][x] == null){
                                stat.setNull(x+1, java.sql.Types.INTEGER);
                            }else{
                                stat.setInt(x+1, (Integer) valores[z][x]);
                            }
                        } else if (tipoObjeto[z][x].equals(Float.class)){
                            if ( valores[z][x] == null){
                                stat.setNull(x+1, java.sql.Types.FLOAT);
                            }else{
                                stat.setFloat(x+1, (Float) valores[z][x]);
                            }
                        } else if (tipoObjeto[z][x].equals(Double.class)){
                            if ( valores[z][x] == null){
                                stat.setNull(x+1, java.sql.Types.DOUBLE);
                            }else{
                                stat.setDouble(x+1, (Double) valores[z][x]);
                            }
                        }
                    }
                    stat.execute();
                    totReg += stat.getUpdateCount();
                } catch (SQLException e){
                    con.rollback();
                    throw new UnsupportedOperationException("Error: " + e);
                }
                
            }
            con.commit();
            if (totReg > 0){
                resp = true;
            }
            con.setAutoCommit(true);
        } catch (SQLException e){
            throw new UnsupportedOperationException("Error: " + e);
        }
        return resp;
    }
    
    private static String getJDBCConnection() {
        return ConfigurationUtil.get("JDBC.Connection");
    }
    private static String getJDBCUser() {
        return ConfigurationUtil.get("JDBC.User");
    }
    private static char[] getJDBCPassword() {
        String res = ConfigurationUtil.get("JDBC.Password");
        return (res == null ? null : res.toCharArray());
    }
   
}
