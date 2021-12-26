package com.example.marinashop.services;


import com.example.marinashop.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products=new ArrayList<>();
    private long ID=0;

    {
        products.add(new Product(++ID,"Boat 1 ","Simple boat",77000,"Kaluga","Terry"));
        products.add(new Product(++ID,"Boat motor","Simple boat motor",27000,"Moscow","Andrew"));
    }

    public List<Product> listProducts() {
        return  products;
    }

    public void  saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
