package org.unipampa.edu.br;

public class Order {

        private EnumInterfaceCoffe coffe;
        private String sugar;

        public Order(EnumInterfaceCoffe coffe, String sugar) {
            this.coffe = coffe;
            this.sugar = sugar;
        }
        public Order() {
        }

        public EnumInterfaceCoffe getCoffe() {
            return coffe;
        }

        public void setCoffe(EnumInterfaceCoffe coffe) {
            this.coffe = coffe;
        }

        public String getSugar() {
            return sugar;
        }

        public void setSugar(String sugar) {
            this.sugar = sugar;
        }
    }

