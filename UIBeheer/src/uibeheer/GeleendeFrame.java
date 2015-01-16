/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibeheer;

import DAL.Film;
import Services.FilmServices;
import Services.FrameServices;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ikke
 */
public class GeleendeFrame extends javax.swing.JFrame {

    /**
     * Creates new form GeleendeFrame
     */
    DefaultListModel model = new DefaultListModel();
    public GeleendeFrame() {
        initComponents();
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
        txtTitel = new javax.swing.JTextField();
        btnZoek = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFilms = new javax.swing.JList();
        btnClose = new javax.swing.JButton();
        btnTerugZettenNew = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnTerugZettenClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Titel:");

        btnZoek.setText("Zoek");
        btnZoek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekActionPerformed(evt);
            }
        });

        lstFilms.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFilmsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFilms);

        btnClose.setText("Sluit");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnTerugZettenNew.setText("<html>Terug te<br> lenen & New</html>");
        btnTerugZettenNew.setEnabled(false);
        btnTerugZettenNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerugZettenNewActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 0, 0));

        btnTerugZettenClose.setText("<html>Terug te<br> lenen & Close</html");
        btnTerugZettenClose.setEnabled(false);
        btnTerugZettenClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerugZettenCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnZoek, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTerugZettenNew)
                            .addComponent(btnTerugZettenClose)
                            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZoek, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTerugZettenNew, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTerugZettenClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZoekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekActionPerformed
        List<Film> allFilms = FilmServices.GetByUitgeleend(true);
        String titel = txtTitel.getText();
        if(!titel.isEmpty())
        {
             titel = titel.toLowerCase();
             for(Film f : allFilms)
             {                 
                 if(f.getTitel().toLowerCase().contains(titel) == true)
                {
                    model.addElement(f);
                }
             }
        }
        else lblError.setText("Er moet een titel worden ingevuld of film staat op te lenen!");
        
        lstFilms.setModel(model);
    }//GEN-LAST:event_btnZoekActionPerformed

    private void btnTerugZettenNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerugZettenNewActionPerformed
        if(lstFilms.getSelectedIndex()>0){
            SetUitgeleendFalse();
            FrameServices.GoToStart(this);
        }
        else lblError.setText("Je moet een film selecteren in de lijst!");
    }//GEN-LAST:event_btnTerugZettenNewActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        FrameServices.GoToStart(this);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void lstFilmsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFilmsValueChanged
        btnTerugZettenClose.setEnabled(true);
        btnTerugZettenNew.setEnabled(true);
    }//GEN-LAST:event_lstFilmsValueChanged

    private void btnTerugZettenCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerugZettenCloseActionPerformed
        if(lstFilms.getSelectedIndex()>0){
            SetUitgeleendFalse();
            ClearAll();
        }
        else lblError.setText("Je moet een film selecteren in de lijst!");
    }//GEN-LAST:event_btnTerugZettenCloseActionPerformed

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
            java.util.logging.Logger.getLogger(GeleendeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeleendeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeleendeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeleendeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeleendeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnTerugZettenClose;
    private javax.swing.JButton btnTerugZettenNew;
    private javax.swing.JButton btnZoek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JList lstFilms;
    private javax.swing.JTextField txtTitel;
    // End of variables declaration//GEN-END:variables

    private void SetUitgeleendFalse() {
        Film film = (Film)lstFilms.getSelectedValue();
        FilmServices.Lenen(film.getFilmID(), false);
    }

    private void ClearAll() {
        txtTitel.setText("");
        model = new DefaultListModel();
        lstFilms.setModel(model);
    }
}
