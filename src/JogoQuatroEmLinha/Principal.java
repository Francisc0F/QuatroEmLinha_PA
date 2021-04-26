package JogoQuatroEmLinha;


import JogoQuatroEmLinha.logica.dados.JogoDados;

public class Principal {
    public static void main(String[] args) {
        JogoDados jogo = new JogoDados();
        jogo.imprimeTable();
        if(jogo.verificaColunas()){
             System.out.print("Ganhou");
        }else{
            System.out.print("Perdeu");
        }

     /*   while(true){
            if(jogo.Jogador1Joga()){
                break;
            }

            if(jogo.Jogador2Joga()){
                break;
            }

            jogo.imprimeTable();

        }*/

    }



}
