package model;
import java.util.ArrayList;
import java.util.Collections;

public class Jogo {
    
    private char[][] matrizJogo;
    private ArrayList<Integer> posicoesLivres = new ArrayList<>(9);
    private ArrayList<Integer> posicoesLivresPlayer = new ArrayList<>(9);
    private Jogador jogador1;
    private Jogador jogador2;

    public Jogo(){super();}

    public Jogo(Jogador jogador1, Jogador jogador2){
        this.jogador1 = new Jogador(jogador1.getNome(), 'X');
        this.jogador2 = new Jogador(jogador2.getNome(), 'O');
        this.matrizJogo = new char[3][3];
        this.jogador1.setVez(true);
        for (int i = 1; i < 10; i++) {
            this.posicoesLivres.add(i);
            this.posicoesLivresPlayer.add(i);
        }
        Collections.shuffle(this.posicoesLivres);
    }

    public char[][] criarMatrizJogo(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                this.matrizJogo[i][j] = ' ';
            }
        }
        return this.matrizJogo;
    }

    public boolean adicionarPosiciao(int pos, char elem){
        if (verificarPosicaoLivre(pos)) {
            switch (pos) {
                case 1:
                    this.matrizJogo[0][0] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 2:
                    this.matrizJogo[0][1] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 3:
                    this.matrizJogo[0][2] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 4:
                    this.matrizJogo[1][0] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 5:
                    this.matrizJogo[1][1] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 6:
                    this.matrizJogo[1][2] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 7:
                    this.matrizJogo[2][0] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 8:
                    this.matrizJogo[2][1] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                case 9:
                    this.matrizJogo[2][2] = elem;
                    this.posicoesLivres.remove(this.posicoesLivres.indexOf(pos));
                    this.posicoesLivresPlayer.remove(this.posicoesLivresPlayer.indexOf(pos));
                    break;
                default:
                    break;
            }
            return true;
        } else {
            System.out.println("Posição já ocupada, por favor digite uma opção disponível!");
            return false;
        }
    }

    private boolean verificarPosicaoLivre(int pos){
        return this.posicoesLivres.contains(pos);
    }

    public int verificarVez(){
        if (this.jogador1.getVez() == true && this.jogador2.getVez() == false) {
            return 1;
        } else if (this.jogador1.getVez() == false && this.jogador2.getVez() == true){
            return 2;
        }else{
            return 0;
        }
    }

    public char verificarGanhador(){
        char simbolo = ' ';
        for (int i = 0; i < 3; i++) {
            if (this.matrizJogo[i][0] == this.matrizJogo[i][1] &&
                this.matrizJogo[i][0] == this.matrizJogo[i][2] &&
                this.matrizJogo[i][1] == this.matrizJogo[i][2]) {
                    simbolo = this.matrizJogo[i][0];
                    return simbolo;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (this.matrizJogo[0][i] == this.matrizJogo[1][i] &&
                this.matrizJogo[0][i] == this.matrizJogo[2][i] &&
                this.matrizJogo[1][i] == this.matrizJogo[2][i]) {
                    simbolo = this.matrizJogo[0][i];
                    return simbolo;
            }
        }
        
        if (this.matrizJogo[0][0] == this.matrizJogo[1][1] &&
            this.matrizJogo[1][1] == this.matrizJogo[2][2] &&
            this.matrizJogo[2][2] == this.matrizJogo[0][0]) {
            simbolo = this.matrizJogo[0][0];
            return simbolo;
        }

        if (this.matrizJogo[0][2] == this.matrizJogo[1][1] &&
            this.matrizJogo[1][1] == this.matrizJogo[2][0] &&
            this.matrizJogo[2][0] == this.matrizJogo[0][2]) {
            simbolo = this.matrizJogo[0][2];
            return simbolo;
        }
        return simbolo;
    }

    public char[][] getMatrizJogo() {
        return matrizJogo;
    }

    public ArrayList<Integer> getPosicoesLivres() {
        return posicoesLivres;
    }

    public ArrayList<Integer> getPosicoesLivresPlayer() {
        return posicoesLivresPlayer;
    }
    
    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                if (j == 2) {
                    string.append(matrizJogo[i][j]);
                }else{
                    string.append(matrizJogo[i][j]).append(" | ");
                }
            }
            string.append("\n");
        }
        return string.toString();
    }

}
