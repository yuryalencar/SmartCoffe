package org.unipampa.edu.br;

import java.util.ArrayList;

public class DrinkMachine {
    private ArrayList<Recipe> recipes;
    private Compartment cupsCompartment;
    private Compartment coinsCompartment;
    private Compartment ingredientsCompartment;
    private EmailCentral emailCentral;

    public DrinkMachine() {
        recipes = new ArrayList();
        cupsCompartment = new CupsCompartment();
        coinsCompartment = new CoinsCompartment();
        ingredientsCompartment = new IngredientsCompartment();
        this.emailCentral = new EmailCentral();

        this.loadRecipes();
        this.loadCompartments();
    }

    /**
     * Method to auth in coffee machine
     *
     * @param email present in email central
     * @return true if is authenticated
     */
    public Boolean auth(String email) {
        return email.equals(this.emailCentral.getTechnicianEmail());
    }

    /**
     * Method to take coins by type
     *
     * @param type   coin type
     * @param amount amount coins to take
     * @return true if can take coins, and false if not
     */
    public Boolean takeCoins(String type, int amount) {
        return coinsCompartment.take(type, amount);
    }

    /**
     * Method to fill coins by type
     *
     * @param type   coin type
     * @param amount amount coins to fill
     * @return true if can fill coins, and false if not
     */
    public Boolean fillCoins(String type, int amount) {
        return coinsCompartment.fill(type, amount);
    }

    /**
     * Method to fill cups by type
     *
     * @param type   cup type
     * @param amount amount cups to fill
     * @return true if can fill cups, and false if not
     */
    public Boolean fillCups(String type, int amount) {
        return cupsCompartment.fill(type, amount);
    }

    /**
     * Method to fill ingredients by type
     *
     * @param type   ingredient type
     * @param amount amount ingredients to fill
     * @return true if can fill ingredients, and false if not
     */
    public Boolean fillIngredients(String type, int amount) {
        return ingredientsCompartment.fill(type, amount);
    }

    /**
     * Method to get amount coins by type
     *
     * @param type coin type
     * @return return integer with amount coins
     */
    public Integer getAmountCoins(String type) {
        return coinsCompartment.verifyAmount(type);
    }

    /**
     * Method to get amount ingredients by type
     *
     * @param type ingredient type
     * @return return integer with amount ingredient
     */
    public Integer getAmountIngredients(String type) {
        return ingredientsCompartment.verifyAmount(type);
    }

    /**
     * Method to make an recipe by your respective type
     *
     * @param type key of the recipe mapped
     * @param recipeSize size of recipe to make, 1 to P, 2 to M, 3 to G
     * @param sugarSize size of sugar 1 to P, 2 to M, 3 to G and any other size to S
     * @return true if make recipe, and false if not.
     */
    public Boolean makeRecipeByType(String type, int recipeSize, int sugarSize) {
        Recipe recipe = this.getRecipeByKey(type);
        if(!this.canMakeRecipe(recipe, recipeSize, sugarSize))
            return false;

        ingredientsCompartment.take("water", recipe.getWater(recipeSize));
        ingredientsCompartment.take("coffee", recipe.getCoffee(recipeSize));
        ingredientsCompartment.take("milk", recipe.getMilk(recipeSize));
        ingredientsCompartment.take("cinnamon", recipe.getCinnamon(recipeSize));
        ingredientsCompartment.take("chocolate", recipe.getChocolate(recipeSize));
        ingredientsCompartment.take("sugar", this.getSugarBySize(sugarSize));

        return true;
    }

    /**
     * Method to verify if machine can make the recipe
     *
     * @param recipe recipe to make
     * @param recipeSize recipe size using 1 to small, 2 to medium and 3 to big
     * @param sugarSize 1 to P, 2 to M, 3 to G, and any other value to S
     * @return true if can make this recipe and false if not
     */
    public Boolean canMakeRecipe(Recipe recipe, int recipeSize, int sugarSize) {
        boolean canMake = false;
        boolean hasSugar = ingredientsCompartment.verifyAmount("sugar") - getSugarBySize(sugarSize) > -1;

        if(recipeSize == 1)
            canMake = verifySmallRecipe(recipe);

        if(recipeSize == 2)
            canMake = verifyMediumRecipe(recipe);

        if(recipeSize == 3)
            canMake = verifyBigRecipe(recipe);

        return canMake && hasSugar;
    }

