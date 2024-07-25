package br.com.kassin.aura;

public enum AuraType {
    YELLOW("yellow"),
    BLUE("blue"),
    WHITE("white"),
    BLACK("black"),
    PURPLE("purple"),
    RED("red"),
    PINK("pink"),
    DEFAULT("default");
    private final String stringValue;

    private AuraType(final String stringValue) {
        this.stringValue = stringValue;
    }

    private String getStringValue() {
        return stringValue;
    }

}

