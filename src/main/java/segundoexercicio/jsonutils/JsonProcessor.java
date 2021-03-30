package segundoexercicio.jsonutils;

import segundoexercicio.model.Composicoes;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;

import static segundoexercicio.jsonutils.ObjectMapperSingleton.getInstance;

public class JsonProcessor {
    private static final String JSON_FILENAME = "json/dados-entrada-servicos-composicoes.json";
    private static final String MSG_ERRO_PROCESSAMENTO_JSON = "Erro ao processar o json de entrada das composições!";
    private final Logger logger = LoggerFactory.getLogger(JsonProcessor.class);

    public String getPrettyJson(List<Composicoes> composicoes) throws JsonProcessingException {
        return getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(composicoes);
    }

    public void imprimirJson(List<Composicoes> composicoes) {
        try {
            System.out.println(getPrettyJson(composicoes));
        } catch (JsonProcessingException e) {
            logger.error("Erro ao imprimir o json de composições calculadas.", e);
        }
    }

    public List<Composicoes> processar() {
        try {
            return Arrays.asList(getInstance().readValue(getFileFromResource(), Composicoes[].class));
        } catch (Exception e) {
            logger.error(MSG_ERRO_PROCESSAMENTO_JSON, e);
        }
        return Collections.emptyList();
    }

    private File getFileFromResource() throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(JSON_FILENAME);
        if (resource == null) {
            throw new IllegalArgumentException("Arquivo não encontrado! " + JSON_FILENAME);
        }
        return new File(resource.toURI());
    }
}
