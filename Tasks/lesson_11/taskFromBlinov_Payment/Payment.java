package Tasks.lesson_11.taskFromBlinov_Payment;

public class Payment {
    private Customer customer;
    private String[] banks = {"AlfaBank", "BelarusBank", "BelWebBank", "BelGazPromBank"};
    private int[] prices;
    private boolean isOk;

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String[] getBanks() {
        return banks;
    }

    public void setBanks(String[] banks) {
        this.banks = banks;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int[] getPrices() {
        return prices;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public Payment(int[] prices) {
        this.prices = prices;
    }

    // Создаем внутренний класс

    class Customer {
        private String bankName;
        private long bankAccountName;
        private boolean isAvailable;
        private int amountOfMoney;

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public long getBankAccountName() {
            return bankAccountName;
        }

        public void setBankAccountName(long bankAccountName) {
            this.bankAccountName = bankAccountName;
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

        public Customer(String bankName, long bankAccountName, boolean isAvailable, int amountOfMoney) {
            this.bankName = bankName;
            this.bankAccountName = bankAccountName;
            this.isAvailable = isAvailable;
            this.amountOfMoney = amountOfMoney;
        }
    }

    // Поддерживает ли магазин банк клиента.

    public void isSupportingBank() {
        for (String name : this.banks) {
            if (this.customer.getBankName().equalsIgnoreCase(name)) {
                this.isOk = true;
            } else {
                this.isOk = false;
            }
        }
    }

    // Общая сумма покупок.

    public int sumOfPurchase() {
        int sum = 0;
        for (int purchase : this.prices) {
            sum += purchase;
        }
        return sum;
    }

    // Оплачиваем покупки.

    public void payment() {
        if (isOk && customer.isAvailable() && customer.getAmountOfMoney() > sumOfPurchase()) {
            customer.setAmountOfMoney(customer.getAmountOfMoney() - sumOfPurchase());
            System.out.println("Payment success!");
        } else if (!isOk && customer.isAvailable() && customer.getAmountOfMoney() > sumOfPurchase()) {
            System.out.println("We not accept this bank's cards.We're sorry.");
        } else if (isOk && !customer.isAvailable() && customer.getAmountOfMoney() > sumOfPurchase()) {
            System.out.println("Customer's card blocked.");
        } else if (isOk && customer.isAvailable() && customer.getAmountOfMoney() < sumOfPurchase()) {
            System.out.println("There are not enough money at the card");
        }
    }

}
