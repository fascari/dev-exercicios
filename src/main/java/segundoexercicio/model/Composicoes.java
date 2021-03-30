package segundoexercicio.model;

import lombok.*;
import segundoexercicio.jsonutils.BigDecimalDeserializer;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Builder(builderMethodName = "create")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class Composicoes {
    private Long codigoComposicao;
    private Long codigoItem;
    private String descricaoComposicao;
    private String descricaoItemComposicao;
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    private BigDecimal quantidadeComposicao;
    private TipoItem tipoItem;
    private Unidade unidadeComposicao;
    private Unidade unidadeItem;
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    private BigDecimal valorUnitario;
}
