import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import javax.swing.Timer;

public class Forms extends JFrame {
    private JTextField campoNome, campoIdade;
    private JRadioButton masculino, feminino;
    private ButtonGroup grupoSexo;
    private JCheckBox interesseAutomoveis, interesseBarcos, interesseAvioes;
    private JComboBox<String> comboEstadoCivil;
    private JButton btnEnviar, btnLimpar;
    Dados dados;
    private JLabel resultadoNome, resultadoIdade, resultadoSexo, resultadoInteresses, resultadoEstadoCivil;
    private JLabel dataHora, rodape;

    public Forms() {
        super("Formulário - Dados Pessoais");

        Container tela = getContentPane();
        tela.setLayout(null);
        dados = new Dados();

        Font fonteNegrito = new Font("Arial", Font.BOLD, 13);
        Font fonteNormal = new Font("Arial", Font.PLAIN, 13);

        // Nome
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(20, 20, 100, 20);
        campoNome = new JTextField();
        campoNome.setBounds(120, 20, 200, 20);

        // Idade
        JLabel labelIdade = new JLabel("Idade:");
        labelIdade.setBounds(20, 50, 100, 20);
        campoIdade = new JTextField();
        campoIdade.setBounds(120, 50, 200, 20);

        // Sexo
        JLabel labelSexo = new JLabel("Sexo:");
        labelSexo.setBounds(20, 80, 100, 20);
        masculino = new JRadioButton("Masculino");
        masculino.setBounds(120, 80, 100, 20);
        feminino = new JRadioButton("Feminino");
        feminino.setBounds(220, 80, 100, 20);
        grupoSexo = new ButtonGroup();
        grupoSexo.add(masculino);
        grupoSexo.add(feminino);

        // Interesses 
        JLabel labelInteresses = new JLabel("Interesses:");
        labelInteresses.setBounds(20, 110, 100, 20);
        interesseAutomoveis = new JCheckBox("Automóveis");
        interesseAutomoveis.setBounds(120, 110, 100, 20);
        interesseBarcos = new JCheckBox("Barcos");
        interesseBarcos.setBounds(220, 110, 100, 20);
        interesseAvioes = new JCheckBox("Aviões");
        interesseAvioes.setBounds(320, 110, 100, 20);

        // Estado Civil
        JLabel labelEstadoCivil = new JLabel("Estado Civil:");
        labelEstadoCivil.setBounds(20, 140, 100, 20);
        String[] estados = {"Selecionar", "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)"};
        comboEstadoCivil = new JComboBox<>(estados);
        comboEstadoCivil.setBounds(120, 140, 150, 20);

        // Botões
        btnEnviar = new JButton("Enviar os Dados");
        btnEnviar.setBounds(50, 180, 150, 30);
        btnEnviar.setMnemonic(KeyEvent.VK_E);
        btnEnviar.setToolTipText("Clique para enviar os dados");

        btnLimpar = new JButton("Limpar os Dados");
        btnLimpar.setBounds(220, 180, 150, 30);
        btnLimpar.setMnemonic(KeyEvent.VK_L);
        btnLimpar.setToolTipText("Clique para limpar os dados");

        // Resultados
        resultadoNome = new JLabel();
        resultadoNome.setBounds(20, 230, 440, 20);
        resultadoNome.setFont(fonteNegrito);

        resultadoIdade = new JLabel();
        resultadoIdade.setBounds(20, 250, 440, 20);
        resultadoIdade.setFont(fonteNegrito);

        resultadoSexo = new JLabel();
        resultadoSexo.setBounds(20, 270, 440, 20);
        resultadoSexo.setFont(fonteNegrito);

        resultadoInteresses = new JLabel();
        resultadoInteresses.setBounds(20, 290, 440, 20);
        resultadoInteresses.setFont(fonteNegrito);

        resultadoEstadoCivil = new JLabel();
        resultadoEstadoCivil.setBounds(20, 310, 440, 20);
        resultadoEstadoCivil.setFont(fonteNegrito);

        // Data e Hora
        dataHora = new JLabel();
        dataHora.setBounds(20, 340, 300, 20);
        dataHora.setFont(new Font("Arial", Font.ITALIC, 12));
        atualizarHora();

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarHora();
            }
        });
        timer.start();

        rodape = new JLabel("Desenvolvido por: Giovanna Alves Martins Torres - 2ºAMS");
        rodape.setBounds(20, 370, 450, 20);
        rodape.setFont(fonteNegrito);

        tela.add(labelNome); tela.add(campoNome);
        tela.add(labelIdade); tela.add(campoIdade);
        tela.add(labelSexo); tela.add(masculino); tela.add(feminino);
        tela.add(labelInteresses);
        tela.add(interesseAutomoveis); tela.add(interesseBarcos); tela.add(interesseAvioes);
        tela.add(labelEstadoCivil); tela.add(comboEstadoCivil);
        tela.add(btnEnviar); tela.add(btnLimpar);
        tela.add(resultadoNome); tela.add(resultadoIdade);
        tela.add(resultadoSexo); tela.add(resultadoInteresses);
        tela.add(resultadoEstadoCivil); tela.add(dataHora); tela.add(rodape);

        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirResultado();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        setSize(520, 440);
        setResizable(false);  
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void atualizarHora() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dataHora.setText("Data e Hora: " + sdf.format(c.getTime()));
    }

    private void exibirResultado() {
        String nome = campoNome.getText().trim();
        String idade = campoIdade.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o nome.");
            campoNome.requestFocus();
            return;
        }

         //*Para a validação da idade, eu utilizei o matches("\\d+")
        /* Serve para verificar se uma string inteira corresponde a um padrão definido
        /* No caso do meu código, eu quero que o forms aceite apenas NÚMEROS 
        /* \\d  qualquer dígito numérico (0-9)
        /* +  significa uma ou mais ocorrências
        /* Então irá aceitar strings como "25", "100", "8" e não aceita "vinte", "12a", ou vazio.
        */
        
        if (!idade.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Por favor, insira apenas números na idade.");
            campoIdade.requestFocus();
            return;
        }

        String estadoCivil = comboEstadoCivil.getSelectedItem().toString();
        if (estadoCivil.equals("Selecionar")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione o estado civil.");
            comboEstadoCivil.requestFocus();
            return;
        }

        dados.setNome(nome);
        dados.setIdade(Integer.parseInt(idade));

        String sexo = masculino.isSelected() ? "Masculino" :
                      feminino.isSelected() ? "Feminino" : "Não informado";
        dados.setSexo(sexo);

        String interesses = "";
        if (interesseAutomoveis.isSelected()) interesses += "Automóveis, ";
        if (interesseBarcos.isSelected()) interesses += "Barcos, ";
        if (interesseAvioes.isSelected()) interesses += "Aviões, ";
        if (!interesses.isEmpty()) interesses = interesses.substring(0, interesses.length() - 2);
        dados.setInteresses(interesses);

        dados.setEstadoCivil(estadoCivil);

        resultadoNome.setText("Nome: " + dados.getNome());
        resultadoIdade.setText("Idade: " + dados.getIdade());
        resultadoSexo.setText("Sexo: " + dados.getSexo());
        resultadoInteresses.setText("Interesses: " + dados.getInteresses());
        resultadoEstadoCivil.setText("Estado Civil: " + dados.getEstadoCivil());
    }

    private void limparCampos() {
        campoNome.setText("");
        campoIdade.setText("");
        grupoSexo.clearSelection();
        interesseAutomoveis.setSelected(false);
        interesseBarcos.setSelected(false);
        interesseAvioes.setSelected(false);
        comboEstadoCivil.setSelectedIndex(0);

        resultadoNome.setText("");
        resultadoIdade.setText("");
        resultadoSexo.setText("");
        resultadoInteresses.setText("");
        resultadoEstadoCivil.setText("");
    }

    public static void main(String[] args) {
        Forms formulario = new Forms();
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
