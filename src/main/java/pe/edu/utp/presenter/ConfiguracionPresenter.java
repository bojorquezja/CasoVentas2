package pe.edu.utp.presenter;

import pe.edu.utp.entity.CabGuiaRem;
import pe.edu.utp.entity.DetGuiaRem;
import pe.edu.utp.model.MVPModel;
import pe.edu.utp.view.MVPView;

public class ConfiguracionPresenter implements MVPPresenter{
    private MVPView view;
    private MVPModel model;
    private Object[] result;
    private String tipoView;

    public ConfiguracionPresenter(MVPView view, MVPModel model, Object[] params) {
        //tipoview, 
        this.model = model;
        this.view = view;
        this.result = new Object[]{(Boolean) true};
        this.tipoView = (((String) params[0]).length()>=0) ? (String) params[0] : "READ";
        view.setPresenter(this);
        Object[] ent=this.model.loadModel("Todo", null);
        view.updateView("Iniciar", new Object[]{"Configuracion", ent});
        view.showView();
    }
    
    @Override
    public void setView(MVPView view) {
        this.view = view;
    }

    @Override
    public void setModel(MVPModel model) {
        this.model = model;
    }

    @Override
    public void notifyPresenter(String subject, Object[] params) {
        if (subject.equalsIgnoreCase("Cancelar")) {
            view.closeView();
        }
        //TODO
        if (subject.equalsIgnoreCase("Aceptar")) {
            //params: String[] 6 par
            model.updateModel("Todo", params);
            view.closeView();
        }
        //TODO Reset y CambioConexion en textfield
        if (subject.equalsIgnoreCase("Reset")) {
            Object[] ent=this.model.loadModel("Reset", null);
            view.updateView("Reset", ent);
        }
        if (subject.equalsIgnoreCase("CambioConexion")) {
            //params: 4 String
            String conex = ConstruyeConexion((String[]) params);
            
            view.updateView("CambioConexion", new Object[]{conex});
        }
    }
    
    private String ConstruyeConexion(String[] valores){
        return "jdbc:mysql://" + valores[0] + ":"+
                valores[1] + "/" +
                valores[2] +
                (valores[3].isEmpty() ? "" : "?" + valores[3]);
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
