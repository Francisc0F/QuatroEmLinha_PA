package JogoQuatroEmLinha.logica.dados;
import java.util.Scanner;

public class JogoDados {

    private int[][] tab;

    public JogoDados() {
        this.tab = new int[6][7];
    }

    public void imprimeTable() {
        int i,j;
        for (i = 0; i < 6; i++) {
            for (j=0;j < 7; j++) {
                System.out.format("%4d", tab[i][j]);
            }
            System.out.println();
        }

    }


    private int obterColuna(int jogador){
        System.out.print("Jogador " + jogador + " Joga: \n");
        System.out.print("Em que Coluna Quer Jogar? \n");
        Scanner myObj = new Scanner(System.in);
        return myObj.nextInt();
    }


    public void Jogador1Joga(){
        jogarPecaColuna(1, obterColuna(1));
    }

    public void Jogador2Joga(){
        jogarPecaColuna(2, obterColuna(2));
    }

   /* public int getPontuacaoByJogador(int jogador) {

        return
    }*/

    private void jogarPecaColuna( int jogador, int coluna) {
        if(coluna > 5 || coluna < 0){
            System.out.print("Indisponivel \n");
            return;
        }

       // System.out.print("Jogador " +jogador+ " Jogou Coluna " + coluna);
        if(this.tab[0][coluna] != 0){
            System.out.print("Coluna cheia.");
            return;
        }


        for( int i = 5; i >= 0 ; i--){
            int pos = this.tab[i][coluna];
            //System.out.print("tab pos " + this.tab[coluna][i] + "\n");
            if(pos == 0){
                this.tab[i][coluna] = jogador;
                break;
            }
        }
    }
/*
    public int verificaHa(int Coluna) {
    }*/

}
