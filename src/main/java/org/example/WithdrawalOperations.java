package org.example;

public interface WithdrawalOperations {
    Double withdraw(Double currentBalance, Double amount, BankType BankType);

    default Double calculateComission(Double amount, BankType BankType){
        if (amount == null || BankType == null){
            return 0.0;
        }

        double rawComission = amount * BankType.getComission();

        return Math.round(rawComission * 100) / 100.0;
    }
}