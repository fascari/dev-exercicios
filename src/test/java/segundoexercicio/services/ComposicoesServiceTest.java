package segundoexercicio.services;

import segundoexercicio.jsonutils.JsonProcessor;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;

import static org.testng.Assert.assertEquals;

@Test
public class ComposicoesServiceTest {
    private static final String JSON = "[ {\n" + "  \"codigoComposicao\" : 87286,\n"
            + "  \"descricaoComposicao\" : \"ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014\",\n"
            + "  \"unidadeComposicao\" : \"M3\",\n" + "  \"valorUnitario\" : 289.97\n" + "}, {\n" + "  \"codigoComposicao\" : 88830,\n"
            + "  \"descricaoComposicao\" : \"BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHP DIURNO. AF_10/2014\",\n"
            + "  \"unidadeComposicao\" : \"CHP\",\n" + "  \"valorUnitario\" : 1.25\n" + "}, {\n" + "  \"codigoComposicao\" : 88831,\n"
            + "  \"descricaoComposicao\" : \"BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHI DIURNO. AF_10/2014\",\n"
            + "  \"unidadeComposicao\" : \"CHI\",\n" + "  \"valorUnitario\" : 0.22\n" + "}, {\n" + "  \"codigoComposicao\" : 94793,\n"
            + "  \"descricaoComposicao\" : \"REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016\",\n"
            + "  \"unidadeComposicao\" : \"UN\",\n" + "  \"valorUnitario\" : 128.60\n" + "}, {\n" + "  \"codigoComposicao\" : 98561,\n"
            + "  \"descricaoComposicao\" : \"IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018\",\n"
            + "  \"unidadeComposicao\" : \"M2\",\n" + "  \"valorUnitario\" : 28.73\n" + "} ]";

    @Test
    public void testarCalculoComposicoes() {
        JsonProcessor jsonProcessor = new JsonProcessor();
        try {
            assertEquals(jsonProcessor.getPrettyJson(new ComposicoesService().calcularValoresUnitarios(jsonProcessor.processar())), JSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
