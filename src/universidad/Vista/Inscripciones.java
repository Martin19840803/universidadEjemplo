
package universidad.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidad.AccesoADatos.Conexion;
import static universidad.AccesoADatos.Conexion.conexionDB;
import universidad.Entidades.Alumno;

public class Inscripciones extends javax.swing.JInternalFrame {

    private Connection con = null;
    private DefaultTableModel modelo = new DefaultTableModel();
   
    public Inscripciones() {
    //    this.re = new RellenarCombos();
        initComponents();
        editarTabla();
        con = Conexion.conexionDB();
    //    LlenarCombos();
    //    re.RellenarCombos("alumno", "idAlumno" ,JComboBoxSeleccionarunAlumno);
        
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JRBMateriasInscriptas = new javax.swing.JRadioButton();
        JRBMateriasnoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFormularioInscripcion = new javax.swing.JTable();
        JBInscribir = new javax.swing.JButton();
        JBSalir = new javax.swing.JButton();
        JBAnularInscripcion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JComboBoxSeleccioneAlumno = new javax.swing.JComboBox<>();

        jMenu1.setText("jMenu1");

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setForeground(new java.awt.Color(153, 153, 153));
        setIconifiable(true);
        setMaximizable(true);
        setTitle("\tFormulario de Inscripcion");
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Formulario de Inscripciones");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione un Alumno");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Listado de materia");

        JRBMateriasInscriptas.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JRBMateriasInscriptas.setText("Materias Inscriptas");
        JRBMateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBMateriasInscriptasActionPerformed(evt);
            }
        });

        JRBMateriasnoInscriptas.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JRBMateriasnoInscriptas.setText("Materias no Inscriptas");
        JRBMateriasnoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBMateriasnoInscriptasActionPerformed(evt);
            }
        });

        TablaFormularioInscripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        TablaFormularioInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaFormularioInscripcion);

        JBInscribir.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBInscribir.setText("Inscribir");

        JBSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        JBAnularInscripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        JBAnularInscripcion.setText("Anular Inscripcion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JBInscribir)
                                .addGap(44, 44, 44)
                                .addComponent(JBAnularInscripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBSalir))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel2)
                                    .addGap(251, 251, 251))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JComboBoxSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JRBMateriasInscriptas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JRBMateriasnoInscriptas)))
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JComboBoxSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRBMateriasInscriptas)
                    .addComponent(JRBMateriasnoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBInscribir)
                    .addComponent(JBSalir)
                    .addComponent(JBAnularInscripcion))
                .addGap(47, 47, 47))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JRBMateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBMateriasInscriptasActionPerformed
        JRBMateriasInscriptas.setEnabled(false);
        JRBMateriasInscriptas.setEnabled(true);
    }//GEN-LAST:event_JRBMateriasInscriptasActionPerformed

    private void JRBMateriasnoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBMateriasnoInscriptasActionPerformed
        JRBMateriasnoInscriptas.setEnabled(false);
        JRBMateriasnoInscriptas.setEnabled(true);
    }//GEN-LAST:event_JRBMateriasnoInscriptasActionPerformed

    //COMBO BOX
   /* private void LlenarCombos() {
    Alumno alumno = new Alumno();
        String listadoAlumno = alumno.getApellido();

    JComboBoxSeleccioneAlumno.removeAllItems();
          for (int i = 0; i < listadoAlumno.size()(); int i = 0; 
i++) { 
        JComboBoxSeleccioneAlumno.addItem(listadoAlumno.get(i).getNombre());
    }
}
*/

    


    public class RellenarComboBox {
        public void RellenarComboBox(String tabla, String valor, JComboBox Combo) {
            String sql = "SELECT * from " + tabla;
            Statement st;
            //conexionDB con = new conexionDB();
            //Connection conexion = con.conexionDB();
            try {
                st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    // Aquí es donde llenas el JComboBox
                    Combo.addItem(rs.getString(valor));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
  
 
    } 
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAnularInscripcion;
    private javax.swing.JButton JBInscribir;
    private javax.swing.JButton JBSalir;
    private javax.swing.JComboBox<String> JComboBoxSeleccioneAlumno;
    private javax.swing.JRadioButton JRBMateriasInscriptas;
    private javax.swing.JRadioButton JRBMateriasnoInscriptas;
    private javax.swing.JTable TablaFormularioInscripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    
    private void editarTabla() {

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        TablaFormularioInscripcion.setModel(modelo);

    }

    
