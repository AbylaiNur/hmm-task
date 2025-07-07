package org.abylai;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    // Возвращает парсированные аргументы
    private static Options parseArgs(String[] args) {
        Options options = new Options();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o" -> {
                    if (++i >= args.length) throw new IllegalArgumentException("Missing required argument");
                    options.outputDir = Paths.get(args[i]);
                }
                case "-p" -> {
                    if (++i >= args.length) throw new IllegalArgumentException("Missing required argument");
                    options.prefix = args[i];
                }
                case "-a" -> options.append = true;
                case "-s" -> options.statMode = StatMode.SHORT;
                case "-f" -> options.statMode = StatMode.FULL;
                default -> options.inputFiles.add(Paths.get(args[i]));
            }
        }

        return options;
    }

    private static class Options {
        Path outputDir = Paths.get(".");
        String prefix = "";
        boolean append = false;
        // В задании нету упоминания про дефолтный режим, так что оставляю просто SHORT
        StatMode statMode = StatMode.SHORT;
        List<Path> inputFiles = new ArrayList<>();
    }

    private enum StatMode {
        SHORT, FULL
    }
}