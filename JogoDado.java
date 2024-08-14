public class JogoDado {
    private Dado v;
    private Dado v1;
    //private int qtd;
    private int soma;
    private int jogadas;
    private int result;

    public JogoDado(){
        v = new Dado();
        v1 = new Dado();
        //this.qtd = q;
        this.jogadas =0;
    }

    public void setResult(int a){
        this.result = a;
    }
    public int getResult(){
        return result;
    }

    public void rolarDados(){
        v.roll();
        v1.roll();
        //System.out.println(v);
    }

    public int somaDados(){
        soma = this.v.getFace() + this.v1.getFace();
        return soma;
    }


    public void jogoAzar(){
        int aux = 0;
        jogadas = 0;

        while(true){
            System.out.println( (jogadas + 1) + "º Lançamento: ");
            rolarDados();
            somaDados();
            System.out.println(v.getFace()+ " e " + v1.getFace()+ " = " +this.soma);
            if(aux == 0 && soma == 7 || soma == 11){
                System.out.println("Jogador Ganhou!");
                setResult(1);
                break;
            }else if (soma == 2 || soma == 3 || soma == 12){
                System.out.println("Jogador Perdeu");
                setResult(0);
                break;
            }else{
                if(aux == 0){
                    aux = soma;
                    System.out.println("Numero a ser buscado: " + aux);
                }
                else if(soma == aux){
                    System.out.println("Jogador Ganhou!");
                    setResult(1);
                    break;
                }
            }
            jogadas++;
        }
    }

    public void porquinho(){
        
    }

    public String toString(){
        return v.getFace() + " e " + v1.getFace();
    }

}
