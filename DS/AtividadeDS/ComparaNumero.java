import javax.swing.JOptionPane;

public class ComparaNumero {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1° número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2° número:"));
        if (num1 == num2) {
            JOptionPane.showMessageDialog(null, "Os números são iguais.");
        } else {
            JOptionPane.showMessageDialog(null, "Os números são diferentes.");
            if (num1 > num2) {
                JOptionPane.showMessageDialog(null, "O maior número é: " + num1 + "\nO menor número é: " + num2);
            } else {
                JOptionPane.showMessageDialog(null, "O maior número é: " + num2 + "\nO menor número é: " + num1);
            }
        }
    }
}