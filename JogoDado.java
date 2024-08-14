public class JogoDado {
    private Dado[] dado;
    private int qtd;
    private int soma;
    private int jogadas;

    public JogoDado(){}

    public JogoDado(int q){
        dado = new Dado[q];
        this.qtd = q;
        this.jogadas =0;
    }

    public void rolarDados(){
        Dado v = new Dado();
        for( int i = 0; i < this.qtd; i++){
            v.roll();
            System.out.println(v);
            dado[i].setFace(v.getFace());
        }
    }

    public int somaDados(){
        soma = this.dado[0].getFace() + this.dado[1].getFace();
        return soma;
    }

    public void jogoAzar(){
        int aux = 0;

        while(true){
            System.out.println( (jogadas + 1) + "º Lancamento: ");
            rolarDados();
            somaDados();
            System.out.println(dado[0].getFace()+ "e" +dado[1].getFace()+ " = " +this.soma);
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
        return dado[0].getFace() + " e " + dado[1].getFace();
    }
    
}
