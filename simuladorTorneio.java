import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.Scanner;

// Classe aplicativa.
public class simuladorTorneio{
    public static final Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
        int num = 0; // Variavel que recebera o numero de jogadores, informado pelo usuario
        System.out.println("==== BEM VINDO AO NOSSO CASSINO ONLINE! ====: ");
        System.out.printf("Insira o numero de participantes: ");
        num = teclado.nextInt();
        int sair = 0;

        Jogador[] players = new Jogador[10]; // Vetor que recebe os resultados do torneio. 
        for (int i = 0; i < 10; i++)
            players[i] = new Jogador(0, 0, 0); // Vetor eh inicializado com 0.

        while(sair != 5){// Primeiro loop para execucao do menu.
            if (num >= 2){
                Torneio campeonato = new Torneio();
                System.out.printf("\n");
                System.out.println("==== MENU INICIAL ====");
                System.out.println("1) Comecar novo torneio;");
                System.out.println("2) Ver placar;");
                System.out.println("3) Salvar torneio;");
                System.out.println("4) Carregar torneio;");
                System.out.println("5) Sair.");
                System.out.printf("Selecione o que deseja: ");
                int opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:// Cria um novo torneio.
                        players = campeonato.iniciarTorneio(num); 
                        /*for (int i = 0; i < campeonato.getJogadores(); i++)
                            System.out.println("Vetor de saldo de jogadores: "+players[i].getSaldo());*/
                        
                        break;
                    case 2:// Mostra o placar final do torneio anterior.
                        campeonato.mostrarPlacarFinal(players, num);
                        break;
                    case 3:// Grava o arquivo do torneio corrente.
                        //gravar_arquivo();
                        break;
                    case 4:// Le um arquivo de um torneio.
                        //campeonato = ler_arquivo(campeonato);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        sair = 5;
                        break;
                    default:
                        System.out.println("Opcao Invalida.");
                        break;
                }
            }
        }
    }

    /*public static Torneio[] ler_arquivo(Torneio campeonato){
        File arquivo = new File("backup.dat");
  
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            //Lendo os objetos de um arquivo e fazendo a coercao de tipos
            
            campeonato = (Torneio[]) oin.readObject();
            oin.close();
            fin.close();
        
            //Uma forma de diferente do for para percorrer vetores
            for (Torneio c : campeonato){
                if (c != null){
                    System.out.println(c);
                }
            }
        }
        catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

        System.out.println("\n\nArquivos importados com sucesso!");

        return campeonato;
    }

    public static void gravar_arquivo(){
        File arquivo = new File("campeonato.dat");
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            // gravando o vetor de pessoas no arquivo
            //oos.writeObject(campeonato);
            oos.flush();
            oos.close();
            fout.close();
        }
        catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
    }*/
}