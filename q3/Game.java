package q3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {
   private static final String ARQUIVO = "q3/1dados.txt";
   private final static int numMinDejogadores = 11;
   static Map<Player, Integer> ranking = new HashMap<Player, Integer>();
   static ArrayList<Player> Players = new ArrayList<>();
   static boolean maquinaGanhou = true;
   static int  posi = 1;
   
   public static void main(String[] args) {
      menu();
   }

   static public void menu() {
      Scanner in = new Scanner(System.in);
      System.out.println();
         System.out.println("**     - JOGO DO DADO -      **");
         System.out.println();
         System.out.println();
         System.out.println("   --------  Menu ---------   ");
         System.out.println();
         System.out.println("Digite o numero de jogadores");
         int numDePlayers = in.nextInt();

         if (numDePlayers <= numMinDejogadores) {
            Scanner in2 = new Scanner(System.in);

            for (int i = 0; i < numDePlayers; i++) {
               System.out.println(" -------------------------- ");
               System.out.println("Digite o nome do jogador " + (i + 1));
               String nome = in2.nextLine();
               System.out.println("Digite o valor do jogador " + (i + 1));
               int valor = in2.nextInt();
               in2.nextLine();
               Player p;
               boolean jaTem = false;

               //verifica se existe um jogador com esse nome;
               for (Player player : Players) {
                  if (player.getNome().equals(nome)) {
                     jaTem = true;
                     player.setValorEscolhido(valor); // seta o valor de um jogador ja existente
                  }
               }
               

               if (!jaTem) {
                  p = new Player(nome, valor);
                  addPlayer(p);
               }

               // -

            }

         

      } 
      jogarDado();
   }

    public static void addPlayer(Player p) {
      Players.add(p);
   }

    public static void jogarDado() {
       
      Dado d = new Dado();
      d.jogarDado();
      d.getNumeroQueCaiu();
      
      for (Player player : Players) {// verifica se alguem ganhou
         if (d.verificaValor(player.getValorEscolhido())) {
            player.setNumDeVitorias();
            System.out.println("Ganhador da rodada: " + player.getNome());
            ranking.put(player, player.getNumDeVitorias());
            maquinaGanhou = false;
            player.setValorEscolhido(0)
            ;
         }
         

      }



      if (maquinaGanhou) {//verifica se maquina ganhou
         int[] valores = {1,2,3,4,5,67,8,9,10,11,12};
           Random n = new Random();
        int valor = valores[n.nextInt(valores.length)];
        if (d.verificaValor(valor)) {
            System.out.println("A maquina Venceu a rodada;");
            System.out.println("Numero escolhido: "+valor);
        }
      }
         System.out.println("DADO: "+d.getNumeroQueCaiu());
         System.out.println();
     


      System.out.println("    - TOP RANK -    "); 
      // Ordena >>>
       Map<Player, Integer> rankingOrdenado = new LinkedHashMap<>();
        ranking.entrySet().stream()
            .sorted(Map.Entry.<Player, Integer>comparingByValue().reversed()) // Ordena pelos valores decrescentemente
            .forEachOrdered(entry -> rankingOrdenado.put(entry.getKey(), entry.getValue()));



      // Imprime o rank
      rankingOrdenado.forEach((player, valor) -> {
         System.out.println("|"+posi+"º " + player.getNome() + " - Vitorias: " + valor);
         
         posi++;
       
      });
      Scanner in = new Scanner(System.in);
      System.out.println();
      System.out.println("Pressione ENTER");
      in.nextLine();
      posi = 1;
      salvarNoArquivo(rankingOrdenado);

   }

     private static void salvarNoArquivo(Map<Player, Integer> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Map.Entry<Player, Integer> entrada : map.entrySet()) {
                writer.write(entrada.getKey().getNome() + " - " + entrada.getValue());
                writer.newLine();
            }
   
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }
   

}
