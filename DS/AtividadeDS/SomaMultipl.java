import javax.swing.JOptionPane;
public class SomaMultipl {
    public static void main(String[] args) {
        int somaImpar = 0;
        long multPar = 1;
        long par = 0;
        for (int i = 0; i <= 30; i++) {
            if (i % 2 == 0) { 
                if (i >= 2) {
                    multPar = multPar * i; 
                } else {
                    par = 0;
                }
            } else {
                somaImpar += i;
            }
        }
        multPar = Math.abs(multPar);
        JOptionPane.showMessageDialog(null, "Soma dos ímpares: " + somaImpar + "\nMultiplicação dos pares: " + multPar);
    }
}



