package view;

import control.DDBBConection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.User;

public class mainView extends javax.swing.JFrame {

    private User userLogged;
    private DDBBConection dbconn;

    public mainView(User userLogged, DDBBConection dbconn) {
        this.userLogged = userLogged;
        this.dbconn = dbconn;
        this.setResizable(false);
        initComponents();
        
        imagen im = new imagen(panelImagen, this.userLogged);
        panelImagen.add(im).repaint();
        
        
        usernameLabel.setText(this.userLogged.getName() + " " + this.userLogged.getLastname());
        userRolLabel.setText(this.userLogged.getRol());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        if (!userLogged.getRol().equals("Administrador")) {
            categoriesButton.setVisible(false);
        }
        if (!userLogged.getRol().equals("Administrador") && !userLogged.getRol().equals("Entrenador")) {
            membersButton.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminPanel = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        libraryButton = new javax.swing.JButton();
        membersButton = new javax.swing.JButton();
        categoriesButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userRolLabel = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profileButton.setText("Mi perfil");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        libraryButton.setText("Biblioteca");
        libraryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryButtonActionPerformed(evt);
            }
        });

        membersButton.setText("Miembros");
        membersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersButtonActionPerformed(evt);
            }
        });

        categoriesButton.setText("Categorias");

        logoutButton.setText("Cerrar sesión");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario: ");

        jLabel2.setText("Rol:");

        panelImagen.setPreferredSize(new java.awt.Dimension(128, 128));

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(membersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(categoriesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(libraryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(userRolLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(userRolLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(profileButton)
                            .addComponent(libraryButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(membersButton)
                            .addComponent(categoriesButton)))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed

        
        try {
            VistaAdminVerPerfilUsuario viewPerfil = new VistaAdminVerPerfilUsuario((this.userLogged.getName()+" "+this.userLogged.getLastname()), 
                                                                                        this.profileButton, 
                                                                                            "");
            viewPerfil.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        closeSesion();

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void membersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersButtonActionPerformed
        if (userLogged.getRol().equals("Administrador")) {
            VistaAdminVerUsuarios viewUsers = new VistaAdminVerUsuarios();
            viewUsers.setVisible(true);
        }
    }//GEN-LAST:event_membersButtonActionPerformed

    private void libraryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryButtonActionPerformed
        Library library;
        try {
            library = new Library(userLogged);
            library.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_libraryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton categoriesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton libraryButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton membersButton;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel userRolLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    private void closeWindow() {
        int exitValue = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir de la aplicación?.", "Salir",
                JOptionPane.YES_NO_OPTION);
        if (exitValue == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void closeSesion() {
        int exitValue = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea cerrar la sesión?.", "Salir",
                JOptionPane.YES_NO_OPTION);
        if (exitValue == JOptionPane.YES_OPTION) {
            this.dbconn.closeConnection();
            userLogged = null;
            this.dispose();
            new login().setVisible(true);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}
