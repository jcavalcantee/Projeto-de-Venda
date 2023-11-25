/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.prototipos;

import classes.Cliente;
import classes.Produto;
import classes.Venda;
import com.mycompany.prototipos.dao.StreetClothingDAO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeffe
 */
public class TelaVenda extends javax.swing.JFrame {

    /**
     * Creates new form TelaVenda
     */
    public TelaVenda() {
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

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPesquisarCliente = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();
        lblNomeCliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnAdicionarItem = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        lblNomeProduto = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblTotalVenda = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcItem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPix = new javax.swing.JButton();
        btnCredito = new javax.swing.JButton();
        btnDebito = new javax.swing.JButton();
        btnDinheiro = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jTextField4.setText("jTextField4");

        jButton2.setText("jButton2");

        jFormattedTextField1.setText("jFormattedTextField1");

        jLabel11.setText("jLabel11");

        jTextField8.setText("jTextField8");

        jButton7.setText("jButton7");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Street Clothing - Vendas");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setText("CPF");

        jLabel4.setText("Nome");

        btnPesquisarCliente.setText("Pesquisar");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setName("CPF"); // NOI18N
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFKeyTyped(evt);
            }
        });

        lblNomeCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnPesquisarCliente)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnPesquisarCliente)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblNomeCliente, txtCPF});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel7.setText("Código");

        jLabel8.setText("Produto");

        jLabel9.setText("Preço");

        jLabel10.setText("Quantidade");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });
        btnAdicionarItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnAdicionarItemKeyTyped(evt);
            }
        });

        txtCodigo.setName("Código"); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtQuantidade.setName("Quantidade"); // NOI18N
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        lblNomeProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPreco.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnPesquisar))
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnAdicionarItem))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(lblNomeProduto)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lblPreco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnAdicionarItem)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblNomeProduto, lblPreco, txtCodigo});

        tblVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Produto", "Produto", "Qtde", "Preço Unit.", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblVenda);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setText("Total da Venda R$:");

        lblTotalVenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalVenda.setText("00.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcItem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExcItem.setText("Excluir Item");
        btnExcItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcItemActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Street Clothing - Tela de Venda");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Other Sources/logo_PI_marcad.jpg"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnPix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pix (1).png"))); // NOI18N
        btnPix.setText("PIX");
        buttonGroup1.add(btnPix);

        btnCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartoes-de-credito.png"))); // NOI18N
        btnCredito.setText("Crédito");
        buttonGroup1.add(btnCredito);

        btnDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visto.png"))); // NOI18N
        btnDebito.setText("Débito");
        buttonGroup1.add(btnDebito);

        btnDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dinheiro.png"))); // NOI18N
        btnDinheiro.setText("Dinheiro");
        buttonGroup1.add(btnDinheiro);
        btnDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinheiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCredito)
                .addGap(12, 12, 12)
                .addComponent(btnDebito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDinheiro)
                .addGap(12, 12, 12))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCredito, btnDebito, btnPix});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPix)
                    .addComponent(btnCredito)
                    .addComponent(btnDebito)
                    .addComponent(btnDinheiro))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCredito, btnDebito, btnDinheiro, btnPix});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFinalizar)
                            .addComponent(btnCancelar)
                            .addComponent(btnExcItem)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar a venda atual?", "Cancelar Venda", WIDTH);

        if (resposta == JOptionPane.YES_NO_OPTION) {
            this.dispose();
        }


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        Validador cod = new Validador();

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
        cod.limiteTexto(txtCodigo, evt, 4);
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyTyped
        Validador pesquisar = new Validador();
        pesquisar.validarCPF(txtCPF);
    }//GEN-LAST:event_txtCPFKeyTyped

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        Validador quantidade = new Validador();

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
        quantidade.limiteTexto(txtQuantidade, evt, 6);
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        Validador pesquisar = new Validador();

        pesquisar.validarTexto(txtCPF);
        if (pesquisar.hasErro()) {
            JOptionPane.showMessageDialog(rootPane, pesquisar.getMensagensErro());
        }

        Cliente pesquisarCliente = new Cliente();
        String cpf = txtCPF.getText().replace(".", "").replace("-", "");
        pesquisarCliente.setCpf(cpf);
        Cliente retorno = StreetClothingDAO.pesquisarClientes(pesquisarCliente);

        if (retorno.getNome() == null) {
            JOptionPane.showMessageDialog(rootPane, "Cliente não cadastrado!");
        } else {
            lblNomeCliente.setText(retorno.getNome());

        }

    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnAdicionarItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarItemKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarItemKeyTyped

    double totalVenda = 0;
    ArrayList<Venda> itensPedido = new ArrayList<>();
    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        int quantidade = 0;
        Validador adicionar = new Validador();

        adicionar.validarTexto(txtCodigo);
        //adicionar.validarTexto(txtProduto);
        adicionar.validarTexto(txtQuantidade);
        //adicionar.ValidarFloat(txtPreco);

        if (adicionar.hasErro()) {
            JOptionPane.showMessageDialog(rootPane, adicionar.getMensagensErro());
        }
        try {
            quantidade = Integer.parseInt(txtQuantidade.getText());
        } catch (NumberFormatException e) {
            if (!txtQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Digite um valor válido para o campo quantidade");
            }
        }
        
        double subTotal = Integer.parseInt(txtQuantidade.getText().toString()) * Double.parseDouble(lblPreco.getText());

        Venda itemPedido = new Venda(Integer.parseInt(txtCodigo.getText()), lblNomeProduto.getText(), Integer.parseInt(txtQuantidade.getText()), Double.parseDouble(lblPreco.getText()), subTotal);

        itensPedido.add(itemPedido);
        
        if (quantidade < 1) {
            JOptionPane.showMessageDialog(null, "Aviso: A quantidade inicial não pode ser menor que 1.", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtQuantidade.setBackground(Color.red);
        } else {
            totalVenda += itemPedido.getSubTotal();
            lblTotalVenda.setText(Double.toString(totalVenda));
        }

//        String pagamento = "pix";
//        Venda vendas = new Venda();
//        vendas.setPagamento(pagamento);
//
//        Venda objIdPedido = StreetClothingDAO.listarPedido(vendas);
//        vendas.setIdPedido(objIdPedido.getIdPedido());
//        vendas.setQtdeProduto(Integer.parseInt(txtQuantidade.getText()));
//
//        Produto estoque = new Produto();
//        estoque = StreetClothingDAO.verifcaQuantidade(estoque, Integer.parseInt(txtCodigo.getText()));
//
//        if (estoque.getEstoqueInicial() < Integer.parseInt(txtQuantidade.getText())) {
//            JOptionPane.showMessageDialog(rootPane, "A quantidade inserida é maior que o estoque de nossa loja!");
//        } else {
//            StreetClothingDAO.cadastrarItemPedido(vendas, Integer.parseInt(txtCodigo.getText().toString()));
//        }
//
        txtCodigo.setText("");
        txtQuantidade.setText("");
        lblNomeProduto.setText("");
        lblPreco.setText("");
        exibir();
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    public void exibir() {

        DefaultTableModel model = (DefaultTableModel) tblVenda.getModel();
        model.setRowCount(0);

        for (Venda item : itensPedido) {
            model.addRow(new String[]{
                String.valueOf(item.getCodProduto()),
                String.valueOf(item.getNomeProduto()),
                String.valueOf(item.getQtdeProduto()),
                String.valueOf(item.getPrecoProduto()),
                String.valueOf(item.getSubTotal())
            });
        }
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Validador adicionar = new Validador();
        adicionar.validarTexto(txtCodigo);
        if (adicionar.hasErro()) {
            JOptionPane.showMessageDialog(rootPane, adicionar.getMensagensErro());
        }

        Produto pesquisarProduto = new Produto();
        pesquisarProduto.setId(Integer.parseInt(txtCodigo.getText()));
        Produto retorno = StreetClothingDAO.pesquisarProdutos(pesquisarProduto);

        if (retorno.getNome() == null) {
            JOptionPane.showMessageDialog(rootPane, "Produto não cadastrado!");
        } else {
            lblNomeProduto.setText(retorno.getNome());
            lblPreco.setText(String.valueOf(retorno.getPrecoUnit()));
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDinheiroActionPerformed

    private void btnExcItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcItemActionPerformed

        int linhaSelecionada = tblVenda.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tblVenda.getModel();
        Venda objIdPedido = new Venda();
        objIdPedido = StreetClothingDAO.listarPedido(objIdPedido);

        boolean retorno = StreetClothingDAO.excluirItemVenda(objIdPedido.getIdPedido());

        if (retorno) {
            JOptionPane.showMessageDialog(rootPane, "Excluído com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar excluir.");
        }

        recarregarTabela();
    }//GEN-LAST:event_btnExcItemActionPerformed

    public void recarregarTabela() {

        Venda objIdPedido = new Venda();
        objIdPedido = StreetClothingDAO.listarPedido(objIdPedido);
        ArrayList<Venda> lista = StreetClothingDAO.listarProdutosVenda(objIdPedido.getIdPedido());

        DefaultTableModel modelo = (DefaultTableModel) tblVenda.getModel();
        modelo.setRowCount(0);

        //Para cada item na lista retornada do banco, adiciono à nossa tabela
        for (Venda item : lista) {
            modelo.addRow(new String[]{
                String.valueOf(item.getCodProduto()),
                String.valueOf(item.getNomeProduto()),
                String.valueOf(item.getQtdeProduto()),
                String.valueOf(item.getPrecoProduto()),
                String.valueOf(item.getSubTotal())
            });
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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnDebito;
    private javax.swing.JButton btnDinheiro;
    private javax.swing.JButton btnExcItem;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPix;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JTable tblVenda;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
