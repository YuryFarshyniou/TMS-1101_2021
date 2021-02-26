package tasks.lesson_13.by.yurachel.task_shop.main;

import tasks.lesson_13.by.yurachel.task_shop.entity.Product;
import tasks.lesson_13.by.yurachel.task_shop.entity.Shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addProduct(new Product(1, "Coffee", 10));
        shop.addProduct(new Product(2, "Sofa", 15));
        shop.addProduct(new Product(3, "Tv", 500));
        shop.addProduct(new Product(4, "Computer", 430));
        shop.addProduct(new Product(5, "Socks", 2));
        shop.addProduct(new Product(6, "Pants", 26));
        shop.addProduct(new Product(7, "Tea", 4));
        shop.addProduct(new Product(8, "Chocolate", 3));

        shop.getProductList().sort((product1, product2) -> product1.getPrice() - product2.getPrice());
        shop.showAllProducts();

        System.out.println("*********************");
        shop.removeProduct(4);
        shop.showAllProducts();

        System.out.println("*******************");

        shop.getProductList().sort((product1, product2) -> product2.getId() - product1.getId());
        shop.showAllProducts();

        System.out.println("***********************");

        shop.editProduct(3, 3, "APPLE", 1000);
        shop.showAllProducts();

    }
}
