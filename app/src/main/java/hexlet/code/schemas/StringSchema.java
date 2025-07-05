package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema contains(String str) {
        addRule("contains", value -> value != null && value.contains(str));
        return this;
    }
    public StringSchema minLength(int len) {
        addRule("minLength", value -> value != null && value.length() >= len);
        return this;
    }
    public StringSchema required() {
        addRule("required", value -> !String.valueOf(value).isEmpty() && value != null);
        requiredOn = true;
        return this;
    }
}
