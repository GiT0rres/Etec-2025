import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuCalculadoraApp extends JFrame {
    private JMenuBar barraMenu;
    private JMenu menuOperacoes, menuSobre, menuSair;
    private JMenuItem itemSomar, itemSubtrair, itemMultiplicar, itemDividir, itemSobre, itemSair;
    private JToolBar barraFerramentas;
    private JButton btnSomar, btnSubtrair, btnMultiplicar, btnDividir, btnSair;
    private JPopupMenu popupMenu;

    public MenuCalculadoraApp() {
        super("Menu Calculadora App");
        Container tela = getContentPane();
        tela.setLayout(new BorderLayout()); 
        setResizable(false); 

     
        String icones[] = {
            "imagens/mais.png",     // índice 0 - Somar
            "imagens/menos.png",    // índice 1 - Subtrair
            "imagens/vezes.png",    // índice 2 - Multiplicar
            "imagens/div.png"       // índice 3 - Dividir
        };

        ImageIcon imagens[] = new ImageIcon[icones.length];
        for (int i = 0; i < icones.length; i++) {
            Image img = new ImageIcon(icones[i]).getImage();
            Image imgReduzida = img.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            imagens[i] = new ImageIcon(imgReduzida);
        }

        // Menu
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        menuOperacoes = new JMenu("Operações");
        menuSobre = new JMenu("Sobre");
        menuSair = new JMenu("Sair");
        barraMenu.add(menuOperacoes);
        barraMenu.add(menuSobre);
        barraMenu.add(menuSair);

        itemSomar = new JMenuItem("Somar");
        itemSubtrair = new JMenuItem("Subtrair");
        itemMultiplicar = new JMenuItem("Multiplicar");
        itemDividir = new JMenuItem("Dividir");
        itemSobre = new JMenuItem("Sobre");
        itemSair = new JMenuItem("Sair");

        menuOperacoes.add(itemSomar);
        menuOperacoes.add(itemSubtrair);
        menuOperacoes.add(itemMultiplicar);
        menuOperacoes.add(itemDividir);
        menuSobre.add(itemSobre);
        menuSair.add(itemSair);


        barraFerramentas = new JToolBar("Ferramentas");
        barraFerramentas.setFloatable(true);
        barraFerramentas.setOrientation(SwingConstants.VERTICAL);

        btnSomar = new JButton(imagens[0]);
        btnSomar.setToolTipText("Somar");

        btnSubtrair = new JButton(imagens[1]);
        btnSubtrair.setToolTipText("Subtrair");

        btnMultiplicar = new JButton(imagens[2]);
        btnMultiplicar.setToolTipText("Multiplicar");

        btnDividir = new JButton(imagens[3]);
        btnDividir.setToolTipText("Dividir");

        btnSair = new JButton("Sair");

        barraFerramentas.add(btnSomar);
        barraFerramentas.add(btnSubtrair);
        barraFerramentas.add(btnMultiplicar);
        barraFerramentas.add(btnDividir);
        barraFerramentas.add(btnSair);

        tela.add(barraFerramentas, BorderLayout.WEST);

        // Popup Menu
        popupMenu = new JPopupMenu();
        JMenuItem popSobre = new JMenuItem("Sobre");
        JMenuItem popSair = new JMenuItem("Sair");
        popupMenu.add(popSobre);
        popupMenu.add(popSair);

        tela.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

       
        itemSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Somar");
            }
        });

        itemSubtrair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Subtrair");
            }
        });

        itemMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Multiplicar");
            }
        });

        itemDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Dividir");
            }
        });

        btnSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Somar");
            }
        });

        btnSubtrair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Subtrair");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Multiplicar");
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaOperacao(MenuCalculadoraApp.this, "Dividir");
            }
        });

        itemSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarSobre();
            }
        });

        popSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarSobre();
            }
        });

        itemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sairApp();
            }
        });

        popSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sairApp();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sairApp();
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarSobre() {
        JOptionPane.showMessageDialog(this, "Nome: Giovanna Alves\nTurma: 2ºAMS\nData: 26/06/2025", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sairApp() {
        int op = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) System.exit(0);
    }

    public static void main(String[] args) {
        new MenuCalculadoraApp();
    }
}

class JanelaOperacao extends JDialog {
    private JTextField txt1, txt2;
    private JLabel lblResultado;
    private JButton btnCalcular, btnLimpar;

    public JanelaOperacao(Frame owner, String operacao) {
        super(owner, operacao, true);
        setLayout(null);

        JLabel lbl1 = new JLabel("1º Número:");
        JLabel lbl2 = new JLabel("2º Número:");
        lblResultado = new JLabel();
        txt1 = new JTextField();
        txt2 = new JTextField();
        btnCalcular = new JButton(operacao);
        btnLimpar = new JButton("Limpar");

        lbl1.setBounds(20, 20, 80, 20);
        txt1.setBounds(100, 20, 100, 20);
        lbl2.setBounds(20, 50, 80, 20);
        txt2.setBounds(100, 50, 100, 20);
        btnCalcular.setBounds(30, 90, 100, 25);
        btnLimpar.setBounds(150, 90, 100, 25);
        lblResultado.setBounds(20, 130, 250, 20);

        add(lbl1);
        add(txt1);
        add(lbl2);
        add(txt2);
        add(btnCalcular);
        add(btnLimpar);
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular(operacao);
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    private void calcular(String op) {
        try {
            double n1 = Double.parseDouble(txt1.getText());
            double n2 = Double.parseDouble(txt2.getText());
            double resultado = 0;
            if (op.equals("Somar")) resultado = n1 + n2;
            else if (op.equals("Subtrair")) resultado = n1 - n2;
            else if (op.equals("Multiplicar")) resultado = n1 * n2;
            else if (op.equals("Dividir")) resultado = (n2 != 0) ? n1 / n2 : 0;
            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            lblResultado.setText("Digite valores válidos.");
        }
    }

    private void limpar() {
        txt1.setText("");
        txt2.setText("");
        lblResultado.setText("");
        txt1.requestFocus();
    }
}
