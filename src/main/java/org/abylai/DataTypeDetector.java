package org.abylai;

public class DataTypeDetector {
    public static DataType detect(String line) {
        if (isInteger(line)) return DataType.INTEGER;
        if (isFloat(line)) return DataType.FLOAT;
        return DataType.STRING;
    }

    private static boolean isInteger(String s) {
        return s.matches("[+-]?\\d+");
    }

    private static boolean isFloat(String s) {
        // TODO: Проверить на баги
        return s.matches("[+-]?(\\d+\\.\\d*|\\d*\\.\\d+)([eE][+-]?\\d+)?")
                || s.matches("[+-]?\\d+[eE][+-]?\\d+");
    }
}
