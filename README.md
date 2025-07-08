## Требования к окружению

| Компонент   | Версия (проверено) |
|-------------|--------------------|
| **Java SE** | 23 (≥23.0.0)       |
| **Maven**   | 3.9.10 или новее   |

> ❗Тестировалась только на Java 23.

---

## Сборка проекта

```bash
# Клонируем репозиторий и собираем fat‑jar
$ mvn clean package
```

После сборки исполняемый файл лежит в `target/shift-task-1.0-SNAPSHOT.jar`.

---

## Запуск утилиты

```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar [опции] <входные_файлы...>
```

### Поддерживаемые опции

| Опция | Аргумент    | Назначение                                                                                        |
| ----- | ----------- |---------------------------------------------------------------------------------------------------|
| `-o`  | `<путь>`    | Каталог для размещения выходных файлов. По умолчанию — текущий каталог.                           |
| `-p`  | `<префикс>` | Префикс имён выходных файлов (например `result_` → `result_integers.txt`).                        |
| `-a`  | —           | **Append**‑режим. Добавляет данные к существующим файлам вместо перезаписи.                       |
| `-s`  | —           | Вывод **краткой** статистики (только количество элементов).                                       |
| `-f`  | —           | Вывод **полной** статистики. Для чисел: min/max/sum/avg. Для строк: длина самой короткой/длинной. |

> Если не указано ни один из `-s` и `-f`, то по умолчанию ничего не выводиться.

## Структура проекта

```
shift-task/
 ├── src/main/java/org/abylai/...
 ├── pom.xml 
 ├── tests
 ├── TESTS.md
 └── README.md
```

### Используемые зависимости

| Группа                     | Артефакт             | Версия | Назначение                           |
| -------------------------- | -------------------- | ------ |--------------------------------------|
| `org.apache.maven.plugins` | `maven-shade-plugin` | 3.5.1  | Создает executable JAR. |

Плагин shade документация: https://maven.apache.org/plugins/maven-shade-plugin/

В проекте **нет** сторонних библиотек рантайма; используется только стандартный JDK.


### Тесты

1. По умолчанию
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/default tests/default/in1.txt tests/default/in2.txt
```

2. Проверка добавления префикса
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -p res_ -o tests/prefix tests/prefix/in.txt
```

3. Проверка -a append
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -a -o tests/append tests/append/in.txt
```

4. Проверка -s short
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -s -o tests/short tests/short/in.txt
```

5. Проверка -f full
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -f -o tests/full tests/full/in.txt
```

6. Если в файле пусто. Не должно создавать файлы
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/empty tests/empty/in.txt
```

7. Проверка на обработку ошибка когда нету указанных файлов
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -s -o tests/no_file tests/no_file/in1.txt tests/no_file/in2.txt
```

8. Только строки
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/only_strings tests/only_strings/in.txt
```

9. Проверка float при scientific notation
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/scientific tests/scientific/in.txt
```
