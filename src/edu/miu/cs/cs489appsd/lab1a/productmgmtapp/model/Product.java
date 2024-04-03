package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

public class Product {
    private Long productId;
    private String productName;
    private String expiryDate;
    private int quantity;
    private double price;

    // Constructors
    public Product() {
        // Default constructor
    }

    public Product(long productId, String productName, String expiryDate, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter methods
    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setter methods
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

