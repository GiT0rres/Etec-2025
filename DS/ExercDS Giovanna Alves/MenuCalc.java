package com.mycompany.exercds;
import javax.swing.JOptionPane;

public class MenuCalc {
    public static void main(String[] args) {
        while (true) {
            String menu = "1 - Soma\n" +
                          "2 - Subtração\n" +
                          "3 - Divisão\n" +
                          "4 - Multiplicação\n" +
                          "5 - Resto da Divisão\n" +
                          "6 - Dobro\n" +
                          "7 - Quadrado\n" +
                          "8 - Cubo\n" +
                          "9 - Raiz Quadrada\n" +
                          "0 - Sair";
            
            String input = JOptionPane.showInputDialog(null, menu);
            int opcao = Integer.parseInt(input);

            if (opcao != 0) {
      double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
      double num2 = 0;
 if (opcao != 6 && opcao != 7 && opcao != 8 && opcao != 9) {
  num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
       }
  double resultado = calcular(opcao, num1, num2);
  if (opcao != 0) {
          JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
       }
            } else {
                break;
            }
        }
    } public static double calcular(int opcao, double num1, double num2) {
        double resultado = 0;

        if (opcao == 1) {
            resultado = num1 + num2;
        }
        else if (opcao == 2) {
            resultado = num1 - num2;
        }
        else if (opcao == 3) {
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!");
            }
        }
        else if (opcao == 4) {
            resultado = num1 * num2;
        }
        else if (opcao == 5) {
            resultado = num1 % num2;
        }
        else if (opcao == 6) {
            resultado = num1 * 2;
        }
        else if (opcao == 7) {
            resultado = Math.pow(num1, 2);
        }
        else if (opcao == 8) {
            resultado = Math.pow(num1, 3);
        }
        else if (opcao == 9) {
            if (num1 >= 0) {
                resultado = Math.sqrt(num1);
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Não é possível calcular a raiz quadrada de um número negativo!");
            }
        }
        else if (opcao == 0) {
            JOptionPane.showMessageDialog(null, "Saindo...");
            System.exit(0);
        }
        return resultado;
    }
        }

