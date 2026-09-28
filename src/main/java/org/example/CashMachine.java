package org.example;

public class CashMachine implements WithdrawalOperations, DepositOperation {
    @Override
    public Double deposit(Double CurrentBalance, Double amount) {
        if (amount == null || amount <= 0) {
            return CurrentBalance;
        }

        double NewBalance = CurrentBalance + amount;
        return Math.round(NewBalance * 100.0) / 100.0;
    }

    @Override
    public Double withdraw(Double CurrentBalance, Double amount, BankType BankType) {
        Double Comission = calculateComission(amount, BankType);
        Double total = amount + Comission;

        if (total > CurrentBalance) {
            System.out.println("Ошибка: Недостаточно средств");
            return CurrentBalance;
        }

        double finalBalance = CurrentBalance - total;
        return Math.round(finalBalance * 100.0) / 100.0;
    }
}
