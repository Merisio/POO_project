import java.util.Scanner;

public class simuladorTorneio{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o numero de jogadores: ");
        int num = teclado.nextInt();

        if (num >= 2){
            Torneio campeonato = new Torneio();
            campeonato.iniciarTorneio(num);
        }
    }
}