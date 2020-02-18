package pe.edu.utp.presenter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pe.edu.utp.dao.CabFacturaDao;
import pe.edu.utp.dao.ClienteDao;
import pe.edu.utp.dao.DetFacturaDao;
import pe.edu.utp.dao.EmpresaDao;
import pe.edu.utp.dao.ProductoDao;
import pe.edu.utp.entity.CabFactura;
import pe.edu.utp.model.FacturaModel;
import pe.edu.utp.model.MVPModel;
import pe.edu.utp.util.TypeUtil;
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
        this.view.setPresenter(this);
        this.view.updateView("Iniciar", new Object[]{"Facturas", tipoView});
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
            //params: codigo FAC, cliente
            try{
                Object[] listObj = model.loadModel("Listar1", params);
                view.updateView("CargarDatos", new Object[]{listObj[0]});
            }catch(Exception e){
                view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
            }
        }
        if (subject.equalsIgnoreCase("Agregar")) {
            //params: codigo FAC, cliente
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new FacturaPresenter(
                        new FacturaView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new FacturaModel(new CabFacturaDao(), new DetFacturaDao(),new EmpresaDao(), new ClienteDao(), new ProductoDao()), 
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
                        new FacturaView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new FacturaModel(new CabFacturaDao(), new DetFacturaDao(),new EmpresaDao(), new ClienteDao(), new ProductoDao()), 
                        new Object[]{"UPDATE", params[0]});
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
                    model.updateModel("DeleteCabDet", new Object[]{params[0]});
                    view.updateView("Refrescar", null);
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
                }
            }
        }
        if (subject.equalsIgnoreCase("Seleccionar")) {
            //params: codigo FA Selecionado
            try{
                result = new Object[]{(CabFactura) model.loadModel("Entidad", params)[0]};
                view.closeView();
            }catch(Exception e){
                view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
            }
        }
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
