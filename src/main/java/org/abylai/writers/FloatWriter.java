package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.IOException;

public class FloatWriter extends Writer {

    public FloatWriter(Options options) throws IOException {
        super(options, DataType.FLOAT);
    }

    @Override
    public void write(String line) throws IOException {
        super.write(line);
    }
}
