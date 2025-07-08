1.
По умолчанию
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/default tests/default/in1.txt tests/default/in2.txt
```

2.
Проверка добавления префикса
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -p res_ -o tests/prefix tests/prefix/in.txt
```

3.
Проверка -a append
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -a -o tests/append tests/append/in.txt
```

4.
Проверка -s short
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -s -o tests/short tests/short/in.txt
```

5.
Проверка -f full
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -f -o tests/full tests/full/in.txt
```

6.
Если в файле пусто. Не должно создавать файлы
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/empty tests/empty/in.txt
```

7.
Проверка на обработку ошибка когда нету указанных файлов
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -s -o tests/no_file tests/no_file/in1.txt tests/no_file/in2.txt
```

8.
Только строки
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/only_strings tests/only_strings/in.txt
```

9.
Проверка float при scientific notation
```
java -jar target/shift-task-1.0-SNAPSHOT.jar -o tests/scientific tests/scientific/in.txt
```
