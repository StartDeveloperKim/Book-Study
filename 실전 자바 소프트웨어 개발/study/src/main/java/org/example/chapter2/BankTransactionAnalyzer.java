package org.example.chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementParser bankStatementParser = new BankStatementCSVParser();
    // 인터페이스를 참조하게 함으로써 결합도를 낮춘다.
    // 만약 구현체를 변경한다하면 new 키워드를 통해 생성되는 객체만 변경하면 된다.

    public static void main(String[] args) throws IOException {


        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for all transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for all transactions in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }


}
