/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author nassr
 */
public class Library extends javax.swing.JFrame {

    /**
     * Creates new form Library
     */
    private final DefaultListModel model;

    public Library() throws SQLException {
        initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGroup(exercisePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(exerciseCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exercisePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(exercisePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Library().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea excerciseDescriptionArea;
    private javax.swing.JLabel exerciseCategoryLabel;
    private javax.swing.JList<String> exerciseList;
    private javax.swing.JPanel exercisePanel;
    private javax.swing.JLabel exerciseTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
