package Slytherin.visao;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import Slytherin.controle.ControleBusca;
import Slytherin.entidade.Conta;
import Slytherin.entidade.Livro;
import Slytherin.excecao.BancoException;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Lukas e Rayssa
 */
public final class Home extends javax.swing.JFrame {
    Livro l = new Livro();
    CarrinhoCompras telaCarrinho = new CarrinhoCompras();
    GerenciaAdm gerenciaAdm = new GerenciaAdm();
    UsuarioCadastrado usuarioCadastrado = new UsuarioCadastrado();
  
    public Livro getL() {
        return l;
    }

    public void setL(Livro l) {
        this.l = l;
    }
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        habilitarCliente();
        setTitle("Livraria Slytherin");
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
        btn_pedidos2 = new javax.swing.JButton();
        btn_pedidos3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmb_criterios = new javax.swing.JComboBox<>();
        txt_palChave = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        cmb_categoria = new javax.swing.JComboBox<>();
        cmb_digitais = new javax.swing.JComboBox<>();
        cmb_livros = new javax.swing.JComboBox<>();
        btn_pedidos = new javax.swing.JButton();
        btn_carrinho = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        scroll_15 = new javax.swing.JScrollPane();
        pn_pai = new javax.swing.JPanel();
        lbl_restrito = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        btn_pedidos2.setBackground(new java.awt.Color(16, 187, 211));
        btn_pedidos2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pedidos2.setForeground(new java.awt.Color(255, 255, 255));
        btn_pedidos2.setText("Meus Pedidos");
        btn_pedidos2.setBorderPainted(false);

