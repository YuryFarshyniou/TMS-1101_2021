package tasks.lesson_13.by.yurachel.task_shop.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop {
    private List<Product> productList;

    {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // Добавляем продукт.

    public void addProduct(Product product) {
        boolean isIdContains = false;
        for (Product product1 : productList) {
            if (product.getId() == product1.getId()) {
                isIdContains = true;
                break;
            }
        }
        if (!isIdContains) productList.add(product);
    }

    // Выводим список продуктов.

    public void showAllProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // Удаляем продукт

    public void removeProduct(int productId) {
        Predicate<Product> predicate = new Predicate<Product>() {

            public boolean test(Product product) {
                return product.getId() == productId;
            }
        };
        productList.removeIf(predicate);
//        productList.removeIf(product -> product.getId() == productId);
    }

    // Редактируем продукт.

    public void editProduct(int id, int newID, String newName, int newPrice) {
        for (Product product1 : productList) {
            if (product1.getId() == id) {
                product1.setId(newID);
                product1.setProductName(newName);
                product1.setPrice(newPrice);
            }
        }
    }

}
