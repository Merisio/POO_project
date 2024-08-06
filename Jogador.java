import java.util.Scanner;

public class Jogador{
    private int id;
    private int tipo;
    private double saldo;
    private double valorDeAposta;
    private int instancia;

    public Jogador(int tipo){
        this.tipo = tipo;
    }
    public Jogador(int tipo, int id){
        this.tipo = tipo;
        this.id = id;
    }
    public void setId(int d){
        this.id = d;
    }
    public void setTipo(int t){
        this.tipo = t;
    }
    public void setSaldo(double s){
        this.saldo = s;
    }
    public void setAposta(double v){
        this.valorDeAposta = v;
    }
    public int getId(){
        return id;
    }
    public int getTipo(){
        return this.tipo;
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