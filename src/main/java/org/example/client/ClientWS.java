package org.example.client;

import proxy.Product;
import proxy.ProductWS;
import proxy.ProductWebService;

import java.util.List;
import java.util.logging.Logger;

public class ClientWS {
    private static final Logger logger = Logger.getLogger(ClientWS.class.getName());

    public static void main(String[] args) {
        ProductWebService proxy = new ProductWS().getProductWebServicePort();
        logger.info("Selling price: " + proxy.sellingPrice(400.00));
        logger.info("--------------");

        Product product = proxy.getProduct(4);
        logger.info("Product Name: " + product.getName());
        logger.info("Product Price: " + product.getPrice());
        logger.info("--------------");

        List<Product> products = proxy.productList();
        products.forEach(p -> {
            logger.info("Product Name: " + p.getName());
            logger.info("Product Price: " + p.getPrice());
        });
    }
}
