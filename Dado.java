import java.util.Random;
public class Dado{
    public int face;
    Random r = new Random();

    public Dado(){
        this.face = 0;
    }

    public void roll(){
        this.face = r.nextInt(6) + 1;
    }
    public void setFace(int a){
        this.face = a;
    }
    public int getFace(){
        return this.face;
    }

    public String toString(){
        return "Valor: " + this.face;
    }
}