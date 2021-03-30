package segundoexercicio.jsonutils;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String numberString = parser.getText();
        if (numberString == null || numberString.isEmpty()) {
            return null;
        }
        if (numberString.contains(",")) {
            return new BigDecimal(numberString.replace(",", "."));
        }
        return new BigDecimal(numberString);
    }

}