import javax.swing.JOptionPane;

public class NumeroDecrescente {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite um número inteiro:"));
        String resultado = "Ordem decrescente:\n";
        for (int i = num; i >= 0; i--) {
            resultado += i + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}