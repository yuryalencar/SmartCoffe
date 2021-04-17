package org.unipampa.edu.br;

import org.jetbrains.annotations.NotNull;

public class CupsCompartment extends Compartment {

    private int amountSmallCup = 100;
    private int amountMediumCup = 100;
    private int amountBigCup = 100;

    public CupsCompartment() {

    }

    /**
     * Takes 1 cup of a given type from the cups compartment.
     *
     * @param  type   one of three types of cup: smallCup, mediumCup or bigCup
     * @param  amount the amount of cups taken, default 1 for cups
     * @return        whether the action was successful
     */
    @Override
    public boolean take(String type, int amount) {

        amount = 1; //cups to take

        switch (type) {
            case "smallCup":
                this.amountSmallCup = this.amountSmallCup - amount;
                break;

            case "mediumCup":
                this.amountMediumCup = this.amountMediumCup - amount;
                break;

            case "bigCup":
                this.amountBigCup = this.amountBigCup - amount;
                break;

            default:
                System.out.println("Tipo de copo não reconhecido em take().");
                return false;
        }
        return true;
    }

    /**
     * Fills the cups compartment of a given cup type.
     *
     * @param  type   one of three types of cup: smallCup, mediumCup or bigCup
     * @param  amount the total amount of cups after filled
     * @return        whether the action was successful
     */
    @Override
    public boolean fill(String type, int amount) {

        // Check if amount is grater than max cup value
        if(amount > this.getMaxAmount()) {
            System.out.println("Quantidade de copos superior ao permitido em fill().");
            return false;
        }

        switch (type) {
            case "smallCup":
                if(amount <= this.amountSmallCup) {
                    System.out.println("Quantidade de copos inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountSmallCup = amount;
                break;

            case "mediumCup":
                if(amount <= this.amountMediumCup) {
                    System.out.println("Quantidade de copos inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountMediumCup = amount;
                break;

            case "bigCup":
                if(amount <= this.amountBigCup) {
                    System.out.println("Quantidade de copos inferior ao esperado em fill().");
                    return false;
                }
                else
                    this.amountBigCup = amount;
                break;

            default:
                System.out.println("Tipo de copo não reconhecido.");
                return false;
        }
        return true;
    }

    /**
     * Verifies the current amount of cups of a given type.
     *
     * @param  type   one of three types of cup: smallCup, mediumCup or bigCup
     * @return        the amount of cups, or -1 if an error occurred
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
                System.out.println("Tipo de copo não reconhecido em verifyAmount().");
                return -1;
        }

    }

    public int getAmountSmallCup() {
        return amountSmallCup;
    }

    public int getAmountMediumCup() {
        return amountMediumCup;
    }

    public int getAmountBigCup() {
        return amountBigCup;
    }
}