    /**
     * Method to get recipe by specific key
     *
     * @param key keyword to get recipe
     * @return recipe if keyword is mapped or null if not
     */
    public Recipe getRecipeByKey(String key) {
        switch (key){
            case "expressCoffee":
                return new Recipe(200, 75, 535, 100, 10, 0, 0, 0);
            case "cappuccino":
                return new Recipe(530, 310, 935, 100, 10, 50, 10, 2);
            case "coffeeWithMilk":
                return new Recipe(530, 310, 935, 75, 10, 50, 0, 0);
            case "hotChocolate":
                return new Recipe(600, 400, 910, 75, 0, 50, 50, 0);
        }

        return null;
    }

    /**
     * Method to verify ingredients to recipes
     *
     * @param amountWater amount water in recipe
     * @param amountCoffee amount coffee in recipe
     * @param amountMilk amount milk in recipe
     * @param amountCinnamon amount cinnamon in recipe
     * @param amountChocolate amount chocolate in recipe
     * @param amountRecipes amount recipes is used in validation
     * @return true if has ingredients in compartment and false if not
     */
    private Boolean verifyRecipe(int amountWater, int amountCoffee, int amountMilk, int amountCinnamon, int amountChocolate, int amountRecipes){
        if(ingredientsCompartment.verifyAmount("water") - (amountWater * amountRecipes) < 0)
            return false;

        if(ingredientsCompartment.verifyAmount("coffee") - (amountCoffee * amountRecipes) < 0)
            return false;

        if(ingredientsCompartment.verifyAmount("milk") - (amountMilk * amountRecipes) < 0)
            return false;

        if(ingredientsCompartment.verifyAmount("cinnamon") - (amountCinnamon * amountRecipes) < 0)
            return false;

        if(ingredientsCompartment.verifyAmount("chocolate") - (amountChocolate * amountRecipes) < 0)
            return false;

        return true;
    }

    /**
     * Method to verify an small recipe
     *
     * @param recipe recipe to verify if machine can make
     * @return true if can make, false if not
     */
    private Boolean verifySmallRecipe(Recipe recipe) {
        int amountWater = recipe.getSmallWater();
        int amountCoffee = recipe.getSmallCoffee();
        int amountMilk = recipe.getSmallMilk();
        int amountCinnamon = recipe.getSmallCinnamon();
        int amountChocolate = recipe.getSmallChocolate();

        return verifyRecipe(amountWater, amountCoffee, amountMilk, amountCinnamon, amountChocolate, 1);
    }

    /**
     * Method to verify an medium recipe
     *
     * @param recipe recipe to verify if machine can make
     * @return true if can make, false if not
     */
    private Boolean verifyMediumRecipe(Recipe recipe) {
        int amountWater = recipe.getMediumWater();
        int amountCoffee = recipe.getMediumCoffee();
        int amountMilk = recipe.getMediumMilk();
        int amountCinnamon = recipe.getMediumCinnamon();
        int amountChocolate = recipe.getMediumChocolate();

        return verifyRecipe(amountWater, amountCoffee, amountMilk, amountCinnamon, amountChocolate, 1);
    }

    /**
     * Method to verify an big recipe
     *
     * @param recipe recipe to verify if machine can make
     * @return true if can make, false if not
     */
    private Boolean verifyBigRecipe(Recipe recipe) {
        int amountWater = recipe.getBigWater();
        int amountCoffee = recipe.getBigCoffee();
        int amountMilk = recipe.getBigMilk();
        int amountCinnamon = recipe.getBigCinnamon();
        int amountChocolate = recipe.getBigChocolate();

        return verifyRecipe(amountWater, amountCoffee, amountMilk, amountCinnamon, amountChocolate, 1);
    }

    /**
     * Get amount sugar by size
     *
     * @param size 1 to P, 2 to M, 3 to G, and any other value to S
     * @return return amount sugar in GR.
     */
    private Integer getSugarBySize(int size) {
        switch (size){
            case 1:
                return 5;
            case 2:
                return 8;
            case 3:
                return 12;
        }

        return 0;
    }

    /**
     * Method to pay and calculate return change money.
     *
     * @param coins coins used to pay
     * @param price drink price
     * @return return change money coins in ArrayList, if can't pay is returned same coins array
     */
    public ArrayList<Integer> pay(ArrayList<Integer> coins, double price) {
        ArrayList<Integer> changeCoins = new ArrayList();
        int changeMoney = this.getChangeMoney(coins, price);
        if (changeMoney < 0)
            return coins;

        for (int coin : coins) {
            coinsCompartment.fill(this.getTypeByValue(coin), 1);
        }

        if (this.hasChangeMoney(changeMoney)) {
            changeCoins = this.getChangeCoins(changeMoney);
        }

        if (changeCoins == null)
            return coins;

        return changeCoins;
    }

