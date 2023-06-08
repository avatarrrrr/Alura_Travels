package br.com.alura.aluraviagens.model;

import java.math.BigDecimal;

public class PackageModel {

    private final String location;
    private final String image;
    private final int days;
    private final BigDecimal price;

    public PackageModel(String location, String image, int days, BigDecimal price) {
        this.location = location;
        this.image = image;
        this.days = days;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public int getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }

}