import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.Scanner;

public class simuladorTorneio implements Serializable{

    public static final Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Insira o numero de jogadores: ");
        int num = teclado.nextInt();
        int sair =0;

        while(sair != 5){
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
                        gravar_arquivo();
                        break;
                    case 4: 
                        campeonato = ler_arquivo(campeonato);
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

    public static Torneio[] ler_arquivo(Torneio campeonato){
        File arquivo = new File("backup.dat");
  
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            /*Lendo os objetos de um arquivo e fazendo a
            coercao de tipos*/
            
            campeonato = (Torneio[]) oin.readObject();
            oin.close();
            fin.close();
        
            //Uma forma de diferente do for para percorrer vetores
            for (Torneio c : campeonato){
                if (c != null){
                    System.out.println(c);
                }
            }
        }catch (Exception ex) {
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
    }
}