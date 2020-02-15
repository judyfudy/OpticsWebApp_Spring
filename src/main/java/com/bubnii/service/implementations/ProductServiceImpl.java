package com.bubnii.service.implementations;

import com.bubnii.dao.interfaces.ProductDao;
import com.bubnii.model.Product;
import com.bubnii.model.ProductType;
import com.bubnii.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void addProductToCart(final int personId, final int productId) {
        productDao.addProductToCart(personId, productId);
    }

    @Override
    public List<Product> getProductsByType(final int typeId) {
        return productDao.getProductsByType(typeId);
    }

    @Override
    public List<ProductType> getAllTypesOfProducts() {
        return productDao.getAllTypesOfProducts();
    }

    @Override
    public List<Product> getAllProductsInCart(final int userId) {
        return productDao.getAllProductsInCart(userId);
    }

    @Override
    public void deleteFromCart(final int productId, final int userId) {
        productDao.deleteFromCart(productId, userId);
    }

    @Override
    public void clearCart(final int userId) {
        productDao.clearCart(userId);
    }
}
