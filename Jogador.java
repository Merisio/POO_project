public class Jogador{
    private JogoDado jogo;
    private int id;
    private int tipo;
    private int saldo;
    private int valorDeAposta;

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
    /*public int resultadoPorc(){
        jogo = new JogoDado(2);
        jogo.aplicaPorquinho();
        return ;

    }*/
}