package org.example;

public enum BankType {
    NEO("НеоКредит Банк", 0.01),
    AUM("Арум Финтех", 0.02),
    VTA("Вектор Альянс Банк", 0.00);

    public final String BankName;
    public final double Comission;

    BankType(String BankName, double Comission) {
        this.BankName = BankName;
        this.Comission = Comission;
    }

    public String getBankName() {
        return this.BankName;
    }

    public double getComission() {
        return this.Comission;
    }
}