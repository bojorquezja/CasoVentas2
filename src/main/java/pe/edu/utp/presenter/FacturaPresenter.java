package pe.edu.utp.presenter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pe.edu.utp.dao.ClienteDao;
import pe.edu.utp.entity.CabFactura;
import pe.edu.utp.entity.Cliente;
import pe.edu.utp.model.ListaClienteModel;
import pe.edu.utp.model.MVPModel;
import pe.edu.utp.util.TypeUtil;
import pe.edu.utp.view.ListaClienteView;
import pe.edu.utp.view.MVPView;

public class FacturaPresenter implements MVPPresenter{
    private MVPView view;
    private MVPModel model;
    private Object[] result;
    private String tipoView;

    public FacturaPresenter(MVPView view, MVPModel model, Object[] params) {
        //tipoview, pk CabFactura
        this.model = model;
        this.view = view;
        this.result = new Object[]{(Boolean) true};
        this.tipoView = (((String) params[0]).length()>=0) ? (String) params[0] : "READ";
        view.setPresenter(this);
        CabFactura ent=null;
        if ( this.tipoView.equalsIgnoreCase("READ") || this.tipoView.equalsIgnoreCase("UPDATE") ){
            ent = (CabFactura) model.loadModel("CabDet", new Object[]{params[1]})[0];
        }
        view.updateView("Iniciar", new Object[]{"Factura", tipoView, ent});
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
        
        if (subject.equalsIgnoreCase("Aceptar")) {
            //params: CabFactura con Det
            if (this.tipoView.equalsIgnoreCase("INSERT")){
                CabFactura ent = (CabFactura) params[0];
                if (ent.getCodGuiaRem().isEmpty()){
                    ent.setCodGuiaRem(null);
                }
                try{
                    model.updateModel("InsertCabDet", new Object[]{ ent });
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
                }
                result = new Object[]{(Boolean) true};
                view.closeView();
            }
            if (this.tipoView.equalsIgnoreCase("UPDATE")){
                CabFactura ent = (CabFactura) params[0];
                if (ent.getCodGuiaRem().isEmpty()){
                    ent.setCodGuiaRem(null);
                }
                try{
                    model.updateModel("UpdateCabDet", new Object[]{ ent });
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
                }
                result = new Object[]{(Boolean) true};
                view.closeView();
            }
            
        }
        if (subject.equalsIgnoreCase("SelectCliente")) {
            //params:
            SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ListaClientePresenter(
                            new ListaClienteView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                            new ListaClienteModel(new ClienteDao()), 
                            new Object[]{"SELECT"});
                    String pk = TypeUtil.toString(p.getResult()[0]);   
                    if (pk != null){
                        Cliente entid = (Cliente) model.loadModel("Cab", new Object[]{pk})[0];
                        view.updateView("CargaCliente", new Object[]{entid});
                    }
                });
        }
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
