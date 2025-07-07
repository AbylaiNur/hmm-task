package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatWriter extends Writer {

    private int countStat;
    private BigDecimal maxStat;
    private BigDecimal minStat;
    private BigDecimal sumStat;

    public FloatWriter(Options options) throws IOException {
        super(options, DataType.FLOAT);
    }

    @Override
    public void write(String line) throws IOException {
        super.write(line);
        accept(line);
    }

    @Override
    public void accept(String line) {
        BigDecimal b = new BigDecimal(line);
        if (countStat == 0) {
            maxStat = new BigDecimal(line);
            minStat = new BigDecimal(line);
            sumStat = BigDecimal.valueOf(0);
        }
        countStat++;
        maxStat = b.max(maxStat);
        minStat = b.min(minStat);
        sumStat = b.add(sumStat);
    }

    @Override
    public void printStats() {
        if (super.options.statMode == Options.StatMode.SHORT) {
            String stat = "Floats: count=%d".formatted(
                    countStat
            );
            System.out.println(stat);
        } else if (super.options.statMode == Options.StatMode.FULL) {
            BigDecimal avgStat = null;
            if (countStat != 0) avgStat = sumStat.divide(BigDecimal.valueOf(countStat), 35, RoundingMode.HALF_UP);

            String stat = "Floats: count=%d, min=%s, max=%s, sum=%s, avg=%s".formatted(
                    countStat, minStat, maxStat, sumStat, avgStat
            );
            System.out.println(stat);
        }
    }
}
