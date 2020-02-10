package com.bubnii.dao.implementations;

import com.bubnii.dao.interfaces.ProductDao;
import com.bubnii.model.Product;
import com.bubnii.model.ProductType;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProductToCart(int personId, int productId) {
        Query<Product> query = sessionFactory.getCurrentSession()
                .createNativeQuery("insert into cart(user_id, product_id) values (?,?)")
                .setParameter(1, personId)
                .setParameter(2, productId);
    }

    @Override
    public List<Product> getProductsByType(int typeId) {
        Query<Product> query = sessionFactory.getCurrentSession()
                .createQuery("from Product where product_type_id=:typeId")
                .setParameter("typeId", typeId);

        return query.list();
    }

    @Override
    public List<ProductType> getAllTypesOfProducts() {
        return sessionFactory.getCurrentSession().createQuery("from ProductType").list();
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        return sessionFactory.getCurrentSession()
                .createNativeQuery("select * from product inner join cart on id = product_id where user_id=?")
                .setParameter(1, userId).list();
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("delete from cart where product_id=? and user_id=?")
                .setParameter(1, productId)
                .setParameter(2, userId);
    }

    @Override
    public void clearCart(int userId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("delete from cart where user_id=?")
                .setParameter(1, userId);
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void add(Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    @Override
    public Product get(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().remove(id);
    }
}
