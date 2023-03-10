package org.example.chapter2.filter;

import org.example.chapter2.domain.BankTransaction;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter{
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
