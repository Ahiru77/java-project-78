package hexlet.code;

import hexlet.code.Schemas.StringSchema;
import hexlet.code.Schemas.NumberSchema;
import hexlet.code.Schemas.MapSchema;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }
    public NumberSchema number() {
        return new NumberSchema();
    }
    public MapSchema map() {
        return new MapSchema();
    }
}
