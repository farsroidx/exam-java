package ir.farsroidx.exam;

public enum TextStyle {

    DIM("\u001B[2m"),

    BOLD("\u001B[1m"),

    ITALIC("\u001B[3m"),
    
    UNDERLINE("\u001B[4m"),

    STRIKETHROUGH("\u001B[9m");

    private final String code;

    TextStyle(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
