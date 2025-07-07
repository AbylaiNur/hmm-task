package org.abylai;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DataTypeDetector {
    public static DataType detect(String line) {
        if (isInteger(line)) return DataType.INTEGER;
        if (isFloat(line)) return DataType.FLOAT;
        return DataType.STRING;
    }

    private static boolean isInteger(String s) {
        boolean looksLikeDecimal = s.indexOf('.') >= 0 || s.indexOf('e') >= 0 || s.indexOf('E') >= 0;
        if (looksLikeDecimal) return false;
        try {
            new BigInteger(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        boolean looksLikeDecimal = s.indexOf('.') >= 0 || s.indexOf('e') >= 0 || s.indexOf('E') >= 0;
        if (!looksLikeDecimal) return false;
        try {
            new BigDecimal(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
