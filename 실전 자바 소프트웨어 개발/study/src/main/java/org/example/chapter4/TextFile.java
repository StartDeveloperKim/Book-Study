package org.example.chapter4;

import org.example.chapter4.importer.Attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TextFile {

    private final Map<String, String> attributes;
    private final List<String> lines;

    public TextFile(File file) throws IOException {
        attributes = new HashMap<>();
        attributes.put(Attributes.PATH.getName(), file.getPath());
        lines = Files.lines(file.toPath()).collect(Collectors.toList());
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void addLineSuffix(final String prefix, final String attributeName) {
        for (String line : lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }

    public int addLines(int start, Predicate<String> isEnd, String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }

            accumulator.append(line);
            accumulator.append("\n");
        }
        attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }
}
