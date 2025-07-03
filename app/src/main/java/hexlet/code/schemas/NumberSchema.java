package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCheck("required", value -> value instanceof Integer);
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> (Integer) value >= 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        addCheck("range", value -> (Integer) value >= a && (Integer) value <= b);
        return this;
    }
}
