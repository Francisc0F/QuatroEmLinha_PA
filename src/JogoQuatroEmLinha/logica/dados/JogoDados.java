package JogoQuatroEmLinha.logica.dados;

import java.util.Random;
import java.util.Scanner;

public class JogoDados {

    private int[][] tab;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public JogoDados() {
        //this.tab = new int[6][7];
        this.tab = new int[][]{
                {0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0},
                {0, 2, 0, 2, 0, 0, 0},
                {0, 2, 0, 2, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 1, 2, 1, 0, 0, 0}
        };


        this.tab = generateTab();

     /*   this.tab = new int[][]{
                {0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}

        };*/
    }

    private int[][] generateTab() {
        int[][] x = new int[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                x[i][j] = (int) (Math.random() * (3 - 1)) + 1;
            }
        }
        return x;
    }

    public void imprimeTable() {
        int i, j;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                if (tab[i][j] == 1) {
                    System.out.format(ANSI_RED + "%4d" + ANSI_RESET, tab[i][j]);
                } else if (tab[i][j] == 2) {
                    System.out.format(ANSI_BLUE + "%4d" + ANSI_RESET, tab[i][j]);
                } else {
                    System.out.format(ANSI_GREEN + "%4d" + ANSI_RESET, tab[i][j]);
                }
            }
            System.out.println();

        }

    }


    private int obterColuna(int jogador) {
        System.out.print("Jogador " + jogador + " Joga: \n");
        System.out.print("Em que Coluna Quer Jogar? \n");
        Scanner myObj = new Scanner(System.in);
        return myObj.nextInt();
    }


    public boolean Jogador1Joga() {
        jogarPecaColuna(1, obterColuna(1));
        if (verificaColunas()) {
            System.out.print("Ganhou");
            return true;
        }
        return false;
    }

    public boolean Jogador2Joga() {
        jogarPecaColuna(2, obterColuna(2));
        if (verificaColunas()) {
            System.out.print("Ganhou");
            return true;
        }
        return false;
    }

    /* public int getPontuacaoByJogador(int jogador) {

         return
     }*/
    public boolean verificaColunas() {
        for (int i = 0; i < 6; i++) {
            if (verificaLinha(i)) {
                System.out.print("Linha " + (i + 1) + "\n");
                return true;
            }
        }


        for (int i = 0; i < 7; i++) {
            if (verificaColuna(i)) {
                System.out.print("Coluna " + (i + 1) + "\n");
                return true;
            }
        }


        return false;
    }

    public boolean verificaColuna(int coluna) {
        int count = 0;
        for (int i = 0; i < 6 && this.tab[i][coluna] != 0; i++) {
            count++;
            int val = this.tab[i][coluna];
            if (i > 0 && this.tab[i - 1][coluna] != val) {
                count = 1;
                continue;
            }
            if (count == 4) {
                return true;
            }

            // System.out.print("this.tab[i][coluna] " + this.tab[i][coluna] + "\n");
        }
        // System.out.print("count " + count + "\n");
        return false;
    }

    public boolean verificaLinha(int linha) {
        int count = 0;
        for (int i = 0; i < 7 && this.tab[linha][i] != 0; i++) {
          //  System.out.print("this.tab[i][coluna] " + this.tab[linha][i] + "\n");
            count++;
            int val = this.tab[linha][i];
            if (i > 0 && this.tab[linha][i - 1] != val) {
                count = 1;
                continue;
            }
            if (count == 4) {
                return true;
            }
        }
        // System.out.print("count " + count + "\n");
        return false;
    }

    private void jogarPecaColuna(int jogador, int coluna) {
        if (coluna > 5 || coluna < 0) {
            System.out.print("Indisponivel \n");
            return;
        }

        // System.out.print("Jogador " +jogador+ " Jogou Coluna " + coluna);
        if (this.tab[0][coluna] != 0) {
            System.out.print("Coluna cheia.");
            return;
        }


        for (int i = 5; i >= 0; i--) {
            int pos = this.tab[i][coluna];
            //System.out.print("tab pos " + this.tab[coluna][i] + "\n");
            if (pos == 0) {
                this.tab[i][coluna] = jogador;
                break;
            }
        }
    }
/*
    public int verificaHa(int Coluna) {
    }*/

}
