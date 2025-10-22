package Prova;

import javax.swing.JOptionPane;

public class ParteDois {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Bem Vindo! Digite o nome do aluno:");
        double nota1 = lerNota("Digite a 1º nota:");
        double nota2 = lerNota("Digite a 2º nota:");
        double nota3 = lerNota("Digite a 3º nota:");
        double nota4 = lerNota("Digite a 4º nota:");
        
        double media = calcularMedia(nota1, nota2, nota3, nota4);
        
        double maiorNota = encontrarMaiorNota(nota1, nota2, nota3, nota4);
        double menorNota = encontrarMenorNota(nota1, nota2, nota3, nota4);
        
        String situacao = (media >= 7.0) ? "Parabéns! Você foi aprovado." : "Sinto muito! Você foi reprovado.";
        
        JOptionPane.showMessageDialog(null, "Aluno: " + nome + 
                                          "\nMédia: " + String.format("%.1f", media) + 
                                          "\nSituação: " + situacao +
                                          "\nMaior Nota: " + maiorNota +
                                          "\nMenor Nota: " + menorNota);
    }

    public static double lerNota(String mensagem) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
    }

    public static double calcularMedia(double nota1, double nota2, double nota3, double nota4) {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }
    
    public static double encontrarMaiorNota(double nota1, double nota2, double nota3, double nota4) {
        double maior = nota1;
        if (nota2 > maior) maior = nota2;
        if (nota3 > maior) maior = nota3;
        if (nota4 > maior) maior = nota4;
        return maior;
    }
    
    public static double encontrarMenorNota(double nota1, double nota2, double nota3, double nota4) {
        double menor = nota1;
        if (nota2 < menor) menor = nota2;
        if (nota3 < menor) menor = nota3;
        if (nota4 < menor) menor = nota4;
        return menor;
    }
}
