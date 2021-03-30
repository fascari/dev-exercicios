package segundoexercicio.model;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static segundoexercicio.model.TipoItem.COMPOSICAO;

@Test
public class ComposicoesTest {
    private static final Long CODIGO_COMPOSICAO = 87286L;
    private static final Long CODIGO_ITEM = 88831L;
    private static final String DESCRICAO_COMPOSICAO = "ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014";
    private static final String DESCRICAO_ITEM_COMPOSICAO = "BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHI DIURNO. AF_10/2014";
    private static final BigDecimal QUANTIDADE_COMPOSICAO = BigDecimal.valueOf(3.91);
    private static final BigDecimal VALOR_UNITARIO = BigDecimal.valueOf(10.0);

    @Test
    public void build() {
        Composicoes composicoes = Composicoes.create().codigoComposicao(CODIGO_COMPOSICAO).codigoItem(CODIGO_ITEM).descricaoComposicao(
                DESCRICAO_COMPOSICAO).descricaoItemComposicao(DESCRICAO_ITEM_COMPOSICAO).quantidadeComposicao(QUANTIDADE_COMPOSICAO).tipoItem(
                COMPOSICAO).unidadeComposicao(Unidade.M3).unidadeItem(Unidade.CHI).valorUnitario(VALOR_UNITARIO).build();

        assertEquals(composicoes.getCodigoComposicao(), CODIGO_COMPOSICAO);
        assertEquals(composicoes.getCodigoItem(), CODIGO_ITEM);
        assertEquals(composicoes.getDescricaoComposicao(), DESCRICAO_COMPOSICAO);
        assertEquals(composicoes.getDescricaoItemComposicao(), DESCRICAO_ITEM_COMPOSICAO);
        assertEquals(composicoes.getQuantidadeComposicao(), QUANTIDADE_COMPOSICAO);
        assertEquals(composicoes.getTipoItem(), COMPOSICAO);
        assertEquals(composicoes.getUnidadeComposicao(), Unidade.M3);
        assertEquals(composicoes.getUnidadeItem(), Unidade.CHI);
        assertEquals(composicoes.getValorUnitario(), VALOR_UNITARIO);
    }
}
