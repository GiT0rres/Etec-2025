package com.mycompany.exercds;
import javax.swing.JOptionPane;

public class Dados {
    
    public static void main(String[] args) {
        String hStr = JOptionPane.showInputDialog("Digite sua altura (ex: 1.60):");
        double h = Double.parseDouble(hStr);
        
        String sexoStr = JOptionPane.showInputDialog("Digite seu sexo (M para masculino, F para feminino):");
        char sexo = sexoStr.charAt(0);
        
        double pesoIdeal = calcularPesoIdeal(sexo, h);
        
        if (pesoIdeal == -1) {
            JOptionPane.showMessageDialog(null, "Sexo inválido! Por favor, insira M ou F.");
        } else {
            JOptionPane.showMessageDialog(null, "Seu peso ideal é: " + String.format("%.2f", pesoIdeal) + " kg");
        }
    }
    public static double calcularPesoIdeal(char sexo, double h) {
        if (sexo == 'M' || sexo == 'm') {
            return (72.7 * h) - 58;
        } else 
            if (sexo == 'F' || sexo == 'f') {
            return (62.1 * h) - 44.7;
        } else {
            return -1; 
        }
    }    
}
