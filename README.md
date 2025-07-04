### Hexlet tests and linter status:
[![Actions Status](https://github.com/Ahiru77/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Ahiru77/java-project-78/actions)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Ahiru77_java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Ahiru77_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Ahiru77_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Ahiru77_java-project-78)
## Описание
Валидатор данных – библиотека, с помощью которой можно проверять корректность данных типа String, int, Map.
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

```
 Для осуществления вложенной валидации объектов Map используется метод *shape*.
