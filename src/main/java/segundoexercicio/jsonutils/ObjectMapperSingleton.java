package segundoexercicio.jsonutils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperSingleton {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private ObjectMapperSingleton() {
    }

    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }
}

