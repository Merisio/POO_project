import java.util.Scanner;

public class Torneio{
    Scanner teclado = new Scanner(System.in);
    private Jogador[] jogadores = new Jogador[10];
    private int numJogadores;
    private int numRodadas;

    public int getRodada(){
        return numRodadas;
    }

    public int getJogadores(){
        return numJogadores;
    }

    public void setRodada(int nr){
        this.numRodadas = nr;
    }

    public void setJogadores(int nj){
        this.numJogadores = nj;
    }

    public void addJogador(){
        System.out.println("Insira o tipo do jogador (0 para humano e 1 para maquina):");
        int tipo = teclado.nextInt();

        jogadores[getJogadores] = new Jogador(tipo);

        setJogadores(num + 1);
    }
    
    public void iniciarTorneio(){
        for (int i = 0; i < numJogadores; i++)
            jogadores[i].setSaldo(100);

        System.out.println("1) Jogo de Azar;");
        System.out.println("2) Bozo;");
        System.out.println("3) Jogo do Porquinho.");
        System.out.println("Selecione o jogo que deseja jogar:");
        int opcao = teclado.nextInt();

        switch(opcao){
            case 1:

                break;
            case 2:

                break;
            case 3:
            
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    public void mostrarPlacarFinal(){

    }


    
}