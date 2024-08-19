import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class simuladorTorneio implements Serializable{
    public static final Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
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

    private static void salvarTorneio(){

    }

    private static void carregarTorneio(){

    }
}