import java.util.Scanner;

public class Jogador{
    private int id;
    private int tipo;
    private double saldo = 100;
    private double valorDeAposta;
    private int instancia;

    public Jogador(int tipo){
        this.tipo = tipo;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public double getValorDeAposta(){
        return this.valorDeAposta;
    }
    public void Apostar(double valor){
        this.valorDeAposta = valor;
    }
    public void jogarDados(){

    }
}