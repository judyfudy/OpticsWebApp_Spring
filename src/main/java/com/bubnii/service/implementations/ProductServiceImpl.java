package com.bubnii.service.implementations;

import com.bubnii.dao.interfaces.ProductDao;
import com.bubnii.model.Product;
import com.bubnii.model.ProductType;
import com.bubnii.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void addProductToCart(int personId, int productId) {
        productDao.addProductToCart(personId, productId);
    }

    @Override
    public List<Product> getProductsByType(int typeId) {
        return productDao.getProductsByType(typeId);
    }

    @Override
    public List<ProductType> getAllTypesOfProducts() {
        return productDao.getAllTypesOfProducts();
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        return productDao.getAllProductsInCart(userId);
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        productDao.deleteFromCart(productId, userId);
    }

    @Override
    public void clearCart(int userId) {
        productDao.clearCart(userId);
    }
}
