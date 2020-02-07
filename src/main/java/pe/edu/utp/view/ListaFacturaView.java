package pe.edu.utp.view;

import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import pe.edu.utp.entity.CabFactura;
import pe.edu.utp.presenter.MVPPresenter;
import pe.edu.utp.util.TypesUtil;

public class ListaFacturaView extends javax.swing.JDialog implements MVPView {
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
        //params[]: Titulo, Tipo ventana(SELE / MAIN)
        if (subject.equalsIgnoreCase("Iniciar")) {
            this.setTitle((String) params[0]);
            if (((String)params[1]).equalsIgnoreCase("SELECT")){
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(false);
                btn5.setVisible(true);
            }
            if (((String)params[1]).equalsIgnoreCase("MAINTENANCE")){
                btn1.setVisible(true);
                btn2.setVisible(true);
                btn3.setVisible(true);
                btn5.setVisible(false);
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
        if (subject.equalsIgnoreCase("CargarDatos")) {
            //params[]: lista
            this.CargaDatos(params);
        }
        if (subject.equalsIgnoreCase("Refrescar")) {
            //params[]: 
            presenter.notifyPresenter("Buscar", new Object[]{tfl0.getText(), tfl1.getText()});
        }
        return resultUpdateView;
    }

    private void CargaDatos(Object[] params){
        //params[]: lista
        DefaultTableModel tblModel = (DefaultTableModel) tbl1.getModel();
        tblModel.setRowCount(0);
        List<CabFactura> lista = (List<CabFactura>) params[0];
        DoubleAdder da = new DoubleAdder();
        lista.stream().map((item) -> {
            Object[] objs = new Object[7];
            objs[0] = item.getCodigoFac();
            objs[1] = item.getRucEmpresa() + "-" + item.getRazSocEmpresa();
            objs[2] = item.getRucCliente() + "-" + item.getRazSocCliente();
            objs[3] = item.getCodGuiaRem();
            objs[4] = item.getFechaEmi();
            objs[5] = item.getTotal();
            objs[6] = item.getCajero();
            da.add(item.getTotal());
            return objs;
        }).forEachOrdered((objs) -> {
            tblModel.addRow(objs);
        });
        tfl2.setText("" + TypesUtil.roundNormal(da.sum(), 2) );
    }
    
    public ListaFacturaView(java.awt.Frame parent, boolean modal) {
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
        for(int x=0 ; x < tbl1.getColumnModel().getColumnCount() ; x++){
            tbl1.getColumnModel().getColumn(x).setCellRenderer((TableCellRenderer) new DefaultTableCellRenderer() {

                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if( value instanceof LocalDate) {
                        value = ldformat.format((LocalDate)value);
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn0 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfl0 = new javax.swing.JTextField();
        tfl1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        tfl2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn0.setText("Buscar");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo FAC", "Empresa", "Cliente", "Guia", "Fecha", "Total", "Cajero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jLabel1.setText("Codigo FAC:");

        jLabel2.setText("Cliente:");

        btn1.setText("Agregar");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("Editar");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText("Borrar");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText("Cerrar");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setText("Seleccionar");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        tfl2.setEditable(false);

        jLabel3.setText("Suma Total S/:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn0))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn0)
                    .addComponent(jLabel1)
                    .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4)
                    .addComponent(btn5)
                    .addComponent(jLabel3)
                    .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        //Buscar
        presenter.notifyPresenter("Buscar", new Object[]{tfl0.getText(), tfl1.getText()});
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        //Agregar
        presenter.notifyPresenter("Agregar", null);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        //Editar
        int fila = tbl1.getSelectedRow();
        if ( fila >= 0 ){
            presenter.notifyPresenter("Editar", new Object[]{tfl0.getText(), tfl1.getText(), tbl1.getModel().getValueAt(fila, 0)});
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione fila valida");
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        //Borrar
        int fila = tbl1.getSelectedRow();
        if ( fila >= 0 ){
            presenter.notifyPresenter("Borrar", new Object[]{tfl0.getText(), tfl1.getText(), tbl1.getModel().getValueAt(fila, 0)});
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione fila valida");
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        //Cerrar
        presenter.notifyPresenter("Cancelar", null);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        //Seleccionar
        int fila = tbl1.getSelectedRow();
        if ( fila >= 0 ){
            presenter.notifyPresenter("Seleccionar", new Object[]{ tbl1.getModel().getValueAt(fila, 0)});
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione fila valida");
        }
    }//GEN-LAST:event_btn5ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField tfl0;
    private javax.swing.JTextField tfl1;
    private javax.swing.JTextField tfl2;
    // End of variables declaration//GEN-END:variables
}
