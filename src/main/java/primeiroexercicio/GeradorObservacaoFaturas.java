package primeiroexercicio;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public abstract class GeradorObservacaoFaturas {
    private static final String MSG_RETORNO = "Fatura %s de simples remessa: %s.";
    private static final String MSG_RETORNO_VALOR = "%d cujo valor é R$ %.2f";
    private static final String MSG_TOTAL = " Total = R$ %.2f";

    public static String gerar(List<Integer> faturas) {
        if (faturas == null || faturas.isEmpty()) {
            return EMPTY;
        }
        if (faturas.size() == 1) {
            return format(MSG_RETORNO, "da nota fiscal", faturas.get(0));
        }
        List<String> faturasStr = faturas.stream().map(Object::toString).collect(Collectors.toList());
        int ultimaFatura = faturas.size() - 1;
        String faturasMsg = join(" e ", join(", ", faturasStr.subList(0, ultimaFatura)), faturasStr.get(ultimaFatura));
        return format(MSG_RETORNO, "das notas fiscais", faturasMsg);
    }

    public static String gerar(Map<Integer, BigDecimal> faturas) {
        if (faturas == null || faturas.isEmpty()) {
            return EMPTY;
        }
        if (faturas.size() == 1) {
            Map.Entry<Integer, BigDecimal> entry = faturas.entrySet().iterator().next();
            BigDecimal valorFatura = entry.getValue();
            return format(MSG_RETORNO, "da nota fiscal",
                    format(MSG_RETORNO_VALOR, entry.getKey(), valorFatura) + "." + format(MSG_TOTAL, valorFatura));
        }
        StringBuilder msgRetorno = new StringBuilder(faturas.size());
        BigDecimal totalFatura = BigDecimal.ZERO;
        for (Iterator<Map.Entry<Integer, BigDecimal>> faturaIter = faturas.entrySet().iterator(); faturaIter.hasNext(); ) {
            Map.Entry<Integer, BigDecimal> fatura = faturaIter.next();
            BigDecimal valorFatura = fatura.getValue();
            totalFatura = totalFatura.add(valorFatura);
            if (msgRetorno.length() > 1) {
                msgRetorno.append(faturaIter.hasNext() ? ", " : " e ");
            }
            msgRetorno.append(format(MSG_RETORNO_VALOR, fatura.getKey(), valorFatura));
        }
        return format(MSG_RETORNO, "das notas fiscais", msgRetorno) + format(MSG_TOTAL, totalFatura);
    }
}