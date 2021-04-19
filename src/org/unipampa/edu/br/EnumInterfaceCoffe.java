package org.unipampa.edu.br;

public enum EnumInterfaceCoffe {

    EXPRESS_COFFEE_P(1,"expressCoffee",1, 75),
    EXPRESS_COFFEE_M (2, "expressCoffee",2, 200),
    EXPRESS_COFFEE_G(3, "expressCoffee", 3, 535),
    CHOCOLATE_COFFEE_P(4, "hotChocolate", 1, 400),
    CHOCOLATE_COFFEE_M(5, "hotChocolate", 2, 600),
    CHOCOLATE_COFFEE_G(6, "hotChocolate", 3, 910),
    CAPPUCCINO_COFFEE_P(7, "cappuccino", 1, 310),
    CAPPUCCINO_COFFEE_M(8, "cappuccino", 2, 530),
    CAPPUCCINO_COFFEE_G(9, "cappuccino", 3, 935),
    MILK_COFFEE_P(10, "coffeeWithMilk", 1, 310),
    MILK_COFFEE_M(11, "coffeeWithMilk", 2, 530),
    MILK_COFFEE_G(12, "coffeeWithMilk", 3, 935),
    SUGAR_S(13, "sugar", 1, 0),
    SUGAR_P(14, "sugar", 2,0),
    SUGAR_M(15, "sugar", 3,0),
    SUGAR_G(16, "sugar", 4, 0);

    int id;
    String drink;
    int size;
    double price;

    EnumInterfaceCoffe(int id, String drink, int size, double price){
        this.id = id;
        this.drink = drink;
        this.size = size;
        this.price = price;
    }

    public static Double getPrice(int id){

        for(EnumInterfaceCoffe item : EnumInterfaceCoffe.values()){
            if(item.id == id){
                return item.price;
            }
        }
        return null;
    }

    public static String getSizeSugar(int size){

        if(size == 1){
            return "S";
        }
        else if(size == 2){
            return "P";
        }
        else if(size == 3){
            return "M";
        }
        else{
            return  "G";
        }
    }

    public static int getSizeSugarInt(String size){

        if(size.equalsIgnoreCase("S")){
            return 1;
        }
        else if(size.equalsIgnoreCase("P") ){
            return 2;
        }
        else if(size.equalsIgnoreCase("M")){
            return 3;
        }
        else{
            return 4;
        }
    }

    public static String getSizeDrink(int size){

        if(size == 1){
            return "P";
        }
        else if(size == 2){
            return "M";
        }
        else{
            return  "G";
        }
    }


    public static String getDrink(String drink){

        if(drink.equalsIgnoreCase("expressCoffee")){
            return "Café Expresso";
        }
        else if(drink.equalsIgnoreCase("hotChocolate")){
            return "Chocolate";
        }
        else if(drink.equalsIgnoreCase("cappuccino")){
            return "Cappuccino";
        }
        else{
            return "Café com Leite";
        }
    }
}


