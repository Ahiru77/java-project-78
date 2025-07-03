package hexlet.code.Schemas;
import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {
    public MapSchema sizeof(int size) {
        addRule("range", value -> value instanceof Map<?, ?> && ((Map<?, ?>) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (var entry : schemas.entrySet()) {
            var key = entry.getKey();
            var schema = entry.getValue();
            addRule("shape", value -> ((Map<?, ?>) value).containsKey(key)
                    && schema.isValid(((Map<?, ?>) value).get(key)));
        }
        return this;
    }

    public MapSchema required() {
        addRule("required", Objects::nonNull);
        requiredOn = true;
        return this;
    }
}
