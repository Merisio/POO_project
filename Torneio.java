import java.util.Scanner;

// Classe Torneio, para a execucao das rodadas e manipulacao de vetores da classe Jogador.
public class Torneio{
    Scanner teclado = new Scanner(System.in);
    private Jogador[] jogadores = new Jogador[10]; // Vetor de 10 jogadores (maximo permitido).
    private int numJogadores; // Numero de jogadores nesse campeonato.
    private int numRodadas; // Numero de rodadas.

    // Getters
    public int getRodada(){
        return numRodadas;
    }

    public int getJogadores(){
        return numJogadores;
    }

    // Setters
    public void setRodada(int nr){
        this.numRodadas = nr;
    }

    public void setJogadores(int nj){
        this.numJogadores = nj;
    }

    // Realiza a adicao de um jogador
    public void addJogador(){
        System.out.println("Insira o tipo do jogador (0 para humano e 1 para maquina):");
        int tipo = teclado.nextInt();

        jogadores[getJogadores] = new Jogador(tipo);

        setJogadores(num + 1);
    }
    
    // Inicia o torneio
    public void iniciarTorneio(int numJog){
        setJogadores(numJog);

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