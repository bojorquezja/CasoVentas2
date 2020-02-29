package pe.edu.utp.ui.presenter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pe.edu.utp.data.dao.CabFacturaDao;
import pe.edu.utp.data.dao.CabGuiaRemDao;
import pe.edu.utp.data.dao.ClienteDao;
import pe.edu.utp.data.dao.DetFacturaDao;
import pe.edu.utp.data.dao.DetGuiaRemDao;
import pe.edu.utp.data.dao.EmpresaDao;
import pe.edu.utp.data.dao.ProductoDao;
import pe.edu.utp.ui.model.ConfiguracionModel;
import pe.edu.utp.ui.model.ListaClienteModel;
import pe.edu.utp.ui.model.ListaEmpresaModel;
import pe.edu.utp.ui.model.ListaFacturaModel;
import pe.edu.utp.ui.model.ListaGuiasRemisionModel;
import pe.edu.utp.ui.model.ListaProductoModel;
import pe.edu.utp.ui.model.MVPModel;
import pe.edu.utp.service.FileUtil;
import pe.edu.utp.ui.view.ConfiguracionView;
import pe.edu.utp.ui.view.ListaClienteView;
import pe.edu.utp.ui.view.ListaEmpresaView;
import pe.edu.utp.ui.view.ListaFacturaView;
import pe.edu.utp.ui.view.ListaGuiasRemisionView;
import pe.edu.utp.ui.view.ListaProductoView;
import pe.edu.utp.ui.view.MVPView;

public class PrincipalPresenter implements MVPPresenter{
    private MVPView view;
    private MVPModel model;
    private Object[] result;
    private String tipoView;

    public PrincipalPresenter(MVPView view, MVPModel model, Object[] params) {
        //tipoview
        this.model = model;
        this.view = view;
        this.result = new Object[]{(Boolean) true};
        this.tipoView = (((String) params[0]).length()>=0) ? (String) params[0] : "READ";
        this.view.setPresenter(this);
        this.view.updateView("Iniciar", new Object[]{"Sistema de Ventas"});
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
        
        if (subject.equalsIgnoreCase("Menu")) {
            //params: Opcion
            if (((String) params[0]).equalsIgnoreCase("MantGuiaRemision")){
                SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ListaGuiasRemisionPresenter(
                            new ListaGuiasRemisionView((JFrame)view, true), 
                            new ListaGuiasRemisionModel(new CabGuiaRemDao(), new DetGuiaRemDao()), 
                            new Object[]{"MAINTENANCE"});
                });
            }
            if (((String) params[0]).equalsIgnoreCase("MantFactura")){
                SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ListaFacturaPresenter(
                            new ListaFacturaView((JFrame)view, true), 
                            new ListaFacturaModel(new CabFacturaDao(), new DetFacturaDao()), 
                            new Object[]{"MAINTENANCE"});
                });
            }
            if (((String) params[0]).equalsIgnoreCase("MantClientes")){
                SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ListaClientePresenter(
                            new ListaClienteView((JFrame)view, true), 
                            new ListaClienteModel(new ClienteDao()), 
                            new Object[]{"MAINTENANCE"});
                });
            }
            if (((String) params[0]).equalsIgnoreCase("MantProductos")){
                SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ListaProductoPresenter(
                            new ListaProductoView((JFrame)view, true), 
                            new ListaProductoModel(new ProductoDao()), 
                            new Object[]{"MAINTENANCE"});
                });
            }
            if (((String) params[0]).equalsIgnoreCase("MantEmpresas")){
                SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ListaEmpresaPresenter(
                            new ListaEmpresaView((JFrame)view, true), 
                            new ListaEmpresaModel(new EmpresaDao()), 
                            new Object[]{"MAINTENANCE"});
                });
            }
            if (((String) params[0]).equalsIgnoreCase("Configuracion")){
                SwingUtilities.invokeLater(() -> {
                    MVPPresenter p = new ConfiguracionPresenter(
                            new ConfiguracionView((JFrame) view, true), 
                            new ConfiguracionModel(), 
                            new Object[]{""});
                });
            }
            if (((String) params[0]).equalsIgnoreCase("Descarga SQL")){
                boolean result = true;
                result = result && FileUtil.exportResourceFile("BDVentas2_1.sql", "BDVentasV2.1.sql");
                result = result && FileUtil.exportResourceFile("BDVentas2_2.sql", "BDVentasV2.2.sql");
                result = result && FileUtil.exportResourceFile("BDVentas2_3.sql", "BDVentasV2.3.sql");
                if(result){
                    view.updateView("MsgBox", new Object[]{"Archivos descargados en la carpeta del aplicativo"});
                }else{
                    view.updateView("MsgBox", new Object[]{"ERROR al descargar Archivos!"});
                }
            }
        }
        
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
