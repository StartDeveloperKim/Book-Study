package org.example.chapter2.summarizer;

import org.example.chapter2.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
