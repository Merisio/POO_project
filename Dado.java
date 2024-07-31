import java.util.Random;
public class Dado{
    public int face;
    Random r = new Random();

    public Dado(){}

    public void roll(){
        face = r.nextInt(6) + 1;
    }

    public int getFace(){
        return this.face;
    }
    public void setFace(int f){
        this.face = f;
    }

    public String toString(){
        return "Valor: " + this.face;
    }
}