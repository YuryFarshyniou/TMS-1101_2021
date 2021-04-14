package by.yurachel.servlet.repository;

import by.yurachel.servlet.entity.ProductEntity;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    public List<ProductEntity> getProducts() {
        return Arrays.asList(new ProductEntity("MacBoook", 2500),
                new ProductEntity("Mi 11 ultra", 1200),
                new ProductEntity("Mi airdots", 35.6),
                new ProductEntity("Galaxy buds live", 230.1),
                new ProductEntity("Galaxy s10", 566));
    }
}
