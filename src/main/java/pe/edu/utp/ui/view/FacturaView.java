package pe.edu.utp.ui.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import pe.edu.utp.data.entity.CabFactura;
import pe.edu.utp.data.entity.CabGuiaRem;
import pe.edu.utp.data.entity.Cliente;
import pe.edu.utp.data.entity.DetFactura;
import pe.edu.utp.data.entity.Empresa;
import pe.edu.utp.data.entity.Producto;
import pe.edu.utp.ui.presenter.MVPPresenter;
import pe.edu.utp.service.FileService;
import pe.edu.utp.service.TypeService;

public class FacturaView extends javax.swing.JDialog implements MVPView {
    private MVPPresenter presenter;

    @Override
    public void showView() {
        setVisible(true);
        //jTextField1.selectAll();
        //jTextField1.requestFocus();
    }

    @Override
    public void hideView() {
        setVisible(false);
    }

    @Override
    public void closeView() {
        dispose();
    }

    @Override
    public void setPresenter(MVPPresenter presenter) {
        this.presenter = presenter;
    }
    
    @Override
    public Object[] updateView(String subject, Object[] params) {
        Object[] resultUpdateView = null;
        //params[]: Titulo, Tipo ventana(READ / INSE / UPDA / DELE), 
        //          CabFactura con Det
        if (subject.equalsIgnoreCase("Iniciar")) {
            this.setTitle((String) params[0]);
            if (((String)params[1]).equals("READ")){
                tfl0.setEditable(false);
                dtp0.setEnabled(false);
                tfl10.setEditable(false);
                tfl1.setEditable(false);
                tfl2.setEditable(false);
                tfl3.setEditable(false);
                tfl4.setEditable(false);
                tfl5.setEditable(false);
                tfl6.setEditable(false);
                tfl7.setEditable(false);
                tfl8.setEditable(false);
                tfl9.setEditable(false);
                btn1.setVisible(false);
                tbl0.setEnabled(false);
                this.CargaDatos(new Object[]{params[2]});
            }
            if (((String)params[1]).equals("INSERT")){
                tfl0.setEditable(true);
                dtp0.setEnabled(true);
                tfl10.setEditable(true);
                tfl1.setEditable(true);
                tfl2.setEditable(false);
                tfl3.setEditable(true);
                tfl4.setEditable(false);
                tfl5.setEditable(false);
                tfl6.setEditable(true);
                tfl7.setEditable(false);
                tfl8.setEditable(false);
                tfl9.setEditable(false);
                btn1.setVisible(true);
                tbl0.setEnabled(true);
            }
            if (((String)params[1]).equals("UPDATE")){
                tfl0.setEditable(false);
                dtp0.setEnabled(true);
                tfl10.setEditable(true);
                tfl1.setEditable(true);
                tfl2.setEditable(false);
                tfl3.setEditable(true);
                tfl4.setEditable(false);
                tfl5.setEditable(false);
                tfl6.setEditable(true);
                tfl7.setEditable(false);
                tfl8.setEditable(false);
                tfl9.setEditable(false);
                btn1.setVisible(true);
                tbl0.setEnabled(true);
                this.CargaDatos(new Object[]{params[2]});
            }
        }
        if (subject.equalsIgnoreCase("CargaCliente")) {
            //params: Cliente
            Cliente entid = (Cliente) params[0];
            if (entid != null){
                tfl3.setText(entid.getRucCliente());
                tfl4.setText(entid.getRazSocCliente());
                tfl5.setText(entid.getDirecCliente());
            }else{
                tfl4.setText("");
                tfl5.setText("");
            }
        }
        if (subject.equalsIgnoreCase("CargaEmpresa")) {
            //params: Empresa
            Empresa entid = (Empresa) params[0];
            if (entid != null){
                tfl1.setText(entid.getRucEmpresa());
                tfl2.setText(entid.getRazSocEmpresa());
            }else{
                tfl2.setText("");
            }
        }
        if (subject.equalsIgnoreCase("CargaGuiaRemision")) {
            //params: CabGuiaRem
            CabGuiaRem entid = (CabGuiaRem) params[0];
            if (entid != null){
                tfl10.setText(entid.getCodGuiaRem());
            }
        }
        if (subject.equalsIgnoreCase("CargaProducto")) {
            //params: Empresa
            Producto entid = (Producto) params[0];
            if (entid != null){
                DefaultTableModel dtm = (DefaultTableModel) tbl0.getModel();
                int cantF = dtm.getRowCount();
                dtm.setRowCount(cantF+1);
                tbl0.setValueAt(entid.getCodigoProd(), cantF, 0);
                tbl0.setValueAt(entid.getDescrProd(), cantF, 1);
                tbl0.setValueAt(entid.getPrecUnit(), cantF, 3);
                
            }
        }
        if (subject.equalsIgnoreCase("DltBox")) {
            //params[]: Mensaje
            String msg = (String) params[0];
            if ( msg.length() == 0 ) {
                msg = "¿Desea eliminar este registro?";
            }
            int r = JOptionPane.showConfirmDialog(null, msg, "Borrar",JOptionPane.YES_NO_OPTION);
            Boolean confirmado = (r==0);
            resultUpdateView = new Object[]{confirmado};
        }
        if (subject.equalsIgnoreCase("MsgBox")) {
            //params[]: Mensaje
            JOptionPane.showMessageDialog(null, params[0]);
        }
        return resultUpdateView;
    }

