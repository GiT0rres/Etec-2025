 /*Alt+S = soma, Alt+L = limpar, Alt+E = sair**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioCalculadora extends JFrame {

    private JTextField txtN1, txtN2;
    private JLabel lblResultado, lblTituloResultado, lblN1, lblN2;
    private JButton btnSoma, btnSub, btnMult, btnDiv, btnLimpar,
            btnHabilitar, btnDesabilitar, btnOcultar, btnExibir, btnSair;
    private Calculadora calc;

    public FormularioCalculadora() {
        super("Calculadora - Giovanna Alves Martins Torres");

        calc = new Calculadora();

        Container tela = getContentPane();
        setLayout(null);

        JLabel lblN1 = new JLabel("1º Número:");
        JLabel lblN2 = new JLabel("2º Número:");
        lblTituloResultado = new JLabel("Resultado:");
        lblResultado = new JLabel("");

        txtN1 = new JTextField(10);
        txtN2 = new JTextField(10);

        btnSoma = new JButton("+");
        btnSub = new JButton("-");
        btnMult = new JButton("*");
        btnDiv = new JButton("/");
        btnLimpar = new JButton("Limpar");
        btnHabilitar = new JButton("Habilitar");
        btnDesabilitar = new JButton("Desabilitar");
        btnOcultar = new JButton("Ocultar");
        btnExibir = new JButton("Exibir");
        btnSair = new JButton("Sair");

        // Atalhos
        btnSoma.setMnemonic(KeyEvent.VK_S);
        btnLimpar.setMnemonic(KeyEvent.VK_L);
        btnSair.setMnemonic(KeyEvent.VK_E);

        JLabel lblRodape = new JLabel("Desenvolvido por: Giovanna Alves Martins Torres - 2ºDS AMS");

        lblN1.setBounds(30, 30, 80, 20);
        txtN1.setBounds(120, 30, 100, 20);
        lblN2.setBounds(30, 60, 80, 20);
        txtN2.setBounds(120, 60, 100, 20);
        lblTituloResultado.setBounds(30, 90, 80, 20);
        lblResultado.setBounds(120, 90, 200, 20);
        lblRodape.setBounds(30, 370, 400, 20);

        int y = 130;
        btnSoma.setBounds(30, y, 50, 25);
        btnSub.setBounds(90, y, 50, 25);
        btnMult.setBounds(150, y, 50, 25);
        btnDiv.setBounds(210, y, 50, 25);

        btnLimpar.setBounds(30, y += 40, 100, 25);
        btnHabilitar.setBounds(140, y, 100, 25);

        btnDesabilitar.setBounds(30, y += 40, 100, 25);
        btnOcultar.setBounds(140, y, 100, 25);

        btnExibir.setBounds(30, y += 40, 100, 25);
        btnSair.setBounds(140, y, 100, 25);

        btnSoma.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        calc.setN1(Double.parseDouble(txtN1.getText()));
                        calc.setN2(Double.parseDouble(txtN2.getText()));
                        calc.somar();
                        lblResultado.setText(""+ calc.getR());
                    }
                }
        );
        btnSub.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        double a = Double.parseDouble(txtN1.getText());
                        double b = Double.parseDouble(txtN2.getText());
                        calc.setN1(a);
                        calc.setN2(b);
                        calc.subtrair(a, b);
                        lblResultado.setText(""+ calc.getR());
                    }
                }
        );

        btnMult.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                         calc.setN1(Double.parseDouble(txtN1.getText()));
                        calc.setN2(Double.parseDouble(txtN2.getText()));
                        calc.multiplicar();
                        lblResultado.setText(""+ calc.getR());
                    }
                }
        );
        
         btnDiv.addActionListener(
               new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        double a = Double.parseDouble(txtN1.getText());
                        double b = Double.parseDouble(txtN2.getText());
                        calc.setN1(a);
                        calc.setN2(b);
                        calc.dividir(a, b);
                        lblResultado.setText(""+ calc.getR());
                    }
                }
        );
        
        btnLimpar.addActionListener(e -> {
            txtN1.setText("");
            txtN2.setText("");
            lblResultado.setText("");
            txtN1.requestFocus();
        });

        btnHabilitar.addActionListener(e -> {
            lblResultado.setEnabled(true);
            lblTituloResultado.setEnabled(true);
        });

        btnDesabilitar.addActionListener(e -> {
            lblResultado.setEnabled(false);
            lblTituloResultado.setEnabled(false);
        });

        btnOcultar.addActionListener(e -> {
            lblResultado.setVisible(false);
            lblTituloResultado.setVisible(false);
        });

        btnExibir.addActionListener(e -> {
            lblResultado.setVisible(true);
            lblTituloResultado.setVisible(true);
        });

        btnSair.addActionListener(e -> System.exit(0));

        tela.add(lblN1); tela.add(txtN1);
        tela.add(lblN2); tela.add(txtN2);
        tela.add(lblTituloResultado); tela.add(lblResultado);
        tela.add(btnSoma); tela.add(btnSub);
        tela.add(btnMult); tela.add(btnDiv);
        tela.add(btnLimpar); tela.add(btnHabilitar);
        tela.add(btnDesabilitar); tela.add(btnOcultar);
        tela.add(btnExibir); tela.add(btnSair);
        tela.add(lblRodape);

        setSize(400, 450);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        new FormularioCalculadora();
    }
}
