 import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Pessoa {
    private String nome;
    private String endereco;
    private double salario;
    private String telefone;
    private String email;

    public Pessoa() {
        this("", "", 0.0, "", "");
    }

    public Pessoa(String nome, String endereco, double salario, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void inserirDadosPessoa() {
        nome = JOptionPane.showInputDialog("Digite seu nome: ");
        endereco = JOptionPane.showInputDialog("Digite seu endereço: ");
        
        String salarioStr = JOptionPane.showInputDialog("Digite seu salário: ");
        try {
            salario = Double.parseDouble(salarioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor de salário inválido. Definido como 0.0");
            salario = 0.0;
        }

        telefone = JOptionPane.showInputDialog("Digite seu número de telefone: ");
        email = JOptionPane.showInputDialog("Digite seu email: ");
    }

    public void apresentarPessoa() {
        DecimalFormat df = new DecimalFormat("#0.00");
        JOptionPane.showMessageDialog(null, "Seu nome é: " + nome);
        JOptionPane.showMessageDialog(null, "Seu endereço é: " + endereco);
        JOptionPane.showMessageDialog(null, "Seu salário é: R$ " + df.format(salario));
        JOptionPane.showMessageDialog(null, "Seu telefone é: " + telefone);
        JOptionPane.showMessageDialog(null, "Seu email é: " + email);
    }
}
