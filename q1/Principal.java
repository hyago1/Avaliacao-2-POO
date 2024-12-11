package q1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList<Pedido> pedidos = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {

        System.out.println();
        System.out.println();
        System.out.println(" ------------ Menu ------------");
        System.out.println("| 1 - Fazer pedido             |");
        System.out.println("| 2 - Ver pedidos confirmados  |");
        System.out.println("| 3 - Ver pedido entregues     |");
        System.out.println("| 4 - Confirmar Entrega         |");
        System.out.println("| 5 - Sair                     |" );
        System.out.println();

        gerenciador();
    }

    public static void gerenciador() {
        Scanner in = new Scanner(System.in);
        int op = in.nextInt();

        switch (op) {
            case 1:
                fazerPedido();

                break;
            case 2:
                verPedidoConfirmados();

                break;
            case 3:
                verPedidoEntregues();

                break;
            case 4:
            confirmarPedido();
                break;
            case 5:
            
                    break;
            default:
                menu();
                break;
        }

        in.close();
    }


    private static void verPedidoEntregues() {
        System.out.println();
        System.out.println("Pedidos Entregues");
        for (Pedido pedido : pedidos) {
            if (pedido.getStatusEntregue() == true) {
            System.out.println("**********************");
            System.out.println("Endereço:" + pedido.getLocal());
            System.out.println("Codigo:" + pedido.getCodigoPedido());
            System.out.println("Valor:" + pedido.getValorTotal());
            }
           
        }
        menu();
    }

    public static void verPedidoConfirmados() {
        System.out.println();
        System.out.println("Pedidos Confirmados");
        for (Pedido pedido : pedidos) {
            if (pedido.getStatusPago() == true) {
            System.out.println("**********************");
            System.out.println("Endereço:" + pedido.getLocal());
            System.out.println("Codigo:" + pedido.getCodigoPedido());
            System.out.println("Valor:" + pedido.getValorTotal());   
            }
            
        }

        menu();
    }

    public static void fazerPedido() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o endereço da entrega:");
        String endereco = in.nextLine();
        System.out.println();
        System.out.println();
        Pedido pedido = new Pedido(endereco);
        System.out.println("Dados do pedido:");
        System.out.println("Endereço: " + pedido.getLocal());
        System.out.println("Hora: " + pedido.getHoraCompra());

        System.out.println("Confirmar? 1 = Sim   2 = Não");
        int op = in.nextInt();
        int qtdBotijao = 0;
        int numCartao = 0;
        if (op == 1) {
            System.out.println("Digite a quantidade de botijoes:");
            qtdBotijao = in.nextInt();
            in.nextLine();
            
        } else {
            Scanner in2 = new Scanner(System.in);
            System.out.println("Digite o novos endereço da entrega:");
            String enderecoAtualizado = in2.nextLine();
            pedido.setLocal(enderecoAtualizado);
            System.out.println("Novo endereço: "+ enderecoAtualizado);

            System.out.println("Digite a quantidade de botijoes:");
            qtdBotijao = in.nextInt();

        }

        pedido.setQtdBotijao(qtdBotijao);
       
        pedido.setCodigoPedido();
        pedido.setStatusPago(true);
        pedido.setValorTotal();
        pedido.setHoraEntrega();
        System.out.println();
        System.out.println();

        System.err.println("Codigo do pedido: " + pedido.getCodigoPedido());
        System.out.println("Hora de entrega: " + pedido.getHoraEntrega());
        System.out.println("Valor Total: " + pedido.getValorTotal());


        System.out.println();

        System.out.println("Digite o numero do cartão:");
        numCartao = in.nextInt();
        in.nextLine();
        pedido.setPagamento(numCartao);

        pedidos.add(pedido);
        menu();

    }

    public static void confirmarPedido(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo para confirmar: ");

        int codigo = in.nextInt();

        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoPedido() == codigo) {
                pedido.setStatusEntregue(true);
                System.err.println("Entrega Confirmada!");
            }else{
                System.out.println("Pedido não localizado");
            }
            
        }


        menu();


    }
}
