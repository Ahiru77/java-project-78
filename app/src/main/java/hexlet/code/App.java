package hexlet.code;

public class App {

    public static void main(String... args) {
        var ex = new Validator();
        var a = ex.string();
        System.out.println(a.minLength(8).contains("trog").isValid(null));
        System.out.println(a.required().minLength(2).contains("trog").isValid("trogs"));
        System.out.println(a.required().minLength(2).contains("trog").isValid("t"));
    }
}
