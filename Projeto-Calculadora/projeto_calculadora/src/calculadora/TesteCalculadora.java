package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes unitários da classe {@link Calculadora}.
 *
 * @author João Vitor Alves dos Santos
 * @version 1.0
 */
public class TesteCalculadora {

    private Calculadora calculadora;

    /** Cria uma nova instância antes de cada teste. */
    @BeforeEach
    void preparar() {
        calculadora = new Calculadora();
    }

    /**
     * Executa a operação, exibe entradas/esperado/obtido e valida o resultado.
     *
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param op       operador
     * @param esperado texto esperado
     */
    private void verificar(int a, int b, String op, String esperado) {
        String obtido = calculadora.calc(a, b, op);
        System.out.println("Entradas: a=" + a + ", b=" + b + ", op=" + op);
        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido:   " + obtido);
        System.out.println("-----------------------------");
        assertEquals(esperado, obtido);
    }

    @Test
    void testeSoma() {
        verificar(5, 3, "+", "Resultado: 8");
    }

    @Test
    void testeSubtracao() {
        verificar(10, 4, "-", "Resultado: 6");
    }

    @Test
    void testeMultiplicacao() {
        verificar(6, 7, "*", "Resultado: 42");
    }

    @Test
    void testeDivisao() {
        verificar(20, 5, "/", "Resultado: 4");
    }

    @Test
    void testeDivisaoPorZero() {
        verificar(10, 0, "/", "Não é possível divisão por 0");
    }

    @Test
    void testeOperadorInvalido() {
        verificar(2, 3, "%", "Operador inválido, tente (+, -, / ou *)");
    }

    @Test
    void testeOperadorNulo() {
        verificar(2, 3, null, "Operador inválido, tente (+, -, / ou *)");
    }

    @Test
    void testeEstouroDeInteiro() {
        verificar(Integer.MAX_VALUE, 1, "+", "Resultado fora do limite permitido");
    }
}