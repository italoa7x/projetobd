/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author italo
 */
public class Frm_cadastroProduto extends javax.swing.JFrame {

    /**
     * Creates new form Frm_cadastroFuncionario
     */
    public Frm_cadastroProduto() {
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
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoQtd = new javax.swing.JTextField();
        campoValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 56, 27, 14);

        jLabel2.setText("Valor R$");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 94, 40, 14);

        campoNome.setEditable(false);
        getContentPane().add(campoNome);
        campoNome.setBounds(64, 53, 160, 20);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifpb/ads/icones/iconfinder_save_2639912.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar);
        btSalvar.setBounds(30, 190, 63, 23);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifpb/ads/icones/iconfinder_Login_out_85206.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 193, 78, 23);

        jLabel3.setText("QTD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 132, 21, 14);

        campoQtd.setEditable(false);
        getContentPane().add(campoQtd);
        campoQtd.setBounds(54, 129, 94, 20);

        try {
            campoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(campoValor);
        campoValor.setBounds(54, 91, 94, 20);

        setSize(new java.awt.Dimension(244, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoQtd;
    private javax.swing.JFormattedTextField campoValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
