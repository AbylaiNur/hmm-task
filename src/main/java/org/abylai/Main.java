package org.abylai;


import org.abylai.writers.FloatWriter;
import org.abylai.writers.IntegerWriter;
import org.abylai.writers.StringWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        run(args);
    }

    private static void run(String[] args) {
        Options options = ArgumentParser.parseArgs(args);

        try (
            IntegerWriter integerWriter = new IntegerWriter(options);
            FloatWriter floatWriter = new FloatWriter(options);
            StringWriter stringWriter = new StringWriter(options);
        ) {
            for (Path in : options.inputFiles) {
                try (BufferedReader br = Files.newBufferedReader(in, StandardCharsets.UTF_8)) {
                    br.lines().forEach(line -> {
                        switch (DataTypeDetector.detect(line)) {
                            case INTEGER -> integerWriter.write(line);
                            case FLOAT   -> floatWriter.write(line);
                            case STRING  -> stringWriter.write(line);
                        }
                    });
                } catch (NoSuchFileException e) {
                    Logger.error("No such file", e);
                } catch (AccessDeniedException e) {
                    Logger.error("Access denied", e);
                } catch (IOException e) {
                    Logger.error("I/O error", e);
                }
            }
            integerWriter.printStats();
            floatWriter.printStats();
            stringWriter.printStats();
        }
    }
}