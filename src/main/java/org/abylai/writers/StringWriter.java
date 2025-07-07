package org.abylai.writers;

import org.abylai.DataType;
import org.abylai.Options;

import java.io.IOException;

public class StringWriter extends Writer {

    public StringWriter(Options options) throws IOException {
        super(options, DataType.STRING);
    }

    @Override
    public void write(String line) throws IOException {
        super.write(line);
    }
}
