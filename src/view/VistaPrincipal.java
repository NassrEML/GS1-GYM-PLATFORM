package view;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaPrincipal extends javax.swing.JFrame {

    private Connection con;
    private DatabaseMetaData dbmd;
    
    public VistaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void conectar() {
        String servidorSQLitePrueba = "jdbc:sqlite:Base de datos GS1.db";
        
        try {
            //Descomentar
            /*Connection con = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + bbdd + "?useSSL=true",
                    usuarioPrueba,
                    contraseñaPrueba);*/
            //Comentar
            con = DriverManager.getConnection(servidorSQLitePrueba);
            dbmd = con.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<String> obtenerTablas() {
        List<String> tablas = new ArrayList<>();
        try {
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, "%", types);
            while (rs.next()) {
                String nombreTabla = rs.getString("TABLE_NAME");
                //System.out.println("Tabla: " + nombreTabla);
                tablas.add(nombreTabla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablas;
    }

    public List<String> obtenerCampos(String tabla) {
        List<String> columnas = new ArrayList<>();
        try {
            ResultSet rs = dbmd.getColumns(null, null, tabla, null);
            while (rs.next()) {
                String nombreCampo = rs.getString("COLUMN_NAME");
                //System.out.println("   Campo: " + nombreCampo);
                columnas.add(tabla + "." + nombreCampo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnas;
    }
    
    public void cerrarConexion() {
        if(con != null) try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarPrueba() {
        conectar();
        System.out.println(obtenerTablas());
        for(String tabla : obtenerTablas()) {
            System.out.println(obtenerCampos(tabla));
        }
        cerrarConexion();
        System.exit(0);
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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().mostrarPrueba();//.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
