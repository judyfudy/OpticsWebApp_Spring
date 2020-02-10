package com.bubnii.dao.interfaces;

import com.bubnii.model.Product;
import com.bubnii.model.ProductType;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    void addProductToCart(int personId, int productId);

    List<Product> getProductsByType(int typeId);

    List<ProductType> getAllTypesOfProducts();

    List<Product> getAllProductsInCart(int userId);

    void deleteFromCart(int productId, int userId);

    void clearCart(int userId);
}
