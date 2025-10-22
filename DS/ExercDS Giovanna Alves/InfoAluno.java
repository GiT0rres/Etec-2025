package com.mycompany.exercds;
import javax.swing.JOptionPane;

public class InfoAluno {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Bem Vindo! Digite o nome do aluno:");
        double nota1 = lerNota("Digite a 1º nota:");
        double nota2 = lerNota("Digite a 2º nota:");
        
        double media = calcularMedia(nota1, nota2);
 String situacao = (media >= 7.0) ? "Parabéns! Você foi aprovado." : "Sinto muito! Você foi reprovado.";
 JOptionPane.showMessageDialog(null, "Aluno: " + nome + "\nMédia: " + String.format("%.2f", media) + "\nSituação: " + situacao);
    }

    public static double lerNota(String mensagem) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
    }

    public static double calcularMedia(double nota1, double nota2) {
        return (nota1 + nota2) / 2;
    }
}
