package org.abylai;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Options {
    public Path outputDir = Paths.get(".");
    public String prefix = "";
    public boolean append = false;
    public StatMode statMode = null;
    public List<Path> inputFiles = new ArrayList<>();

    public enum StatMode {
        SHORT, FULL
    }
}


