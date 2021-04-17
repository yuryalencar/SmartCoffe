package org.unipampa.edu.br;

public class CoinsCompartment extends Compartment {

    private int amountFiveCents = 30;
    private int amountTenCents = 30;
    private int amountTwentyFiveCents = 30;
    private int amountFiftyCents = 30;
    private int amountOneBRL = 30;

    public CoinsCompartment() {

    }

    /**
     * Takes a number of coins of a given type from the coins compartment.
     *
     * @param  type   one of five types of coin: fiveCents, tenCents, twentyFiveCents, fiftyCents e oneBRL
     * @param  amount the amount of coins taken
     * @return        whether the action was successful
     */
    @Override
    public boolean take(String type, int amount) {

        switch (type) {
            case "fiveCents":
                if(this.amountFiveCents - amount >= 0)
                    this.amountFiveCents -= amount;
                else {
                    System.out.println("Quantidade de moedas superior ao limite em take().");
                    return false;
                }
                break;

            case "tenCents":
                if(this.amountTenCents - amount >= 0)
                    this.amountTenCents -= amount;
                else {
                    System.out.println("Quantidade de moedas superior ao limite em take().");
                    return false;
                }
                break;

            case "twentyFiveCents":
                if(this.amountTwentyFiveCents - amount >= 0)
                    this.amountTwentyFiveCents -= amount;
                else {
                    System.out.println("Quantidade de moedas superior ao limite em take().");
                    return false;
                }
                break;

            case "fiftyCents":
                if(this.amountFiftyCents - amount >= 0)
                    this.amountFiftyCents -= amount;
                else {
                    System.out.println("Quantidade de moedas superior ao limite em take().");
                    return false;
                }
                break;

            case "oneBRL":
                if(this.amountOneBRL - amount >= 0)
                    this.amountOneBRL -= amount;
                else {
                    System.out.println("Quantidade de moedas superior ao limite em take().");
                    return false;
                }
                break;

            default:
                System.out.println("Tipo de copo não reconhecido em take().");
                return false;
        }

        return true;
    }

    /**
     * Fills the coins compartment of a given coin type.
     *
     * @param  type   one of five types of coin: fiveCents, tenCents, twentyFiveCents, fiftyCents e oneBRL
     * @param  amount the total amount of coins after filled
     * @return        whether the action was successful
     */
    @Override
    public boolean fill(String type, int amount) {

        // Check if amount is grater than max coin value
        if(amount > this.getMaxAmount()) {
            System.out.println("Quantidade de moedas superior ao permitido em fill().");
            return false;
        }

        switch (type) {
            case "fiveCents":
                if(amount <= this.amountFiveCents) {
                    System.out.println("Quantidade de moedas inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountFiveCents = amount;
                break;

            case "tenCents":
                if(amount <= this.amountTenCents) {
                    System.out.println("Quantidade de moedas inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountTenCents = amount;
                break;

            case "twentyFiveCents":
                if(amount <= this.amountTwentyFiveCents) {
                    System.out.println("Quantidade de moedas inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountTwentyFiveCents = amount;
                break;

            case "fiftyCents":
                if(amount <= this.amountFiftyCents) {
                    System.out.println("Quantidade de moedas inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountFiftyCents = amount;
                break;

            case "oneBRL":
                if(amount <= this.amountOneBRL) {
                    System.out.println("Quantidade de moedas inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountOneBRL = amount;
                break;

            default:
                System.out.println("Tipo de moeda não reconhecido.");
                return false;
        }
        return true;
    }

    /**
     * Verifies the current amount of coins of a given type.
     *
     * @param  type   one of five types of coin: fiveCents, tenCents, twentyFiveCents, fiftyCents e oneBRL
     * @return        the amount of coins, or -1 if an error occurred
     */
    @Override
    public int verifyAmount(String type) {

        switch (type) {
            case "fiveCents":
                return this.amountFiveCents;

            case "tenCents":
                return this.amountTenCents;

            case "twentyFiveCents":
                return this.amountTwentyFiveCents;

            case "fiftyCents":
                return this.amountFiftyCents;

            case "oneBRL":
                return this.amountOneBRL;

            default:
                System.out.println("Tipo de moeda não reconhecido em verifyAmount().");
                return -1;
        }

    }
}
