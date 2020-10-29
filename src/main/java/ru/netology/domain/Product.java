package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.ProductRepository;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private int price;

    private ProductRepository repository;
    public Product (ProductRepository repository) {
        this.repository = repository;
    }

    public boolean matches(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
            return true;
        }
        return false;
    }
}
