package org.unipampa.edu.br;

public abstract class Compartment {

    private int maxAmount = 100;
    private int maxToSenderEmail = 80;
    private int minToSenderEmail = 15;

    public Compartment() {

    }

    /*public Compartment(int maxAmount, int maxToSenderEmail, int minToSenderEmail) {

    }*/

    public abstract boolean take(String type, int amount);

    public abstract boolean fill(String type, int amount);

    public abstract int verifyAmount(String type);

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getMaxToSenderEmail() {
        return maxToSenderEmail;
    }

    public int getMinToSenderEmail() {
        return minToSenderEmail;
    }
}
