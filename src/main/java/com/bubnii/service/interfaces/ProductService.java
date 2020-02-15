package com.bubnii.service.interfaces;

import com.bubnii.model.Product;
import com.bubnii.model.ProductType;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void addProductToCart(final int personId, final int productId);

    List<Product> getProductsByType(final int typeId);

    List<ProductType> getAllTypesOfProducts();

    List<Product> getAllProductsInCart(final int userId);

    void deleteFromCart(final int productId, final int userId);

    void clearCart(final int userId);
}
