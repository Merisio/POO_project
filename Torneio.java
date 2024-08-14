import java.util.Scanner;

// Classe Torneio, para a execucao das rodadas e manipulacao de vetores da classe Jogador.
public class Torneio{
    Scanner teclado = new Scanner(System.in);
    private Jogador[] jogadores = new Jogador[10]; // Vetor de 10 jogadores (maximo permitido).
    private int numJogadores; // Numero de jogadores nesse campeonato.
    private int numRodadas; // Numero de rodadas.

   public void setVetor(){
        for(int i =0; i<10; i++)
            jogadores[i] = new Jogador(0, 0, 0.0) ; //inicializando vetor com 0;
    }

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

    // Realiza a adicao dos jogadores
    public void addJogadores(){
        setVetor();
        for (int i = 0; i < this.numJogadores; i++){
            jogadores[i].setSaldo(100);
            jogadores[i].setId(i+1);
            System.out.println("Insira o tipo do jogador " + (i+1) + "(0 para humano e 1 para maquina):");
            int tipo = teclado.nextInt();
            jogadores[i].setTipo(tipo);
        }
    }

    // Inicia o torneio
    public void iniciarTorneio(int numJog){
        setJogadores(numJog);
        addJogadores();

        System.out.println("1) Jogo de Azar;");
        System.out.println("2) Bozo;");
        System.out.println("3) Jogo do Porquinho.");
        System.out.println("Selecione o jogo que deseja jogar:");
        int opcao = teclado.nextInt();

        switch(opcao){
            case 1:
            while(opcao != 3){
                for(int i = 0; i< numJogadores; i++){
                    if(jogadores[i].getTipo() == 0){
                        System.out.println("Saldo Do jogador "+(i+1)+": " +jogadores[i].getSaldo()+". Insira o valor da aposta: ");
                        double aposta = teclado.nextDouble();
                        if(aposta <= jogadores[i].getSaldo()){
                            jogadores[i].setAposta(aposta); 
                        }else{
                            System.out.println("Aposta Invalida. Saldo Insuficiente.");
                        }
                    }else{
                        System.out.println("Saldo Do jogador "+(i+1)+": "+jogadores[i].getSaldo());
                        if(jogadores[i].getSaldo() > 5){
                            double aposta = (jogadores[i].getSaldo() / 5);
                            jogadores[i].setAposta(aposta);
                        }else{
                            break;
                        }
                    }
                }
                for(int i = 0; i< numJogadores; i++){
                    if(jogadores[i].getSaldo() > 0){
                        int r = jogadores[i].resultado();
                        if(r ==0){
                            jogadores[i].setSaldo(jogadores[i].getSaldo() - jogadores[i].getValorDeAposta());
                        }else{
                            jogadores[i].setSaldo(jogadores[i].getSaldo() + jogadores[i].getValorDeAposta());
                        }
                    }
                    if(jogadores[i].getSaldo() == 0)
                        opcao = 3;
                }
            }
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

    