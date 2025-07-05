### Hexlet tests and linter status:
[![Actions Status](https://github.com/Ahiru77/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Ahiru77/java-project-78/actions)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Ahiru77_java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Ahiru77_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Ahiru77_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Ahiru77_java-project-78)
## Описание
Валидатор данных – библиотека, с помощью которой можно проверять корректность данных типа String, int, Map. Класс для начала валидации - *Validator*.
- При валидации строк доступны следующие проверки:
  - contains() — добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку
  - required() — делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение, которое не позволяет использовать null или пустую строку в качестве значения
  - minLength() — добавляет в схему ограничение минимальной длины для строки. Строка должна быть равна или длиннее указанного числа
```java
StringSchema schema = v.string().contains("fox").required();

schema.isValid("what does the fox say"); // true
schema.isValid("what does the dog say"); // false
schema.isValid(""); // false
```
- Для валидации чисел:   
  - required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
  - positive() — добавляет ограничение на знак числа. Число должно быть положительным
  - range() — добавляет допустимый диапазон, в который должно попадать значение числа включая границы
```java
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true
```
- Для валидации объектов типа Map:
  - required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения. Требуется тип данных Map
  - sizeof() — добавляет ограничение на размер мапы. Количество пар ключ-значений в объекте Map должно быть равно заданному
```java
MapSchema schema = v.map();

schema.required().sizeof(2);
Map<String, String> data = new HashMap<>();
schema.isValid(data);  // false
data.put("key1", "value1");
data.put("key2", "value2");
schema.isValid(data); // true
```
 Для осуществления вложенной валидации объектов Map используется метод *shape*.
 ```java
MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("firstName", new Validator().string().required());
schemas.put("lastName", new Validator().string().required().minLength(2));
schema.shape(schemas);

Map<String, Object> person01 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Petrovic");
schema.isValid(person01); // true

Map<String, Object> person02 = new HashMap<>();
human1.put("firstName", "Tom");
human1.put("lastName", null);
schema.isValid(person02); // false
```
