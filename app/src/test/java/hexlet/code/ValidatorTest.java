package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidatorTest {
    private static final StringSchema STRING_SCHEMA = new Validator().string();
    private static final NumberSchema NUMBER_SCHEMA = new Validator().number();
    private static final MapSchema MAP_SCHEMA = new Validator().map();

    @Test
    public void testString() {
        assertTrue(STRING_SCHEMA.isValid(null));
        assertTrue(STRING_SCHEMA.isValid("what does the fox say"));

        STRING_SCHEMA.required();
        assertFalse(STRING_SCHEMA.isValid(null));
        assertFalse(STRING_SCHEMA.isValid(""));

        STRING_SCHEMA.contains("fox");
        assertTrue(STRING_SCHEMA.isValid("what does the fox say"));
        assertFalse(STRING_SCHEMA.isValid("what does the fax say"));

        STRING_SCHEMA.minLength(4);
        assertTrue(STRING_SCHEMA.isValid("the fox"));
        assertFalse(STRING_SCHEMA.isValid("fox"));
    }

    @Test
    public void testNumber() {
        assertTrue(NUMBER_SCHEMA.isValid(null));
        assertTrue(NUMBER_SCHEMA.isValid(5));

        NUMBER_SCHEMA.required();
        assertFalse(NUMBER_SCHEMA.isValid(null));
        assertTrue(NUMBER_SCHEMA.isValid(10));

        NUMBER_SCHEMA.range(10, 20);
        assertTrue(NUMBER_SCHEMA.isValid(15));
        assertFalse(NUMBER_SCHEMA.isValid(5));

        NUMBER_SCHEMA.positive();
        assertTrue(NUMBER_SCHEMA.isValid(20));
        assertFalse(NUMBER_SCHEMA.isValid(-20));
    }

    @Test
    public void testMap() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertTrue(MAP_SCHEMA.isValid(null));
        assertTrue(MAP_SCHEMA.isValid(data));

        MAP_SCHEMA.required();
        assertFalse(MAP_SCHEMA.isValid(null));
        assertTrue(MAP_SCHEMA.isValid(data));

        MAP_SCHEMA.sizeof(2);
        assertFalse(MAP_SCHEMA.isValid(data));
        data.put("key2", "value2");
        assertTrue(MAP_SCHEMA.isValid(data));
    }

    @Test
    public void testMapShape() {
        HashMap<String, BaseSchema<String>> data = new HashMap<>();
        data.put("firstName", new Validator().string().required());
        data.put("lastName", new Validator().string().required().minLength(2));
        MAP_SCHEMA.shape(data);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(MAP_SCHEMA.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(MAP_SCHEMA.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(MAP_SCHEMA.isValid(human3));
    }
}