    private void CargaDatos(Object[] params){
        //params[]: CabFactura con Det
        CabFactura ent = (CabFactura) params[0];
        tfl0.setText(ent.getCodigoFac());
        dtp0.setDate(ent.getFechaEmi());
        tfl10.setText(ent.getCabGuiaRem().getCodGuiaRem());
        tfl1.setText(ent.getEmpresa().getRucEmpresa());
        tfl2.setText(ent.getEmpresa().getRazSocEmpresa());
        tfl3.setText(ent.getCliente().getRucCliente());
        tfl4.setText(ent.getCliente().getRazSocCliente());
        tfl5.setText(ent.getCliente().getDirecCliente());
        tfl6.setText(ent.getCajero());
        tfl7.setText(ent.getSubTotal().toString());
        tfl8.setText(ent.getIgv().toString());
        tfl9.setText(ent.getTotal().toString());
        DefaultTableModel tblModel = (DefaultTableModel) tbl0.getModel();
        tblModel.setRowCount(0);
        List<DetFactura> lista =  ent.getDetFactura();
        lista.stream().map((item) -> {
            Object[] objs = new Object[5];
            objs[0] = item.getProducto().getCodigoProd();
            objs[1] = item.getProducto().getDescrProd();
            objs[2] = item.getCantidad();
            objs[3] = item.getProducto().getPrecUnit();
            objs[4] = item.getValorVenta();
            return objs;
        }).forEachOrdered((objs) -> {
            tblModel.addRow(objs);
        });
    }
    
    private void sumaTotales(TableModel tm){
        Double val1=Double.valueOf("0.0");
        for (int x=0 ; x < tm.getRowCount() ; x++){
            val1 += TypeService.toDoubleZero(tbl0.getValueAt(x, 4)) ;
        }
        tfl7.setText(""+ TypeService.roundNormal(val1, 2));
        tfl8.setText(""+ TypeService.roundNormal(val1*0.18, 2));
        tfl9.setText(""+ TypeService.roundNormal(val1*1.18, 2));
    }
    
