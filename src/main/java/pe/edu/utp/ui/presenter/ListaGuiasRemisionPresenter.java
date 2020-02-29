package pe.edu.utp.ui.presenter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pe.edu.utp.data.dao.CabGuiaRemDao;
import pe.edu.utp.data.dao.ClienteDao;
import pe.edu.utp.data.dao.DetGuiaRemDao;
import pe.edu.utp.data.dao.EmpresaDao;
import pe.edu.utp.data.dao.ProductoDao;
import pe.edu.utp.data.entity.CabGuiaRem;
import pe.edu.utp.ui.model.GuiasRemisionModel;
import pe.edu.utp.ui.model.MVPModel;
import pe.edu.utp.service.TypeService;
import pe.edu.utp.ui.view.GuiasRemisionView;
import pe.edu.utp.ui.view.MVPView;

public class ListaGuiasRemisionPresenter implements MVPPresenter{
    private MVPView view;
    private MVPModel model;
    private Object[] result;
    private String tipoView;

    public ListaGuiasRemisionPresenter(MVPView view, MVPModel model, Object[] params) {
        this.model = model;
        this.view = view;
        this.result = null;
        this.tipoView = (((String) params[0]).length()>=0) ? (String) params[0] : "SELECT";
        this.view.setPresenter(this);
        this.view.updateView("Iniciar", new Object[]{"Guia de Remision", tipoView});
        this.view.updateView("Refrescar", null);
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
        if (subject.equalsIgnoreCase("Buscar")) {
            //params: codigo GR, cliente
            try{
                Object[] listObj = model.loadModel("Listar1", params);
                view.updateView("CargarDatos", new Object[]{listObj[0]});
            }catch(Exception e){
                view.updateView("MsgBox", new Object[]{TypeService.breakLine(e.toString(), 100)});
            }
        }
        if (subject.equalsIgnoreCase("Agregar")) {
            //params: codigo GR, cliente
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new GuiasRemisionPresenter(
                        new GuiasRemisionView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new GuiasRemisionModel(new CabGuiaRemDao(), new DetGuiaRemDao(),new EmpresaDao(), new ClienteDao(), new ProductoDao()), 
                        new Object[]{"INSERT"});
                Boolean cambio = (Boolean) p.getResult()[0];   //prueba
                if (cambio){
                    view.updateView("Refrescar", null);
                }
            });
        }
        if (subject.equalsIgnoreCase("Editar")) {
            //params: codigo GR, cliente, codigo GR Editar
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new GuiasRemisionPresenter(
                        new GuiasRemisionView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new GuiasRemisionModel(new CabGuiaRemDao(), new DetGuiaRemDao(),new EmpresaDao(), new ClienteDao(), new ProductoDao()), 
                        new Object[]{"UPDATE", params[0]});
                Boolean cambio = (Boolean) p.getResult()[0];   //prueba
                if (cambio){
                    view.updateView("Refrescar", null);
                }
            });
        }
        if (subject.equalsIgnoreCase("Borrar")) {
            //params: codigo GR, cliente, codigo GR Borrar
            if ( (Boolean) view.updateView("DltBox", new Object[]{""})[0] ){
                try{
                    model.updateModel("DeleteCabDet", new Object[]{params[0]});
                    view.updateView("Refrescar", null);
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeService.breakLine(e.toString(), 100)});
                }
            }
        }
        if (subject.equalsIgnoreCase("Seleccionar")) {
            //params: codigo GR Selecionado
            try{
                result = new Object[]{(CabGuiaRem) model.loadModel("Entidad", params)[0]};
                view.closeView();
            }catch(Exception e){
                view.updateView("MsgBox", new Object[]{TypeService.breakLine(e.toString(), 100)});
            }
        }
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
