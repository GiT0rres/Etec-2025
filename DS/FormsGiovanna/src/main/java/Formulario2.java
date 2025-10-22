import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Formulario2 extends JFrame {
    public Formulario2(String nome, String matricula, String curso, String serie, String periodo, String cursoNome, String restricoes) {
        setTitle("Apresentação dos Dados");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 229, 255));

        JLabel lblNome = new JLabel("Nome: " + nome);
        lblNome.setBounds(30, 30, 400, 20);
        add(lblNome);

        JLabel lblMatricula = new JLabel("Matrícula: " + matricula);
        lblMatricula.setBounds(30, 55, 400, 20);
        add(lblMatricula);

        JLabel lblCurso = new JLabel("Curso: " + curso);
        lblCurso.setBounds(30, 80, 400, 20);
        add(lblCurso);

        JLabel lblCursoNome = new JLabel("Curso Nome: " + cursoNome);
        lblCursoNome.setBounds(30, 105, 400, 20);
        add(lblCursoNome);

        JLabel lblSerie = new JLabel("Série: " + serie);
        lblSerie.setBounds(30, 130, 400, 20);
        add(lblSerie);

        JLabel lblPeriodo = new JLabel("Período: " + periodo);
        lblPeriodo.setBounds(30, 155, 400, 20);
        add(lblPeriodo);

        JLabel lblRestricoes = new JLabel("Restrições Médicas: " + restricoes);
        lblRestricoes.setBounds(30, 180, 440, 20);
        add(lblRestricoes);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(120, 230, 100, 30);
        add(btnVoltar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(260, 230, 100, 30);
        add(btnSair);

        JLabel lblFooter = new JLabel("Feito por: Giovanna Torres - 2ºAMS");
        lblFooter.setFont(new Font("Arial", Font.ITALIC, 12));
        lblFooter.setBounds(140, 280, 300, 20);
        add(lblFooter);

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Formulario1().setVisible(true);
                dispose();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
