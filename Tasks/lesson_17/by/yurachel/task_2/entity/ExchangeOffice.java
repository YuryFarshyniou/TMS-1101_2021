package tasks.lesson_17.by.yurachel.task_2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExchangeOffice extends Thread {
    public final static double CURRENT_EXCHANGE_RATE_OF_USD = 2.59;
    public final static double CURRENT_EXCHANGE_RATE_OF_EUR = 3.091;

    private int amountOfUSD = 2000;
    private int amountOfEUR = 2000;
    private int amountOfBLR = 100_000;
    private String ExchangeOfficeName;
    private Random random = new Random();
    private List<Client> queue;
    private boolean tooMuchUSD = false;
    private boolean tooMuchEUR = false;
    private boolean isNotEnoughUSD = false;
    private boolean isNotEnoughEUR = false;

    {
        queue = new ArrayList<>();
        for (int i = 0; i < random.nextInt(13) + 2; i++) {
            queue.add(new Client(this));
        }
    }

    public int getAmountOfUSD() {
        return amountOfUSD;
    }

    public void setAmountOfUSD(int amountOfUSD) {
        this.amountOfUSD = amountOfUSD;
    }

    public int getAmountOfEUR() {
        return amountOfEUR;
    }

    public void setAmountOfEUR(int amountOfEUR) {
        this.amountOfEUR = amountOfEUR;
    }

    public int getAmountOfBLR() {
        return amountOfBLR;
    }

    public void setAmountOfBLR(int amountOfBLR) {
        this.amountOfBLR = amountOfBLR;
    }

    public String getExchangeOfficeName() {
        return ExchangeOfficeName;
    }

    public void setExchangeOfficeName(String exchangeOfficeName) {
        ExchangeOfficeName = exchangeOfficeName;
    }

    public boolean isTooMuchUSD() {
        return tooMuchUSD;
    }

    public void setTooMuchUSD(boolean tooMuchUSD) {
        this.tooMuchUSD = tooMuchUSD;
    }

    public boolean isNotEnoughEUR() {
        return isNotEnoughEUR;
    }

    public void setNotEnoughEUR(boolean notEnoughEUR) {
        isNotEnoughEUR = notEnoughEUR;
    }

    public ExchangeOffice(String exchangeOfficeName) {
        super(exchangeOfficeName);

    }

    public boolean isTooMuchEUR() {
        return tooMuchEUR;
    }

    public void setTooMuchEUR(boolean tooMuchEUR) {
        this.tooMuchEUR = tooMuchEUR;
    }

    public boolean isNotEnoughUSD() {
        return isNotEnoughUSD;
    }

    public void setNotEnoughUSD(boolean notEnoughUSD) {
        isNotEnoughUSD = notEnoughUSD;
    }

    public void amountOfMoneyInTheBank() {
        System.out.printf("In the %s right now: %d rubles,%d USD,%d EUR%s", getExchangeOfficeName(), getAmountOfBLR(), getAmountOfUSD(), getAmountOfEUR(),"\n");
    }

    public void run() {
        try {

            for (int i = 0; i < queue.size(); i++) {
                System.out.printf("Client %d is making operation in %s: %s", i + 1, Thread.currentThread().getName(), "\n");
                queue.get(i).operation();
                Thread.sleep(random.nextInt(10000) + 2000);
                System.out.printf("Operation completed in %s.%s", Thread.currentThread().getName(), "\n");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

