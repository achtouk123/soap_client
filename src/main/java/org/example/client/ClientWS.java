package org.example.client;

import proxy.Product;
import proxy.ProductWS;
import proxy.ProductWebService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientWS {
    private static final Logger logger = Logger.getLogger(ClientWS.class.getName());
    private static final double DEFAULT_PRICE = 400.00;
    private static final int DEFAULT_PRODUCT_ID = 4;

    public static void main(String[] args) {
        ProductWebService proxy = new ProductWS().getProductWebServicePort();

        logSellingPrice(proxy, DEFAULT_PRICE);
        logger.info("--------------");

        logProductDetails(proxy, DEFAULT_PRODUCT_ID);
        logger.info("--------------");

        logProductList(proxy);
    }

    private static void logSellingPrice(ProductWebService proxy, double price) {
        if (price <= 0) {
            logger.warning("Invalid price. Cannot calculate selling price.");
            return;
        }

        double sellingPrice = proxy.sellingPrice(price);
        if (logger.isLoggable(Level.INFO)) {
            logger.info(() -> String.format("Selling price for %.2f is %.2f", price, sellingPrice));
        }
    }

    private static void logProductDetails(ProductWebService proxy, int productId) {
        if (productId <= 0) {
            logger.warning("Invalid product ID.");
            return;
        }

        Product product = proxy.getProduct(productId);
        if (product == null) {
            logger.warning(() -> String.format("No product found with ID: %d", productId));
            return;
        }

        if (logger.isLoggable(Level.INFO)) {
            logger.info(() -> String.format("Product ID: %d, Name: %s, Price: %.2f",
                    productId, product.getName(), product.getPrice()));
        }
    }

    private static void logProductList(ProductWebService proxy) {
        List<Product> products = proxy.productList();
        if (products == null || products.isEmpty()) {
            logger.warning("Product list is empty or null.");
            return;
        }

        if (logger.isLoggable(Level.INFO)) {
            products.forEach(p -> logger.info(() -> String.format("Product Name: %s, Price: %.2f",
                    p.getName(), p.getPrice())));
        }
    }
}
