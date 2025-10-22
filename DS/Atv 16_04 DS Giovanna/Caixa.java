import javax.swing.JOptionPane;
public class Caixa {

   
    public double getSaldo() {
        return saldo;
    }

    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    private double saldo;
        
   public Caixa() {
       this(0);
   }
    
    public Caixa (double saldo) {
        this.saldo = saldo;
      }
public void entrar() {
double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da entrada: "));
this.setSaldo(this.saldo + valor);
}  
public void retirar() {
double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da retirada: "));
this.setSaldo(this.saldo - valor);
}
}
        