        btn_pedidos3.setBackground(new java.awt.Color(16, 187, 211));
        btn_pedidos3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pedidos3.setForeground(new java.awt.Color(255, 255, 255));
        btn_pedidos3.setText("Adicionar Autor");
        btn_pedidos3.setBorderPainted(false);
        btn_pedidos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidos3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 246, 252));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.PNG")));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 38, 50));

        cmb_criterios.setBackground(new java.awt.Color(16, 187, 211));
        cmb_criterios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_criterios.setForeground(new java.awt.Color(255, 255, 255));
        cmb_criterios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtros", "Editora", "T??tulo", "Autor", "ISBN" }));
        cmb_criterios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_palChave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_palChave.setForeground(new java.awt.Color(51, 51, 51));
        txt_palChave.setBorder(null);
        txt_palChave.setCaretColor(java.awt.Color.white);

        btn_ok.setBackground(new java.awt.Color(16, 187, 211));
        btn_ok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ok.setForeground(new java.awt.Color(255, 255, 255));
        btn_ok.setText("OK");
        btn_ok.setBorderPainted(false);
        btn_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_okMouseExited(evt);
            }
        });
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        cmb_categoria.setBackground(new java.awt.Color(16, 187, 211));
        cmb_categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_categoria.setForeground(new java.awt.Color(255, 255, 255));
        cmb_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categorias", "ADMINISTRA????O", "AGROPECU??RIA", "ARTES", "??UDIO LIVRO", "AUTO AJUDA", "CI??NCIAS BIOL??GICAS", "CI??NCIAS EXATAS", "CI??NCIAS HUMANAS", "CONTABILIDADE", "IDIOMA", "DICION??RIO", "DID??TICO", "DIREITO", "ECONOMIA", "ENGENHARIA TECNOL??GICA", "ESPORTE", "GASTRONOMIA", "GEOGRAFIA HIST??RICA", "INFORM??TICA", "LINGU??STICA", "LITERATURA ESTRANGEIRA", "LITERATURA INFANTIL", "LITERATURA NACIONAL", "MEDICINA", "RELIGI??O", "TURISMO" }));
        cmb_categoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmb_categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_categoriaItemStateChanged(evt);
            }
        });

        cmb_digitais.setBackground(new java.awt.Color(16, 187, 211));
        cmb_digitais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_digitais.setForeground(new java.awt.Color(255, 255, 255));
        cmb_digitais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E-Books", "Lan??amentos", "Pr??-Vendas", "Mais Vendidos" }));
        cmb_digitais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmb_livros.setBackground(new java.awt.Color(16, 187, 211));
        cmb_livros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_livros.setForeground(new java.awt.Color(255, 255, 255));
        cmb_livros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livros", "Lan??amentos", "Pr??-Vendas", "Mais Vendidas" }));
        cmb_livros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_pedidos.setBackground(new java.awt.Color(16, 187, 211));
        btn_pedidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pedidos.setForeground(new java.awt.Color(255, 255, 255));
        btn_pedidos.setText("Meus Pedidos");
        btn_pedidos.setBorderPainted(false);
        btn_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pedidosMouseExited(evt);
            }
        });

        btn_carrinho.setBackground(new java.awt.Color(16, 187, 211));
        btn_carrinho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_carrinho.setForeground(new java.awt.Color(255, 255, 255));
        btn_carrinho.setText("Meu Carrinho");
        btn_carrinho.setBorderPainted(false);
        btn_carrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_carrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_carrinhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_carrinhoMouseExited(evt);
            }
        });
        btn_carrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carrinhoActionPerformed(evt);
            }
        });

        btn_sair.setBackground(new java.awt.Color(16, 187, 211));
        btn_sair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_sair.setText("Logout");
        btn_sair.setBorderPainted(false);
        btn_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sairMouseExited(evt);
            }
        });
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        pn_pai.setBackground(new java.awt.Color(18, 38, 50));
        pn_pai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pn_paiLayout = new javax.swing.GroupLayout(pn_pai);
        pn_pai.setLayout(pn_paiLayout);
        pn_paiLayout.setHorizontalGroup(
            pn_paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        pn_paiLayout.setVerticalGroup(
            pn_paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        scroll_15.setViewportView(pn_pai);

        lbl_restrito.setForeground(new java.awt.Color(16, 187, 211));
        lbl_restrito.setText("> Acesso restrito");
        lbl_restrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_restrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_restritoMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Webp.net-resizeimage.jpg"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_1iconhome.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("???");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_pedidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_carrinho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_sair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_restrito))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmb_livros, 0, 185, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_digitais, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_criterios, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_palChave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_palChave, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmb_livros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_digitais, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_criterios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_pedidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sair)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_restrito))
                            .addComponent(scroll_15, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(929, 674));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_categoriaItemStateChanged
        /*
        Categorias
        ADMINISTRA????O
        AGROPECU??RIA
        ARTES
        ??UDIO LIVRO
        AUTO AJUDA
        CI??NCIAS BIOL??GICAS
        CI??NCIAS EXATAS
        CI??NCIAS HUMANAS
        CONTABILIDADE
        IDIOMA
        DICION??RIO
        DID??TICO
        DIREITO
        ECONOMIA
        ENGENHARIA TECNOL??GICA
        ESPORTE
        GASTRONOMIA
        GEOGRAFIA HIST??RICA
        INFORM??TICA
        LINGU??STICA
        LITERATURA ESTRANGEIRA
        LITERATURA INFANTIL
        LITERATURA NACIONAL
        MEDICINA
        RELIGI??O
        TURISMO
        */
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            pn_pai.removeAll();
            GridLayout gerente = new GridLayout(10, 1);//Mostra at?? 10 itens um em baixo do outro
            pn_pai.setLayout(gerente);

            ControleBusca controleBusca = new ControleBusca();
            ArrayList<Livro> resultBusca;
            String categoria;
            
            switch (cmb_categoria.getSelectedIndex()) {
                case 0:
                    JOptionPane.showMessageDialog(rootPane, "Selecione uma categoria");
                    return;
                case 1:
                    categoria = "ADMINISTRACAO";
                    break;
                case 2:
                    categoria = "AGROPECUARIA";
                    break;
                case 3:
                    categoria = "ARTES";
                    break;
                case 4:
                    categoria = "AUDIOLIVRO";
                    break;
                case 5:
                    categoria = "AUTOAJUDA";
                    break;
                case 6:
                    categoria = "CIENCIAS_BIO";
                    break;
                case 7:
                    categoria = "CIENCIAS_EXA";
                    break;
                case 8:
                    categoria = "CIENCIAS_HUM";
                    break;
                case 9:
                    categoria = "CONTABILIDADE";
                    break;
                case 10:
                    categoria = "IDIOMA";
                    break;
                case 11:
                    categoria = "DICIONARIO";
                    break;
                case 12:
                    categoria = "DIDATICO";
                    break;
                case 13:
                    categoria = "DIREITO";
                    break;
                case 14:
                    categoria = "ECONOMIA";
                    break;
                case 15:
                    categoria = "ENG_TEC";
                    break;
                case 16:
                    categoria = "ESPORTE";
                    break;
                case 17:
                    categoria = "GASTRONOMIA";
                    break;
                case 18:
                    categoria = "GEO_HIST";
                    break;
                case 19:
                    categoria = "INFORMATICA";
                    break;
                case 20:
                    categoria = "LINGUISTICA";
                    break;
                case 21:
                    categoria = "LITER_ESTR";
                    break;
                case 22:
                    categoria = "LITER_INFA";
                    break;
                case 23:
                    categoria = "LITER_NACIO";
                    break;
                case 24:
                    categoria = "MEDICINA";
                    break;
                case 25:
                    categoria = "RELIGIAO";
                    break;
                case 26:
                    categoria = "TURISMO";
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane, "Erro ao buscar");
                    return;
            }
            
            try {
                controleBusca.fazerBusca(categoria, 5);
            } catch (BancoException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                return;
            }
            
            resultBusca = controleBusca.getResultadosBusca();
            
            NumberFormat formato_grana = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));
            
            resultBusca.forEach((ver) -> {
                Slytherin.visao.pn_Busca p1 = new Slytherin.visao.pn_Busca();
                pn_pai.add(p1);
                p1.getTxt_titulo().setText(ver.getTitulo());
                p1.getTxt_autor().setText(ver.getAutor().getNome());
                p1.getTxt_preco().setText(formato_grana.format(ver.getPrecoVenda()));
                p1.setLi(ver);
            });
            //System.out.println(l.getIsbn());
            //System.out.println(l.getMargemLucro());
            //Atualiza form...pequeno erro grafico
            pequenoBug();//Corrige
        }
    }//GEN-LAST:event_cmb_categoriaItemStateChanged

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed

        pn_pai.removeAll();//Retira tudo do painel
        if ("".equals(txt_palChave.getText()) || " ".equals(txt_palChave.getText()) || "   ".equals(txt_palChave.getText()) ||cmb_criterios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha filtros ou paravra chave");
        } else {
            GridLayout gerente = new GridLayout(10, 1);//Mostra at?? 10 itens um em baixo do outro
            pn_pai.setLayout(gerente);

            ControleBusca controleBusca = new ControleBusca();
            ArrayList<Livro> resultBusca;
            
            try {
                controleBusca.fazerBusca(txt_palChave.getText(), cmb_criterios.getSelectedIndex());
            } catch (BancoException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                return;
            }
            
            resultBusca = controleBusca.getResultadosBusca();

            resultBusca.forEach((ver) -> {
                Slytherin.visao.pn_Busca p1 = new Slytherin.visao.pn_Busca();
                pn_pai.add(p1);
                p1.getTxt_titulo().setText(ver.getTitulo());
                p1.getTxt_autor().setText(ver.getAutor().getNome());
                p1.getTxt_preco().setText(String.valueOf(ver.getPrecoVenda()));
                p1.setLi(ver);//envia objeto
            }); //System.out.println(l.getIsbn());
            //System.out.println(l.getMargemLucro());

            //Atualiza form...pequeno erro grafico
            pequenoBug();//Corrige

        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        Conta.deslogar();
        usuarioCadastrado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_carrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carrinhoActionPerformed
        telaCarrinho.setVisible(true);
        telaCarrinho.preencherTabela();
    }//GEN-LAST:event_btn_carrinhoActionPerformed

    private void btn_pedidos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidos3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pedidos3ActionPerformed

    private void lbl_restritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_restritoMouseClicked
        gerenciaAdm.setVisible(true);
    }//GEN-LAST:event_lbl_restritoMouseClicked

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        usuarioCadastrado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel5MousePressed

    private void btn_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseEntered
        // TODO add your handling code here:
        btn_ok.setBackground(new java.awt.Color(93,194,176)); 
    }//GEN-LAST:event_btn_okMouseEntered

    private void btn_okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseExited
        // TODO add your handling code here:
        btn_ok.setBackground(new java.awt.Color(16,187,211));
    }//GEN-LAST:event_btn_okMouseExited

    private void btn_pedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pedidosMouseEntered
        // TODO add your handling code here:
        btn_pedidos.setBackground(new java.awt.Color(93,194,176));
    }//GEN-LAST:event_btn_pedidosMouseEntered

    private void btn_pedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pedidosMouseExited
        // TODO add your handling code here:
        btn_pedidos.setBackground(new java.awt.Color(16,187,211));
    }//GEN-LAST:event_btn_pedidosMouseExited

    private void btn_carrinhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_carrinhoMouseEntered
        // TODO add your handling code here:
        btn_carrinho.setBackground(new java.awt.Color(93,194,176));
    }//GEN-LAST:event_btn_carrinhoMouseEntered

    private void btn_carrinhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_carrinhoMouseExited
        // TODO add your handling code here:
        btn_carrinho.setBackground(new java.awt.Color(16,187,211));
    }//GEN-LAST:event_btn_carrinhoMouseExited

    private void btn_sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseEntered
        // TODO add your handling code here:
        btn_sair.setBackground(new java.awt.Color(93,194,176));
    }//GEN-LAST:event_btn_sairMouseEntered

    private void btn_sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseExited
        // TODO add your handling code here:
        btn_sair.setBackground(new java.awt.Color(16,187,211));
    }//GEN-LAST:event_btn_sairMouseExited
    private void pequenoBug(){
        int x = this.getHeight();
            int y = this.getWidth();
            this.setSize(y - 1, x - 1);
            this.setSize(y, x);
    }
    
    public void habilitarCliente() {
        btn_pedidos.setEnabled(true);
        btn_sair.setEnabled(true);
    }
    
    public void desabilitarCliente() {
        btn_pedidos.setEnabled(false);
        btn_sair.setEnabled(false);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_carrinho;
    private javax.swing.JButton btn_ok;
    private static javax.swing.JButton btn_pedidos;
    private static javax.swing.JButton btn_pedidos2;
    private static javax.swing.JButton btn_pedidos3;
    private static javax.swing.JButton btn_sair;
    private javax.swing.JComboBox<String> cmb_categoria;
    private javax.swing.JComboBox<String> cmb_criterios;
    private javax.swing.JComboBox<String> cmb_digitais;
    private javax.swing.JComboBox<String> cmb_livros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_restrito;
    private javax.swing.JPanel pn_pai;
    private javax.swing.JScrollPane scroll_15;
    private javax.swing.JTextField txt_palChave;
    // End of variables declaration//GEN-END:variables
}
