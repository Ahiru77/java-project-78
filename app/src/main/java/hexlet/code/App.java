package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import hexlet.code.Schemas.BaseSchema;

public class App {
    public static void main(String... args) {
        var mapSchema = new Validator().map();
        Map<String, BaseSchema> data = new HashMap<>();
        data.put("firstName", new Validator().string().required());
        data.put("lastName", new Validator().string().required().minLength(2));
        mapSchema.shape(data);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        System.out.println("Human1 is " + mapSchema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        System.out.println("Human2 is " + mapSchema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        System.out.println("Human3 is " + mapSchema.isValid(human3));




        var numberSchema = new Validator().number();
        numberSchema.positive();
        System.out.println("20 is " + numberSchema.isValid(20));
        System.out.println("-20 is " + numberSchema.isValid(-20));
    }
}
