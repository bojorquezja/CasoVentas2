package pe.edu.utp.ui.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pe.edu.utp.ui.presenter.MVPPresenter;
import pe.edu.utp.service.FileService;

public class PrincipalView extends javax.swing.JFrame implements MVPView{
    private MVPPresenter presenter;
    
    @Override
    public void showView() {
        setVisible(true);
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
            //params[]: Titulo
            this.setTitle((String) params[0]);
        }
        if (subject.equalsIgnoreCase("MsgBox")) {
            //params[]: Mensaje
            JOptionPane.showMessageDialog(null, params[0]);
        }
        return resultUpdateView;
    }
    
    public PrincipalView() {
        initComponents();
        this.setIconImage(FileService.getImageAsIcon("ventas.png"));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        meb1 = new javax.swing.JMenu();
        mei1_0 = new javax.swing.JMenuItem();
        mei1_1 = new javax.swing.JMenuItem();
        mei1_2 = new javax.swing.JMenuItem();
        mei1_3 = new javax.swing.JMenuItem();
        mei1_4 = new javax.swing.JMenuItem();
        meb2 = new javax.swing.JMenu();
        mei2_0 = new javax.swing.JMenuItem();
        mei2_1 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Ventas");

        meb1.setText("Mantenimiento");
        meb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meb1ActionPerformed(evt);
            }
        });

        mei1_0.setText("Clientes");
        mei1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei1_0ActionPerformed(evt);
            }
        });
        meb1.add(mei1_0);

        mei1_1.setText("Productos");
        mei1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei1_1ActionPerformed(evt);
            }
        });
        meb1.add(mei1_1);

        mei1_2.setText("Empresas");
        mei1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei1_2ActionPerformed(evt);
            }
        });
        meb1.add(mei1_2);

        mei1_3.setText("Configuracion");
        mei1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei1_3ActionPerformed(evt);
            }
        });
        meb1.add(mei1_3);

        mei1_4.setText("Descarga SQLs");
        mei1_4.setToolTipText("");
        mei1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei1_4ActionPerformed(evt);
            }
        });
        meb1.add(mei1_4);

        jMenuBar1.add(meb1);

        meb2.setText("Ventas");
        meb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meb2ActionPerformed(evt);
            }
        });

        mei2_0.setText("Guia Remision");
        mei2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei2_0ActionPerformed(evt);
            }
        });
        meb2.add(mei2_0);

        mei2_1.setText("Factura");
        mei2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mei2_1ActionPerformed(evt);
            }
        });
        meb2.add(mei2_1);

        jMenuBar1.add(meb2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mei2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei2_0ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"MantGuiaRemision"});
    }//GEN-LAST:event_mei2_0ActionPerformed

    private void mei2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei2_1ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"MantFactura"});
    }//GEN-LAST:event_mei2_1ActionPerformed

    private void meb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meb2ActionPerformed

    private void mei1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei1_3ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"Configuracion"});
    }//GEN-LAST:event_mei1_3ActionPerformed

    private void meb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meb1ActionPerformed
        
    }//GEN-LAST:event_meb1ActionPerformed

    private void mei1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei1_4ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"Descarga SQL"});
    }//GEN-LAST:event_mei1_4ActionPerformed

    private void mei1_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei1_0ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"MantClientes"});
    }//GEN-LAST:event_mei1_0ActionPerformed

    private void mei1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei1_1ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"MantProductos"});
    }//GEN-LAST:event_mei1_1ActionPerformed

    private void mei1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mei1_2ActionPerformed
        presenter.notifyPresenter("Menu", new Object[]{"MantEmpresas"});
    }//GEN-LAST:event_mei1_2ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu meb1;
    private javax.swing.JMenu meb2;
    private javax.swing.JMenuItem mei1_0;
    private javax.swing.JMenuItem mei1_1;
    private javax.swing.JMenuItem mei1_2;
    private javax.swing.JMenuItem mei1_3;
    private javax.swing.JMenuItem mei1_4;
    private javax.swing.JMenuItem mei2_0;
    private javax.swing.JMenuItem mei2_1;
    // End of variables declaration//GEN-END:variables

    
}
