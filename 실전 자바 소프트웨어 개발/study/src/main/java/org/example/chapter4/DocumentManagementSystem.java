package org.example.chapter4;

import org.example.chapter4.importer.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DocumentManagementSystem {

    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentView = Collections.unmodifiableList(documents); // 추가 및 삭제 행위를 막는다.
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("invoice", new InvoiceImporter());
        extensionToImporter.put("jpg", new ImageImporter());
    }

    public void importFile(String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf(".");
        if (separatorIndex != -1) {
            final String extension = path.substring(separatorIndex + 1); // 확장자 가져오기
            final Importer importer = extensionToImporter.get(extension); // 확장자를 통해 Importer 가져오기
            if (importer == null) {
                throw new IOException();
            }

            final Document document = importer.importFile(file);
            documents.add(document);
        }
    }

    public List<Document> contents() {
        return documentView;
    }

    public List<Document> search(final String query) {
        return documents.stream().filter(Query.parse(query))
                .collect(Collectors.toList());
    }
}
