public class Jogador{
    private JogoDado jogo = new JogoDado();
    private int id;
    private int tipo;
    private double saldo;
    private double valorDeAposta;

    // Construtores.
    public Jogador(int tipo){
        this.tipo = tipo;
    }
    public Jogador(int tipo, int id, double sl){
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
    public void setSaldo(double s){
        this.saldo = s;
    }
    public void setAposta(double v){
        this.valorDeAposta = v;
    }

    // Getters.
    public int getId(){
        return this.id;
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

    // Resultado do Jogo de Azar.
    public int resultadoAzar(){
        jogo.jogoAzar();
        return jogo.getResult();
    }

    // Resultado do Jogo Porquinho.
    /*public int resultadoPorc(){
        return ;

    }*/
}