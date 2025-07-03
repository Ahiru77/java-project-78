package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {
    public NumberSchema range(int min, int max) {

        addRule("range", value -> value instanceof Integer && (Integer) value >= min && (Integer) value <= max);
        return this;
    }
    public NumberSchema positive() {
        addRule("positive", value -> value instanceof Integer && (Integer) value >= 0);
        return this;
    }
    public NumberSchema required() {
        addRule("required", Objects::nonNull);
        requiredOn = true;
        return this;
    }
}
