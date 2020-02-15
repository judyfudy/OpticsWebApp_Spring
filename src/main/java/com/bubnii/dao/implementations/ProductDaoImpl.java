package com.bubnii.dao.implementations;

import com.bubnii.dao.interfaces.ProductDao;
import com.bubnii.model.Product;
import com.bubnii.model.ProductType;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProductToCart(final int personId, final int productId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("insert into cart(user_id, product_id) values (?,?)")
                .setParameter(1, personId)
                .setParameter(2, productId).executeUpdate();
    }

    @Override
    public List<Product> getProductsByType(final int typeId) {
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
    public List<Product> getAllProductsInCart(final int userId) {
        return sessionFactory.getCurrentSession()
                .createNativeQuery("select * from product inner join cart on id = product_id where user_id=?")
                .setParameter(1, userId).list();
    }

    @Override
    public void deleteFromCart(final int productId, final int userId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("delete from cart where product_id=? and user_id=?")
                .setParameter(1, productId)
                .setParameter(2, userId).executeUpdate();
    }

    @Override
    public void clearCart(final int userId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("delete from cart where user_id=?")
                .setParameter(1, userId).executeUpdate();
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void add(final Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    @Override
    public Product get(final int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void update(final Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(final int id) {
        sessionFactory.getCurrentSession().remove(id);
    }
}
