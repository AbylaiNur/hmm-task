package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Logger;
import org.abylai.Options;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Writer implements AutoCloseable {
    protected final Options options;
    private Path filepath;
    private BufferedWriter writer;
    private boolean active;

    public Writer(Options options, DataType dataType) {
        this.options = options;

        String typeStr = switch (dataType) {
            case INTEGER -> "integers";
            case FLOAT -> "floats";
            case STRING -> "strings";
            case null -> null;
        };

        try {
            this.filepath = Paths.get(options.outputDir.toString(), options.prefix + typeStr + ".txt");
            active = true;
        } catch (InvalidPathException ex) {
            Logger.error("Invalid file path", ex);
        }
    }

    public void write(String line) {
        if (!active) return;
        if (writer == null) {
            // Проверка существует путь(директория) к файлу
            if (!options.outputDir.toFile().exists()) {
                options.outputDir.toFile().mkdirs();
            }
            try {
                writer = new BufferedWriter(new FileWriter(filepath.toFile(), options.append));
            } catch (IOException ex) {
                Logger.error("Error creating file", ex);
                return;
            }
        }

        try {
            writer.write(line);
            writer.newLine();
            accept(line);
        } catch (IOException ex) {
            Logger.error("Error writing line", ex);
        }
    }

    @Override
    public void close() {
        if (!active) return;
        if (writer != null) {
            try {
                writer.close();
                active = false;
            } catch (IOException ex) {
                Logger.error("Error closing writer", ex);
            }
        }
    }

    // Добавляет значение в статистику
    public abstract void accept(String line);
    public abstract void printStats();
}
