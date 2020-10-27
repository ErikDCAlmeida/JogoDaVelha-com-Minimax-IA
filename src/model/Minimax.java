package model;

import java.util.ArrayList;

public class Minimax {
    
    Jogo jogo;

    Jogador jogador;

    public Minimax(Jogo jogo) {
        this.jogo = jogo;
        this.jogador = this.jogo.getJogador1();
    }

    public int melhorJogadaIA(char[][] quadroJogo){
        int melhorValor = -10;
        int melhorMovimento = 0;
        ArrayList<Integer> posicoesLivres = this.posicoeList(this.jogo.getMatrizJogo());
        for (int i = 0; i < posicoesLivres.size(); i++) {
            this.adicionarPosicaoIA(quadroJogo, posicoesLivres.get(i), this.jogo.getJogador1().getSimbolo());
            int valor = this.miniMax(quadroJogo, this.jogo.getJogador2());
            this.reAdicionarPosicaoIA(quadroJogo, posicoesLivres.get(i));

            if (melhorValor < valor) {
                melhorValor = valor;
                melhorMovimento = posicoesLivres.get(i);
            }
            
        }
        return melhorMovimento;
    }

    private int miniMax(char[][] quadroJogo, Jogador jogador){
        char ganhador = this.verificarGanhadorIA(quadroJogo);
        if (ganhador == this.jogo.getJogador1().getSimbolo()) {
            return 1;
        } else if (ganhador == this.jogo.getJogador2().getSimbolo()) {
            return -1;
        } else if (ganhador == 'E') {
            return 0;
        }

        Jogador jogadorAtual;

        int melhorValor;
        if (jogador.equals(jogo.getJogador1())) {
            melhorValor = -10;
        } else {
            melhorValor = 10;
        }

        if (jogador.equals(jogo.getJogador1())){
            jogadorAtual = jogo.getJogador2();
        } else {
            jogadorAtual = jogo.getJogador1();
        }

        ArrayList<Integer> posicoesLivres = this.posicoeList(quadroJogo);

        for (int i = 0; i < posicoesLivres.size(); i++) {
            this.adicionarPosicaoIA(quadroJogo, posicoesLivres.get(i), jogador.getSimbolo());
            int valor = this.miniMax(quadroJogo, jogadorAtual);
            this.reAdicionarPosicaoIA(quadroJogo, posicoesLivres.get(i));

            if (jogador.equals(jogo.getJogador1())) {
                if (melhorValor < valor) {
                    melhorValor = valor;
                }
            } else {
                if (melhorValor > valor) {
                    melhorValor = valor;
                }
            }
        }

        return melhorValor;
    }

    private ArrayList<Integer> posicoeList(char[][] mesaJogo){
        ArrayList<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < mesaJogo.length; i++) {
            for (int j = 0; j < mesaJogo.length; j++) {
                if (mesaJogo[i][j] == ' ') {
                    if (i == 0 && j == 0) {
                        posicoes.add(1);
                    } else if (i == 0 && j == 1) {
                        posicoes.add(2);
                    } else if (i == 0 && j == 2) {
                        posicoes.add(3);
                    } else if (i == 1 && j == 0) {
                        posicoes.add(4);
                    } else if (i == 1 && j == 1) {
                        posicoes.add(5);
                    } else if (i == 1 && j == 2) {
                        posicoes.add(6);
                    } else if (i == 2 && j == 0) {
                        posicoes.add(7);
                    } else if (i == 2 && j == 1) {
                        posicoes.add(8);
                    } else if (i == 2 && j == 2) {
                        posicoes.add(9);
                    } 
                }
            }
        }
        return posicoes;
    }

    private void adicionarPosicaoIA(char[][] quadro, int pos, char simbol){
        if (pos == 1) {
            quadro[0][0] = simbol;
        } else if (pos == 2) {
            quadro[0][1] = simbol;
        } else if (pos == 3) {
            quadro[0][2] = simbol;
        } else if (pos == 4) {
            quadro[1][0] = simbol;
        } else if (pos == 5) {
            quadro[1][1] = simbol;
        } else if (pos == 6) {
            quadro[1][2] = simbol;
        } else if (pos == 7) {
            quadro[2][0] = simbol;
        } else if (pos == 8) {
            quadro[2][1] = simbol;
        } else if (pos == 9) {
            quadro[2][2] = simbol;
        } 
    }

    private void reAdicionarPosicaoIA(char[][] quadro, int pos){
        if (pos == 1) {
            quadro[0][0] = ' ';
        } else if (pos == 2) {
            quadro[0][1] = ' ';
        } else if (pos == 3) {
            quadro[0][2] = ' ';
        } else if (pos == 4) {
            quadro[1][0] = ' ';
        } else if (pos == 5) {
            quadro[1][1] = ' ';
        } else if (pos == 6) {
            quadro[1][2] = ' ';
        } else if (pos == 7) {
            quadro[2][0] = ' ';
        } else if (pos == 8) {
            quadro[2][1] = ' ';
        } else if (pos == 9) {
            quadro[2][2] = ' ';
        } 
    }

    private char verificarGanhadorIA(char[][] quadro){
        for (int i = 0; i < quadro.length; i++) {
            if (quadro[i][0] == quadro[i][1] && quadro[i][1] == quadro[i][2] && quadro[i][2] != ' ') {
                return quadro[i][0];
            }
        }

        for (int i = 0; i < quadro.length; i++) {
            if (quadro[0][i] == quadro[1][i] && quadro[1][i] == quadro[2][i] && quadro[2][i] != ' ') {
                return quadro[0][i];
            }
        }

        if (quadro[0][0] == quadro[1][1] && quadro[1][1] == quadro[2][2] && quadro[2][2] != ' ') {
            return quadro[0][0];
        }

        if (quadro[0][2] == quadro[1][1] && quadro[1][1] == quadro[2][0] && quadro[2][0] != ' ') {
            return quadro[0][2];
        }

        for (int i = 0; i < quadro.length; i++) {
            for (int j = 0; j < quadro[i].length; j++) {
                if (quadro[i][j] == ' ') {
                    return '?';
                }
            }
        }

        return 'E';
    }
}
