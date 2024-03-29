/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import enums.naoTerminais.CodigoPalavrasNaoTerminaisEnum;
import java.awt.Color;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import models.Pilha;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.TabelaSemantica;
import servicos.Files;
import servicos.ProcessarTextoLexico;
import servicos.ProcessarTextoSintatico;
import utils.TextLineNumber;

/**
 *
 * @author Clienteç
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private String caminhoDoc = null;
    private Stack<Pilha> pilhaLexica = new Stack<>();
    private Stack<Pilha> pilhaSintatica = new Stack<>();
    private final StringBuilder stbLogs = new StringBuilder();
    
    public TelaPrincipal() {
        initComponents();
        jLabelDebug.setVisible(false);
        TextLineNumber tn = new TextLineNumber(jTextAreaPagina);
        jScrollPagina.setRowHeaderView(tn);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFundo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableA = new javax.swing.JTable();
        jScrollPagina = new javax.swing.JScrollPane();
        jTextAreaPagina = new javax.swing.JTextArea();
        jPanelFundoLog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableX = new javax.swing.JTable();
        jToolBarPilhaSintatica = new javax.swing.JToolBar();
        jLabelPilhaSintatica = new javax.swing.JLabel();
        jToolBarPilhaLéxica = new javax.swing.JToolBar();
        jLabelPilhaLéxica = new javax.swing.JLabel();
        jToolBarBarraFerramentas = new javax.swing.JToolBar();
        jButtonNovoArquivo = new javax.swing.JButton();
        jButtonPasta = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jBtnRunCode = new javax.swing.JButton();
        jBtnDebugPlay = new javax.swing.JButton();
        jBtnDebugCode = new javax.swing.JButton();
        jLabelDebug = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");

        jTableA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Palavra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableA.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableA);
        if (jTableA.getColumnModel().getColumnCount() > 0) {
            jTableA.getColumnModel().getColumn(0).setResizable(false);
            jTableA.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextAreaPagina.setColumns(20);
        jTextAreaPagina.setLineWrap(true);
        jTextAreaPagina.setRows(5);
        jTextAreaPagina.setWrapStyleWord(true);
        jScrollPagina.setViewportView(jTextAreaPagina);

        jPanelFundoLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Console"));

        jTextAreaLog.setEditable(false);
        jTextAreaLog.setColumns(20);
        jTextAreaLog.setForeground(new java.awt.Color(255, 0, 0));
        jTextAreaLog.setRows(5);
        jScrollPane3.setViewportView(jTextAreaLog);

        javax.swing.GroupLayout jPanelFundoLogLayout = new javax.swing.GroupLayout(jPanelFundoLog);
        jPanelFundoLog.setLayout(jPanelFundoLogLayout);
        jPanelFundoLogLayout.setHorizontalGroup(
            jPanelFundoLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelFundoLogLayout.setVerticalGroup(
            jPanelFundoLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTableX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Palavra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableX.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableX);
        if (jTableX.getColumnModel().getColumnCount() > 0) {
            jTableX.getColumnModel().getColumn(0).setResizable(false);
            jTableX.getColumnModel().getColumn(1).setResizable(false);
        }

        jToolBarPilhaSintatica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBarPilhaSintatica.setRollover(true);

        jLabelPilhaSintatica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPilhaSintatica.setText("Pilha Sintática");
        jToolBarPilhaSintatica.add(jLabelPilhaSintatica);

        jToolBarPilhaLéxica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBarPilhaLéxica.setRollover(true);

        jLabelPilhaLéxica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPilhaLéxica.setText("Pilha Léxica");
        jToolBarPilhaLéxica.add(jLabelPilhaLéxica);

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPagina)
                    .addComponent(jPanelFundoLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jToolBarPilhaSintatica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBarPilhaLéxica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addComponent(jScrollPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelFundoLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addComponent(jToolBarPilhaSintatica, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBarPilhaLéxica, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jToolBarBarraFerramentas.setRollover(true);

        jButtonNovoArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/icone documento.png"))); // NOI18N
        jButtonNovoArquivo.setToolTipText("Novo arquivo");
        jButtonNovoArquivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovoArquivo.setFocusable(false);
        jButtonNovoArquivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNovoArquivo.setMaximumSize(new java.awt.Dimension(40, 65));
        jButtonNovoArquivo.setMinimumSize(new java.awt.Dimension(40, 65));
        jButtonNovoArquivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNovoArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoArquivoActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jButtonNovoArquivo);

        jButtonPasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/icone pasta.png"))); // NOI18N
        jButtonPasta.setToolTipText("Abrir arquivo");
        jButtonPasta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPasta.setFocusable(false);
        jButtonPasta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPasta.setMaximumSize(new java.awt.Dimension(40, 65));
        jButtonPasta.setMinimumSize(new java.awt.Dimension(40, 65));
        jButtonPasta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPastaActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jButtonPasta);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/icone salvar.png"))); // NOI18N
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.setFocusable(false);
        jButtonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalvar.setMaximumSize(new java.awt.Dimension(40, 65));
        jButtonSalvar.setMinimumSize(new java.awt.Dimension(40, 65));
        jButtonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jButtonSalvar);

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/icone excluir.png"))); // NOI18N
        jButtonLimpar.setToolTipText("Limpar");
        jButtonLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpar.setFocusable(false);
        jButtonLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpar.setMaximumSize(new java.awt.Dimension(40, 65));
        jButtonLimpar.setMinimumSize(new java.awt.Dimension(40, 65));
        jButtonLimpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jButtonLimpar);

        jBtnRunCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/icone run.png"))); // NOI18N
        jBtnRunCode.setToolTipText("Executar");
        jBtnRunCode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRunCode.setFocusable(false);
        jBtnRunCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnRunCode.setMaximumSize(new java.awt.Dimension(40, 65));
        jBtnRunCode.setMinimumSize(new java.awt.Dimension(40, 65));
        jBtnRunCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnRunCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRunCodeActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jBtnRunCode);

        jBtnDebugPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/Icone DebugPlay.png"))); // NOI18N
        jBtnDebugPlay.setToolTipText("Debugar ");
        jBtnDebugPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnDebugPlay.setFocusable(false);
        jBtnDebugPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnDebugPlay.setMaximumSize(new java.awt.Dimension(40, 65));
        jBtnDebugPlay.setMinimumSize(new java.awt.Dimension(40, 65));
        jBtnDebugPlay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnDebugPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDebugPlayMouseClicked(evt);
            }
        });
        jBtnDebugPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDebugPlayActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jBtnDebugPlay);

        jBtnDebugCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/icones/Icone Debug.png"))); // NOI18N
        jBtnDebugCode.setToolTipText("Debugar por partes");
        jBtnDebugCode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnDebugCode.setFocusable(false);
        jBtnDebugCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnDebugCode.setMaximumSize(new java.awt.Dimension(40, 65));
        jBtnDebugCode.setMinimumSize(new java.awt.Dimension(40, 65));
        jBtnDebugCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnDebugCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDebugCodeMouseClicked(evt);
            }
        });
        jBtnDebugCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDebugCodeActionPerformed(evt);
            }
        });
        jToolBarBarraFerramentas.add(jBtnDebugCode);

        jLabelDebug.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDebug.setText("Debug [OFF]");
        jToolBarBarraFerramentas.add(jLabelDebug);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarBarraFerramentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarBarraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPastaActionPerformed
        caminhoDoc = Files.abrirArquivoDialog(this);
        jTextAreaPagina.setText(Files.lerArquivo(caminhoDoc));
    }//GEN-LAST:event_jButtonPastaActionPerformed

    public void analisarSintaxe() throws Exception {
        if (getPilhaSintatica().isEmpty()) {
            setPilhaSintatica(new Stack<>());
            getPilhaSintatica().add(CodigoPalavrasNaoTerminaisEnum.PROGRAMA.getPilha());
            if (getPilhaSintatica().size() == 1) {
                criarTabelaSintatica(getPilhaSintatica());
                return;
            }
        }

        ProcessarTextoSintatico.debugarSintaxe(getPilhaSintatica(), getPilhaLexica());
        criarTabelaSintatica(getPilhaSintatica());
        criarTabelaLexica(getPilhaLexica());
    }

    public Stack<Pilha> getPilhaLexica() {
        return pilhaLexica;
    }

    public void setPilhaLexica(Stack<Pilha> pilhaLexica) {
        this.pilhaLexica = pilhaLexica;
    }

    public Stack<Pilha> getPilhaSintatica() {
        return pilhaSintatica;
    }

    public void setPilhaSintatica(Stack<Pilha> pilhaSintatica) {
        this.pilhaSintatica = pilhaSintatica;
    }

    public void criarTabelaLexica(Stack<Pilha> pilha) {
        criarTabela((DefaultTableModel) jTableA.getModel(), pilha);
    }

    private void criarTabelaSintatica(Stack<Pilha> pilha) {
        criarTabela((DefaultTableModel) jTableX.getModel(), pilha);
    }

    private void criarTabela(DefaultTableModel tabela, Stack<Pilha> pilha) {

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }

        int tam = pilha.size() - 1;
        for (int i = tam; i >= 0; i--) {
            Pilha p = pilha.get(i);
            tabela.addRow(new Object[]{p.getCodigo(), p.getDescricao()});
        }
    }

    public void limpar() {
        limpar(true);
    }

    public void limpar(boolean limparCodigo) {

        limparTabela((DefaultTableModel) jTableA.getModel());
        limparTabela((DefaultTableModel) jTableX.getModel());
        jLabelDebug.setText("Debug [OFF]");
        jLabelDebug.setVisible(false);

        if (limparCodigo) {
            jTextAreaPagina.setText("");
            jTextAreaLog.setText("");
            clearLogs();
            limparPilhas();
        }
    }

    public void limparPilhas() {
        getPilhaLexica().clear();
        getPilhaSintatica().clear();
    }

    private void limparTabela(DefaultTableModel tabela) {
        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
    }

    private void addLog(String log) {
        addLog(log, true);
    }

    private void addLog(String log, boolean breakline) {

        if (breakline && stbLogs.length() > 0) {
            stbLogs.append("\n");
        }

        stbLogs.append(log);
    }

    private void clearLogs() {
        stbLogs.setLength(0);
    }

    private void showLogs() {
        jTextAreaLog.setText(stbLogs.toString());
    }

    private void jButtonNovoArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoArquivoActionPerformed
        limpar();
        caminhoDoc = null;
    }//GEN-LAST:event_jButtonNovoArquivoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (caminhoDoc != null && !caminhoDoc.isEmpty()) {
            Files.gravarArquivo(caminhoDoc, jTextAreaPagina.getText());
            return;
        }

        if ((caminhoDoc = Files.salvarArquivoDialog(this)) != null) {
            Files.gravarArquivo(caminhoDoc, jTextAreaPagina.getText());
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limpar();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jBtnRunCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRunCodeActionPerformed
        clearLogs();
        jLabelDebug.setText("Debug [OFF]");
        jLabelDebug.setVisible(false);
        jTextAreaLog.setForeground(Color.black);
        addLog("Compilando...");

        if (jTextAreaPagina.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione algum texto para ser analisado");
            return;
        }

        try {
            limparPilhas();
            setPilhaLexica(ProcessarTextoLexico.criarPilha(jTextAreaPagina.getText()));
            Collections.reverse(getPilhaLexica());
            criarTabelaLexica(getPilhaLexica());
            criarTabelaSintatica(getPilhaSintatica());
            addLog("Análise léxica finalizada.");
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            limpar(false);
            jTextAreaLog.setForeground(Color.red);
            addLog("Erro: " + ex.getMessage());
            
        }

        showLogs();
    }//GEN-LAST:event_jBtnRunCodeActionPerformed

    private void jBtnDebugCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDebugCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDebugCodeActionPerformed

    private void jBtnDebugCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDebugCodeMouseClicked
        try {
            jLabelDebug.setText("Debug [ON]");

            if (getPilhaLexica().isEmpty() && getPilhaSintatica().isEmpty()) {
                jLabelDebug.setText("Debug [OFF]");
            }

            if (getPilhaLexica().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Execute o algoritmo");
                return;
            }

            jLabelDebug.setVisible(true);

            analisarSintaxe();

            if (getPilhaLexica().isEmpty() && getPilhaSintatica().isEmpty()) {
                addLog("Análise sintática finalizada.");
            }

        } catch (Exception ex) {
            jLabelDebug.setText("Debug [OFF]");
            jTextAreaLog.setForeground(Color.red);
            addLog(ex.getMessage());
        }

        showLogs();
    }//GEN-LAST:event_jBtnDebugCodeMouseClicked

    private void jBtnDebugPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDebugPlayMouseClicked

        jLabelDebug.setVisible(false);
        
        if (getPilhaLexica().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Execute o algoritmo");
            return;
        }

        try {
            while (!getPilhaLexica().isEmpty()) {
                analisarSintaxe();
            }
            addLog("Análise sintática finalizada.");
            addLog("Compilado com sucesso.");
            jTextAreaLog.setForeground(Color.GREEN.darker().darker());
        } catch (Exception ex) {
            jTextAreaLog.setForeground(Color.red);
            addLog(ex.getMessage());
        }
        showLogs();
    }//GEN-LAST:event_jBtnDebugPlayMouseClicked

    private void jBtnDebugPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDebugPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDebugPlayActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDebugCode;
    private javax.swing.JButton jBtnDebugPlay;
    private javax.swing.JButton jBtnRunCode;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovoArquivo;
    private javax.swing.JButton jButtonPasta;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelDebug;
    private javax.swing.JLabel jLabelPilhaLéxica;
    private javax.swing.JLabel jLabelPilhaSintatica;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JPanel jPanelFundoLog;
    private javax.swing.JScrollPane jScrollPagina;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableA;
    private javax.swing.JTable jTableX;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JTextArea jTextAreaPagina;
    private javax.swing.JToolBar jToolBarBarraFerramentas;
    private javax.swing.JToolBar jToolBarPilhaLéxica;
    private javax.swing.JToolBar jToolBarPilhaSintatica;
    // End of variables declaration//GEN-END:variables
}
