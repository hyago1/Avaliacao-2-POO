package q2;
import java.util.Scanner;

import q2.*;
public class Principal {


    public static int[][] sala(int pos []){
        int[][] sala = new int[20][40];
        sala[pos[0]][pos[1]] = 1;


        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j]);
                if (j == 39) {
                    System.out.println("");
                }
            }
        }
           
        
        
        return sala;
        
    }

    public static void main(String[] args) {
        

        menu();
   
            
    }

    public static void menu(){
        Robo R1 = new Robo(0,0,3);
        int n = 0;
        Scanner in = new Scanner(System.in);
        while (n !=5) {

            sala(R1.mostrarPosicaoAtual());


            System.out.println(" ----  Menu ----");
            System.out.println("1 Andar Frente");
            System.out.println("2 Andar Atras");
            System.out.println("3 Andar Direita");
            System.out.println("4 Andar Esquerta");
            System.out.println("5 Sair");
            int op = in.nextInt(); 
            switch (op) {
                case 1:
                    R1.andarFrente();
                    break;
            
                    case 2:
                    R1.andarTras();
                    break;
            
                    case 3:
                    R1.andarDireita();
                    break;
            
                    case 4:
                    R1.andarEsquerda();
                    break;

                    case 5:
                    n = 5;
                    break;
            
                    default:

                    menu();

                    break;
            }
        }
        System.out.println();


    }




}
