import java.util.Scanner;

// Classe Torneio, para a execucao das rodadas e manipulacao de vetores da classe Jogador.
public class Torneio{
    Scanner teclado = new Scanner(System.in);
    private Jogador[] jogadores = new Jogador[10]; // Vetor de 10 jogadores (maximo permitido).
    private int numJogadores; // Numero de jogadores nesse campeonato.
    private int numRodadas; // Numero de rodadas.
    private int[] vencedores = new int[10]; // Vetor de verificacao para ver qual jogador perdeu e qual ganhou a rodada.
    private int ganhador, cont =0, premio = 0; // Acumula os valores de aposta de todos os jogadores na variavel premio.

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

    public void apostar(){
        for(int i = 0; i < numJogadores; i++){// Repeticao para operar com o vetor de jogadores.
            if(jogadores[i].getTipo() == 0){
            // Verifica se o jogador eh do tipo humano, solicitando que o jogador 
            // insira o valor de aposta desejado caso verdadeiro.
                if (jogadores[i].getSaldo() == 0)
                    System.out.println("O jogador "+(i+1)+" nao possui mais moedas.");
                else{  
                    System.out.println("Saldo Do jogador "+(i+1)+": " +jogadores[i].getSaldo()+" moedas. Insira o valor da aposta: ");
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
                    System.out.println("Jogador "+ (i+1)+ " nao possui mais moedas, e foi eliminado.");
                else{
                    System.out.println("Saldo Do jogador "+(i+1)+": "+jogadores[i].getSaldo()+ "moedas.");

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
    public void premiacao(int cont){
        for(int i = 0; i < numJogadores; i++){
            if (vencedores[i] == 1){ // Indica que o jogador "i" venceu.
                System.out.println("==> O jogador "+(i + 1)+" venceu. <==");
                // Utiliza o contador para verificar quantos jogadores venceram e premiar de forma igual.
                if(cont > 0){
                    jogadores[i].setSaldo((jogadores[i].getSaldo() + (int)premio/cont) - jogadores[i].getValorDeAposta());
                }
                else{
                    jogadores[i].setSaldo(jogadores[i].getSaldo() + ((int)premio-jogadores[i].getValorDeAposta()));
                    vencedores[i]= 0;
                }
            }
            else{// jogador "i" perdeu.
                System.out.println("== O jogador "+ (i+1)+ " perdeu. ==");
                // Desconta o valor apostado.
                jogadores[i].setSaldo(jogadores[i].getSaldo() - jogadores[i].getValorDeAposta());
            }
        }
    }

    public void Azar(){
        int contVen = 0;
        apostar();

        for(int i = 0; i < numJogadores; i++){
            if(jogadores[i].getSaldo() > 0){ // Verifica se o saldo do jogador eh maior do que 0, 
                                            // para que o jogador possa apostar.
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
            }else{
                cont++;
            }   
            // Teste para as rodadas.
                //if(jogadores[i].getSaldo() == 0)
                    //opcao = 3;
        }
        System.out.println(" ");
        premiacao(contVen);
        premio = 0;

    }

    public int JogoPorquinho(int rodadas){
        int menor = 0;
        apostar();

        for (int i = 0; i < numJogadores; i++){
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
            //System.out.println("menor"+menor);  // testando
            System.out.println("Resultado Jogador "+(i+1) +": "+ resultado2);
            System.out.println("");
            vencedores[i]=0;
        }
        if(ganhador == 0){
            System.out.println("Empate");
        }
        else{
            System.out.println("Ganhador - Jogador "+ganhador);
            vencedores[ganhador-1] = 1;
        }
        System.out.println("");
        premiacao(0);
        rodadas++;

        return rodadas;
    }

    // Inicia o torneio
    public void iniciarTorneio(int numJog){
        int opcao = 0;
        int rodadas = 1;
        //while(opcao !=4){
        setJogadores(numJog); // Define o numero maximo de jogadores com os dados passados pelo operador.
        addJogadores();// Define o Id, o Saldo e o Tipo de cada jogador.

        // Menu para decidir qual jogo sera jogado.
        System.out.println("1) Jogo de Azar;");
        System.out.println("2) Jogo do Porquinho;");
        System.out.println("3) Sair.");
        System.out.println("Selecione o jogo que deseja jogar:");
        opcao = teclado.nextInt();

        switch(opcao){
            case 1:
                do{ // Repeticao para definir o numero de rodadas, ate que reste apenas um vencedor.
                    Azar();
                }while(cont < (numJogadores-1));
                cont = 0;
                break;
            case 2:
                while(cont < numJog);
                    rodadas = JogoPorquinho(rodadas);
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida.");
            }
        //}
    }

    public void mostrarPlacarFinal(){
        int winner = 0;

        for (int i = 0; i < numJogadores; i++){
            System.out.println("Saldo do jogador "+(i+1)+": "+(jogadores[i].getSaldo()));
            
            if (jogadores[i].getSaldo() > 0)
                winner = i + 1;
        }
        System.out.println("O vencedor foi o jogador "+winner+".");
    }
}

    