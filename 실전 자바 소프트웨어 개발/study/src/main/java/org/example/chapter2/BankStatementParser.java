package org.example.chapter2;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseForm(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
