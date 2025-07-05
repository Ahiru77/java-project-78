package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected  Map<String, Predicate<T>> map = new HashMap<>();
    protected  boolean requiredOn = false;


    public final void addRule(String rule, Predicate<T> state) {
        map.put(rule, state);
    }

    public final boolean isValid(T obj) {
        if (!requiredOn && obj == null) {
            return true;
        }
        var i = 0;
        for (var entry : map.entrySet()) {
            i = i + 1;
            System.out.println("Num of rule " + entry.getKey() + " is " + i + ", "
                    + "named as " + obj + " = " + !entry.getValue().test(obj) + ", cond is " + entry.getValue());
            if (!entry.getValue().test(obj)) {
                return false;
            }
        }
        return true;
    }
}