    public FacturaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                presenter.notifyPresenter("Cancelar", null);
            }
        });
        this.setIconImage(FileService.getImageAsIcon("ventas.png"));
        this.setLocationRelativeTo(null);
        //calcula suma
        tbl0.getModel().addTableModelListener((e) -> {
            TableModel tm = (TableModel) e.getSource();
            this.sumaTotales(tm);
        });
        //formatos a celdas de tabla
        DateTimeFormatter ldformat = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        for(int x=0 ; x < tbl0.getColumnModel().getColumnCount() ; x++){
            tbl0.getColumnModel().getColumn(x).setCellRenderer((TableCellRenderer) new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if( value instanceof LocalDate) {
                        value = ldformat.format((LocalDate)value);
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
                }
            });
        }
        //corregir Lgooddatepicker
        DatePickerSettings dps = new DatePickerSettings();
        dps.setFormatForDatesCommonEra("dd/MM/yyyy");
        dtp0.setSettings(dps);
        Dimension d = new Dimension(140, 20);
        dtp0.setSize(d);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfl0 = new javax.swing.JTextField();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfl6 = new javax.swing.JTextField();
        tfl7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl0 = new javax.swing.JTable();
        dtp0 = new com.github.lgooddatepicker.components.DatePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfl1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfl2 = new javax.swing.JTextField();
        btn21 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfl3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfl4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfl5 = new javax.swing.JTextField();
        btn22 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        tfl10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfl8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfl9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn20 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cod. Factura:");

        btn0.setText("Cancelar");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btn1.setText("Aceptar");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Emision:");

        jLabel8.setText("Cajero:");

        jLabel9.setText("SubTotal S/");

        tbl0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Descripcion Producto", "Cantidad", "PU", "Valor Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tbl0FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tbl0);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));

        jLabel2.setText("RUC:");

        tfl1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfl1FocusLost(evt);
            }
        });

        jLabel4.setText("Razon Social:");

        btn21.setText("...");
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn21)
                    .addComponent(jLabel4))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel6.setText("RUC:");

        tfl3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfl3FocusLost(evt);
            }
        });

        jLabel5.setText("Razon Social:");

        jLabel7.setText("Direcccion:");

        btn22.setText("...");
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfl3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfl4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfl5))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btn22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn10.setText("+");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn11.setText("-");
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        jLabel10.setText("Guia Remision:");

        jLabel11.setText("IGV S/");

        jLabel12.setText("Total S/");

        btn20.setText("...");
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(29, 29, 29)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dtp0, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfl10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn0)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfl6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfl9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfl8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfl7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dtp0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btn10)
                    .addComponent(btn11)
                    .addComponent(tfl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn0)
                    .addComponent(btn1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        //Cancelar
        presenter.notifyPresenter("Cancelar", null);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        //Aceptar
        //salir de edicion
        if (tbl0.isEditing()) {
            tbl0.getCellEditor().stopCellEditing();
        }
        TableModel tm = (TableModel) tbl0.getModel();
        this.sumaTotales(tm);
        
        CabFactura cgr = new CabFactura(tfl0.getText(), 
                dtp0.getDate(), 
                new CabGuiaRem(tfl10.getText(), null,null, null,null,null),
                new Empresa(tfl1.getText(), tfl2.getText()), 
                new Cliente(tfl3.getText(), tfl4.getText(), tfl5.getText()), 
                tfl6.getText(), 
                TypeService.toDoubleZero(tfl7.getText()),
                TypeService.toDoubleZero(tfl8.getText()),
                TypeService.toDoubleZero(tfl9.getText())
        );
        List<DetFactura> dgr = new ArrayList<>();
        for (int x=0 ; x < tbl0.getModel().getRowCount() ; x++){
            dgr.add(new DetFactura(cgr, 
                    new Producto(TypeService.toString(tbl0.getValueAt(x, 0)), TypeService.toString(tbl0.getValueAt(x, 1)), TypeService.toDoubleZero(tbl0.getValueAt(x, 3))),
                    TypeService.toIntegerZero(tbl0.getValueAt(x, 2)),
                    TypeService.toDoubleZero(tbl0.getValueAt(x, 4))
                )
            );
        }
        cgr.setDetFactura(dgr);
        presenter.notifyPresenter("Aceptar", new Object[]{ cgr });

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // +
        presenter.notifyPresenter("SelectProducto", null);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        // -
        if (tbl0.getModel().getRowCount()>0){
            if (tbl0.getSelectedRow() > 0){
                DefaultTableModel dtm = (DefaultTableModel) tbl0.getModel();
                dtm.removeRow(tbl0.getSelectedRow());
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione una fila valida");
            }
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void tbl0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl0FocusLost
        //salir de edicion cuando la tabla pierda el foco
        if (tbl0.isEditing()) {
            tbl0.getCellEditor().stopCellEditing();
        }
    }//GEN-LAST:event_tbl0FocusLost

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        presenter.notifyPresenter("SelectCliente", null);
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        presenter.notifyPresenter("SelectEmpresa", null);
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        presenter.notifyPresenter("SelectGuiaRemision", null);
    }//GEN-LAST:event_btn20ActionPerformed

    private void tfl3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfl3FocusLost
        presenter.notifyPresenter("DatosCliente", new Object[]{tfl3.getText()});
    }//GEN-LAST:event_tfl3FocusLost

    private void tfl1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfl1FocusLost
        presenter.notifyPresenter("DatosEmpresa", new Object[]{tfl1.getText()});
    }//GEN-LAST:event_tfl1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private com.github.lgooddatepicker.components.DatePicker dtp0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl0;
    private javax.swing.JTextField tfl0;
    private javax.swing.JTextField tfl1;
    private javax.swing.JTextField tfl10;
    private javax.swing.JTextField tfl2;
    private javax.swing.JTextField tfl3;
    private javax.swing.JTextField tfl4;
    private javax.swing.JTextField tfl5;
    private javax.swing.JTextField tfl6;
    private javax.swing.JTextField tfl7;
    private javax.swing.JTextField tfl8;
    private javax.swing.JTextField tfl9;
    // End of variables declaration//GEN-END:variables
}
