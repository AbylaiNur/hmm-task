package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.IOException;

public class StringWriter extends Writer {

    private int countStat;
    private Integer minLengthStat;
    private Integer maxLengthStat;

    public StringWriter(Options options) throws IOException {
        super(options, DataType.STRING);
        countStat = 0;
    }

    @Override
    public void write(String line) throws IOException {
        super.write(line);
        accept(line);
    }

    @Override
    public void accept(String line) {
        if (countStat == 0) {
            minLengthStat = line.length();
            maxLengthStat = line.length();
        }
        countStat++;
        maxLengthStat = Math.max(maxLengthStat, line.length());
        minLengthStat = Math.min(minLengthStat, line.length());
    }

    @Override
    public void printStats() {
        if (super.options.statMode == Options.StatMode.SHORT) {
            String stat = "Strings: count=%d".formatted(
                    countStat
            );
            System.out.println(stat);
        } else if (super.options.statMode == Options.StatMode.FULL) {
            String stat = "Strings: count=%d, min_length=%s, max_length=%s".formatted(
                    countStat, minLengthStat, maxLengthStat
            );
            System.out.println(stat);
        }
    }
}
