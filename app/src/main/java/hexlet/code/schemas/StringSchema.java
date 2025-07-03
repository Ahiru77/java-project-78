package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public StringSchema contains(String str) {
        addRule("contains", value -> value != null && String.valueOf(value).contains(str));
        return this;
    }
    public StringSchema minLength(int len) {
        addRule("minLength", value -> value != null && String.valueOf(value).length() >= len);
        return this;
    }
    public StringSchema required() {
        addRule("required", value -> !String.valueOf(value).isEmpty() && value != null);
        requiredOn = true;
        return this;
    }
}
