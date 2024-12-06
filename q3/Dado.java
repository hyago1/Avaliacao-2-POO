package q3;

import java.util.Random;

public class Dado {
    private int numeroQueCaiu;
   static final private int[] valores = {1,2,3,4,5,67,8,9,10,11,12}; 


    public int getNumeroQueCaiu() {
        return numeroQueCaiu;
    }



    public void jogarDado(){
        Random n = new Random();
        int valor = valores[n.nextInt(valores.length)];


        System.out.println();

         this.numeroQueCaiu = valor;
    }


    public boolean verificaValor(int valor){

        boolean igual = false;
        
        if (getNumeroQueCaiu() == valor) {

           igual = true;
           
        }
      return igual;
        
    }





    
}
