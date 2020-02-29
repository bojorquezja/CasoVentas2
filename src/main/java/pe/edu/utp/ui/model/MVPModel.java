package pe.edu.utp.ui.model;

public interface MVPModel {
    void updateModel(String subject, Object[] params );
    Object[] loadModel(String subject, Object[] params );
}
