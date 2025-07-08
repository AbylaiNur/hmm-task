1.
По умолчанию
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/default tests/default/in1.txt tests/default/in2.txt
```

2.
Проверка добавления префикса
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -p res_ -o tests/prefix tests/prefix/in.txt
```

3.
Проверка -a append
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -a -o tests/append tests/append/in.txt
```

4.
Проверка -s short
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -s -o tests/short tests/short/in.txt
```

5.
Проверка -f full
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -f -o tests/full tests/full/in.txt
```

6.
Если в файле пусто. Не должно создавать файлы
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/empty tests/empty/in.txt
```

7.
Проверка на обработку ошибка когда нету указанных файлов
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -s -o tests/no_file tests/no_file/in1.txt tests/no_file/in2.txt
```

8.
Только строки
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/only_strings tests/only_strings/in.txt
```

9.
Проверка float при scientific notation
```bash
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/scientific tests/scientific/in.txt
```
