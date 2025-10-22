public class MatrizCaracter {
    public static void main(String[] args) {
       
        int[][] figuraA = {
               {1, 1, 1, 1, 1},
               {1, 1, 1, 1, 1},
               {1, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
         }; System.out.println();
        desenharFigura(figuraA); 
 
        
        int[][] figuraB = {
               {1, 1, 1, 1, 1},
               {1, 0, 0, 0, 1},
               {1, 0, 0, 0, 1},
               {1, 1, 1, 1, 1},
        };System.out.println();
        desenharFigura(figuraB);

        int[][] figuraC = {
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1}
        };System.out.println();
        desenharFigura(figuraC);
    }

    public static void desenharFigura(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}