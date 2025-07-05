package hexlet.code.schemas;
import java.util.Map;
import java.util.Objects;

public final class MapSchema<A, B> extends BaseSchema<Map<A, B>> {
    public MapSchema<A, B> sizeof(int size) {
        addRule("range", value -> value.size() == size);
        return this;
    }

    public MapSchema<A, B> shape(Map<A, BaseSchema<B>> schemas) {
        addRule("shape", map -> schemas.entrySet().stream().allMatch(e -> {
            A key = e.getKey();
            BaseSchema<B> schema = e.getValue();
            return (map.containsKey(key)
                    && schema.isValid(map.get(key)));
        })
        );
        return this;
    }

    public MapSchema<A, B> required() {
        addRule("required", Objects::nonNull);
        requiredOn = true;
        return this;
    }
}
