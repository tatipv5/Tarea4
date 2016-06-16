/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import archivos.Escritor;
import archivos.Leer;
import archivos.LeerDistElec;
import controlador.Controlador;
import hilos.Lock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.ArrayDistritos;

/**
 *
 * @author tati
 */
public class VentanaPrincipal extends javax.swing.JFrame {


    private Lock lock = new Lock();
    private Leer leer = new Leer();
    private Escritor escritor = new Escritor();
    private LeerDistElec leerD = new LeerDistElec();
    private Controlador c=new Controlador(lock, leerD, leer, escritor);
         
    /**new
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        subirDist.setEnabled(true);
      subirPadron.setEnabled(false);
      escogerDir.setEnabled(false);
      jTextField1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        subirPadron = new javax.swing.JButton();
        escogerDir = new javax.swing.JButton();
        subirDist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jFileChooser1.setDialogTitle("ThisismyopenDialog");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.controlShadow);

        subirPadron.setBackground(java.awt.SystemColor.control);
        subirPadron.setFont(new java.awt.Font("Norasi", 2, 18)); // NOI18N
        subirPadron.setForeground(new java.awt.Color(24, 175, 231));
        subirPadron.setText("Subir Padron");
        subirPadron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirPadronActionPerformed(evt);
            }
        });

        escogerDir.setBackground(java.awt.SystemColor.control);
        escogerDir.setFont(new java.awt.Font("Norasi", 2, 18)); // NOI18N
        escogerDir.setForeground(new java.awt.Color(24, 175, 231));
        escogerDir.setText("Directorio ");
        escogerDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escogerDirActionPerformed(evt);
            }
        });

        subirDist.setBackground(java.awt.SystemColor.control);
        subirDist.setFont(new java.awt.Font("Norasi", 2, 18)); // NOI18N
        subirDist.setForeground(new java.awt.Color(24, 175, 231));
        subirDist.setText("Subir Distrito Electoral");
        subirDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirDistActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion archivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(subirDist, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(subirPadron, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(escogerDir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subirPadron, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subirDist, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(escogerDir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //es el que lee del archivo, el archivo grande.
    private void subirPadronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirPadronActionPerformed

        jFileChooser1.setCurrentDirectory(new java.io.File("."));
        jFileChooser1.setDialogTitle("Seleccione el archivo");
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            c.iniciarHilos(file);
            subirPadron.setEnabled(false);
            escogerDir.setEnabled(true);
            jTextField1.setEnabled(true);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_subirPadronActionPerformed

    private void subirDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirDistActionPerformed
         jFileChooser1.setCurrentDirectory(new java.io.File("."));
         jFileChooser1.setDialogTitle("Seleccione el archivo");
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
             try {
                 c.leerDistrito(file);
                 subirDist.setEnabled(false);
                 subirPadron.setEnabled(true);
                 System.out.println("leyo"+ArrayDistritos.getInstance().devolverDiez());
             } catch (IOException ex) {
                 Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }

        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_subirDistActionPerformed

    //este es el que dice donde se va a guardar el archivo nuevo.
    private void escogerDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escogerDirActionPerformed
        if(!jTextField1.getText().equals("")) {
            try {
                c.crearArchivo(jTextField1.getText());
                subirPadron.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_escogerDirActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton escogerDir;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton subirDist;
    private javax.swing.JButton subirPadron;
    // End of variables declaration//GEN-END:variables
}
