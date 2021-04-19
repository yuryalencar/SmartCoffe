package org.unipampa.edu.br;

public class CoinsCompartment extends Compartment {

    private int amountFiveCents;
    private int amountTenCents;
    private int amountTwentyFiveCents;
    private int amountFiftyCents;
    private int amountOneBRL;

    public CoinsCompartment() {
        super(100, 80, 15);

        this.amountFiveCents = 0;
        this.amountTenCents = 0;
        this.amountTwentyFiveCents = 0;
        this.amountFiftyCents = 0;
        this.amountOneBRL = 0;
    }

    /**
     * Takes a number of coins of a given type from the coins compartment.
     *
     * @param type   one of five types of coin: fiveCents, tenCents, twentyFiveCents, fiftyCents e oneBRL
     * @param amount the amount of coins taken
     * @return whether the action was successful
     */
    @Override
    public boolean take(String type, int amount) {

        System.out.println("Entrou");
        if (amount < 0)
            return false;

        switch (type) {
            case "fiveCents":
                if (this.amountFiveCents - amount >= 0) {
                    this.amountFiveCents -= amount;
                    return true;
                }
                break;

            case "tenCents":
                if (this.amountTenCents - amount >= 0) {
                    this.amountTenCents -= amount;
                    return true;
                }
                break;

            case "twentyFiveCents":
                if (this.amountTwentyFiveCents - amount >= 0) {
                    this.amountTwentyFiveCents -= amount;
                    return true;
                }
                break;

            case "fiftyCents":
                if (this.amountFiftyCents - amount >= 0) {
                    this.amountFiftyCents -= amount;
                    return true;
                }
                break;

            case "oneBRL":
                if (this.amountOneBRL - amount >= 0) {
                    this.amountOneBRL -= amount;
                    return true;
                }
                break;
        }

        return false;
    }

    /**
     * Fills the coins compartment of a given coin type.
     *
     * @param type   one of five types of coin: fiveCents, tenCents, twentyFiveCents, fiftyCents e oneBRL
     * @param amount the total amount of coins after filled
     * @return whether the action was successful
     */
    @Override
    public boolean fill(String type, int amount) {

        if (amount < 0)
            return false;

        switch (type) {
            case "fiveCents":
                if (this.amountFiveCents + amount > this.getMaxAmount())
                    return false;

                this.amountFiveCents += amount;
                break;

            case "tenCents":
                if (this.amountTenCents + amount > this.getMaxAmount())
                    return false;

                this.amountTenCents += amount;
                break;

            case "twentyFiveCents":
                if (this.amountTwentyFiveCents + amount > this.getMaxAmount())
                    return false;

                this.amountTwentyFiveCents += amount;
                break;

            case "fiftyCents":
                if (this.amountFiftyCents + amount > this.getMaxAmount())
                    return false;

                this.amountFiftyCents += amount;
                break;

            case "oneBRL":
                if (this.amountOneBRL + amount > this.getMaxAmount())
                    return false;

                this.amountOneBRL += amount;
                break;

            default:
                return false;
        }

        return true;
    }

    /**
     * Verifies the current amount of coins of a given type.
     *
     * @param type one of five types of coin: fiveCents, tenCents, twentyFiveCents, fiftyCents e oneBRL
     * @return the amount of coins, or -1 if an error occurred
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
                return -1;
        }

    }
}
