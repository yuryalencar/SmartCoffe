package org.unipampa.edu.br;

public class Recipe {
    private final int price;
    private final int maxPrice;
    private final int minPrice;
    private final int water;
    private final int coffee;
    private final int milk;
    private final int chocolate;
    private final int cinnamon;

    public Recipe(int price, int minPrice, int maxPrice, int water, int coffee, int milk, int chocolate, int cinnamon) {
        this.price = price;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.water = water;
        this.coffee = coffee;
        this.milk = milk;
        this.chocolate = chocolate;
        this.cinnamon = cinnamon;
    }

    public int getBigPrice() {
        return this.maxPrice;
    }

    public int getMediumPrice() {
        return this.price;
    }

    public int getSmallPrice() {
        return this.minPrice;
    }

    public double getBigMilk() {
        return this.getBig(this.milk);
    }

    public double getMediumMilk() {
        return this.getMedium(this.milk);
    }

    public double getSmallMilk() {
        return this.getSmall(this.milk);
    }

    public double getBigCinnamon() {
        return this.getBig(this.cinnamon);
    }

    public double getMediumCinnamon() {
        return this.getMedium(this.cinnamon);
    }

    public double getSmallCinnamon() {
        return this.getSmall(this.cinnamon);
    }

    public double getBigCoffee() {
        return this.getBig(this.coffee);
    }

    public double getMediumCoffee() {
        return this.getMedium(this.coffee);
    }

    public double getSmallCoffee() {
        return this.getSmall(this.coffee);
    }

    public double getBigWater() {
        return this.getBig(this.water);
    }

    public double getMediumWater() {
        return this.getMedium(this.water);
    }

    public double getSmallWater() {
        return this.getSmall(this.water);
    }

    public double getBigChocolate() {
        return this.getBig(this.chocolate);
    }

    public double getMediumChocolate() {
        return this.getMedium(this.chocolate);
    }

    public double getSmallChocolate() {
        return this.getSmall(this.chocolate);
    }

    private double getBig(int ingredient) {
        return ingredient * 2;
    }

    private double getMedium(int ingredient) {
        return ingredient;
    }

    private double getSmall(int ingredient) {
        return ingredient / 2.0;
    }
}
