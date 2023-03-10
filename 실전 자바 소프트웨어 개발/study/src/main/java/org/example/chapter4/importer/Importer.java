package org.example.chapter4.importer;

import org.example.chapter4.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFile(File file) throws IOException;
}
