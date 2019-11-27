package view;

import control.DDBBConection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.User;

public class Library extends javax.swing.JFrame {

    private final DefaultListModel model;
    private User userLogged;

    public Library(User userLogged) throws SQLException {
        initComponents();
        this.userLogged = userLogged;
        if(userLogged.getRol().equals("Deportista")) createExerciseButton.setVisible(false);
        model = new DefaultListModel();
        exerciseList.setModel(model);
        exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        excerciseDescriptionArea.setEditable(false);
        excerciseDescriptionArea.setWrapStyleWord(true);
        loadList();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        exerciseList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        exercisePanel = new javax.swing.JPanel();
        exerciseTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        excerciseDescriptionArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        exerciseCategoryLabel = new javax.swing.JLabel();
        createExerciseButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        exerciseList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                exerciseListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(exerciseList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Biblioteca de ejercicios");

        exerciseTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exerciseTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        excerciseDescriptionArea.setColumns(20);
        excerciseDescriptionArea.setLineWrap(true);
        excerciseDescriptionArea.setRows(5);
        jScrollPane2.setViewportView(excerciseDescriptionArea);

        jLabel2.setText("Categoría: ");

        javax.swing.GroupLayout exercisePanelLayout = new javax.swing.GroupLayout(exercisePanel);
        exercisePanel.setLayout(exercisePanelLayout);
        exercisePanelLayout.setHorizontalGroup(
            exercisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(exercisePanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exerciseCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exercisePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exerciseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        exercisePanelLayout.setVerticalGroup(
            exercisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exercisePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exerciseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(exercisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(exerciseCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        createExerciseButton.setText("Crear Ejercicio");
        createExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createExerciseButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refrescar Lista");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createExerciseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exercisePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(exercisePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createExerciseButton)
                    .addComponent(refreshButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exerciseListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_exerciseListValueChanged
        try {
            setExerciseInToPanel(exerciseList.getSelectedValue());
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exerciseListValueChanged

    private void createExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createExerciseButtonActionPerformed
        ViewCreateExercise vce = new ViewCreateExercise(userLogged);
        vce.setVisible(true);
    }//GEN-LAST:event_createExerciseButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            model.clear();
            loadList();
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void closeWindow() {
        int exitValue = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir de la aplicación?.", "Salir",
                JOptionPane.YES_NO_OPTION);
        if (exitValue == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createExerciseButton;
    private javax.swing.JTextArea excerciseDescriptionArea;
    private javax.swing.JLabel exerciseCategoryLabel;
    private javax.swing.JList<String> exerciseList;
    private javax.swing.JPanel exercisePanel;
    private javax.swing.JLabel exerciseTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables

    private void loadList() throws SQLException {
        Statement stmt = DDBBConection.con.createStatement();
        String sql = "SELECT * FROM Exercise";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String value = rs.getString("Title");
            model.addElement(value);
        }
        repaint();
    }

    private void setExerciseInToPanel(String title) throws SQLException {
        Statement stmt = DDBBConection.con.createStatement();
        String sql = "SELECT * FROM Exercise WHERE Title='" + title + "'";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            exerciseTitle.setText(rs.getString("Title"));
            excerciseDescriptionArea.setText(rs.getString("Description"));
            exerciseCategoryLabel.setText(rs.getString("Category"));
        }
        repaint();
    }
}
