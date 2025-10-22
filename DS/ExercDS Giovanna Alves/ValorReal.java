package com.mycompany.exercds;
import javax.swing.JOptionPane;
        
public class ValorReal {
    public static void main (String[] args){
  double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o 1º valor real:"));
  double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o 2º valor real:"));
        
        diferenca(num1, num2);
    }
    public static void diferenca(double num1, double num2) {
 double resultado = num1 - num2 ; 
JOptionPane.showMessageDialog(null, "A diferença é de: " + resultado);
    }
}
