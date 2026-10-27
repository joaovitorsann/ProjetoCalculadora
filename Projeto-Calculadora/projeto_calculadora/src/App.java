import calculadora.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {

        Calculadora calc = new Calculadora();

        System.out.println(calc.calc(0, 3, "/"));
    }
}
