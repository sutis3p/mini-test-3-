package com.example.baitapmvc.model;

public class Painting {
    private int id;
    private String paintCode;
    private String name;
    private double height;
    private double width;
    private String material;
    private String status;
    private double price;

    public Painting() {
    }

    public Painting(int id, String paintCode, String name, double height, double width, String material, String status, double price) {
        this.id = id;
        this.paintCode = paintCode;
        this.name = name;
        this.height = height;
        this.width = width;
        this.material = material;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaintCode() {
        return paintCode;
    }

    public void setPaintCode(String paintCode) {
        this.paintCode = paintCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}