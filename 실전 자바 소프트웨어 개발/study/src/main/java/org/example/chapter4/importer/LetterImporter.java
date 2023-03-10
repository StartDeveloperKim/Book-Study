package org.example.chapter4.importer;

import org.example.chapter4.Document;
import org.example.chapter4.TextFile;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.example.chapter4.importer.Attributes.*;

public class LetterImporter implements Importer{

    private static final String NAME_PREFIX = "Dear";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT.getName());

        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS.getName());
        textFile.addLines(lineNumber + 1, line -> line.startsWith("regards,"), BODY.getName());

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE.getName(), "LETTER");

        return new Document(attributes);
    }
}
