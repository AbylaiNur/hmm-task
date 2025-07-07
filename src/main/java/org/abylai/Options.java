package org.abylai;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Options {
    public Path outputDir = Paths.get(".");
    public String prefix = "";
    public boolean append = false;
    // В задании нету упоминания про дефолтный режим, так что оставляю просто SHORT
    public StatMode statMode = StatMode.SHORT;
    public List<Path> inputFiles = new ArrayList<>();

    public enum StatMode {
        SHORT, FULL
    }
}


