package segundoexercicio;

import segundoexercicio.jsonutils.JsonProcessor;
import segundoexercicio.model.Composicoes;
import segundoexercicio.services.ComposicoesService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SegundoExercicio {
    private static final Logger logger = LoggerFactory.getLogger(ComposicoesService.class);

    public static void main(String[] args) {
        logger.info("Processo de cálculo das composições iniciado!");
        JsonProcessor jsonProcessor = new JsonProcessor();
        List<Composicoes> composicoesList = jsonProcessor.processar();
        jsonProcessor.imprimirJson(new ComposicoesService().calcularValoresUnitarios(composicoesList));
        logger.info("Processo de cálculo das composições finalizado!");
    }
}