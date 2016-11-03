package com.ads.test.cart;

import com.ads.test.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrei Andrade on 02/11/2016.
 */
public class ShoppingCartTest {

    public enum ProductName {Tv, Dvd, Notebook, Geladeira, Smartphone}

    ;
    private ShoppingCart shoppingCart;
    private Map<String, Product> products;

    @Before
    public void init() {
        this.shoppingCart = new ShoppingCart();
        this.products = new HashMap<String, Product>();

        int productId = 0;
        this.products.put(ProductName.Tv.toString(), new Product(++productId, ProductName.Tv.toString(), new BigDecimal(2000), new Date()));
        this.products.put(ProductName.Dvd.toString(), new Product(++productId, ProductName.Dvd.toString(), new BigDecimal(150), new Date()));
        this.products.put(ProductName.Notebook.toString(), new Product(++productId, ProductName.Notebook.toString(), new BigDecimal(2500), new Date()));
        this.products.put(ProductName.Geladeira.toString(), new Product(++productId, ProductName.Geladeira.toString(), new BigDecimal(2200), new Date()));
        this.products.put(ProductName.Smartphone.toString(), new Product(++productId, ProductName.Smartphone.toString(), new BigDecimal(1500), new Date()));
    }

    @Test(expected = NullPointerException.class)
    public void addItensNull() {
        this.shoppingCart.addItem(null);
        this.shoppingCart.addItem(null);
    }

    @Test
    public void addItemExistent() {
        this.shoppingCart.addItem(this.products.get(ProductName.Tv.toString()));
        this.shoppingCart.addItem(this.products.get(ProductName.Tv.toString()));
    }
}