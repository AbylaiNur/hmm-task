package org.abylai;

public class Logger {
    public static void error(String phase, Exception e) {
        System.err.printf("[ERROR] %s : %s%n", phase, e.getMessage());
    }
}
