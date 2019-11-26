package view;

import control.*;
import model.*;
import view.VistaAdminVerPerfilUsuario;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author yusef
 */
public class VistaAdminVerUsuarios extends javax.swing.JFrame {

    private final DefaultListModel userModel = new DefaultListModel();
    private List<User> users = new ArrayList<>();
    private final DatabaseMetaData md = DDBBConection.dbmd;
    private String mailOfUserSelected;

    public VistaAdminVerUsuarios() {
        initComponents();
        this.setResizable(false);
        this.allUsersList.setModel(userModel);
        showUsers();

    }

    /**
     * Mostrar los usuarios en la lista al abrir la interfaz
     */
    private void showUsers() {
        userModel.clear();

        //String nombreTabla = "User";
        //ResultSet rs1;
        try {
            Statement stmt = DDBBConection.con.createStatement();
            String sql = "SELECT Name, Lastname, Mail FROM User";
            ResultSet rs = stmt.executeQuery(sql);

            //rs1 = md.getColumns(null, null, nombreTabla, null);

            while (rs.next()) {
                String nombreCampo = rs.getString("Name") + " " + rs.getString("Lastname");
                this.
                userModel.addElement(nombreCampo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VistaAdminVerUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allUsersList = new javax.swing.JList();
        showPerfilButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Usuarios");

        jScrollPane1.setViewportView(allUsersList);

        showPerfilButton.setText("Ver Perfil");
        showPerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPerfilButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Borrar");

        jButton2.setText("Crear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showPerfilButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showPerfilButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(81, 81, 81))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPerfilButtonActionPerformed

        this.showPerfilButton.setEnabled(false);

        if (allUsersList.getSelectedIndices().length == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione un usuario", "",
                    JOptionPane.INFORMATION_MESSAGE);
            this.showPerfilButton.setEnabled(true);
            return;
        }
        
        VistaAdminVerPerfilUsuario vistaPerfil = new VistaAdminVerPerfilUsuario((String)allUsersList.getSelectedValue());
        vistaPerfil.setVisible(true);
        //this.setVisible(false);


    }//GEN-LAST:event_showPerfilButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList allUsersList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showPerfilButton;
    // End of variables declaration//GEN-END:variables
}
