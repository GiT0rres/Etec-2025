package com.mycompany.giovannads;
import javax.swing.JOptionPane;
public class Calculadora {
    private double n1;
    private double n2;
    private double r;
    
    public Calculadora(){
        this(0,0,0);
    }
    public Calculadora(double n1, double n2, double r){
        this.n1 = n1;
        this.n2 = n2;
        this.r = r;
    }
    

    // GETTERS
    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public double getR() {
        return r;
    }

    // SETTERS
    public void setN1(double n1) {
        this.n1 = n1;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void somar() {
        setN1(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro n�mero:")));
        setN2(Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:")));
        setR(getN1()+getN2());
        JOptionPane.showMessageDialog(null, "O valor da soma é igual á: "+getR());
    }

    public void subtrair(double a, double b) {
        setN1(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:")));
        setN2(Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:")));
        setR(getN1()-getN2());
    }

    public double multiplicar() {
        return n1 * n2;
    }

    public double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro: divisão por zero!");
            return 0;
        }
    }
} 