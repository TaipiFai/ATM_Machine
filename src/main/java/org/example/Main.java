package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account referenceAccount = new Account(12345, 999, 10000.00, BankType.AUM);

        System.out.print("Введите номер карты: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Введите корректный номер карты!");
            return;
        }

        int inputCard = scanner.nextInt();

        System.out.print("Введите пин-код: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введите корректный пин-код!");
            return;
        }

        int inputPin = scanner.nextInt();

        if (referenceAccount.getCardNumber() != inputCard || referenceAccount.getPinCode() != inputPin) {
            System.out.println("Ошибка: Неверный номер карты или пин-код!");
            return;
        }

        System.out.println("Авторизация успешна!");

        CashMachine atm = new CashMachine();

        System.out.print("Внесите купюры: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: Некорректная сумма!");
            return;
        }

        Double depositAmount = scanner.nextDouble();

        if (depositAmount <= 0) {
            System.out.println("Ошибка: Некорректная сумма!");
            return;
        }

        referenceAccount.balance = atm.deposit(referenceAccount.getBalance(), depositAmount);
        System.out.printf("Ваш баланс: %.2f.%n", referenceAccount.getBalance());

        System.out.print("Введите сумму для снятия: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: Некорректная сумма!");
            return;
        }

        Double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount <= 0) {
            System.out.println("Ошибка: Некорректная сумма!");
            return;
        }

        Double oldBalance = referenceAccount.getBalance();
        referenceAccount.balance = atm.withdraw(oldBalance, withdrawAmount, referenceAccount.getBankType());

        System.out.printf("Ваш баланс: %.2f.%n", referenceAccount.getBalance());
        scanner.close();
    }
}