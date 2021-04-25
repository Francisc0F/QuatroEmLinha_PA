package JogoQuatroEmLinha;


import JogoQuatroEmLinha.logica.dados.JogoDados;

public class Principal {
    public static void main(String[] args) {
        JogoDados jogo = new JogoDados();
        jogo.imprimeTable();

        while(true){
            jogo.Jogador1Joga();
            jogo.Jogador2Joga();
            jogo.imprimeTable();

        }

    }



}
