package segundoexercicio.services;

import segundoexercicio.model.Composicoes;
import segundoexercicio.model.TipoItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ComposicoesService {
    public List<Composicoes> calcularValoresUnitarios(List<Composicoes> composicoesList) {
        return doCalcularValoresUnitariosComposicoes(getComposicoesAgrupadas(composicoesList));
    }

    private BigDecimal calcularValorUnitarioComposicoes(List<Composicoes> composicoes) {
        return composicoes.stream().map(c -> c.getQuantidadeComposicao().multiply(c.getValorUnitario()).setScale(2, BigDecimal.ROUND_FLOOR)).reduce(
                BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_FLOOR);
    }

    private void calcularValorUnitarioSubComposicoes(Map<Long, List<Composicoes>> composicoesAgrupadas, Composicoes c) {
        List<Composicoes> composicaoItens = composicoesAgrupadas.get(c.getCodigoItem());
        List<Composicoes> subItensComposicao = composicaoItens.stream().filter(ci -> TipoItem.COMPOSICAO.equals(ci.getTipoItem())).collect(
                Collectors.toList());
        if (!subItensComposicao.isEmpty()) {
            subItensComposicao.forEach(sc -> calcularValorUnitarioSubComposicoes(composicoesAgrupadas, sc));
        }
        c.setValorUnitario(calcularValorUnitarioComposicoes(composicaoItens));
    }

    private List<Composicoes> doCalcularValoresUnitariosComposicoes(Map<Long, List<Composicoes>> composicoesAgrupadas) {
        List<Composicoes> composicoesCalculadas = new ArrayList<>();
        composicoesAgrupadas.forEach((key, composicoes) -> {
            composicoes.stream().filter(c -> TipoItem.COMPOSICAO.equals(c.getTipoItem())).forEach(
                    c -> calcularValorUnitarioSubComposicoes(composicoesAgrupadas, c));
            Composicoes primeiraComposicao = composicoes.get(0);
            composicoesCalculadas.add(Composicoes.create()
                    .codigoComposicao(key)
                    .descricaoComposicao(primeiraComposicao.getDescricaoComposicao())
                    .unidadeComposicao(primeiraComposicao.getUnidadeComposicao())
                    .valorUnitario(calcularValorUnitarioComposicoes(composicoes))
                    .build());
        });
        composicoesCalculadas.sort(Comparator.comparing(Composicoes::getCodigoComposicao));
        return composicoesCalculadas;
    }

    private Map<Long, List<Composicoes>> getComposicoesAgrupadas(List<Composicoes> composicoesList) {
        return composicoesList.stream().collect(groupingBy(Composicoes::getCodigoComposicao));
    }
}
