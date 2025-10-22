import javax.swing.JOptionPane;

public class TrocaNumero {

    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1° número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2° número:"));

        JOptionPane.showMessageDialog(null, "Antes da troca:\nNúmero 1°: " + num1 + "\nNúmero 2°: " + num2);

        int troca = num1;
        num1 = num2;
        num2 = troca;

        JOptionPane.showMessageDialog(null, "Depois da troca:\nNúmero 1°: " + num1 + "\nNúmero 2°: " + num2);
    }
}