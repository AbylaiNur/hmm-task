package org.abylai;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Options {
    Path outputDir = Paths.get(".");
    String prefix = "";
    boolean append = false;
    // В задании нету упоминания про дефолтный режим, так что оставляю просто SHORT
    StatMode statMode = StatMode.SHORT;
    List<Path> inputFiles = new ArrayList<>();

    public enum StatMode {
        SHORT, FULL
    }
}


