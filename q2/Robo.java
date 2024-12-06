package q2;

public class Robo {
    private static int linha;
    private  static int coluna;
    private static int passo;

  




    public  Robo(int linha, int coluna, int passo){
        this.linha = linha;
        this.coluna = coluna;
        this.passo = passo;
        
    }


    

    public static int getLinha() {
        return linha;
    }

    public static void setLinha(int linha) {
        Robo.linha = linha;
    }

    public static int getColuna() {
        return coluna;
    }

    public static void setColuna(int coluna) {
        Robo.coluna = coluna;
    }

    public static int getPasso() {
        return passo;
    }

    public static void setPasso(int passo) {
        Robo.passo = passo;
    }

    public int[] mostrarPosicaoAtual(){
        int[] posicao = {linha,coluna};
        
        return posicao;
    }
    public static void andarFrente(){
        if(linha>0){
            linha--;
        }
        
    }
    public static void andarTras(){
        if (linha<19) {
            linha++;
        }
        
    }
    public static void andarDireita(){
        if (coluna<39) {
            coluna++;
        }
    }
    public static void andarEsquerda(){
        if (coluna > 0) {
            coluna--;
        }
    }

    
}
