package com.mycompany.giovannads;

import javax.swing.JOptionPane;

public class PrincipalC {
    public static void main(String[] args) {
    Calculadora calc = new Calculadora();
    int opcao;
        
        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
            "Escolha a operação:\n" +
            "1 - Soma\n" +
            "2 - Subtração\n" +
            "3 - Multiplicação\n" +
            "4 - Divisão\n" +
            "0 - Sair"
            ));
            switch (opcao) {
                case 1:
                    calc.somar();
                    JOptionPane.showMessageDialog(null, "Resultado da soma: " + calc.getR());
                    break;

                case 2:
                    calc.subtrair(calc.getN1(), calc.getN2());
                    JOptionPane.showMessageDialog(null, "Resultado da subtração: " + calc.getR());
                    break;

                case 3:
                    double mult = calc.multiplicar();
                    JOptionPane.showMessageDialog(null, "Resultado da multiplicação: " + mult);
                    break;

                case 4:
                    calc.setR(calc.dividir(calc.getN1(), calc.getN2()));
                    JOptionPane.showMessageDialog(null, "Resultado da divisão: " + calc.getR());
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando Programa!");
                default:
                    JOptionPane.showMessageDialog(null, "Opcão inválida!");
            }
        }
        while (opcao != 0);
    }
}