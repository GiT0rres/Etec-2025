import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Formulario1 extends JFrame {
    JTextField txtNome, txtMatricula;
    JRadioButton rbtnEtim, rbtnMtec, rbtnTecnico;
    JRadioButton rbtn1, rbtn2, rbtn3;
    JComboBox<String> cboPeriodo, cboCursoNome;
    JTextArea txtRestricoes;
    JButton btnApresentar, btnLimpar, btnSair;
    ButtonGroup grupoCurso, grupoSerie;

    public Formulario1() {
        setTitle("Dados Cadastrais do Aluno");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 229, 255));

        JLabel lblTitulo = new JLabel("Dados Cadastrais do Aluno");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 51, 153));
        lblTitulo.setBounds(180, 10, 300, 30);
        add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 60, 100, 20);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 60, 400, 22);
        add(txtNome);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(30, 90, 100, 20);
        add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(130, 90, 200, 22);
        add(txtMatricula);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(30, 120, 100, 20);
        add(lblCurso);

        rbtnEtim = new JRadioButton("Etim");
        rbtnMtec = new JRadioButton("Mtec");
        rbtnTecnico = new JRadioButton("Técnico");

        grupoCurso = new ButtonGroup();
        grupoCurso.add(rbtnEtim);
        grupoCurso.add(rbtnMtec);
        grupoCurso.add(rbtnTecnico);

        rbtnEtim.setBounds(130, 120, 70, 20);
        rbtnMtec.setBounds(210, 120, 70, 20);
        rbtnTecnico.setBounds(290, 120, 80, 20);

        add(rbtnEtim);
        add(rbtnMtec);
        add(rbtnTecnico);

        JLabel lblSerie = new JLabel("Série:");
        lblSerie.setBounds(390, 120, 50, 20);
        add(lblSerie);

        rbtn1 = new JRadioButton("1ª");
        rbtn2 = new JRadioButton("2ª");
        rbtn3 = new JRadioButton("3ª");

        grupoSerie = new ButtonGroup();
        grupoSerie.add(rbtn1);
        grupoSerie.add(rbtn2);
        grupoSerie.add(rbtn3);

        rbtn1.setBounds(440, 120, 45, 20);
        rbtn2.setBounds(490, 120, 45, 20);
        rbtn3.setBounds(540, 120, 45, 20);

        add(rbtn1);
        add(rbtn2);
        add(rbtn3);

        JLabel lblPeriodo = new JLabel("Período:");
        lblPeriodo.setBounds(30, 150, 100, 20);
        add(lblPeriodo);

        cboPeriodo = new JComboBox<>(new String[]{"Matutino", "Vespertino", "Noturno"});
        cboPeriodo.setBounds(130, 150, 150, 22);
        add(cboPeriodo);

        JLabel lblCursoNome = new JLabel("Curso Nome:");
        lblCursoNome.setBounds(310, 150, 100, 20);
        add(lblCursoNome);

        cboCursoNome = new JComboBox<>(new String[]{"Enfermagem", "Logística", "Advocacia", "Pedagogia"});
        cboCursoNome.setBounds(410, 150, 120, 22);
        add(cboCursoNome);

        JLabel lblRestricoes = new JLabel("Restrições Médicas:");
        lblRestricoes.setBounds(30, 180, 150, 20);
        add(lblRestricoes);

        txtRestricoes = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtRestricoes);
        scroll.setBounds(30, 210, 500, 70);
        add(scroll);

        btnApresentar = new JButton("Apresentar Dados");
        btnApresentar.setBounds(50, 300, 160, 30);
        add(btnApresentar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(230, 300, 100, 30);
        add(btnLimpar);

        btnSair = new JButton("Sair");
        btnSair.setBounds(350, 300, 100, 30);
        add(btnSair);

        JLabel lblFooter = new JLabel("Feito por: Giovanna Torres - 2ºAMS");
        lblFooter.setFont(new Font("Arial", Font.ITALIC, 12));
        lblFooter.setBounds(180, 360, 300, 20);
        add(lblFooter);

        btnApresentar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String matricula = txtMatricula.getText();
                String curso = rbtnEtim.isSelected() ? "Etim" :
                               rbtnMtec.isSelected() ? "Mtec" :
                               rbtnTecnico.isSelected() ? "Técnico" : "";

                String serie = rbtn1.isSelected() ? "1ª série" :
                               rbtn2.isSelected() ? "2ª série" :
                               rbtn3.isSelected() ? "3ª série" : "";

                String periodo = (String) cboPeriodo.getSelectedItem();
                String cursoNome = (String) cboCursoNome.getSelectedItem();
                String restricoes = txtRestricoes.getText();

                Formulario2 form2 = new Formulario2(nome, matricula, curso, serie, periodo, cursoNome, restricoes);
                form2.setVisible(true);
                dispose();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtMatricula.setText("");
                grupoCurso.clearSelection();
                grupoSerie.clearSelection();
                cboPeriodo.setSelectedIndex(0);
                cboCursoNome.setSelectedIndex(0);
                txtRestricoes.setText("");
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
