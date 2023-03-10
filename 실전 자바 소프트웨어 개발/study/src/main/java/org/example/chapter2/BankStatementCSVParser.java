package org.example.chapter2;

import org.example.chapter2.domain.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final int EXPECTED_ATTRIBUTES_LENGTH = 3;

    @Override
    public BankTransaction parseForm(String line) {
        final String[] columns = line.split(",");

//        if (columns.length < EXPECTED_ATTRIBUTES_LENGTH) {
//            throw new CSVSyntaxException();
//        }
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines) {
            bankTransactions.add(parseForm(line));
        }
        return bankTransactions;
    }
}
