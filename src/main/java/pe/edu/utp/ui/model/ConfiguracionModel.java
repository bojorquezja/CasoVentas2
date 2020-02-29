package pe.edu.utp.ui.model;

import pe.edu.utp.service.ConfigurationService;

public class ConfiguracionModel implements MVPModel{

    @Override
    public void updateModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Todo")) {
            //params: String[]
            String[] propiedades = new String[]{"JDBC.Server", "JDBC.Port", "JDBC.DataBase",
                            "JDBC.Parameters", "JDBC.Connection", "JDBC.User", 
                            "JDBC.Password"};
                
            ConfigurationService.setArray(propiedades, (String[]) params);
        }
        
    }

    @Override
    public Object[] loadModel(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Todo")) {
            //params: 
            return ConfigurationService.getArray(new String[]{"JDBC.Server", "JDBC.Port", "JDBC.DataBase",
                            "JDBC.Parameters", "JDBC.Connection", "JDBC.User", 
                            "JDBC.Password"}
            );
        }
        if (subject.equalsIgnoreCase("Reset")) {
            //params: 
            return ConfigurationService.getDefaultArray(new String[]{"JDBC.Server", "JDBC.Port", "JDBC.DataBase",
                            "JDBC.Parameters", "JDBC.Connection", "JDBC.User", 
                            "JDBC.Password"}
            );
        }
        return null;
    }
    
}
