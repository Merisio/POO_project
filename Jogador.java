// Classe Jogador, que representa cada jogador do Torneio
public class Jogador{
    private JogoDado jogo;
    private int id;// Numero de identificacao do jogador.
    private int tipo; // Maquina ou humano.
    private int saldo; // Saldo total.
    private int valorDeAposta; // Valor que o jogador deseja apostar na rodada.

    // Construtores.
    public Jogador(int tipo){
        this.tipo = tipo;
    }
    public Jogador(int tipo, int id, int sl){
        this.tipo = tipo;
        this.id = id;
        this.saldo = sl;
    }

    // Setters.
    public void setId(int d){
        this.id = d;
    }
    public void setTipo(int t){
        this.tipo = t;
    }
    public void setSaldo(int s){
        this.saldo = s;
    }
    public void setAposta(int v){
        this.valorDeAposta = v;
    }

    // Getters.
    public int getId(){
        return this.id;
    }
    public int getTipo(){
        return this.tipo;
    }
    public int getSaldo(){
        return this.saldo;
    }
    public int getValorDeAposta(){
        return this.valorDeAposta;
    }

    // Resultado do Jogo de Azar.
    public int resultadoAzar(){
        jogo = new JogoDado(2);
        jogo.aplicaRegraAzar();
        return jogo.getResult();
    }

    // Resultado do Jogo Porquinho.
    public int resultadoPorc(){
        jogo = new JogoDado(2);
        jogo.aplicaPorquinho();
        return jogo.getResult();
    }
}