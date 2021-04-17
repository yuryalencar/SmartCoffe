package org.unipampa.edu.br;

import java.util.ArrayList;

public class CoffeMachine {
    private ArrayList<Recipe> recipes;
    private Compartment cupsCompartment;
    private Compartment coinsCompartment;
    private Compartment ingredientsCompartment;
    private EmailCentral emailCentral;

    public CoffeMachine() {
        recipes = new ArrayList();
        cupsCompartment = new CupsCompartment();
        coinsCompartment = new CoinsCompartment();
        ingredientsCompartment = new IngredientsCompartment();
        this.emailCentral = new EmailCentral();

        this.loadRecipes();
        this.loadCompartments();
    }

    private void loadRecipes() {
        Recipe expressCoffee = new Recipe(200, 75, 535, 100, 10,0,0,0);
        Recipe cappuccino = new Recipe(530, 310, 935, 100, 10,50,10,2);
        Recipe coffeeWithMilk = new Recipe(530, 310, 935, 75, 10,50,0,0);
        Recipe hotChocolate = new Recipe(600, 400, 910, 75, 0,50,50,0);

        recipes.add(expressCoffee);
        recipes.add(cappuccino);
        recipes.add(coffeeWithMilk);
        recipes.add(hotChocolate);
    }

    private void loadCompartments(){
        cupsCompartment.fill("smallCup", 100);
        cupsCompartment.fill("mediumCup", 100);
        cupsCompartment.fill("bigCup", 100);

        coinsCompartment.fill("fiveCents", 30);
        coinsCompartment.fill("tenCents", 30);
        coinsCompartment.fill("twentyFiveCents", 30);
        coinsCompartment.fill("fiftyCents", 30);
        coinsCompartment.fill("oneBRL", 30);

        ingredientsCompartment.fill("water", 30000);
        ingredientsCompartment.fill("coffee", 3000);
        ingredientsCompartment.fill("milk", 15000);
        ingredientsCompartment.fill("cinnamon", 600);
        ingredientsCompartment.fill("chocolate", 15000);
        ingredientsCompartment.fill("sugar", 3600);
    }

    public Boolean auth(String email) {
        return email.equals(this.emailCentral.getTechnicianEmail());
    }

    public Boolean takeCoins(String type, int amount){
        return coinsCompartment.take(type, amount);
    }

    public Boolean fillCoins(String type, int amount){
        return coinsCompartment.fill(type, amount);
    }

    public Boolean fillCups(String type, int amount){
        return cupsCompartment.fill(type, amount);
    }

    public Boolean fillIngredients(String type, int amount){
        return ingredientsCompartment.fill(type, amount);
    }

    public Integer getAmountCoins(String type) {
        return coinsCompartment.verifyAmount(type);
    }

    public Integer getAmountIngredients(String type) {
        return ingredientsCompartment.verifyAmount(type);
    }
}
