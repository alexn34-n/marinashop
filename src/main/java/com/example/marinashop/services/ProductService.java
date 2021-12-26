package com.example.marinashop.services;


import com.example.marinashop.models.Product;
import com.example.marinashop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
//    private List<Product> products=new ArrayList<>();
//    private long ID=0;
//
//    {
//        products.add(new Product(++ID,"Boat 1 ","Simple boat",77000,"Kaluga","Terry"));
//        products.add(new Product(++ID,"Boat motor","Simple boat motor",27000,"Moscow","Andrew"));
//    }
    private  final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title!=null) return productRepository.findByTitle(title);
        return  productRepository.findAll();
    }

    public void  saveProduct(Product product) {
    //    product.setId(++ID);
        log.info("Saving new {}",product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
      //  products.removeIf(product -> product.getId().equals(id));
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
//        for (Product product : products) {
//            if (product.getId().equals(id)) return product;
//        }

       // return null;
        return  productRepository.findById(id).orElse(null);
    }
}
