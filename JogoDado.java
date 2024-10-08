// Clase JogoDado, que executa os jogos de dado escolhidos no Torneio.
public class JogoDado {
    private Dado[] dado = new Dado[2];
    private int qtd;
    private int soma;
    private int jogadas;
    private int result;
    private int mult;

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
        for(int i =0; i < qtd; i++)
            dado[i].roll();
    }

    // Soma os dois valores dos dados.
    public void somaDados(){
        this.soma = this.dado[0].getFace() + this.dado[1].getFace();
    }

    // Multiplica os dois valores dos dados.
    public void multiplicaDados(){
        this.mult = this.dado[0].getFace() * this.dado[1].getFace();
    }

    // Realiza o Jogo de Azar.
    public void aplicaRegraAzar(){
        int aux = 0;
        jogadas = 1;

        while(true){// Repete ate que o valor estabelecido seja encontrado pelo jogador, ou ate que ele perca.
            // Mostra o numero de lancamentos ja executados.
            System.out.println( (jogadas) + "º Lancamento: ");
            // Rola e soma os dados.
            rolarDados();
            somaDados();
            // Mostra na tela os valores encontrados no dado.
            System.out.println("    "+dado[0].getFace()+ " e " + dado[1].getFace()+ " = " +this.soma); 
            
            // Jogador ganha imediatamente se encontrar algum desses 3 valores.
            if(aux == 0 && soma == 7 || soma == 11){
                System.out.println("--> Jogador Ganhou!");
                setResult(1);
                break;
            }
            // Jogador perde imediatamente se encontrar algum desses 3 valores.
            else if(soma == 2 || soma == 3 || soma == 12){
                System.out.println("--> Jogador Perdeu");
                setResult(0);
                break;
            }
            // Caso nao ache nenhum daqueles valores, as rodadas se repetem ate que ganhe ou perca.
            else{
                if(aux == 0){
                    aux = soma;
                    System.out.println("**Numero a ser buscado: " + aux);
                }
                else if(soma == aux){
                    System.out.println("--> Jogador ganhou!");
                    setResult(1);
                    break;
                }
            }
            jogadas++; // incrementa o numero de jogadas.
        }
    }

    // Realiza o Jogo do Porquinho
    public void aplicaPorquinho(){
        int pontos = 0;

        while(pontos < 300){
            jogadas++;// Incrementa o numero de jogadas.

            System.out.println((jogadas + "º Lancamento: "));
            // Rola e multiplica os dados.
            rolarDados(); 
            multiplicaDados();

            // Mostra na tela os valores encontrados no dado.
            System.out.println(dado[0].getFace()+ " e " + dado[1].getFace()+ " = " +this.mult);
            
            // Caso em que os valores sao 2 uns, rendendo 30 pontos para o jogador.
            if(this.mult == 1){
                pontos += 30;
                System.out.println("*Doble de As*");
            }
            else if(dado[0].getFace() == dado[1].getFace()){
            // Caso em que o jogador tira 2 numeros iguais, tendo sua pontuacao dobrada.
                pontos += (this.mult *2);
                System.out.println("*Doble*");
            }
            else // Atribui o valor encontrado na pontuacao
                pontos += this.mult;

            System.out.println("--> Pontuacao: "+pontos);// Mostra a pontuacao na tela.
            System.out.println("");

            if(pontos > 300)
                setResult(jogadas);
        }
    }

    // toString para mostrar na tela.
    public String toString(){
        return dado[0].getFace() + " e " + dado[1].getFace();
    }
}