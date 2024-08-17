import java.util.Scanner;

// Classe Torneio, para a execucao das rodadas e manipulacao de vetores da classe Jogador.
public class Torneio{
    Scanner teclado = new Scanner(System.in);
    private Jogador[] jogadores = new Jogador[10]; // Vetor de 10 jogadores (maximo permitido).
    private int numJogadores; // Numero de jogadores nesse campeonato.
    private int numRodadas; // Numero de rodadas.
    private int[] vencedores = new int[10];
    private int ganhador;

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
            jogadores[i] = new Jogador(0, 0, 0);
    }

    // Realiza a adicao dos jogadores
    public void addJogadores(){
        setVetor();
        for (int i = 0; i < this.numJogadores; i++){
            jogadores[i].setSaldo(100);
            jogadores[i].setId(i+1);
            System.out.println("");
            System.out.println("Insira o tipo do jogador " + (i+1) + "(0 para humano e 1 para maquina):");
            int tipo = teclado.nextInt();
            jogadores[i].setTipo(tipo);
        }
    }

    // Inicia o torneio
    public void iniciarTorneio(int numJog){
        int opcao =0;
        //while(opcao !=4){
            setJogadores(numJog); // Define o numero maximo de jogadores com os dados passados pelo operador.
            addJogadores();// Define o Id, o Saldo e o Tipo de cada jogador.

            // Menu para decidir qual jogo sera jogado.
        System.out.println("1) Jogo de Azar;");
        System.out.println("2) Bozo; (Não Disponivel)");
        System.out.println("3) Jogo do Porquinho;");
        System.out.println("4) Sair.");
        System.out.println("Selecione o jogo que deseja jogar:");
        opcao = teclado.nextInt();

        switch(opcao){
            case 1:
                while(opcao != 3){ // Repeticao para definir o numero de rodadas, ate que reste apenas um vencedor.
                    int contVen = 0;
                    int premio = 0;

                    for(int i = 0; i < numJogadores; i++){// Repeticao para operar com o vetor de jogadores.
                        if(jogadores[i].getTipo() == 0){
                        // Verifica se o jogador eh do tipo humano, solicitando que o jogador 
                        // insira o valor de aposta desejado caso verdadeiro.
                            System.out.println("Saldo Do jogador "+(i+1)+": " +jogadores[i].getSaldo()+" moedas. Insira o valor da aposta: ");
                            int aposta = teclado.nextInt();

                            if(aposta <= jogadores[i].getSaldo()){ // Verificacao para que o jogador nao 
                                jogadores[i].setAposta(aposta);    // aposte mais do que tem em seu saldo.
                                premio += aposta;
                            }else
                                System.out.println("Aposta Invalida. Saldo Insuficiente.");
                        }else{// Caso o jogador seja uma maquina, possui uma aposta predefinida.
                            System.out.println("Saldo Do jogador "+(i+1)+": "+jogadores[i].getSaldo()+ "moedas.");
                            if(jogadores[i].getSaldo() > 5){// Verificacao com o numero 5 para nao lidar com numeros decimais muito proximos de 0.
                                int aposta = (jogadores[i].getSaldo() / 5);
                                jogadores[i].setAposta(aposta);
                                premio += aposta;
                            }else
                                break;
                        }
                    }
                    for(int i = 0; i < numJogadores; i++){
                        if(jogadores[i].getSaldo() > 0){ // Verifica se o saldo do jogador eh maior do que 0, 
                                                        // para que o jogador possa apostar.
                            int r = jogadores[i].resultadoAzar();
                            // Chama a funcao resultado, que retorna um booleano mostrando se o
                            // jogador perdeu ou ganhou, alem de executar a rodada do Jogo de Azar.

                            if(r == 0){ // Verifica se o jogador perdeu.
                                vencedores[i] = 0; // Identifica como 0 quem perdeu e como 1 quem ganhou.
                            }else{
                                contVen++; //Incrementa o contador de vencedores.
                                vencedores[i] = 1;
                            }
                        }
                        // Teste para as rodadas.
                        if(jogadores[i].getSaldo() == 0)
                            opcao = 3;
                    }

                    for(int i = 0; i < numJogadores; i++){
                        if (vencedores[i] == 1){
                            System.out.println("O jogador "+(i + 1)+" venceu.");
                            jogadores[i].setSaldo(jogadores[i].getSaldo() + (int)premio/contVen);
                        }else{
                            System.out.println("O jogador "+ (i+1)+ " perdeu.");
                            jogadores[i].setSaldo(jogadores[i].getSaldo() - jogadores[i].getValorDeAposta());
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Desculpe, este jogo não está disponivel.");

                break;
            case 3:
                while(opcao !=5){
                    int premio =0, menor =0;
                    for(int i = 0; i < numJogadores; i++){// Repeticao para operar com o vetor de jogadores.
                        if(jogadores[i].getTipo() == 0){
                        // Verifica se o jogador eh do tipo humano, solicitando que o jogador 
                        // insira o valor de aposta desejado caso verdadeiro.
                            System.out.println("Saldo Do jogador "+(i+1)+": " +jogadores[i].getSaldo()+" moedas. Insira o valor da aposta: ");
                            int aposta = teclado.nextInt();
                            if(aposta <= jogadores[i].getSaldo()){ // Verificacao para que o jogador nao 
                                jogadores[i].setAposta(aposta);    // aposte mais do que tem em seu saldo.
                                premio += aposta;
                            }else
                                System.out.println("Aposta Invalida. Saldo Insuficiente.");
                        }else{// Caso o jogador seja uma maquina, possui uma aposta predefinida.
                            System.out.println("Saldo Do jogador "+(i+1)+": "+jogadores[i].getSaldo()+ " moedas.");
                            if(jogadores[i].getSaldo() > 5){// Verificacao com o numero 5 para nao lidar com numeros decimais muito proximos de
                                int aposta = (jogadores[i].getSaldo() / 5);
                                jogadores[i].setAposta(aposta);
                                premio += aposta;
                            }else
                                break;
                        }
                    }
                    for (int i = 0 ; i < numJogadores; i++){

                        System.out.println("----------------------------------");
                        System.out.println("Jogador "+ (i+1));
                        System.out.println("----------------------------------");
                        int resultado2 = jogadores[i].resultadoPorc();
                        if(menor == 0){
                            menor = resultado2;
                            ganhador = (i+1);
                        }else if(resultado2 == menor){
                            ganhador = 0;
                        }else if(resultado2 < menor){
                            menor = resultado2;
                            ganhador = (i+1);
                        }
                        System.out.println("menor"+menor);
                        System.out.println("Resultado Jogador "+(i+1) +": "+ resultado2);
                        System.out.println("");
                        vencedores[i]=0;
                    }
                    if(ganhador == 0){
                        System.out.println("Empate");
                    }else{
                        System.out.println("Ganhador - Jogador "+ganhador);
                        vencedores[ganhador-1] = 1;
                    }
                    for(int i = 0; i < numJogadores; i++){
                        if (vencedores[i] == 1){
                            System.out.println("O jogador "+(i + 1)+" venceu.");
                            jogadores[i].setSaldo(jogadores[i].getSaldo() + ((int)premio-jogadores[i].getValorDeAposta()));
                            vencedores[i]= 0;
                        }else{
                            System.out.println("O jogador "+ (i+1)+ " perdeu.");
                            jogadores[i].setSaldo(jogadores[i].getSaldo() - jogadores[i].getValorDeAposta());
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida.");
            }
        //}
    }

    public void mostrarPlacarFinal(){
        
    }
}

    