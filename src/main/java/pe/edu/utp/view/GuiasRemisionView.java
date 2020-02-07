package pe.edu.utp.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.toddfast.util.convert.TypeConverter;
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
import pe.edu.utp.entity.CabGuiaRem;
import pe.edu.utp.entity.DetGuiaRem;
import pe.edu.utp.presenter.MVPPresenter;

public class GuiasRemisionView extends javax.swing.JDialog implements MVPView {
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
        //          CabGuiaRem con Det
        if (subject.equalsIgnoreCase("Iniciar")) {
            this.setTitle((String) params[0]);
            if (((String)params[1]).equals("READ")){
                tfl0.setEditable(false);
                dtp0.setEnabled(false);
                tfl1.setEditable(false);
                tfl2.setEditable(false);
                tfl3.setEditable(false);
                tfl4.setEditable(false);
                tfl5.setEditable(false);
                tfl6.setEditable(false);
                tfl7.setEditable(false);
                btn1.setVisible(false);
                tbl0.setEnabled(false);
                this.CargaDatos(new Object[]{params[2]});
            }
            if (((String)params[1]).equals("INSERT")){
                tfl0.setEditable(true);
                dtp0.setEnabled(true);
                tfl1.setEditable(true);
                tfl2.setEditable(true);
                tfl3.setEditable(true);
                tfl4.setEditable(true);
                tfl5.setEditable(true);
                tfl6.setEditable(true);
                tfl7.setEditable(true);
                btn1.setVisible(true);
                tbl0.setEnabled(true);
            }
            if (((String)params[1]).equals("UPDATE")){
                tfl0.setEditable(false);
                dtp0.setEnabled(true);
                tfl1.setEditable(true);
                tfl2.setEditable(true);
                tfl3.setEditable(true);
                tfl4.setEditable(true);
                tfl5.setEditable(true);
                tfl6.setEditable(true);
                tfl7.setEditable(true);
                btn1.setVisible(true);
                tbl0.setEnabled(true);
                this.CargaDatos(new Object[]{params[2]});
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
        //params[]: CabGuiaRem con Det
        CabGuiaRem ent = (CabGuiaRem) params[0];
        tfl0.setText(ent.getCodGuiaRem());
        dtp0.setDate(ent.getFechaEmi());
        tfl1.setText(ent.getRucEmpresa());
        tfl2.setText(ent.getRazSocEmpresa());
        tfl3.setText(ent.getRucCliente());
        tfl4.setText(ent.getRazSocCliente());
        tfl5.setText(ent.getDirecCliente());
        tfl6.setText(ent.getAlmacenero());
        tfl7.setText(ent.getBultos().toString());
        DefaultTableModel tblModel = (DefaultTableModel) tbl0.getModel();
        tblModel.setRowCount(0);
        List<DetGuiaRem> lista =  ent.getDetGuiaRem();
        lista.stream().map((item) -> {
            Object[] objs = new Object[3];
            objs[0] = item.getCodigoProd();
            objs[1] = item.getDescrProd();
            objs[2] = item.getCantidad();
            return objs;
        }).forEachOrdered((objs) -> {
            tblModel.addRow(objs);
        });
    }
    
    
    public GuiasRemisionView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                presenter.notifyPresenter("Cancelar", null);
            }
        });
        this.setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfl3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfl4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfl5 = new javax.swing.JTextField();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo GR:");

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

        jLabel8.setText("Almacenero:");

        jLabel9.setText("Bultos:");

        tbl0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Descripcion Producto", "Cantidad"
            }
        ));
        tbl0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tbl0FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tbl0);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));

        jLabel2.setText("RUC:");

        jLabel4.setText("Razon Social:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel6.setText("RUC:");

        jLabel5.setText("Razon Social:");

        jLabel7.setText("Direcccion:");

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
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfl4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfl5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn0))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfl7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(jLabel8)
                            .addGap(147, 147, 147)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfl6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtp0, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btn10)
                    .addComponent(btn11))
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
        if (tbl0.isEditing()) {
            tbl0.getCellEditor().stopCellEditing();
        }
        List<DetGuiaRem> dgr = new ArrayList<>();
        for (int x=0 ; x < tbl0.getModel().getRowCount() ; x++){
            Integer val;
            try{
                val = TypeConverter.convert(Integer.class, tbl0.getValueAt(x, 2));
            }catch(Exception e){
                val = 0;
            }
            dgr.add(new DetGuiaRem(tfl0.getText(), 
                    (String) tbl0.getValueAt(x, 0), 
                    (String) tbl0.getValueAt(x, 1), 
                    val
                )
            );
        }
        if (tfl7.getText().isEmpty()){
            tfl7.setText("0");
        }
        CabGuiaRem cgr = new CabGuiaRem(tfl0.getText(), 
                dtp0.getDate(), 
                tfl1.getText(), 
                tfl2.getText(), 
                tfl3.getText(), 
                tfl4.getText(), 
                tfl5.getText(), 
                tfl6.getText(), 
                Integer.valueOf(tfl7.getText()) 
        );
        cgr.setDetGuiaRem(dgr);
        presenter.notifyPresenter("Aceptar", new Object[]{ cgr });
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // +
        DefaultTableModel dtm = (DefaultTableModel) tbl0.getModel();
        dtm.setRowCount(dtm.getRowCount()+1);
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
        if (tbl0.isEditing()) {
            tbl0.getCellEditor().stopCellEditing();
        }
    }//GEN-LAST:event_tbl0FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private com.github.lgooddatepicker.components.DatePicker dtp0;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField tfl2;
    private javax.swing.JTextField tfl3;
    private javax.swing.JTextField tfl4;
    private javax.swing.JTextField tfl5;
    private javax.swing.JTextField tfl6;
    private javax.swing.JTextField tfl7;
    // End of variables declaration//GEN-END:variables
}
