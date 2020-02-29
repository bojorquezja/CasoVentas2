package pe.edu.utp.ui.view;

import javax.swing.JOptionPane;
import pe.edu.utp.data.entity.Producto;
import pe.edu.utp.ui.presenter.MVPPresenter;
import pe.edu.utp.service.FileService;
import pe.edu.utp.service.TypeService;

public class ProductoView extends javax.swing.JDialog implements MVPView {
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
        //          Producto 
        if (subject.equalsIgnoreCase("Iniciar")) {
            this.setTitle((String) params[0]);
            if (((String)params[1]).equals("READ")){
                tfl0.setEditable(false);
                tfl1.setEditable(false);
                tfl2.setEditable(false);
                btn1.setVisible(false);
                this.CargaDatos(new Object[]{params[2]});
            }
            if (((String)params[1]).equals("INSERT")){
                tfl0.setEditable(true);
                tfl1.setEditable(true);
                tfl2.setEditable(true);
                btn1.setVisible(true);
            }
            if (((String)params[1]).equals("UPDATE")){
                tfl0.setEditable(false);
                tfl1.setEditable(true);
                tfl2.setEditable(true);
                btn1.setVisible(true);
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
        //params[]: Producto
        Producto ent = (Producto) params[0];
        tfl0.setText(ent.getCodigoProd());
        tfl1.setText(ent.getDescrProd());
        tfl2.setText(ent.getPrecUnit().toString());
    }
    
    
    public ProductoView(java.awt.Frame parent, boolean modal) {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfl0 = new javax.swing.JTextField();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfl1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfl2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo:");

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

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Precio Unit. S/:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn0))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfl1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfl0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(tfl2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfl0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn0)
                    .addComponent(btn1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        //Cancelar
        presenter.notifyPresenter("Cancelar", null);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        //Aceptar
        Producto cgr = new Producto(tfl0.getText(), 
                tfl1.getText(),
                TypeService.toDoubleZero(tfl2.getText())
        );
        presenter.notifyPresenter("Aceptar", new Object[]{ cgr });
    }//GEN-LAST:event_btn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfl0;
    private javax.swing.JTextField tfl1;
    private javax.swing.JTextField tfl2;
    // End of variables declaration//GEN-END:variables
}
