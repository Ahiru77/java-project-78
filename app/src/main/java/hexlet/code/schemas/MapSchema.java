package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCheck("required", value -> value instanceof Map<?, ?>);
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int num) {
        addCheck("sizeof", value -> ((Map<?, ?>) value).size() >= num);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (var entry : schemas.entrySet()) {
            var key = entry.getKey();
            var val = entry.getValue();
            addCheck("shape", value -> val.isValid(((Map<?, ?>) value).get(key)));
        }
        return this;
    }
}
