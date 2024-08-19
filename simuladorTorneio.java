import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.util.Scanner;

public class simuladorTorneio implements Serializable{

    public static final Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Insira o numero de jogadores: ");
        int num = teclado.nextInt();

        if (num >= 2){
            Torneio campeonato = new Torneio();
            System.out.println("==== MENU INICIAL ====");
            System.out.println("1) Comecar novo Campeonato.");
            System.out.println("2) Ver placar.");
            System.out.println("3) Salvar Campeonato.");
            System.out.println("4) Carregar Campeonato.");
            System.out.println("5) Sair.");
            System.out.println("Selecione o que deseja:");
            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    campeonato.iniciarTorneio(num);  
                    break;
                case 2:
                    campeonato.mostrarPlacarFinal();
                    break;
                case 3:
                    salvarTorneio();
                    break;
                case 4: 
                    carregarTorneio();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao Invalida.");
                    break;
            }
        }
    }

    public static void ler_arquivo(){
        File arquivo = new File("campeonato.dat");
  
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            /*Lendo os objetos de um arquivo e fazendo a
            coercao de tipos*/
            
            //Pessoa[] agendaArq = (Pessoa[]) oin.readObject();
            oin.close();
            fin.close();
        
            //Uma forma de diferente do for para percorrer vetores
            /*for (Pessoa p : agendaArq) {
                p.imprimirDados();
            }*/
        }catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
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
    }
}