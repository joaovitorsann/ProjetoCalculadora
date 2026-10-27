
package calculadora;

/**
 * Realiza faz contas básicas.
 *
 * @version 1.0
 * @author João Vitor Alves dos Santos
 */
public class Calculadora {

    /* Prefixo padrão exibido antes de todo resultado válido. */
    private static final String PREFIXO_R = "Resultado: ";

    /*  Mensagem exibida ao tentar dividir por zero. */
    private static final String MSG_DIVISAO_POR_ZERO = "Não é possível divisão por 0";

    /* Mensagem exibida quando o operador é nulo ou desconhecido. */
    private static final String MSG_OPERADOR_INVALIDO = "Operador inválido, tente (+, -, / ou *)";

    /* Mensagem exibida quando o resultado ultrapassa o limite do tipo int. */
    private static final String MSG_ESTOURO = "Resultado fora do limite permitido";

    /**
     * Faz uma operação matemática básica entre dois números inteiros.
     *
     * @param a  primeiro operando
     * @param b  segundo operando
     * @param op operador da operação: "+", "-", "*" ou "/"
     * @return mensagem com o resultado, ou mensagem de erro caso a operação
     *         seja inválida, seja uma divisão por zero ou cause estouro de int
     */
    public String calc(int a, int b, String op) {
        if (op == null) {
            return MSG_OPERADOR_INVALIDO;
        }

        try {
            switch (op) {
                case "+":
                    return formatar(somar(a, b));
                case "-":
                    return formatar(subtrair(a, b));
                case "*":
                    return formatar(multiplicar(a, b));
                case "/":
                    return dividir(a, b);
                default:
                    return MSG_OPERADOR_INVALIDO;
            }
        } catch (ArithmeticException e) {
            // Math.xxxExact lança esta exceção quando o resultado não cabe em um int
            return MSG_ESTOURO;
        }
    }

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro valor
     * @param b segundo valor
     * @return a soma de a e b
     * @throws ArithmeticException se o resultado ultrapassar o limite de int
     */
    private int somar(int a, int b) {
        return Math.addExact(a, b);
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a minuendo
     * @param b subtraendo
     * @return a diferença entre a e b
     * @throws ArithmeticException se o resultado ultrapassar o limite de int
     */
    private int subtrair(int a, int b) {
        return Math.subtractExact(a, b);
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return o produto de a por b
     * @throws ArithmeticException se o resultado ultrapassar o limite de int
     */
    private int multiplicar(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    /**
     * Divide dois números inteiros, validando divisão por zero.
     *
     * @param a dividendo
     * @param b divisor
     * @return mensagem com o quociente, ou mensagem de erro se b for zero
     */
    private String dividir(int a, int b) {
        if (b == 0) {
            return MSG_DIVISAO_POR_ZERO;
        }
        return formatar(a / b);
    }

    /**
     * Monta a mensagem final de um resultado válido.
     *
     * @param valor resultado calculado
     * @return texto no formato "Resultado: valor"
     */
    private String formatar(int valor) {
        return PREFIXO_R + valor;
    }
}