    /**
     * Method to get change coins by change money
     *
     * @param changeMoney change money using cents
     * @return null if not has coins and integer arrays if we can change coins.
     */
    public ArrayList<Integer> getChangeCoins(int changeMoney) {
        if (!this.hasChangeMoney(changeMoney))
            return null;

        ArrayList<Integer> changeCoins = new ArrayList();
        int amountFiveCents = coinsCompartment.verifyAmount("fiveCents");
        int amountTenCents = coinsCompartment.verifyAmount("tenCents");
        int amountTwentyFiveCents = coinsCompartment.verifyAmount("twentyFiveCents");
        int amountFiftyCents = coinsCompartment.verifyAmount("fiftyCents");
        int amountOneBRL = coinsCompartment.verifyAmount("oneBRL");

        while (changeMoney > 0) {
            if (changeMoney > 99 && amountOneBRL > 0) {
                if (coinsCompartment.take("oneBRL", 1)) {
                    changeCoins.add(100);
                    amountOneBRL--;
                    changeMoney -= 100;
                } else {
                    this.rollbackCoins(changeCoins);
                    return null;
                }
            } else if (changeMoney > 49 && amountFiftyCents > 0) {
                if (coinsCompartment.take("fiftyCents", 1)) {
                    changeCoins.add(50);
                    amountFiftyCents--;
                    changeMoney -= 50;
                } else {
                    this.rollbackCoins(changeCoins);
                    return null;
                }
            } else if (changeMoney > 24 && amountTwentyFiveCents > 0) {
                if (coinsCompartment.take("twentyFiveCents", 1)) {
                    changeCoins.add(25);
                    amountTwentyFiveCents--;
                    changeMoney -= 25;
                } else {
                    this.rollbackCoins(changeCoins);
                    return null;
                }
            } else if (changeMoney > 9 && amountTenCents > 0) {
                if (coinsCompartment.take("tenCents", 1)) {
                    changeCoins.add(10);
                    amountTenCents--;
                    changeMoney -= 10;
                } else {
                    this.rollbackCoins(changeCoins);
                    return null;
                }
            } else if (changeMoney > 4 && amountFiveCents > 0) {
                if (coinsCompartment.take("fiveCents", 1)) {
                    changeCoins.add(5);
                    amountFiveCents--;
                    changeMoney -= 5;
                } else {
                    this.rollbackCoins(changeCoins);
                    return null;
                }
            } else {
                this.rollbackCoins(changeCoins);
                return new ArrayList<Integer>();
            }
        }

        return changeCoins;
    }

    /**
     * Method to return change money in cents format
     * for example: 2.5 BRL change money is 250 cents
     *
     * @param coins coins useds to pay
     * @param price drink price
     * @return return change money in cents
     */
    public Integer getChangeMoney(ArrayList<Integer> coins, double price) {
        if (!this.canPay(coins, price))
            return -1;

        return this.getSumCoins(coins) - this.formatPrice(price);
    }

    /**
     * Method to verify if price can pay an drink
     *
     * @param coins coins useds to pay
     * @param price drink price
     * @return true if money can pay drink, and false if not
     */
    public Boolean canPay(ArrayList<Integer> coins, double price) {
        if (!this.validateCoins(coins) || !this.validatePrice(price) || !this.hasSpaceInCompartment(coins))
            return false;

        int change = this.getSumCoins(coins) - this.formatPrice(price);
        return change > 0;
    }

    /**
     * Method to verify if coffee machine has space in compartment
     * to add new coins
     *
     * @param coins coins to verify compartment space
     * @return true if coffee machine has space and false if not
     */
    public Boolean hasSpaceInCompartment(ArrayList<Integer> coins) {
        int fiveCents = 0;
        int tenCents = 0;
        int twentyFiveCents = 0;
        int fiftyCents = 0;
        int oneBRL = 0;

        for (int coin : coins) {
            switch (coin) {
                case 5:
                    fiveCents += 1;
                    break;
                case 10:
                    tenCents += 1;
                    break;
                case 25:
                    twentyFiveCents += 1;
                    break;
                case 50:
                    fiftyCents += 1;
                    break;
                case 100:
                    oneBRL += 1;
                    break;
            }
        }

        if (coinsCompartment.verifyAmount("fiveCents") + fiveCents > coinsCompartment.getMaxAmount()) {
            return false;
        }

        if (coinsCompartment.verifyAmount("tenCents") + tenCents > coinsCompartment.getMaxAmount()) {
            return false;
        }

        if (coinsCompartment.verifyAmount("twentyFiveCents") + twentyFiveCents > coinsCompartment.getMaxAmount()) {
            return false;
        }

        if (coinsCompartment.verifyAmount("fiftyCents") + fiftyCents > coinsCompartment.getMaxAmount()) {
            return false;
        }

        if (coinsCompartment.verifyAmount("oneBRL") + oneBRL > coinsCompartment.getMaxAmount()) {
            return false;
        }

        return true;
    }

