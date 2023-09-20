
package universidad.Vista;

import javax.swing.JOptionPane;
import universidad.AccesoADatos.MateriaData;
import universidad.Entidades.Materia;


public class GestiondeMateria extends javax.swing.JInternalFrame {


    public GestiondeMateria() {
       initComponents();
       limpiarCampo();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JBBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JBNuevo = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBGuardar = new javax.swing.JButton();
        JBSalir = new javax.swing.JButton();
        JTextFieldCodigo = new javax.swing.JTextField();
        JTextFieldNombre = new javax.swing.JTextField();
        JTextFieldAño = new javax.swing.JTextField();
        JRBEstado = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("\tMateria");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        JBBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBBuscar.setText("Buscar");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Materia");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Año");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado");

        JBNuevo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBNuevo.setText("Nuevo");
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        JBEliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });

        JBGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBGuardar.setText("Guardar");
        JBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarActionPerformed(evt);
            }
        });

        JBSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        JTextFieldCodigo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        JTextFieldNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        JTextFieldAño.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        JRBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(JRBEstado))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(JBNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTextFieldNombre)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                            .addComponent(JBBuscar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBBuscar)
                    .addComponent(jLabel2)
                    .addComponent(JTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JRBEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNuevo)
                    .addComponent(JBEliminar)
                    .addComponent(JBGuardar)
                    .addComponent(JBSalir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

                        //BOTON SALIR
    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_JBSalirActionPerformed

    
                        //BOTON ESTADO
    private void JRBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBEstadoActionPerformed
    JRBEstado.setEnabled(false);
    JRBEstado.setEnabled(true);
    }//GEN-LAST:event_JRBEstadoActionPerformed

    
                        //BOTON GUARDAR
    private void JBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarActionPerformed
        String nombre = JTextFieldNombre.getText();
        int anio = Integer.parseInt(JTextFieldAño.getText());
        Boolean estado = JRBEstado.isSelected();
        Materia materia = new Materia(nombre, anio, estado);
        MateriaData materiaData = new MateriaData();
        materiaData.guardarMateria(materia);
        limpiarCampo();
    }//GEN-LAST:event_JBGuardarActionPerformed

                       //BOTON ELIMINAR
    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        try{
        String codigo1 = JTextFieldCodigo.getText();
        if(!(codigo1.equals(""))){
        int codigo = Integer.parseInt(codigo1);
        MateriaData materiaData = new MateriaData();
        materiaData.eliminarMateria(codigo);
        limpiarCampo();
        }else{
        JOptionPane.showMessageDialog(this, "Ingrear un numero");
        }
        }catch(NumberFormatException fe){
        JOptionPane.showMessageDialog(this,"Ingrese solo numeros");
        
        }
        
    }//GEN-LAST:event_JBEliminarActionPerformed
                    //BOTON NUEVO
    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        limpiarCampo();
        
        
    }//GEN-LAST:event_JBNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBGuardar;
    private javax.swing.JButton JBNuevo;
    private javax.swing.JButton JBSalir;
    private javax.swing.JRadioButton JRBEstado;
    private javax.swing.JTextField JTextFieldAño;
    private javax.swing.JTextField JTextFieldCodigo;
    private javax.swing.JTextField JTextFieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
private void limpiarCampo(){
JTextFieldAño.setText("");
JTextFieldCodigo.setText("");
JTextFieldNombre.setText("");
JRBEstado.setSelected(false);
}

}
