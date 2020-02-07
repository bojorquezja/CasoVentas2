package pe.edu.utp.presenter;

import javax.swing.SwingUtilities;
import pe.edu.utp.dao.CabFacturaDao;
import pe.edu.utp.dao.DetFacturaDao;
import pe.edu.utp.model.FacturaModel;
import pe.edu.utp.model.MVPModel;
import pe.edu.utp.util.TypesUtil;
import pe.edu.utp.view.FacturaView;
import pe.edu.utp.view.MVPView;

public class ListaFacturaPresenter implements MVPPresenter{
    private MVPView view;
    private MVPModel model;
    private Object[] result;
    private String tipoView;

    public ListaFacturaPresenter(MVPView view, MVPModel model, Object[] params) {
        this.model = model;
        this.view = view;
        this.result = null;
        this.tipoView = (((String) params[0]).length()>=0) ? (String) params[0] : "SELECT";
        view.setPresenter(this);
        view.updateView("Iniciar", new Object[]{"Guia de Remision", tipoView});
        Object[] listObj = model.loadModel("Listar1", new Object[]{"", ""});
        view.updateView("Refrescar", new Object[]{listObj[0]});
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
        if (subject.equalsIgnoreCase("Buscar")) {
            //params: codigo FAC, cliente
            Object[] listObj = model.loadModel("Listar1", params);
            view.updateView("CargarDatos", new Object[]{listObj[0]});
        }
        if (subject.equalsIgnoreCase("Agregar")) {
            //params: codigo FAC, cliente
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new FacturaPresenter(
                        new FacturaView(null, true), 
                        new FacturaModel(new CabFacturaDao(), new DetFacturaDao()), 
                        new Object[]{"INSERT"});
                Boolean cambio = (Boolean) p.getResult()[0];   //prueba
                if (cambio){
                    view.updateView("Refrescar", null);
                }
            });
        }
        if (subject.equalsIgnoreCase("Editar")) {
            //params: codigo FAC, cliente, codigo FAC Editar
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new FacturaPresenter(
                        new FacturaView(null, true), 
                        new FacturaModel(new CabFacturaDao(), new DetFacturaDao()), 
                        new Object[]{"UPDATE", params[2]});
                Boolean cambio = (Boolean) p.getResult()[0];   //prueba
                if (cambio){
                    view.updateView("Refrescar", null);
                }
            });
        }
        if (subject.equalsIgnoreCase("Borrar")) {
            //params: codigo FAC, cliente, codigo FAC Borrar
            if ( (Boolean) view.updateView("DltBox", new Object[]{""})[0] ){
                try{
                    model.updateModel("DeleteCabDet", new Object[]{params[2]});
                    view.updateView("Refrescar", null);
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypesUtil.breakLine(e.toString(), 100)});
                }
            }
        }
        if (subject.equalsIgnoreCase("Seleccionar")) {
            //params: codigo GR Selecionado
            result = new Object[]{params[0]};
            view.closeView();
        }
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
