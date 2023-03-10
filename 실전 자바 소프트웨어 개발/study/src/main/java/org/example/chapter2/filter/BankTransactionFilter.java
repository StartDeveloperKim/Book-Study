package org.example.chapter2.filter;

import org.example.chapter2.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
