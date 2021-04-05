package org.example;

public enum ExchangeTypes {
    DIRECT("direct"),
    TOPIC("topic"),
    HEADERS("headers"),
    FANOUT("fanout");


    private final String type;

    private ExchangeTypes(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }


}
