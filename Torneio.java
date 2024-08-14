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
    public void setVetor(){// Inicializa todo o vetor com 0.
        for(int i = 0; i < 10; i++)
            jogadores[i] = new Jogador(0, 0, 0.0);
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
        setJogadores(numJog); // Define o numero maximo de jogadores com os dados passados pelo operador.
        addJogadores();// Define o Id, o Saldo e o Tipo de cada jogador.

        // Menu para decidir qual jogo sera jogado.
        System.out.println("1) Jogo de Azar;");
        System.out.println("2) Bozo;");
        System.out.println("3) Jogo do Porquinho;");
        System.out.println("4) Sair.");
        System.out.println("Selecione o jogo que deseja jogar:");
        int opcao = teclado.nextInt();

        switch(opcao){
            case 1:
            while(opcao != 3){ // Repeticao para definir o numero de rodadas, ate que reste apenas um vencedor.
                for(int i = 0; i< numJogadores; i++){// Repeticao para operar com o vetor de jogadores.
                    if(jogadores[i].getTipo() == 0){
                    // Verifica se o jogador eh do tipo humano, solicitando que o jogador 
                    // insira o valor de aposta desejado caso verdadeiro.
                        System.out.println("Saldo Do jogador "+(i+1)+": " +jogadores[i].getSaldo()+". Insira o valor da aposta: ");
                        double aposta = teclado.nextDouble();

                        if(aposta <= jogadores[i].getSaldo()){ // Verificacao para que o jogador nao 
                            jogadores[i].setAposta(aposta);    // aposte mais do que tem em seu saldo.
                        }
                        else
                            System.out.println("Aposta Invalida. Saldo Insuficiente.");
                    }
                    else{// Caso o jogador seja uma maquina, possui uma aposta predefinida.
                        System.out.println("Saldo Do jogador "+(i+1)+": "+jogadores[i].getSaldo());
                        if(jogadores[i].getSaldo() > 5){// Verificacao com o numero 5 para nao lidar com numeros decimais muito proximos de 0.
                            double aposta = (jogadores[i].getSaldo() / 5);
                            jogadores[i].setAposta(aposta);
                        }
                        else
                            break;
                    }
                /* } // Gui, acho que podemos tirar esse for, e deixar tudo em um so.
                for(int i = 0; i< numJogadores; i++){*/
                    if(jogadores[i].getSaldo() > 0){ // Verifica se o saldo do jogador eh maior do que 0, 
                                                     // para que o jogador possa apostar.

                        int r = jogadores[i].resultadoAzar();
                        // Chama a funcao resultado, que retorna um booleano mostrando se o
                        // jogador perdeu ou ganhou, alem de executar a rodada do Jogo de Azar.

                        if(r == 0) // Verifica se o jogador perdeu.
                            // Se o jogador perdeu, o valor de aposta eh descontado de seu saldo.
                            jogadores[i].setSaldo(jogadores[i].getSaldo() - jogadores[i].getValorDeAposta());
                        else
                            // Se ganhou, o valor de aposta eh adicionado ao seu saldo.
                            jogadores[i].setSaldo(jogadores[i].getSaldo() + jogadores[i].getValorDeAposta());
                        
                    }
                    // Teste para as rodadas.
                    if(jogadores[i].getSaldo() == 0)
                        opcao = 3;
                }
            }
                break;
            case 2:

                break;
            case 3:
            
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    public void mostrarPlacarFinal(){
        
    }
}

    