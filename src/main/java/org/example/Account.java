package org.example;

public class Account {
    public int CardNumber;
    public int PinCode;
    public double balance;
    public BankType BankType;

    public Account(int CardNumber, int PinCode, double balance, BankType BankType) {
        if (CardNumber >= 10000 && CardNumber <= 99999) {
            this.CardNumber = CardNumber;
        } else {
            System.out.println("Ошибка: Некорректный номер карты");
            this.CardNumber = 0;
        }

        if (PinCode >= 100 && PinCode <= 999) {
            this.PinCode = PinCode;
        } else {
            System.out.println("Ошибка: некорректный пин-код");
            this.PinCode = 0;
        }

        if (balance == 0) {
            this.balance = 0.0;
        } else {
            this.balance = Math.round(balance * 100.0) / 100.0;
        }

        if (BankType == null) {
            this.BankType = org.example.BankType.NEO;
        } else {
            this.BankType = BankType;
        }
    }

    public int getCardNumber() {
        return this.CardNumber;
    }

    public int getPinCode() {
        return this.PinCode;
    }

    public Double getBalance() {
        return this.balance;
    }

    public BankType getBankType() {
        return this.BankType;
    }

    @Override
    public String toString() {
        String formattedBalance = String.format("%.2f", this.balance);
        return "«" + this.BankType.getBankName() + "» Карта: " + this.CardNumber + ", Баланс: " + formattedBalance + " руб.";
    }
}
