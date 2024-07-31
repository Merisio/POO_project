public class JogoDado {
    private Dado[] dado;
    private int qtd;
    private int soma;
    private int valor;

    public JogoDado(){}

    public JogoDado(int q){
        dado = new Dado[q];
        this.qtd = q;
        this.valor = 0;
    }

    public void setFace(int f){
        this.valor = f;
    }
    
    public int getSideUp(){
        return valor;
    }


    public void rolarDados(){
        Dado v = new Dado();
        for(int x = 0; x < qtd; x++){
            v.roll();
            dado[x].setFace(v.getFace());
        }
    }

    public int somaDados(){
        soma = this.dado[0].getFace() + this.dado[1].getFace();
        return soma;
    }

    public void jogoAzar(){
        int aux = 0;

        while(soma != aux){
            System.out.println( 1 + "º Lancamento: ");
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
                System.out.println("Numero a ser buscado: "+this.soma);
                    if(soma == aux){
                        System.out.println("Jogador Ganhou!");
                    }
                }
            }
        }

    public String toString(){
        return "A";
    }
}
