import javax.swing.JOptionPane;

public class OrganizarNumero {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1° número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2° número:"));
        int num3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 3° número:"));
        int maior = num1;
        if (num2 > maior) {
            maior = num2;
        }
        if (num3 > maior) {
            maior = num3;
        }
        int menor = num1;
        if (num2 < menor) {
            menor = num2;
        }
        if (num3 < menor) {
            menor = num3;
        }
        int meio = num1;
        if (num2 > menor && num2 < maior) {
            meio = num2;
        }
        if (num3 > menor && num3 < maior) {
            meio = num3;
        }
        String resultado = "Ordem decrescente: " + maior + ", " + meio + ", " + menor;
        JOptionPane.showMessageDialog(null, resultado);
    }
}