package com.mycompany.exercds;
import javax.swing.JOptionPane;

public class CalcHip {
    public static void main(String[] args) {
        String baseStr = JOptionPane.showInputDialog("Digite o valor da base:");
        String alturaStr = JOptionPane.showInputDialog("Digite o valor da altura:");
        double base = Double.parseDouble(baseStr);
        double altura = Double.parseDouble(alturaStr);
        double resultado = hipotenusa(base, altura);
        JOptionPane.showMessageDialog(null, "O valor da hipotenusa é: " + resultado);
    }
    public static double hipotenusa(double base, double altura) {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }
}

