package org.example.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserTest {

    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = bankStatementParser.parseForm(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        assertEquals(expected.getDescription(), result.getDescription());
    }
}