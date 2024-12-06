package q3;

public class Player {
    private  String nome;
    private int  valorEscolhido;
    private int numDeVitorias=0;


    
    
    public Player(String nome, int valorEscolhido) {
        this.nome = nome;
        this.valorEscolhido = valorEscolhido;
        this.numDeVitorias = 0;
    }

    public  String getNome() {
        return nome;
    }
    public  void setNome(String nome) {
        this.nome = nome;
    }
    public int getValorEscolhido() {
        return valorEscolhido;
    }
    public void setValorEscolhido(int n) {
        this.valorEscolhido = n;
    }
   
    
    public int getNumDeVitorias() {
        return numDeVitorias;
    }
    public void setNumDeVitorias() {

        this.numDeVitorias++;

        
    }



    
}
