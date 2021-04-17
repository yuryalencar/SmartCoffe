package org.unipampa.edu.br;

public abstract class Compartment {

    private final int MAX_AMOUNT;
    private final int MAX_PERCENT_TO_SENDER_EMAIL;
    private final int MIN_PERCENT_TO_SENDER_EMAIL;

    public Compartment(int maxAmount, int maxPercentToSenderEmail, int minPercentToSenderEmail) {
        this.MAX_AMOUNT = maxAmount;
        this.MAX_PERCENT_TO_SENDER_EMAIL = maxPercentToSenderEmail;
        this.MIN_PERCENT_TO_SENDER_EMAIL = minPercentToSenderEmail;
    }

    public abstract boolean take(String type, int amount);

    public abstract boolean fill(String type, int amount);

    public abstract int verifyAmount(String type);

    public int getMaxAmount() {
        return MAX_AMOUNT;
    }

    public int getMaxToSenderEmail() {
        return MAX_PERCENT_TO_SENDER_EMAIL;
    }

    public int getMinToSenderEmail() {
        return MIN_PERCENT_TO_SENDER_EMAIL;
    }
}
