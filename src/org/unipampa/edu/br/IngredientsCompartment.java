package org.unipampa.edu.br;

public class IngredientsCompartment extends Compartment {

    private final int MAX_WATER;
    private final int MAX_COFFEE;
    private final int MAX_MILK;
    private final int MAX_CINNAMON;
    private final int MAX_CHOCOLATE;
    private final int MAX_SUGAR;

    private int amountWater;
    private int amountCoffee;
    private int amountMilk;
    private int amountCinnamon;
    private int amountChocolate;
    private int amountSugar;

    public IngredientsCompartment() {
        super(0, 0, 15);

        this.MAX_WATER = 30000;
        this.MAX_COFFEE = 3000;
        this.MAX_MILK = 15000;
        this.MAX_CINNAMON = 600;
        this.MAX_CHOCOLATE = 15000;
        this.MAX_SUGAR = 3600;

        this.amountWater = 0;
        this.amountCoffee = 0;
        this.amountMilk = 0;
        this.amountCinnamon = 0;
        this.amountChocolate = 0;
        this.amountSugar = 0;
    }

    /**
     * Takes an amount of one ingredient from the ingredients compartment.
     *
     * @param type   one of six types of ingredients: water, coffee, milk, cinnamon, chocolate, sugar
     * @param amount the amount of the ingredient taken
     * @return whether the action was successful
     */
    @Override
    public boolean take(String type, int amount) {

        if(amount < 0)
            return false;

        switch (type) {
            case "water":
                if (this.amountWater - amount >= 0) {
                    this.amountWater -= amount;
                    return true;
                }
                break;

            case "coffee":
                if (this.amountCoffee - amount >= 0) {
                    this.amountCoffee -= amount;
                    return true;
                }

                break;

            case "milk":
                if (this.amountMilk - amount >= 0) {
                    this.amountMilk -= amount;
                    return true;
                }
                break;

            case "cinnamon":
                if (this.amountCinnamon - amount >= 0) {
                    this.amountCinnamon -= amount;
                    return true;
                }
                break;

            case "chocolate":
                if (this.amountChocolate - amount >= 0) {
                    this.amountChocolate -= amount;
                    return true;
                }
                break;

            case "sugar":
                if (this.amountSugar - amount >= 0) {
                    this.amountSugar -= amount;
                    return true;
                }
                break;
        }

        return false;
    }

    /**
     * Fills the ingredient compartment of a given type.
     *
     * @param type   one of six types of ingredients: water, coffee, milk, cinnamon, chocolate, sugar
     * @param amount the total amount of the ingredient after filled
     * @return whether the action was successful
     */
    @Override
    public boolean fill(String type, int amount) {

        if (amount < 0)
            return false;

        switch (type) {
            case "water":
                if (amount + this.amountWater > this.MAX_WATER) {
                    return false;
                }
                this.amountWater += amount;
                break;

            case "coffee":
                if (amount + this.amountCoffee > this.MAX_COFFEE) {
                    return false;
                }
                this.amountCoffee += amount;
                break;

            case "milk":
                if (amount + this.amountMilk > this.MAX_MILK) {
                    return false;
                }
                this.amountMilk += amount;
                break;

            case "cinnamon":
                if (amount + this.amountCinnamon > this.MAX_CINNAMON) {
                    return false;
                }
                this.amountCinnamon += amount;
                break;

            case "chocolate":
                if (amount + this.amountChocolate > this.MAX_CHOCOLATE) {
                    return false;
                }
                this.amountChocolate += amount;
                break;

            case "sugar":
                if (amount + this.amountSugar > this.MAX_SUGAR) {
                    return false;
                }
                this.amountSugar += amount;
                break;

            default:
                return false;
        }

        return true;
    }

    /**
     * Verifies the current amount of ingredients of a given type.
     *
     * @param type one of six types of ingredients: water, coffee, milk, cinnamon, chocolate, sugar
     * @return the amount of the ingredient, or -1 if an error occurred
     */
    @Override
    public int verifyAmount(String type) {

        switch (type) {
            case "water":
                return this.amountWater;

            case "coffee":
                return this.amountCoffee;

            case "milk":
                return this.amountMilk;

            case "cinnamon":
                return this.amountCinnamon;

            case "chocolate":
                return this.amountChocolate;

            case "sugar":
                return this.amountSugar;

            default:
                return -1;
        }

    }
}
