package tasks.lesson_17.by.yurachel.task_2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

    private ExchangeOffice exchangeOffice;
    private int sumOfOperationInCurrency;
    private int secondOperationInCurrency;
    private List<String> operations;
    private List<String> currency;
    private int amountOfOperations;
    private Random random = new Random();


    {
        operations = new ArrayList<>();
        operations.add("Sell");
        operations.add("Buy");
        operations.add("Both");

        currency = new ArrayList<>();
        currency.add("USD");
        currency.add("EUR");
    }

    public ExchangeOffice getExchangeOffice() {
        return exchangeOffice;
    }

    public void setExchangeOffice(ExchangeOffice exchangeOffice) {
        this.exchangeOffice = exchangeOffice;
    }

    public int getSumOfOperationInCurrency() {
        return sumOfOperationInCurrency;
    }

    public void setSumOfOperationInCurrency(int sumOfOperationInCurrency) {
        this.sumOfOperationInCurrency = sumOfOperationInCurrency;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void setCurrency(List<String> currency) {
        this.currency = currency;
    }

    public int getSecondOperationInCurrency() {
        return secondOperationInCurrency;
    }

    public void setSecondOperationInCurrency(int secondOperationInCurrency) {
        this.secondOperationInCurrency = secondOperationInCurrency;
    }

    public int getAmountOfOperations() {
        return amountOfOperations;
    }

    public void setAmountOfOperations(int amountOfOperations) {
        this.amountOfOperations = amountOfOperations;
    }

    public Client(ExchangeOffice exchangeOffice) {
        this.exchangeOffice = exchangeOffice;
        this.amountOfOperations = random.nextInt(2);
        this.sumOfOperationInCurrency = random.nextInt(2000) + 100;
        if (amountOfOperations == 1) {
            this.secondOperationInCurrency = random.nextInt(2000) + 100;
        }
    }

    // Продает валюту банку

    private void sellCurrency() {
        String currency = this.currency.get(random.nextInt(2));
        int amountOfMoneyAfterSelling = 0;
        if (currency.equalsIgnoreCase("USD") && !exchangeOffice.isTooMuchUSD()) {
            if (sumOfOperationInCurrency + exchangeOffice.getAmountOfUSD() > 20_000) {
                System.out.println("The bank can't take so much money");

            } else {
                amountOfMoneyAfterSelling = (int) (sumOfOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_USD);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() - amountOfMoneyAfterSelling);
                exchangeOffice.setAmountOfUSD(exchangeOffice.getAmountOfUSD() + sumOfOperationInCurrency);
                System.out.printf("Solo operation:  Sold %d %s to the %s, and get %d rubles.%s", sumOfOperationInCurrency, currency,
                        Thread.currentThread().getName(), amountOfMoneyAfterSelling, "\n");
            }

        } else if (currency.equalsIgnoreCase("EUR") && !exchangeOffice.isTooMuchEUR()) {
            if (sumOfOperationInCurrency + exchangeOffice.getAmountOfEUR() > 20_000) {
                System.out.println("The bank can't take so much money");

            } else {
                amountOfMoneyAfterSelling = (int) (sumOfOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_EUR);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() - amountOfMoneyAfterSelling);
                exchangeOffice.setAmountOfEUR(exchangeOffice.getAmountOfEUR() + sumOfOperationInCurrency);
                System.out.printf("Solo operation:  Sold %d %s to the %s, and get %d rubles%s", sumOfOperationInCurrency, currency,
                        Thread.currentThread().getName(), amountOfMoneyAfterSelling, "\n");
            }
        }
    }

    // Покупает валюту у банка.

    private void buyCurrency() {
        String currency = this.currency.get(random.nextInt(2));
        int amountOfMoneyAfterBuying = 0;
        if (currency.equalsIgnoreCase("USD")) {
            if (sumOfOperationInCurrency > exchangeOffice.getAmountOfUSD()) {
                System.out.println("The bank doesn't have enough money to make an operation.");
            } else {
                amountOfMoneyAfterBuying = (int) (sumOfOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_USD);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() + amountOfMoneyAfterBuying);
                exchangeOffice.setAmountOfUSD(exchangeOffice.getAmountOfUSD() - sumOfOperationInCurrency);
                System.out.printf("Solo operation:  Bought %d %s from the %s, and spent on it %d rubles.%s", sumOfOperationInCurrency, currency,
                        Thread.currentThread().getName(), amountOfMoneyAfterBuying, "\n");
            }

        } else if (currency.equalsIgnoreCase("EUR")) {
            if (sumOfOperationInCurrency > exchangeOffice.getAmountOfEUR()) {
                System.out.println("The bank doesn't have enough money to make an operation.");

            } else {
                amountOfMoneyAfterBuying = (int) (sumOfOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_EUR);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() + amountOfMoneyAfterBuying);
                exchangeOffice.setAmountOfEUR(exchangeOffice.getAmountOfEUR() - sumOfOperationInCurrency);
                System.out.printf("Solo operation:  Bought %d %s from the %s, and spent on it %d rubles.%s", sumOfOperationInCurrency, currency,
                        Thread.currentThread().getName(), amountOfMoneyAfterBuying, "\n");
            }
        }
    }

    // Если обе операции.

    private void BothOperation() {
        String cellCurrency = this.currency.get(random.nextInt(2));
        int amountOfMoneyAfterSelling = 0;
        int amountOfMoneyAfterBuying = 0;
        if (cellCurrency.equalsIgnoreCase("USD")) {
            if (sumOfOperationInCurrency + exchangeOffice.getAmountOfUSD() > 20_000) {
                System.out.println("The bank can't take so much money");

            } else {
                amountOfMoneyAfterSelling = (int) (sumOfOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_USD);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() - amountOfMoneyAfterSelling);
                exchangeOffice.setAmountOfUSD(exchangeOffice.getAmountOfUSD() + sumOfOperationInCurrency);
            }

            if (secondOperationInCurrency > exchangeOffice.getAmountOfEUR()) {
                System.out.println("The bank doesn't have enough money to make an operation.");

            } else {
                amountOfMoneyAfterBuying = (int) (secondOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_EUR);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() + amountOfMoneyAfterBuying);
                exchangeOffice.setAmountOfEUR(exchangeOffice.getAmountOfEUR() - secondOperationInCurrency);
            }

            System.out.printf("Both operations:  Sold %d %s to the %s, and get %d rubles.%s" +
                            "Bought %d EUR from the %s, and spent on it %d rubles.%s", sumOfOperationInCurrency, cellCurrency,
                    Thread.currentThread().getName(), amountOfMoneyAfterSelling, "\n", secondOperationInCurrency,
                    Thread.currentThread().getName(), amountOfMoneyAfterBuying, "\n");


        } else if (cellCurrency.equalsIgnoreCase("EUR")) {
            if (sumOfOperationInCurrency + exchangeOffice.getAmountOfEUR() > 20_000) {
                System.out.println("The bank can't take so much money");

            } else {
                amountOfMoneyAfterSelling = (int) (sumOfOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_EUR);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() - amountOfMoneyAfterSelling);
                exchangeOffice.setAmountOfEUR(exchangeOffice.getAmountOfEUR() + sumOfOperationInCurrency);
            }
            if (secondOperationInCurrency > exchangeOffice.getAmountOfUSD()) {
                System.out.println("The bank doesn't have enough money to make an operation.");

            } else {
                amountOfMoneyAfterBuying = (int) (secondOperationInCurrency * ExchangeOffice.CURRENT_EXCHANGE_RATE_OF_USD);
                exchangeOffice.setAmountOfBLR(exchangeOffice.getAmountOfBLR() + amountOfMoneyAfterBuying);
                exchangeOffice.setAmountOfUSD(exchangeOffice.getAmountOfUSD() - secondOperationInCurrency);
            }
            System.out.printf("Both operations:  Sold %d %s to the %s, and get %d rubles%s" +
                            "Bought %d USD from the %s, and spent on it %d rubles.%s", sumOfOperationInCurrency, cellCurrency,
                    Thread.currentThread().getName(), amountOfMoneyAfterSelling, "\n", secondOperationInCurrency,
                    Thread.currentThread().getName(), amountOfMoneyAfterBuying, "\n");
        }
    }

    // Выполнение операции.

    public void operation() {
        if (exchangeOffice.getAmountOfUSD() <= 0 && exchangeOffice.getAmountOfEUR() <= 0 &&
                exchangeOffice.getAmountOfEUR() > 20_000 && exchangeOffice.getAmountOfUSD() > 20_000) {
            Thread.currentThread().interrupt();
        }
        String operation = operations.get(random.nextInt(2));
        switch (amountOfOperations) {
            case 0:
                if (operation.equalsIgnoreCase("Sell")) {

                    sellCurrency();

                } else if (operation.equalsIgnoreCase("Buy")) {

                    buyCurrency();
                }
                break;
            case 1:
                BothOperation();
                break;
        }
    }

}
