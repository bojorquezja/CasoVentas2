package pe.edu.utp.ui.presenter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pe.edu.utp.data.dao.CabGuiaRemDao;
import pe.edu.utp.data.dao.ClienteDao;
import pe.edu.utp.data.dao.DetGuiaRemDao;
import pe.edu.utp.data.dao.EmpresaDao;
import pe.edu.utp.data.dao.ProductoDao;
import pe.edu.utp.data.entity.CabFactura;
import pe.edu.utp.data.entity.CabGuiaRem;
import pe.edu.utp.data.entity.Cliente;
import pe.edu.utp.data.entity.Empresa;
import pe.edu.utp.data.entity.Producto;
import pe.edu.utp.ui.model.ListaClienteModel;
import pe.edu.utp.ui.model.ListaEmpresaModel;
import pe.edu.utp.ui.model.ListaGuiasRemisionModel;
import pe.edu.utp.ui.model.ListaProductoModel;
import pe.edu.utp.ui.model.MVPModel;
import pe.edu.utp.service.TypeUtil;
import pe.edu.utp.ui.view.ListaClienteView;
import pe.edu.utp.ui.view.ListaEmpresaView;
import pe.edu.utp.ui.view.ListaGuiasRemisionView;
import pe.edu.utp.ui.view.ListaProductoView;
import pe.edu.utp.ui.view.MVPView;

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
        this.view.setPresenter(this);
        CabFactura ent=null;
        try{
            if ( this.tipoView.equalsIgnoreCase("READ") || this.tipoView.equalsIgnoreCase("UPDATE") ){
                ent = (CabFactura) this.model.loadModel("CabDet", new Object[]{params[1]})[0];
            }
            this.view.updateView("Iniciar", new Object[]{"Factura", tipoView, ent});
        }catch(Exception e){
            this.view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
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
            //params: CabFactura con Det
            if (this.tipoView.equalsIgnoreCase("INSERT")){
                CabFactura ent = (CabFactura) params[0];
                if (ent.getCabGuiaRem().getCodGuiaRem().isEmpty()){
                    ent.getCabGuiaRem().setCodGuiaRem(null);
                }
                if (ent.getEmpresa().getRucEmpresa().isEmpty()){
                    ent.getEmpresa().setRucEmpresa(null);
                }
                if (ent.getCliente().getRucCliente().isEmpty()){
                    ent.getCliente().setRucCliente(null);
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
                if (ent.getCabGuiaRem().getCodGuiaRem().isEmpty()){
                    ent.getCabGuiaRem().setCodGuiaRem(null);
                }
                if (ent.getEmpresa().getRucEmpresa().isEmpty()){
                    ent.getEmpresa().setRucEmpresa(null);
                }
                if (ent.getCliente().getRucCliente().isEmpty()){
                    ent.getCliente().setRucCliente(null);
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
                Cliente entid = (Cliente) p.getResult()[0]; 
                if (entid != null){
                    view.updateView("CargaCliente", new Object[]{entid});
                }
            });
        }
        if (subject.equalsIgnoreCase("DatosCliente")) {
            //params: pk Cliente
            String pk = TypeUtil.toString(params[0]);   
            if (pk != null){
                try{
                    Cliente entid = (Cliente) model.loadModel("CargaCliente", new Object[]{pk})[0];
                    view.updateView("CargaCliente", new Object[]{entid});
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
                }
            }
        }
        if (subject.equalsIgnoreCase("SelectGuiaRemision")) {
            //params: pk GR
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new ListaGuiasRemisionPresenter(
                        new ListaGuiasRemisionView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new ListaGuiasRemisionModel(new CabGuiaRemDao(), new DetGuiaRemDao()), 
                        new Object[]{"SELECT"});
                CabGuiaRem entid = (CabGuiaRem) p.getResult()[0]; 
                if (entid != null){
                    view.updateView("CargaGuiaRemision", new Object[]{entid});
                }
            });
        }
        if (subject.equalsIgnoreCase("SelectEmpresa")) {
            //params: pk Emp
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new ListaEmpresaPresenter(
                        new ListaEmpresaView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new ListaEmpresaModel(new EmpresaDao()), 
                        new Object[]{"SELECT"});
                Empresa entid = (Empresa) p.getResult()[0]; 
                if (entid != null){
                    view.updateView("CargaEmpresa", new Object[]{entid});
                }
            });
        }
        if (subject.equalsIgnoreCase("DatosEmpresa")) {
            //params: pk Emp
            String pk = TypeUtil.toString(params[0]);   
            if (pk != null){
                try{
                    Empresa entid = (Empresa) model.loadModel("CargaEmpresa", new Object[]{pk})[0];
                    view.updateView("CargaEmpresa", new Object[]{entid});
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
                }
            }
        }
        if (subject.equalsIgnoreCase("SelectProducto")) {
            //params:
            SwingUtilities.invokeLater(() -> {
                MVPPresenter p = new ListaProductoPresenter(
                        new ListaProductoView((JFrame) SwingUtilities.getWindowAncestor((JDialog)view), true), 
                        new ListaProductoModel(new ProductoDao()), 
                        new Object[]{"SELECT"});
                Producto entid = (Producto) p.getResult()[0]; 
                if (entid != null){
                    view.updateView("CargaProducto", new Object[]{entid});
                }
            });
        }
        if (subject.equalsIgnoreCase("DatosProducto")) {
            //params: pk Cliente
            String pk = TypeUtil.toString(params[0]);   
            if (pk != null){
                try{
                    Producto entid = (Producto) model.loadModel("CargaProducto", new Object[]{pk})[0];
                    view.updateView("CargaProducto", new Object[]{entid});
                }catch(Exception e){
                    view.updateView("MsgBox", new Object[]{TypeUtil.breakLine(e.toString(), 100)});
                }
            }
        }
    }

    @Override
    public Object[] getResult() {
        return result;
    }
    
}
