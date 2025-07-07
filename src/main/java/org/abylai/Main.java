package org.abylai;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            run(args);
        } catch (Exception e) {
            // TODO: Добавить нормальую обработку
            e.printStackTrace();
        }
    }

    private static void run(String[] args) {
        Options options = ArgumentParser.parseArgs(args);

    }
}