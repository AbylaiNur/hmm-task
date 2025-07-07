package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.IOException;

public class IntegerWriter extends Writer {

    public IntegerWriter(Options options) throws IOException {
        super(options, DataType.INTEGER);
    }

    @Override
    public void write(String line) throws IOException {
        super.write(line);
    }
}
