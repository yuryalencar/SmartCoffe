package org.unipampa.edu.br;

public class CupsCompartment extends Compartment {

    private int amountSmallCup;
    private int amountMediumCup;
    private int amountBigCup;

    public CupsCompartment() {
        super(100, 0, 15);

        this.amountBigCup = 0;
        this.amountMediumCup = 0;
        this.amountSmallCup = 0;
    }

    /**
     * Takes 1 cup of a given type from the cups compartment.
     *
     * @param type   one of three types of cup: smallCup, mediumCup or bigCup
     * @param amount the amount of cups taken, default 1 for cups
     * @return whether the action was successful
     */
    @Override
    public boolean take(String type, int amount) {

        if (amount < 0)
            return false;

        switch (type) {
            case "smallCup":
                if (this.amountSmallCup - amount > -1) {
                    this.amountSmallCup -= amount;
                    return true;
                }
                break;

            case "mediumCup":
                if (this.amountMediumCup - amount > -1) {
                    this.amountMediumCup -= amount;
                    return true;
                }
                break;

            case "bigCup":
                if (this.amountBigCup - amount > -1) {
                    this.amountBigCup -= amount;
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * Fills the cups compartment of a given cup type.
     *
     * @param type   one of three types of cup: smallCup, mediumCup or bigCup
     * @param amount the total amount of cups after filled
     * @return whether the action was successful
     */
    @Override
    public boolean fill(String type, int amount) {

        if (amount < 0)
            return false;

        switch (type) {
            case "smallCup":
                if (this.amountSmallCup + amount <= this.getMaxAmount()) {
                    this.amountSmallCup += amount;
                    return true;
                }
                break;

            case "mediumCup":
                if (this.amountMediumCup + amount <= this.getMaxAmount()) {
                    this.amountMediumCup += amount;
                    return true;
                }
                break;

            case "bigCup":
                if (this.amountBigCup + amount <= this.getMaxAmount()) {
                    this.amountBigCup += amount;
                    return true;
                }
                break;

        }

        return false;
    }

    /**
     * Verifies the current amount of cups of a given type.
     *
     * @param type one of three types of cup: smallCup, mediumCup or bigCup
     * @return the amount of cups, or -1 if an error occurred
     */
    @Override
    public int verifyAmount(String type) {

        switch (type) {
            case "smallCup":
                return this.amountSmallCup;

            case "mediumCup":
                return this.amountMediumCup;

            case "bigCup":
                return this.amountBigCup;

            default:
                return -1;
        }

    }
}
