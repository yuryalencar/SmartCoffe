package org.unipampa.edu.br;

public class Recipe {
    private int price;
    private int maxPrice;
    private int minPrice;
    private int water;
    private int coffee;
    private int milk;
    private int chocolate;
    private int cinnamon;

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

    public int getBigMilk() {
        return this.getBig(this.milk);
    }

    public int getMediumMilk() {
        return this.getMedium(this.milk);
    }

    public int getSmallMilk() {
        return this.getSmall(this.milk);
    }

    public int getBigCinnamon() {
        return this.getBig(this.cinnamon);
    }

    public int getMediumCinnamon() {
        return this.getMedium(this.cinnamon);
    }

    public int getSmallCinnamon() {
        return this.getSmall(this.cinnamon);
    }

    public int getBigCoffee() {
        return this.getBig(this.coffee);
    }

    public int getMediumCoffee() {
        return this.getMedium(this.coffee);
    }

    public int getSmallCoffee() {
        return this.getSmall(this.coffee);
    }

    public int getBigWater() {
        return this.getBig(this.water);
    }

    public int getMediumWater() {
        return this.getMedium(this.water);
    }

    public int getSmallWater() {
        return this.getSmall(this.water);
    }

    public int getBigChocolate() {
        return this.getBig(this.chocolate);
    }

    public int getMediumChocolate() {
        return this.getMedium(this.chocolate);
    }

    public int getSmallChocolate() {
        return this.getSmall(this.chocolate);
    }

    public int getWater(int size) {
        switch (size){
            case 1:
                return this.getSmall(this.water);
            case 2:
                return this.getMedium(this.water);
            case 3:
                return this.getBig(this.water);
        }
        return 0;
    }

    public int getCoffee(int size) {
        switch (size){
            case 1:
                return this.getSmall(this.coffee);
            case 2:
                return this.getMedium(this.coffee);
            case 3:
                return this.getBig(this.coffee);
        }
        return 0;
    }

    public int getMilk(int size) {
        switch (size){
            case 1:
                return this.getSmall(this.milk);
            case 2:
                return this.getMedium(this.milk);
            case 3:
                return this.getBig(this.milk);
        }
        return 0;
    }

    public int getChocolate(int size) {
        switch (size){
            case 1:
                return this.getSmall(this.chocolate);
            case 2:
                return this.getMedium(this.chocolate);
            case 3:
                return this.getBig(this.chocolate);
        }
        return 0;
    }

    public int getCinnamon(int size) {
        switch (size){
            case 1:
                return this.getSmall(this.cinnamon);
            case 2:
                return this.getMedium(this.cinnamon);
            case 3:
                return this.getBig(this.cinnamon);
        }
        return 0;
    }

    private int getBig(int ingredient) {
        return (int) (ingredient * 2);
    }

    private int getMedium(int ingredient) {
        return (int) ingredient;
    }

    private int getSmall(int ingredient) {
        return (int) (ingredient / 2);
    }
}
