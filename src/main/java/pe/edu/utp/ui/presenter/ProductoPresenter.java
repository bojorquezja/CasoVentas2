package pe.edu.utp.ui.presenter;

import pe.edu.utp.data.entity.Producto;
import pe.edu.utp.ui.model.MVPModel;
import pe.edu.utp.service.TypeService;
import pe.edu.utp.ui.view.MVPView;

public class ProductoPresenter implements MVPPresenter{
    private MVPView view;
    private MVPModel model;
    private Object[] result;
    private String tipoView;

    public ProductoPresenter(MVPView view, MVPModel model, Object[] params) {
        //tipoview, pk CabGR
        this.model = model;
        this.view = view;
        this.result = new Object[]{(Boolean) true};
        this.tipoView = (((String) params[0]).length()>=0) ? (String) params[0] : "READ";
        this.view.setPresenter(this);
        Producto ent=null;
        try{
            if ( this.tipoView.equalsIgnoreCase("READ") || this.tipoView.equalsIgnoreCase("UPDATE") ){
                ent = (Producto) this.model.loadModel("Cab", new Object[]{params[1]})[0];
            }
            this.view.updateView("Iniciar", new Object[]{"Producto", tipoView, ent});
        }catch(Exception e){
            this.view.updateView("MsgBox", new Object[]{TypeService.breakLine(e.toString(), 100)});
        }
        this.view.showView();
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
        
        if (subject.equalsIgnoreCase("Aceptar")) {
            //params: Producto 
            if (this.tipoView.equalsIgnoreCase("INSERT")){
                Producto ent = (Producto) params[0];
                try{
                    model.updateModel("InsertCab", new Object[]{ ent });
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeService.breakLine(e.toString(), 100)});
                }
                result = new Object[]{(Boolean) true};
                view.closeView();
            }
            if (this.tipoView.equalsIgnoreCase("UPDATE")){
                Producto ent = (Producto) params[0];
                try{
                    model.updateModel("UpdateCab", new Object[]{ ent });
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeService.breakLine(e.toString(), 100)});
                }
                result = new Object[]{(Boolean) true};
                view.closeView();
            }
            
        }
        
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
