package pe.edu.utp.view;

import javax.swing.JOptionPane;
import pe.edu.utp.presenter.MVPPresenter;
import pe.edu.utp.util.DocumentListenerUtil;

public class ConfiguracionView extends javax.swing.JDialog implements MVPView {
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
        if (subject.equalsIgnoreCase("Iniciar")) {
            //params[]: Titulo, String[] valores
            this.setTitle((String) params[0]);
            String[] valores = (String[]) params[1];
            this.CargaDatos(valores);
        }
        if (subject.equalsIgnoreCase("Reset")) {
            //params[]: String[] 
            this.CargaDatos(params);
        }
        if (subject.equalsIgnoreCase("CambioConexion")) {
            //params[]: String conex
            String val = (String) params[0];
            tfl5.setText(val);
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
        //params[]: String[] val
        String[] val = (String[]) params;
        tfl0.setText(val[0]);
        tfl1.setText(val[1]);
        tfl2.setText(val[2]);
        tfl3.setText(val[3]);
        tfl5.setText(val[4]);
        tfl4.setText(val[5]);
        pfl0.setText(val[6]);
        
    }
    
    
    public ConfiguracionView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                presenter.notifyPresenter("Cancelar", null);
            }
        });
        this.setLocationRelativeTo(null);
        //value change event
        tfl0.getDocument().addDocumentListener((DocumentListenerUtil) e -> enviaUpdateConexion());
        tfl1.getDocument().addDocumentListener((DocumentListenerUtil) e -> enviaUpdateConexion());
        tfl2.getDocument().addDocumentListener((DocumentListenerUtil) e -> enviaUpdateConexion());
        tfl3.getDocument().addDocumentListener((DocumentListenerUtil) e -> enviaUpdateConexion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfl0 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfl1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfl3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfl2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfl4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfl5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pfl0 = new javax.swing.JPasswordField();
        btn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Base de Datos"));

        jLabel6.setText("Servidor:");

        tfl0.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfl0PropertyChange(evt);
            }
        });

        jLabel5.setText("Puerto:");

        tfl1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfl1PropertyChange(evt);
            }
        });

        jLabel7.setText("Parametros:");

        tfl3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfl3PropertyChange(evt);
            }
        });

        jLabel8.setText("Nombre BD:");

        tfl2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfl2PropertyChange(evt);
            }
        });

        jLabel9.setText("Usuario:");

        jLabel10.setText("Conexion:");

        tfl5.setEditable(false);
        tfl5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel11.setText("Contraseña:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfl3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfl4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pfl0, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(tfl5)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(pfl0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        btn2.setText("Configuracion por defecto");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn0))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn0)
                    .addComponent(btn1)
                    .addComponent(btn2))
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
        String[] valores = {tfl0.getText(), tfl1.getText(), tfl2.getText(), 
                tfl3.getText(), tfl5.getText(), tfl4.getText(), 
                new String(pfl0.getPassword())
                };
        
        presenter.notifyPresenter("Aceptar", valores);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        presenter.notifyPresenter("Reset", null);
    }//GEN-LAST:event_btn2ActionPerformed

    private void tfl0PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfl0PropertyChange
        
    }//GEN-LAST:event_tfl0PropertyChange

    private void tfl1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfl1PropertyChange
        
    }//GEN-LAST:event_tfl1PropertyChange

    private void tfl2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfl2PropertyChange
        
    }//GEN-LAST:event_tfl2PropertyChange

    private void tfl3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfl3PropertyChange
        
    }//GEN-LAST:event_tfl3PropertyChange

    private void enviaUpdateConexion(){
        String[] valores = {tfl0.getText(), tfl1.getText(), tfl2.getText(), 
                tfl3.getText()
                };
        if (presenter!=null){
            presenter.notifyPresenter("CambioConexion", valores);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pfl0;
    private javax.swing.JTextField tfl0;
    private javax.swing.JTextField tfl1;
    private javax.swing.JTextField tfl2;
    private javax.swing.JTextField tfl3;
    private javax.swing.JTextField tfl4;
    private javax.swing.JTextField tfl5;
    // End of variables declaration//GEN-END:variables
}
