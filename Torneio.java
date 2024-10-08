import java.io.Serializable;
import java.util.Scanner;

// Classe Torneio, para a execucao das rodadas e manipulacao de vetores da classe Jogador.
public class Torneio implements Serializable{
    private Jogador[] jogadores = new Jogador[10]; // Vetor de 10 jogadores (maximo permitido).
    private int numJogadores; // Numero de jogadores nesse campeonato.
    private int[] vencedores = new int[10]; // Vetor de verificacao para ver qual jogador perdeu e qual ganhou a rodada.
    private int ganhador, aux, cont = 0, premio = 0; // Acumula os valores de aposta de todos os jogadores na variavel premio.
    
    // Getters
    public int getJogadores(){
        return numJogadores;
    }
    
    // Setters
    public void setJogadores(int nj){
        this.numJogadores = nj;
    }
    public void setVetor(){// Inicializa todo o vetor com 0.
        for(int i = 0; i < 10; i++)
            jogadores[i] = new Jogador(0, 0, 0);
    }

    // Realiza a adicao dos jogadores
    public void addJogadores(){
        Scanner teclado = new Scanner(System.in);
        setVetor(); // Inicializa o vetor de jogadores como 0.
        System.out.printf("\n");

        // Seta os valores dos jogadores de acordo com o padrao passado pelo trabalho.
        for (int i = 0; i < this.numJogadores; i++){
            jogadores[i].setSaldo(100);
            jogadores[i].setId(i+1);

            // Pede o tipo do jogador, para ser informado pelo usuario.
            System.out.printf("Insira o tipo do jogador " + (i+1) + "(0 para humano e 1 para maquina): ");
            int tipo = teclado.nextInt();
            jogadores[i].setTipo(tipo);
        }
    }

    public void apostar(){
        Scanner teclado = new Scanner(System.in);
        for(int i = 0; i < numJogadores; i++){// Repeticao para operar com o vetor de jogadores.
            if(jogadores[i].getTipo() == 0){
            // Verifica se o jogador eh do tipo humano, solicitando que o jogador 
            // insira o valor de aposta desejado caso verdadeiro.
                if (jogadores[i].getSaldo() == 0)
                    System.out.println("O jogador "+(i+1)+" nao possui mais moedas.");
                else{  
                    System.out.printf("Saldo Do jogador "+(i+1)+": " +jogadores[i].getSaldo()+" moedas. Insira o valor da aposta: ");
                    int aposta = teclado.nextInt();

                    if(aposta <= jogadores[i].getSaldo()){ // Verificacao para que o jogador nao 
                        jogadores[i].setAposta(aposta);    // aposte mais do que tem em seu saldo.
                        premio += aposta; // Incrementa o premio final com a aposta realizada.
                    }
                    else
                        System.out.println("Aposta Invalida. Saldo Insuficiente.");
                }
            }
            else{// Caso o jogador seja uma maquina, possui uma aposta predefinida.
                if (jogadores[i].getSaldo() == 0)
                    System.out.println("Jogador "+ (i+1)+ " nao possui mais moedas.");
                else{
                    System.out.println("Saldo Do jogador "+(i+1)+": "+jogadores[i].getSaldo()+ " moedas.");

                    if(jogadores[i].getSaldo() >= 5){// Verificacao com o numero 5 para nao lidar com numeros decimais muito proximos de 0.
                        int aposta = ((int)(jogadores[i].getSaldo() / 5));
                        jogadores[i].setAposta(aposta);
                        premio += aposta; // Incrementa o premio final com a aposta realizada.
                    }
                }
            }
        }
    }

    // Premia os vencedores da rodada, e desconta daqueles que perderam.
    public void premiacao(int aux){
        for(int i = 0; i < numJogadores; i++){
            if (vencedores[i] == 1){ // Indica que o jogador "i" venceu.
                System.out.println("==> O jogador "+(i + 1)+" venceu a rodada. <==");
                // Utiliza o contador para verificar quantos jogadores venceram e premiar de forma igual.
                if(aux > 0){
                    jogadores[i].setSaldo((jogadores[i].getSaldo() + premio/aux) - jogadores[i].getValorDeAposta());
                }
                else{
                    jogadores[i].setSaldo(jogadores[i].getSaldo() + (premio-jogadores[i].getValorDeAposta()));
                    vencedores[i]= 0;
                }
            }   
            else{// jogador "i" perdeu.
                System.out.println("== O jogador "+ (i+1)+ " perdeu a rodada. ==");
                // Desconta o valor apostado.
                jogadores[i].setSaldo(jogadores[i].getSaldo() - jogadores[i].getValorDeAposta());
            }
        }
    }

