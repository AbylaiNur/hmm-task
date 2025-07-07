package org.abylai;

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

    }
}