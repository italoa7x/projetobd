/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import bd.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Funcionario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author darkc
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private Funcionario logado;
    
    public Principal(Funcionario f) {
        initComponents();
        logado = f;
        
        if(logado != null){
            lblLogado.setText(logado.getCargo());
        }else{
            lblLogado.setText("admin");
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

        btCadastroHospede = new javax.swing.JButton();
        btCadastraProduto = new javax.swing.JButton();
        btCadastraQuarto = new javax.swing.JButton();
        btReservaQuarto = new javax.swing.JButton();
        btPedido = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblLogado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btCadastroHospede.setText("Cadastrar hospede");
        btCadastroHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroHospedeActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastroHospede);
        btCadastroHospede.setBounds(10, 11, 137, 39);

        btCadastraProduto.setText("Cadastrar produto");
        btCadastraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastraProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastraProduto);
        btCadastraProduto.setBounds(10, 68, 137, 39);

        btCadastraQuarto.setText("Cadastrar quarto");
        btCadastraQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastraQuartoActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastraQuarto);
        btCadastraQuarto.setBounds(10, 113, 137, 39);

        btReservaQuarto.setText("Reservar quarto");
        getContentPane().add(btReservaQuarto);
        btReservaQuarto.setBounds(10, 158, 137, 39);

        btPedido.setText("Pedido");
        btPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btPedido);
        btPedido.setBounds(10, 260, 137, 40);

        jButton8.setText("Cadastrar funcionario");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(10, 208, 137, 41);
        getContentPane().add(lblLogado);
        lblLogado.setBounds(330, 280, 140, 40);

        jButton1.setText("Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 10, 100, 40);

        setSize(new java.awt.Dimension(505, 367));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastroHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroHospedeActionPerformed
        // TODO add your handling code here:
        new Frm_cadastroHospede().setVisible(true);
    }//GEN-LAST:event_btCadastroHospedeActionPerformed

    private void btCadastraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastraProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCadastraProdutoActionPerformed

    private void btCadastraQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastraQuartoActionPerformed
        // TODO add your handling code here:
        new Frm_cadastroQuarto().setVisible(true);
        
    }//GEN-LAST:event_btCadastraQuartoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Frm_cadastroFuncionario().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoActionPerformed
        // TODO add your handling code here:
        new Frm_pedido(logado).setVisible(true);
    }//GEN-LAST:event_btPedidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int respost = JOptionPane.showConfirmDialog(null, "Deseja visualizar o relatório?");
        if (respost == JOptionPane.YES_OPTION) {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            String caminho = "relatorio.jasper";
            JasperPrint jasper = null;
            try {
                jasper = JasperFillManager.fillReport(caminho, null, con);
                JasperViewer view = new JasperViewer(jasper, false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório. "+ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastraProduto;
    private javax.swing.JButton btCadastraQuarto;
    private javax.swing.JButton btCadastroHospede;
    private javax.swing.JButton btPedido;
    private javax.swing.JButton btReservaQuarto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel lblLogado;
    // End of variables declaration//GEN-END:variables
}
