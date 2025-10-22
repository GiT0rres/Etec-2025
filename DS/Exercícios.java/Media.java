import javax.swing.JOptionPane;

public class Media {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Bem-vindo, aluno! Por favor, digite seu nome:");
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1° nota:"));
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2° nota:"));
        double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 3° nota:"));
        double nota4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 4° nota:"));
        double mediafinal = (nota1 + nota2 + nota3 + nota4) / 4;
        JOptionPane.showMessageDialog(null, "Nome do aluno: " + nome + "\nMédia: " + mediafinal);
    }
}