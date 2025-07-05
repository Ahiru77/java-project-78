package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema range(int min, int max) {

        addRule("range", value -> value >= min && value <= max);
        return this;
    }
    public NumberSchema positive() {
        addRule("positive", value -> value >= 0);
        return this;
    }
    public NumberSchema required() {
        addRule("required", Objects::nonNull);
        requiredOn = true;
        return this;
    }
}
