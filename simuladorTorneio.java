import java.util.Scanner;

public class simuladorTorneio{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o número de jogadores:");
        int num = teclado.nextInt();

        Torneio campeonato = new Torneio();

        campeonato.iniciarTorneio(num);
    }
}