/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author AMD
 */
public class Ubah extends javax.swing.JFrame {
    String nama = Login.getU_nama();
    Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form Ubah
     */
    
    private String a,b;
    private int c;
    public Ubah() {
        initComponents();
        userJl.setText(nama);
        jLabel4.setVisible(false);
        confirmBT.setVisible(false);
        tampungJL.setVisible(false);
        visibleBtn(false);
    }
    
    public void tampilUser(String user){
        userJl.setText(user);
    }
    
    private void visibleBtn(boolean a){
        verifikasBt.setVisible(!a);
        changeBT.setVisible(a);
        jLabel2.setVisible(!a);
        jLabel3.setVisible(a);
        jlblKet.setVisible(a);
        jlblKet1.setVisible(a);
    }
    
    private void gantiPass(){
        try {
            setKoneksi();
            String sql="update tbuser set "+
                "password = "+"'"+passTF.getText()+"' "+
                "where nama = '"+userJl.getText()+"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Password Berhasil Diubah","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            passTF.setText("");
            visibleBtn(false);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Gagal mengubah password");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userJl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passTF = new javax.swing.JPasswordField();
        jlblKet = new javax.swing.JLabel();
        jlblKet1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        changeBT = new javax.swing.JButton();
        confirmBT = new javax.swing.JButton();
        tampungJL = new javax.swing.JLabel();
        verifikasBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ganti Password");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Masukkan Password Lama Anda");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 64, 220, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Masukkan Password Baru Anda");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Masukkan Kembali Password Baru Anda");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 240, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Pengguna :");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 141, -1, -1));

        userJl.setText("jLabel1");
        jPanel1.add(userJl, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 141, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Password :");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 164, -1, -1));
        jPanel1.add(passTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 161, 174, -1));

        jlblKet.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblKet.setForeground(new java.awt.Color(255, 0, 0));
        jlblKet.setText("Panjang karakter password tidak boleh kurang dari 2 digit");
        jPanel1.add(jlblKet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 208, -1, -1));

        jlblKet1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblKet1.setForeground(new java.awt.Color(255, 0, 0));
        jlblKet1.setText("dan tidak boleh lebih dari 10 digit !");
        jPanel1.add(jlblKet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 228, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 204, 153));

        changeBT.setText("OK");
        changeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBTActionPerformed(evt);
            }
        });

        confirmBT.setText("OK");
        confirmBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBTActionPerformed(evt);
            }
        });

        tampungJL.setBackground(new java.awt.Color(0, 0, 0));

        verifikasBt.setText("OK");
        verifikasBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifikasBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verifikasBt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmBT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(tampungJL, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmBT)
                        .addComponent(verifikasBt))
                    .addComponent(tampungJL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 360, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBTActionPerformed
        // TODO add your handling code here:
        if(passTF.getText().length()<2) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh kurang dari 2 digit !");
            passTF.setText("");
            visibleBtn(true);
            passTF.requestFocus();
        }
        else if(passTF.getText().length()>10) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh lebih dari 10 digit !");
            passTF.setText("");
            visibleBtn(true);
            passTF.requestFocus();
        }
        else {
            b = passTF.getText();
            a = b;
            tampungJL.setText(a);
            passTF.setText("");
            jLabel4.setVisible(true);
            confirmBT.setVisible(true);

            visibleBtn(false);
            verifikasBt.setVisible(false);
            jLabel2.setVisible(false);
        }
    }//GEN-LAST:event_changeBTActionPerformed

    private void confirmBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBTActionPerformed
        // TODO add your handling code here:
        a = tampungJL.getText();
        b = passTF.getText();

        if (a.equals(b)) {
            c = JOptionPane.showConfirmDialog(null, "Anda yakin ingin merubah password?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
            if (c == 0){
                gantiPass();
                jLabel4.setVisible(false);
                confirmBT.setVisible(false);
            }
            else
            {
                visibleBtn(false);
                passTF.setText("");
                jLabel4.setVisible(false);
                confirmBT.setVisible(false);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Password baru yang anda masukkan tidak cocok!");
            passTF.setText("");
            passTF.requestFocus();
        }
    }//GEN-LAST:event_confirmBTActionPerformed

    private void verifikasBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifikasBtActionPerformed
        // TODO add your handling code here:
        try {
            setKoneksi();
            String sql="select * from tbuser where nama = '"+
            userJl.getText()+"' and password = '"+passTF.getText()+"'";
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) {
                passTF.setText("");
                visibleBtn(true);
            }
            else  {
                passTF.setText("");
                JOptionPane.showMessageDialog(null, "Password lama yang anda masukkan salah!");
                visibleBtn(false);
                passTF.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Koneksi Gagal");
        }
    }//GEN-LAST:event_verifikasBtActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Ubah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ubah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ubah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ubah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ubah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeBT;
    private javax.swing.JButton confirmBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlblKet;
    private javax.swing.JLabel jlblKet1;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JLabel tampungJL;
    private javax.swing.JLabel userJl;
    private javax.swing.JButton verifikasBt;
    // End of variables declaration//GEN-END:variables

 public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/smartshopaplikasi","root","");
            st=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
}
