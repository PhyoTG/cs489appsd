package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] productsData = {
                new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        };

        printProducts(productsData);
    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.getProductName()));
        // Print products in JSON format
        System.out.println("Printed in JSON format:");
        for (Product product : products) {
            System.out.printf("{\"productId\": %d, \"productName\": \"%s\", \"expiryDate\": \"%s\", \"quantity\": %d, \"price\": %.2f}%n",
                    product.getProductId(), product.getProductName(), product.getExpiryDate(), product.getQuantity(), product.getPrice());
        }

        // Print products in XML format
        System.out.println("\nPrinted in XML format:");
        for (Product product : products) {
            System.out.printf("<Product>%n  <productId>%d</productId>  <productName>%s</productName>  <expiryDate>%s</expiryDate>  <quantity>%d</quantity>  <price>%.2f</price>%n</Product>%n",
                    product.getProductId(), product.getProductName(), product.getExpiryDate(), product.getQuantity(), product.getPrice());
        }

        // Print products in CSV format
        System.out.println("\nPrinted in CSV format:");
        System.out.println("productId,productName,expiryDate,quantity,price");
        for (Product product : products) {
            System.out.printf("%d,%s,%s,%d,%.2f%n",
                    product.getProductId(), product.getProductName(), product.getExpiryDate(), product.getQuantity(), product.getPrice());
        }
    }
}