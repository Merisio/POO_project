public class Teste {
    public static void main(String[] args){
        Dado v = new Dado();
        JogoDado dice = new JogoDado();
        dice.rolarDados();
        int teste = dice.getSideUp();

        System.out.println(teste);
        System.out.println(v);
    }
}
