package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class IntegerWriter extends Writer {

    private int countStat;
    private BigInteger maxStat;
    private BigInteger minStat;
    private BigInteger sumStat;

    public IntegerWriter(Options options) throws IOException {
        super(options, DataType.INTEGER);
        countStat = 0;
    }

    @Override
    public void write(String line) throws IOException {
        super.write(line);
        accept(line);
    }

    @Override
    public void accept(String line) {
        BigInteger b = new BigInteger(line);
        if (countStat == 0) {
            maxStat = b;
            minStat = b;
            sumStat = BigInteger.valueOf(0);
        }
        countStat++;
        maxStat = b.max(maxStat);
        minStat = b.min(minStat);
        sumStat = b.add(sumStat);
    }

    @Override
    public void printStats() {
        if (super.options.statMode == Options.StatMode.SHORT) {
            String stat = "Integers: count=%d".formatted(
                    countStat
            );
            System.out.println(stat);
        } else if (super.options.statMode == Options.StatMode.FULL) {
            BigDecimal avgStat = null;
            if (countStat != 0) avgStat = new BigDecimal(sumStat).divide(BigDecimal.valueOf(countStat), 5, RoundingMode.HALF_UP);

            String stat = "Integers: count=%d, min=%s, max=%s, sum=%s, avg=%s".formatted(
                    countStat, minStat, maxStat, sumStat, avgStat
            );
            System.out.println(stat);
        }
    }
}
