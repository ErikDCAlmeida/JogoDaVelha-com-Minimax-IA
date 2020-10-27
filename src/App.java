import java.util.Scanner;

import model.Jogo;
import model.Minimax;
import model.Jogador;

public class App {
    public static void main(String[] args) {
        
        Jogo jogo = new Jogo(new Jogador("NPC"), new Jogador("Player1"));
        jogo.criarMatrizJogo();
        
        Jogador ganhador = null;

        Scanner scan = new Scanner(System.in);

        System.out.println("Bem vindo ao TicTacToe (Jogo da Velha)!\nAqui você jogará contra uma máquina, tente vencê-la.\n" +
                            "Avisando que ela é que começa.\n");
        Minimax minMax = new Minimax(jogo);
        while (ganhador == null) {
            boolean add;
            int vez = jogo.verificarVez();
            if (vez == 1) {
                System.out.println("Jogada do(a) " + jogo.getJogador1().getNome() + ":");
                int melhorMovimento = minMax.melhorJogadaIA(jogo.getMatrizJogo());
                add = jogo.adicionarPosiciao(melhorMovimento, jogo.getJogador1().getSimbolo());
                if (add) {
                    jogo.getJogador1().setVez(false);
                    jogo.getJogador2().setVez(true);
                }
            } else if (vez == 2){
                System.out.println("Posições livres: " + jogo.getPosicoesLivresPlayer());
                System.out.print("Escolha uma das posições acima que restam.\nEscolha:");
                int pos = scan.nextInt();
                add = jogo.adicionarPosiciao(pos, jogo.getJogador2().getSimbolo());
                if (add) {
                    jogo.getJogador1().setVez(true);
                    jogo.getJogador2().setVez(false);
                }
            }
            if (jogo.getPosicoesLivres().size() <= 4) {
                char simboloAux = jogo.verificarGanhador();
                if (simboloAux == jogo.getJogador1().getSimbolo()) {
                    ganhador = jogo.getJogador1();
                }
                if (simboloAux == jogo.getJogador2().getSimbolo()) {
                    ganhador = jogo.getJogador2();
                }
            }
            System.out.println(jogo);
            if (jogo.getPosicoesLivres().isEmpty()) {
                break;
            }
        }
        if (ganhador == null) {
            System.out.println("Não houve ganhadores, resultou em um empate!");
        }else{
            System.out.println("Ganhador: " + ganhador.getNome());
        }
        scan.close();
    }
}
