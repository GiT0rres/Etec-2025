package com.mycompany.exercds;
import javax.swing.JOptionPane;

public class ContarDias {
    public static void main(String[] args) {
        String mesStr = JOptionPane.showInputDialog("Digite o número do mês:");
        String anoStr = JOptionPane.showInputDialog("Digite o ano:");

        try {
            int mes = Integer.parseInt(mesStr);
            int ano = Integer.parseInt(anoStr);

            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Mês inválido. Digite um número entre 1 e 12.");
            } else {
                int dias = diasNoMes(mes, ano);
                JOptionPane.showMessageDialog(null, "O mês " + mes + " do ano " + ano + " tem " + dias + " dias.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Digite números inteiros para o mês e o ano.");
        }
    }
    public static boolean isBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
    public static int diasNoMes(int mes, int ano) {
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            return 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else if (mes == 2) {
            return isBissexto(ano) ? 29 : 28;
        } else {
            return -1; 
        }
    }
}

