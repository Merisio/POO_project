public class JogoDado {
    private Dado dado = new Dado();
    private int qtd;
    private int soma;

    public JogoDado(){}

    public JogoDado(int q){
        this.qtd = q;
    }

    public void rolarDados(){
        dado.roll();
    }

    public int somaDados(){
        soma = this.dado.getFace() + this.dado.getFace();
        return soma;
    }

    public void jogoAzar(){
        int aux = 0;

        while(soma != aux){
            System.out.println( 1 + "º Lancamento: ");
            rolarDados();
            somaDados();
            //System.out.println(dado[0].getFace()+ "e" +dado[1].getFace()+ " = " +this.soma);
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
        return dado + " e " + dado;
    }

    public int regraDoJogo(int valor, int procurar){
        if(procurar == 0){
            if(valor == 7 ||valor ==11){
                return 1;
            }else if (valor == 2 || valor == 3 || valor == 12){
                return 2;
            }else{
                return 0;
            }
        }else if (valor == procurar){
            return 1;
        }else{
            return 0;
        } 
    }
    public void JogoAzar(){
        System.out.println("[Nova Jogada]");
        rolarDados();
        System.out.println(dado);
    }
}
