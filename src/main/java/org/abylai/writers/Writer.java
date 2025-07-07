package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Writer implements AutoCloseable {
    protected final Options options;
    private final Path filepath;
    private BufferedWriter writer;

    public Writer(Options options, DataType dataType) throws IOException {
        this.options = options;

        String typeStr = switch (dataType) {
            case INTEGER -> "integers";
            case FLOAT -> "floats";
            case STRING -> "strings";
            case null -> null;
        };

        this.filepath = Paths.get(options.outputDir.toString(), options.prefix + typeStr + ".txt");
    }

    public void write(String line) throws IOException {
        if (writer == null) {
            // Проверка существует путь(директория) к файлу
            if (!options.outputDir.toFile().exists()) {
                options.outputDir.toFile().mkdirs();
            }

            writer = new BufferedWriter(new FileWriter(filepath.toFile(), options.append));
        }

        writer.write(line);
        writer.newLine();
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }

    // Добавляет значение в статистику
    public abstract void accept(String line);
    public abstract void printStats();
}
