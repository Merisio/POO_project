public class JogoDado {
    private Dado v;
    private Dado v1;
    //private int qtd;
    private int soma;
    private int jogadas;

    public JogoDado(){
        v = new Dado();
        v1 = new Dado();
        //this.qtd = q;
        this.jogadas =0;
    }

    public void rolarDados(){
        v.roll();
        System.out.println(v);
    }

    public int somaDados(){
        soma = this.v.getFace() + this.v1.getFace();
        return soma;
    }

    public void jogoAzar(){
        int aux = 0;

        while(true){
            System.out.println( (jogadas + 1) + "º Lancamento: ");
            rolarDados();
            somaDados();
            System.out.println(v.getFace()+ "e" + v1.getFace()+ " = " +this.soma);
            if(soma == 7 || soma ==11){
                System.out.println("Jogador Ganhou!");
                break;
            }else if (soma == 2 || soma == 3 || soma == 12){
                System.out.println("Jogador Perdeu");
                break;
            }else{
                if(aux == 0){
                    aux = soma;
                    System.out.println("Numero a ser buscado: " + aux);
                }
                else if(soma == aux){
                    System.out.println("Jogador Ganhou!");
                    break;
                }
            }
            jogadas++;
        }
    }

    public String toString(){
        return v.getFace() + " e " + v1.getFace();
    }

}