    // Funcao que executa o Jogo de Azar.
    public void Azar(){
        int contVen = 0;
        apostar();
        Scanner teclado = new Scanner(System.in);
        for(int i = 0; i < numJogadores; i++){
            if(jogadores[i].getSaldo() > 0){ // Verifica se o saldo do jogador eh maior do que 0, 
                                             // para que o jogador possa apostar
                System.out.println("----------------------------------");
                System.out.println("Jogador "+ (i+1));
                System.out.println("----------------------------------");
                int r = jogadores[i].resultadoAzar();
                // Chama a funcao resultado, que retorna um booleano mostrando se o
                // jogador perdeu ou ganhou, alem de executar a rodada do Jogo de Azar.
                if(r == 0){ // Verifica se o jogador perdeu.
                    vencedores[i] = 0; // Identifica como 0 quem perdeu e como 1 quem ganhou.
                }
                else{
                    contVen++; //Incrementa o contador de vencedores.
                    vencedores[i] = 1;
                }
            }   
            // Teste para as rodadas.
                //if(jogadores[i].getSaldo() == 0)
                    //opcao = 3;
        }
        System.out.println(" ");
        premiacao(contVen);
        premio = 0;
    }

    // Funcao que executa o Jogo do Porquinho.
    public void JogoPorquinho(){
        int menor = 0;
        apostar();

        for (int i = 0; i < numJogadores; i++){
            if(jogadores[i].getSaldo() > 0){
                System.out.println("----------------------------------");
                System.out.println("Jogador "+ (i+1));
                System.out.println("----------------------------------");
                int resultado2 = jogadores[i].resultadoPorc();
                //Chama a funcao resultado, que retorna o numero de lancamentos do jogador
                if(menor == 0){              //Atribui o numero de lancamentos do primeiro jogador para a variavel menor
                    menor = resultado2;
                    ganhador = (i+1);
                }else if(resultado2 == menor){ //Compara os resultados de um jogador com os resultados do outro
                    ganhador = 0;               //Se forem iguais, significa que deu empate, entao nao tem ganhador(ganhador=0)
                }else if(resultado2 < menor){   //Se o resultado do segundo jogador for menor,  
                    menor = resultado2;         //a variavel menor recebe esse resultado e ganhador passa a ser o Id do jogador
                    ganhador = (i+1);           
                }
                //System.out.println("menor"+menor);  // testando
                System.out.println("Resultado Jogador "+(i+1) +": "+ resultado2);  //imprime o resultado de cada jogador a cada rodada
                vencedores[i]=0;
            }
        }
        if(ganhador == 0){ //verifica se houve algum ganhador
            System.out.println("Empate");
        }
        else{
            vencedores[ganhador-1] = 1; //Caso haja um ganhador e atribuido "1" ao vetor de vencedores, para fazer a premiacao
        }
        System.out.println("");
        premiacao(0);
        premio=0;
    }

    // Inicia o torneio
    public Jogador[] iniciarTorneio(int numJog){
        int opcao = 0;
        Scanner teclado = new Scanner(System.in);
        setJogadores(numJog); // Define o numero maximo de jogadores com os dados passados pelo operador.
        addJogadores();// Define o Id, o Saldo e o Tipo de cada jogador.

        // Menu para decidir qual jogo sera jogado.
        System.out.printf("\n");
        System.out.println("==== MENU DE JOGOS ====");
        System.out.println("1) Jogo de Azar;");
        System.out.println("2) Jogo do Porquinho;");
        System.out.println("3) Sair.");
        System.out.printf("Selecione o jogo que deseja jogar: ");
        opcao = teclado.nextInt();
        System.out.printf("\n");

        switch(opcao){
            case 1:
                do{ // Repeticao para definir o numero de rodadas, ate que reste apenas um vencedor.
                    Azar();

                    for (int i = 0; i < numJogadores; i++){
                        if (jogadores[i].getSaldo() <= 0)
                            cont++;
                        if (cont == numJogadores-1)
                            break;
                    }
                } while(cont != numJogadores-1);
            
                cont = 0;
                break;
            case 2:
                do{ // Repeticao para definir o numero de rodadas, ate que reste apenas um vencedor.
                    JogoPorquinho();

                    for (int i = 0; i < numJogadores; i++){
                        if (jogadores[i].getSaldo() <= 0)
                            cont++;
                    }
                    if (cont == numJogadores-1)
                        break;
                    
                } while(aux != 1);

                cont=0;
                break;                
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
        return jogadores;
    }

    // Funcao que mostra o placar final do torneio, com o saldo final de cada jogador e quem ganhou.
    public void mostrarPlacarFinal(Jogador[] players, int num){
        int winner = 0; // Variavel que identifica qual eh o vencedor.

        System.out.printf("\n");
        System.err.println("==== PLACAR FINAL DO TORNEIO! ====");

        for (int i = 0; i < num; i++){// Loop para operar o vetor de jogadores.
            System.out.println("Saldo do jogador "+(i+1)+": "+(players[i].getSaldo()));
            // Mostra o saldo de cada jogador.
            
            if (players[i].getSaldo() > 0) // Identifica o unico vencedor do torneio.
                winner = i + 1;
        }
        if (winner == 0)
        // Se nao houve nenhum vencedor, quer dizer que ambos os jogadores perderam tudo na mesma rodada, 
        // fazendo com que haja um empate.
            System.out.println("Ambos os jogadores perderam. Mais sorte na proxima vez!!");
        else // Se há um vencedor, ele eh mostrado na tela.
            System.out.println("O vencedor foi o jogador "+winner+". PARABENS!");
    }
}
    