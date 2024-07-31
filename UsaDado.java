public class UsaDado {
    public static void main(String[] args){
        Dado v = new Dado();
        v.roll();
        int valor = v.getFace();

        System.out.println(valor);
        System.out.println(v);
    }
}
