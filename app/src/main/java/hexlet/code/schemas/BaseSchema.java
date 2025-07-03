package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private Map<String, Predicate<Object>> map = new HashMap<>();
    public boolean requiredOn = false;

    public void addRule(String rule, Predicate<Object> state) {
        map.put(rule, state);
    }

    public boolean isValid(Object obj) {
        if (!requiredOn && obj == null) {
            return true;
        }
        var i = 0;
        for (var entry : map.entrySet()) {
            i = i + 1;
            System.out.println("Num of rule " + entry.getKey() + " is " + i);
            if (!entry.getValue().test(obj)) {
                return false;
            }
        }
        return true;
    }
}
