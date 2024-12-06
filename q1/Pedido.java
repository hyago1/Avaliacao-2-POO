package q1;

import java.time.LocalTime;
import java.util.Random;



public class Pedido {

    private LocalTime horaCompra;
    private LocalTime horaEntrega;
    private float preco = 98;
    private String local;
    private float qtdBotijao = 0;
    
    private int pagamento;
    private Boolean statusPago = false;
    private Boolean statusEntregue = false;
    private int codigoPedido;
    private float valorTotal = qtdBotijao*preco;

    
    public Pedido(String local) {
        LocalTime horaCompra = LocalTime.now();
        
        this.horaCompra = horaCompra;
        this.local = local;
   
    }
    

    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }


    public void setHoraEntrega() {
        this.horaEntrega = horaCompra.plusHours(6);
    }


    public LocalTime getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(LocalTime horaCompra) {
        this.horaCompra = horaCompra;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public float getQtdBotijao() {
        return qtdBotijao;
    }

    public void setQtdBotijao(int qtdBotijao2) {
        this.qtdBotijao = qtdBotijao2;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    public float setValorTotal() {
        this.valorTotal = preco*qtdBotijao;
        return valorTotal;
    }


    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public Boolean getStatusPago() {
        return statusPago;
    }

    public void setStatusPago(Boolean statusPago) {
        this.statusPago = statusPago;
    }

    public Boolean getStatusEntregue() {
        return statusEntregue;
    }

    public void setStatusEntregue(Boolean statusEntregue) {
        this.statusEntregue = statusEntregue;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido() {
        Random random = new Random();
        this.codigoPedido = random.nextInt(99999);
    } 


}
