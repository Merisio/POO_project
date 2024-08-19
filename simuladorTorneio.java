import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class simuladorTorneio implements Serializable{
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

        System.out.println("Insira o numero de jogadores: ");
        int num = teclado.nextInt();

        if (num >= 2){
            Torneio campeonato = new Torneio();
            campeonato.iniciarTorneio(num);
            campeonato.mostrarPlacarFinal();
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