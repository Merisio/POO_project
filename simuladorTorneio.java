import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class simuladorTorneio implements Serializable{
<<<<<<< HEAD
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int opcao;

        System.out.println("==== MENU INICIAL ====");
        System.out.println("1) Novo torneio;");
        System.out.println("2) Ler arquivo;");
        System.out.println("3) Sair.");
        System.out.println("Selecione a opcao desejada:");
        opcao = teclado.nextInt();

        switch (opcao){
            case 1:
                break;

            case 2:
                break;
        }

=======
    public static final Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
>>>>>>> 7ee3d369fd0b3da45613c74e7083bbf78453a0d1
        System.out.println("Insira o numero de jogadores: ");
        int num = teclado.nextInt();

        if (num >= 2){
            Torneio campeonato = new Torneio();
            System.out.println("1) Começar novo Campeonato.");
            System.out.println("2) Ver placar.");
            System.out.println("3) Salvar Campeonato.");
            System.out.println("3) Carregar Campeonato.");
            System.out.println("4) Sair.");
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
                default:
                    System.out.println("Opcao Invalida.");
                    break;
            }
        }
    }

<<<<<<< HEAD
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
=======
    private static void salvarTorneio(){

    }

    private static void carregarTorneio(){
>>>>>>> 7ee3d369fd0b3da45613c74e7083bbf78453a0d1

    }
}