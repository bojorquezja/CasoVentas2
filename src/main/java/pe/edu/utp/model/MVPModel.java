package pe.edu.utp.model;

public interface MVPModel {
    void updateModel(String subject, Object[] params );
    Object[] loadModel(String subject, Object[] params );
}
