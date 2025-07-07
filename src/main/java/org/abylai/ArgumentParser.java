package org.abylai;

import java.nio.file.Paths;

public class ArgumentParser {
    // Возвращает парсированные аргументы
    public static Options parseArgs(String[] args) {
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
                case "-s" -> options.statMode = Options.StatMode.SHORT;
                case "-f" -> options.statMode = Options.StatMode.FULL;
                default -> options.inputFiles.add(Paths.get(args[i]));
            }
        }
        return options;
    }
}
