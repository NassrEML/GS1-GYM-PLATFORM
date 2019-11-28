package view;

import control.DDBBConection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

public class ViewCreateExercise extends javax.swing.JFrame {

    private User userLogged;
    
    public ViewCreateExercise(User userLogged) {
        this.userLogged = userLogged;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createExerciseLabel = new javax.swing.JLabel();
        createExerciseButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        categoryLabel = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        createExerciseLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        createExerciseLabel.setText("Crear Ejercicio");

        createExerciseButton.setText("Crear Ejercicio");
        createExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createExerciseButtonActionPerformed(evt);
            }
        });

        titleLabel.setText("Título(*)");

        descriptionLabel.setText("Descripción(*)");

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Categoria", "Fuerza", "Hipertrofia", "Extensión" }));

        categoryLabel.setText("Categoria(*)");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        warning.setForeground(new java.awt.Color(255, 0, 51));
        warning.setText("(*)Campos obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createExerciseButton)
                        .addGap(18, 18, 18)
                        .addComponent(warning))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(categoryLabel)
                            .addComponent(titleLabel)
                            .addComponent(descriptionLabel))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(title)
                            .addComponent(category, 0, 122, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(createExerciseLabel)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createExerciseLabel)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(categoryLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createExerciseButton)
                    .addComponent(warning))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createExerciseButtonActionPerformed
        if(title.getText().isEmpty() || description.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aún hay campos por rellenar", "Error, faltan fatos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        try {
            DDBBConection.addExercise(title.getText(), description.getText(), (String)category.getSelectedItem(), userLogged.getMail());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido un error.", "Error al crear ejercicio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Se ha creado el ejercicio correctamente.", "Crear Ejercicio", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_createExerciseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton createExerciseButton;
    private javax.swing.JLabel createExerciseLabel;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField title;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