    /**
     * Method to verify if has change money in
     * coins compartment.
     *
     * @param changeMoney - change money in cents
     * @return true if we has change money, and false if not
     */
    public Boolean hasChangeMoney(int changeMoney) {
        int amountMoney = 0;

        amountMoney += this.getAmountCoins("fiveCents") * 5;
        amountMoney += this.getAmountCoins("tenCents") * 10;
        amountMoney += this.getAmountCoins("twentyFiveCents") * 25;
        amountMoney += this.getAmountCoins("fiftyCents") * 50;
        amountMoney += this.getAmountCoins("oneBRL") * 100;

        return amountMoney >= changeMoney;
    }


    /**
     * Method to format BRL price to BRL cent price
     *
     * @param price BRL price
     * @return BRL cent price
     */
    public Integer formatPrice(double price) {
        return (int) (price * 100);
    }

    /**
     * Method to validate inserted coins.
     *
     * @param coins array of the coins to validate
     * @return return true if is valid, and false if not
     */
    public Boolean validateCoins(ArrayList<Integer> coins) {
        boolean valid = true;
        for (int coin : coins) {
            if (coin != 5 && coin != 10 && coin != 25 && coin != 50 && coin != 100) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    /**
     * Method to get type by coin value
     *
     * @param value coin value
     * @return an string with key
     */
    public String getTypeByValue(int value) {
        switch (value) {
            case 5:
                return "fiveCents";
            case 10:
                return "tenCents";
            case 25:
                return "twentyFiveCents";
            case 50:
                return "fiftyCents";
            case 100:
                return "oneBRL";
        }
        return null;
    }

    /**
     * Method to register coffee machine recipes
     */
    private void loadRecipes() {
        Recipe expressCoffee = new Recipe(200, 75, 535, 100, 10, 0, 0, 0);
        Recipe cappuccino = new Recipe(530, 310, 935, 100, 10, 50, 10, 2);
        Recipe coffeeWithMilk = new Recipe(530, 310, 935, 75, 10, 50, 0, 0);
        Recipe hotChocolate = new Recipe(600, 400, 910, 75, 0, 50, 50, 0);

        recipes.add(expressCoffee);
        recipes.add(cappuccino);
        recipes.add(coffeeWithMilk);
        recipes.add(hotChocolate);
    }

    /**
     * Method to load compartments in
     * coffee machine create.
     */
    private void loadCompartments() {
        cupsCompartment.fill("smallCup", 100);
        cupsCompartment.fill("mediumCup", 100);
        cupsCompartment.fill("bigCup", 100);

        coinsCompartment.fill("fiveCents", 0);
        coinsCompartment.fill("tenCents", 0);
        coinsCompartment.fill("twentyFiveCents", 0);
        coinsCompartment.fill("fiftyCents", 0);
        coinsCompartment.fill("oneBRL", 2);

        ingredientsCompartment.fill("water", 30000);
        ingredientsCompartment.fill("coffee", 3000);
        ingredientsCompartment.fill("milk", 15000);
        ingredientsCompartment.fill("cinnamon", 600);
        ingredientsCompartment.fill("chocolate", 15000);
        ingredientsCompartment.fill("sugar", 3600);
    }

    /**
     * Method to sum coins value
     *
     * @param coins array with coins
     * @return return coins sum
     */
    private Integer getSumCoins(ArrayList<Integer> coins) {
        int sumCoins = 0;
        for (int coin : coins) {
            sumCoins += coin;
        }
        return sumCoins;
    }

    /**
     * Method to validate amount price
     *
     * @param price BRL amount price
     * @return true if is an valid price and false if not
     */
    private Boolean validatePrice(double price) {
        int formattedPrice = this.formatPrice(price);
        return formattedPrice % 5 == 0;
    }

    /**
     * Method to made an rollback if in change coin process we
     * not found more coins.
     * <p>
     * This method fill coins again.
     *
     * @param coins to insert again in coins compartment
     */
    private void rollbackCoins(ArrayList<Integer> coins) {
        for (int coin : coins) {
            coinsCompartment.fill(this.getTypeByValue(coin), 1);
        }
    }
}
