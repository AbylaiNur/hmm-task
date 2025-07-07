package org.abylai;


import org.abylai.writers.FloatWriter;
import org.abylai.writers.IntegerWriter;
import org.abylai.writers.StringWriter;
import org.abylai.writers.Writer;

public class Main {
    public static void main(String[] args) {
        try {
            run(args);
        } catch (Exception e) {
            // TODO: Добавить нормальую обработку
            e.printStackTrace();
        }
    }

    private static void run(String[] args) throws Exception {
        Options options = ArgumentParser.parseArgs(args);
        try (Writer writer = new FloatWriter(options)) {
//            writer.write("1231412");
//            writer.write("99912312");
//            writer.write("-13212312");
//            writer.write("1.528535047E-25");

            writer.printStats();
        }
    }
}