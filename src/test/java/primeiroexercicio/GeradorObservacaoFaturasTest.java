package primeiroexercicio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.testng.annotations.Test;

import static primeiroexercicio.GeradorObservacaoFaturas.gerar;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.testng.Assert.assertEquals;

@Test
public class GeradorObservacaoFaturasTest {
    @Test
    public void testarPrimeiroCenarioFaturaNula() {
        String resultado = gerar(Collections.emptyList());
        assertEquals(resultado, EMPTY);
    }

    @Test
    public void testarPrimeiroCenarioFaturaUnica() {
        String resultado = gerar(Collections.singletonList(1));
        assertEquals(resultado, "Fatura da nota fiscal de simples remessa: 1.");
    }

    @Test
    public void testarPrimeiroCenarioFaturasMultiplas() {
        String resultado = gerar(Arrays.asList(1, 2, 3, 4));
        assertEquals(resultado, "Fatura das notas fiscais de simples remessa: 1, 2, 3 e 4.");
    }

    @Test
    public void testarSegundoCenarioFaturaNula() {
        String resultado = gerar(new HashMap<>());
        assertEquals(resultado, EMPTY);
    }

    @Test
    public void testarSegundoCenarioFaturaUnica() {
        HashMap<Integer, BigDecimal> faturasValores = new HashMap<>();
        faturasValores.put(1, new BigDecimal(10));
        String resultado = gerar(faturasValores);
        assertEquals(resultado, "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 10,00. Total = R$ 10,00.");
    }

    @Test
    public void testarSegundoCenarioFaturasMultiplas() {
        HashMap<Integer, BigDecimal> faturasValores = new HashMap<>();
        faturasValores.put(1, new BigDecimal(10));
        faturasValores.put(2, new BigDecimal(20));
        faturasValores.put(3, new BigDecimal(30));
        String resultado = gerar(faturasValores);
        assertEquals(resultado,
                "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10,00, 2 cujo valor é R$ 20,00 e 3 cujo valor é R$ 30,00. Total = R$ 60,00");
    }
}
