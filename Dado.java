import java.util.Random;

// Classe Dado, que representa cada dado utilizado nos jogos.
public class Dado{
    public int face;
    Random r = new Random();

    // Construtor
    public Dado(){
        this.face = 0;
    }
    // Rola o dado ou seja, seta um valor aleatorio de um a seis na face.
    public void roll(){
        this.face = r.nextInt(6) + 1;
    }

    // Seta a face do dado com um valor a escolha.
    public void setFace(int a){
        this.face = a;
    }

    // Retorna a face do dado.
    public int getFace(){
        return this.face;
    }

    // toString
    public String toString(){
        return "Valor: " + this.face;
    }
}