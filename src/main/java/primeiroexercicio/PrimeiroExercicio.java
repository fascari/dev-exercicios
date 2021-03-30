package primeiroexercicio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

import static primeiroexercicio.GeradorObservacaoFaturas.gerar;
import static java.util.Collections.singletonList;

public class PrimeiroExercicio {
    public static void main(String[] args) {
        gerarPrimeiroCenario();
        System.out.println("\n");
        gerarSegundoCenario();
    }

    private static void gerarPrimeiroCenario() {
        System.out.println("==== PRIMEIRO CENÁRIO ====");
        System.out.println("\n");
        System.out.println("> FATURA ÚNICA");
        System.out.println(gerar(singletonList(1)));
        System.out.println("> MÚLTIPLAS FATURAS");
        System.out.println(gerar(Arrays.asList(1, 2, 3, 4)));
    }

    private static void gerarSegundoCenario() {
        System.out.println("==== SEGUNDO CENÁRIO ====");
        System.out.println("\n");
        System.out.println("> FATURA ÚNICA - VALOR");
        HashMap<Integer, BigDecimal> faturasValores = new HashMap<>();
        faturasValores.put(1, new BigDecimal(10));
        System.out.println(gerar(faturasValores));
        System.out.println("> MÚLTIPLAS FATURAS - VALOR");
        faturasValores = new HashMap<>();
        faturasValores.put(1, new BigDecimal(10));
        faturasValores.put(2, new BigDecimal(20));
        faturasValores.put(3, new BigDecimal(30));
        System.out.println(gerar(faturasValores));
    }
}