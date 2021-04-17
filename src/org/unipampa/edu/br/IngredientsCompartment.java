package org.unipampa.edu.br;

public class IngredientsCompartment extends Compartment {

    private int amountWater = 30000;
    private int amountCoffee = 3000;
    private int amountMilk = 15000;
    private int amountCinnamon = 600;
    private int amountChocolate = 15000;
    private int amountSugar = 3600;

    private final int MAX_WATER = 30000;
    private final int MAX_COFFEE = 3000;
    private final int MAX_MILK = 15000;
    private final int MAX_CINNAMON = 600;
    private final int MAX_CHOCOLATE = 15000;
    private final int MAX_SUGAR = 3600;

    public IngredientsCompartment() {

    }

    /**
     * Takes an amount of one ingredient from the ingredients compartment.
     *
     * @param  type   one of six types of ingredients: water, coffee, milk, cinnamon, chocolate, sugar
     * @param  amount the amount of the ingredient taken
     * @return        whether the action was successful
     */
    @Override
    public boolean take(String type, int amount) {

        switch (type) {
            case "water":
                if(this.amountWater - amount >= 0)
                    this.amountWater -= amount;
                else {
                    System.out.println("Quantidade do ingrediente superior ao limite em take().");
                    return false;
                }
                break;

            case "coffee":
                if(this.amountCoffee - amount >= 0)
                    this.amountCoffee -= amount;
                else {
                    System.out.println("Quantidade do ingrediente superior ao limite em take().");
                    return false;
                }
                break;

            case "milk":
                if(this.amountMilk - amount >= 0)
                    this.amountMilk -= amount;
                else {
                    System.out.println("Quantidade do ingrediente superior ao limite em take().");
                    return false;
                }
                break;

            case "cinnamon":
                if(this.amountCinnamon - amount >= 0)
                    this.amountCinnamon -= amount;
                else {
                    System.out.println("Quantidade do ingrediente superior ao limite em take().");
                    return false;
                }
                break;

            case "chocolate":
                if(this.amountChocolate - amount >= 0)
                    this.amountChocolate -= amount;
                else {
                    System.out.println("Quantidade do ingrediente superior ao limite em take().");
                    return false;
                }
                break;

            case "sugar":
                if(this.amountSugar - amount >= 0)
                    this.amountSugar -= amount;
                else {
                    System.out.println("Quantidade do ingrediente superior ao limite em take().");
                    return false;
                }
                break;

            default:
                System.out.println("Tipo de ingrediente não reconhecido em take().");
                return false;
        }

        return true;
    }

    /**
     * Fills the ingredient compartment of a given type.
     *
     * @param  type   one of six types of ingredients: water, coffee, milk, cinnamon, chocolate, sugar
     * @param  amount the total amount of the ingredient after filled
     * @return        whether the action was successful
     */
    @Override
    public boolean fill(String type, int amount) {

        switch (type) {
            case "water":
                if(amount <= this.amountWater) {
                    System.out.println("Quantidade do ingrediente inferior ao esperado em fill().");
                    return false;
                }
                else if(amount > MAX_WATER) {
                    System.out.println("Quantidade do ingrediente superior ao permitido em fill().");
                    return false;
                }
                else
                    this.amountWater = amount;
                break;

            case "coffee":
                if(amount <= this.amountCoffee) {
                    System.out.println("Quantidade do ingrediente inferior ao esperado em fill().");
                    return false;
                }
                else if(amount > MAX_COFFEE) {
                    System.out.println("Quantidade do ingrediente superior ao permitido em fill().");
                    return false;
                }
                else
                    this.amountCoffee = amount;
                break;

            case "milk":
                if(amount <= this.amountMilk) {
                    System.out.println("Quantidade do ingrediente inferior ao esperado em fill().");
                    return false;
                }
                else if(amount > MAX_MILK) {
                    System.out.println("Quantidade do ingrediente superior ao permitido em fill().");
                    return false;
                }
                else
                    this.amountMilk = amount;
                break;

            case "cinnamon":
                if(amount <= this.amountCinnamon) {
                    System.out.println("Quantidade do ingrediente inferior ao esperado em fill().");
                    return false;
                }
                else if(amount > MAX_CINNAMON) {
                    System.out.println("Quantidade do ingrediente superior ao permitido em fill().");
                    return false;
                }
                else
                    this.amountCinnamon = amount;
                break;

            case "chocolate":
                if(amount <= this.amountChocolate) {
                    System.out.println("Quantidade do ingrediente inferior ao esperado em fill().");
                    return false;
                }
                else if(amount > MAX_CHOCOLATE) {
                    System.out.println("Quantidade do ingrediente superior ao permitido em fill().");
                    return false;
                }
                else
                    this.amountChocolate = amount;
                break;

            case "sugar":
                if(amount <= this.amountSugar) {
                    System.out.println("Quantidade do ingrediente inferior ao esperado em fill().");
                    return false;
                }
                else if(amount > MAX_SUGAR) {
                    System.out.println("Quantidade do ingrediente superior ao permitido em fill().");
                    return false;
                }
                else
                    this.amountSugar = amount;
                break;

            default:
                System.out.println("Tipo de ingrediente não reconhecido em fill().");
                return false;
        }
        return true;
    }

    /**
     * Verifies the current amount of ingredients of a given type.
     *
     * @param  type   one of six types of ingredients: water, coffee, milk, cinnamon, chocolate, sugar
     * @return        the amount of the ingredient, or -1 if an error occurred
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
                System.out.println("Tipo de ingrediente não reconhecido em verifyAmount().");
                return -1;
        }

    }
}
