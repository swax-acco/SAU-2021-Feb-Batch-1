package com.au.session.ordermanager.controller;

public class Product {
    private int id;
    private String product_name, category_name;
    private int price;

    public Product(int id, String product_name, String category_name, int price) {
        this.setId(id);
        this.setProduct_name(product_name);
        this.setCategory_name(category_name);
        this.setPrice(price);
    }

    public Product() {
	}

	public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
