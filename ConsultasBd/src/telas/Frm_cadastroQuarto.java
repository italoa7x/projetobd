/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;
import model.*;
import dao.QuartoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italo
 */
public class Frm_cadastroQuarto extends javax.swing.JFrame {

    /**
     * Creates new form Frm_cadastroQuarto
     */
   private QuartoDAO quartoDAO;
    
    
    public Frm_cadastroQuarto() {
        initComponents();
        quartoDAO = new QuartoDAO();
        
        preencherTabela();
    }

    private void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_quarto.getModel();
        try {
            Quarto quartos = (Quarto) quartoDAO.read();

            for(Quarto x : quartos.getQuartos()) {
                String[] dados = new String[4];
                dados[0] = x.getId() + "";
                dados[1] = x.getAcomodacoes()+ "";
                dados[2] = x.getDiaria()+ "";
                dados[3] = x.getStatus();
                modelo.addRow(dados);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_quarto.getModel();
        modelo.setNumRows(0);
        try {
            Quarto quartos = (Quarto) quartoDAO.read();

            for (Quarto x : quartos.getQuartos()) {
                String[] dados = new String[4];
                dados[0] = x.getId() + "";
                dados[1] = x.getAcomodacoes() + "";
                dados[2] = x.getDiaria() + "";
                dados[3] = x.getStatus();
                modelo.addRow(dados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void inserirExtra(String id, String extra) {
        String[] dados = {id, extra};
        DefaultTableModel modelo = (DefaultTableModel) tbl_extras.getModel();
        modelo.addRow(dados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_quarto = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVerExtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoStatus = new javax.swing.JTextField();
        painelExtra = new javax.swing.JPanel();
        btSelecionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_extras = new javax.swing.JTable();
        btRemover = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        campoAcomodacoes = new javax.swing.JTextField();
        campoDiaria = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tbl_quarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Acomodações", "Diária", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbl_quarto);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btVerExtras.setText("Ver Extras");
        btVerExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerExtrasActionPerformed(evt);
            }
        });

        jLabel1.setText("Acomodações");

        jLabel2.setText("Diária R$");

        jLabel3.setText("Status");

        campoStatus.setEditable(false);
        campoStatus.setText("Disponível");

        painelExtra.setBorder(javax.swing.BorderFactory.createTitledBorder("Insira os extras"));

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        tbl_extras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Extra"
            }
        ));
        jScrollPane3.setViewportView(tbl_extras);

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelExtraLayout = new javax.swing.GroupLayout(painelExtra);
        painelExtra.setLayout(painelExtraLayout);
        painelExtraLayout.setHorizontalGroup(
            painelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelExtraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSelecionar))
                    .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelExtraLayout.setVerticalGroup(
            painelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSelecionar)
                .addGap(18, 18, 18)
                .addComponent(btRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelExtraLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btVoltar.setText("voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        campoAcomodacoes.setEditable(false);

        campoDiaria.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAcomodacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(campoDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(painelExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btVerExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btSalvar)
                .addGap(91, 91, 91)
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoAcomodacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(painelExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btVerExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar)
                    .addComponent(btVoltar))
                .addGap(0, 39, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(663, 474));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        // TODO add your handling code here:
        new Frm_escolherExtra(this).setVisible(true);
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        // TODO add your handling code here:
        int linha = tbl_extras.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tbl_extras.getModel();
        if (linha != -1) {
            modelo.removeRow(linha);

        }

    }//GEN-LAST:event_btRemoverActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        this.habilitarCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        int linha = tbl_quarto.getSelectedRow();
        int id = Integer.parseInt((String) tbl_quarto.getValueAt(linha, 0));
        try {
            if (quartoDAO.delete(id)) {
                JOptionPane.showMessageDialog(null, "Excluído.");
                atualizarTabela();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        ArrayList<Extra> extrasQuarto = new ArrayList<Extra>();

        // pega todos os extras selecionado para o quarto.
        for (int i = 0; i < tbl_extras.getRowCount(); i++) {
            int id = Integer.parseInt((String) tbl_extras.getValueAt(i, 0));
            String extra = (String) tbl_extras.getValueAt(i, 1);

            Extra extraTabela = new Extra();
            extraTabela.setId(id);
            extraTabela.setNome(extra);

            extrasQuarto.add(extraTabela);
        }
        try {
            // pega os dados do quarto que foram inseridos nos campos.
            int acomodacoes = Integer.parseInt(campoAcomodacoes.getText());
            float diaria = Float.parseFloat(campoDiaria.getText());
            String status = campoStatus.getText();
            // preenche o objeto quartodto
            Quarto quarto = new Quarto();
            quarto.setAcomodacoes(acomodacoes);
            quarto.setDiaria(diaria);
            quarto.setStatus(status);
            quarto.setExtras(extrasQuarto);

            if (!campoAcomodacoes.getText().equals("") && !campoDiaria.getText().equals("")) {
                if (quartoDAO.salvar(quarto)){
                    JOptionPane.showMessageDialog(null, "Cadastrado");
                    limparcampos();
                    atualizarTabela();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVerExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerExtrasActionPerformed
        // TODO add your handling code here:
        try {
            int linha = tbl_quarto.getSelectedRow();
            if (linha != -1) {
                int idQuarto = Integer.parseInt((String) tbl_quarto.getValueAt(linha, 0));
                ArrayList<String> extras = quartoDAO.viewAllExtras(idQuarto);
                JOptionPane.showMessageDialog(null, extras.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btVerExtrasActionPerformed

    private void habilitarCampos() {
        campoAcomodacoes.setEditable(true);
        campoDiaria.setEditable(true);
    }

    private void limparcampos() {
        campoAcomodacoes.setText("");
        campoDiaria.setText("");
        tbl_extras.removeAll();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JButton btVerExtras;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField campoAcomodacoes;
    private javax.swing.JTextField campoDiaria;
    private javax.swing.JTextField campoStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel painelExtra;
    private javax.swing.JTable tbl_extras;
    private javax.swing.JTable tbl_quarto;
    // End of variables declaration//GEN-END:variables
}
