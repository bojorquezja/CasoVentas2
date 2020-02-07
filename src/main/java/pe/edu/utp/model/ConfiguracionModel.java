package pe.edu.utp.model;

import pe.edu.utp.util.ConfigurationUtil;

public class ConfiguracionModel implements MVPModel{

    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Todo")) {
            //params: String[]
            String[] propiedades = new String[]{"JDBC.Server", "JDBC.Port", "JDBC.DataBase",
                            "JDBC.Parameters", "JDBC.Connection", "JDBC.User", 
                            "JDBC.Password"};
                
            ConfigurationUtil.setArray(propiedades, (String[]) params);
        }
        
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Todo")) {
            //params: 
            return ConfigurationUtil.getArray(new String[]{"JDBC.Server", "JDBC.Port", "JDBC.DataBase",
                            "JDBC.Parameters", "JDBC.Connection", "JDBC.User", 
                            "JDBC.Password"}
            );
        }
        if (subject.equalsIgnoreCase("Reset")) {
            //params: 
            return ConfigurationUtil.getDefaultArray(new String[]{"JDBC.Server", "JDBC.Port", "JDBC.DataBase",
                            "JDBC.Parameters", "JDBC.Connection", "JDBC.User", 
                            "JDBC.Password"}
            );
        }
        return null;
    }
    
}
