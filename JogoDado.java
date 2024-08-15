public class JogoDado {
    private Dado[] dado = new Dado[2];
    private int qtd;
    private int soma;
    private int jogadas;
    private int result;

    // Construtores.
    public JogoDado(int q){
        this.qtd = q;
        this.jogadas =0;
        for(int i =0; i < qtd; i++){
            dado[i] = new Dado();
        }
    }

    // Setter e Getter do Resultado.
    public void setResult(int a){
        this.result = a;
    }
    public int getResult(){
        return result;
    }

    // Rola os dados do Jogo de Azar.
    public void rolarDados(){
        for(int i =0; i < qtd; i++){
            dado[i].roll();
        }
        
        //System.out.println(v);
    }

    // Soma os dois valores dos dados.
    public int somaDados(){
        soma = this.dado[0].getFace() + this.dado[1].getFace();
        return soma;
    }

    // Realiza o Jogo de Azar
    public void aplicaRegraAzar(){
        int aux = 0;
        jogadas = 1;

        while(true){// Repete ate que o valor estabelecido seja encontrado pelo jogador, ou ate que ele perca.
            // Mostra o numero de lancamentos ja executados.
            System.out.println( (jogadas) + "º Lançamento: ");
            // Rola e soma os dados.
            rolarDados();
            somaDados();
            // Mostra na tela os valores encontrados no dado.
            System.out.println(dado[0].getFace()+ " e " + dado[1].getFace()+ " = " +this.soma); 
            
            // Jogador ganha imediatamente se encontrar algum desses 3 valores.
            if(aux == 0 && soma == 7 || soma == 11){
                System.out.println("Jogador Ganhou!");
                setResult(1);
                break;
            }
            // Jogador perde imediatamente se encontrar algum desses 3 valores.
            else if(soma == 2 || soma == 3 || soma == 12){
                System.out.println("Jogador Perdeu");
                setResult(0);
                break;
            }
            // Caso nao ache nenhum daqueles valores, as rodadas se repetem ate que ganhe ou perca.
            else{
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

    public void aplicaPorquinho(){
        int pontos =0;
        while(pontos<300){

        }
    }

    public String toString(){
        return dado[0].getFace() + " e " + dado[1].getFace();
    }

}
