package tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Payment {
    private Customer customer;
    private List<String> banks;
    private List<Purchase> purchaseList;
    private boolean isOk;

    {

        purchaseList = new ArrayList<>();
        banks = new ArrayList<>(Arrays.asList("AlfaBank", "BelarusBank", "BelGazPromBank", "BelWebBank"));
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(String name, String bankName, boolean isAvailable, int amountOfMoney) {
        this.customer = new Customer(name, bankName, isAvailable, amountOfMoney);
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public List<String> getBanks() {
        return banks;
    }

    public void setBanks(List<String> banks) {
        this.banks = banks;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }


    public String toString() {
        return "Information about payment: " + customer + "\nbanks = " + banks +
                purchaseList + ".";
    }

// Создаем внутренний класс

    private class Purchase {
        private String purchaseName;
        private int prices;

        public String getPurchaseName() {
            return purchaseName;
        }

        public void setPurchaseName(String purchaseName) {
            this.purchaseName = purchaseName;
        }

        public int getPrices() {
            return prices;
        }

        public void setPrices(int prices) {
            this.prices = prices;
        }

        public Purchase(String purchaseName, int prices) {
            this.purchaseName = purchaseName;
            this.prices = prices;
        }


        public String toString() {
            return "Purchase's information." + "purchaseName: " + purchaseName + ", prices: " + prices;
        }
    }

    private class Customer {
        private String name;
        private String bankName;
        private boolean isAvailable;
        private int amountOfMoney;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        public int getAmountOfMoney() {
            return amountOfMoney;
        }

        public void setAmountOfMoney(int amountOfMoney) {
            this.amountOfMoney = amountOfMoney;
        }

        public Customer(String name, String bankName, boolean isAvailable, int amountOfMoney) {
            this.name = name;
            this.bankName = bankName;
            this.isAvailable = isAvailable;
            this.amountOfMoney = amountOfMoney;
        }


        public String toString() {
            return "Customer's information. " + "name: " + name + ", bankName: " + bankName +
                    ", is available card: " + isAvailable + ", amountOfMoney = " + amountOfMoney;
        }
    }

    // Поддерживает ли магазин банк клиента.

    public void isSupportingBank() {
        for (String name : banks) {
            if (customer.getBankName().equalsIgnoreCase(name)) {
                this.isOk = true;
                return;
            }
        }
    }

    // Добавляем покупки

    public void addPurchase(String purchaseName, int purchasePrice) {
        this.purchaseList.add(new Purchase(purchaseName, purchasePrice));
    }

    // Общая сумма покупок.

    public int sumOfPurchase() {
        int sum = 0;
        for (Purchase purchase : this.purchaseList) {
            sum += purchase.prices;
        }
        return sum;
    }

    // Выводим список покупок.

    public void showPurchases() {
        for (Purchase purchase : purchaseList) {
            System.out.println("Purchase " + purchase.purchaseName + " and it's price is " + purchase.prices);
        }
    }

    // Оплачиваем покупки.

    public void payment() throws Exception {
        if (this.isOk && getCustomer().isAvailable() && getCustomer().getAmountOfMoney() > sumOfPurchase()) {
            getCustomer().setAmountOfMoney(getCustomer().getAmountOfMoney() - sumOfPurchase());
        } else if (!isOk && getCustomer().isAvailable() && getCustomer().getAmountOfMoney() > sumOfPurchase()) {
            throw new Exception("We not accept this bank's cards.We're sorry.");
        } else if (isOk && !getCustomer().isAvailable() && getCustomer().getAmountOfMoney() > sumOfPurchase()) {
            throw new Exception("Customer's card blocked.");
        } else if (isOk && getCustomer().isAvailable() && getCustomer().getAmountOfMoney() < sumOfPurchase()) {
            throw new Exception("There are not enough money at the card.");
        }
    }

    // Добавляем новый банк .

    public void addBank(String bankName) {
        banks.add(bankName);
    }

}
