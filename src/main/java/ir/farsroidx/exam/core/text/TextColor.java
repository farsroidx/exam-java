package ir.farsroidx.exam.core.text;

public enum TextColor {

    BLACK("\u001B[30m"),

    GRAY("\u001B[37m"),

    RED("\u001B[31m"),

    GREEN("\u001B[32m"),

    YELLOW("\u001B[33m"),

    BLUE("\u001B[34m"),

    PURPLE("\u001B[35m"),

    CYAN("\u001B[36m");

    private final String code;

    TextColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
