package ir.farsroidx.exam.models;

@SuppressWarnings("ALL")
public final class MenuModel {

    private final String key;

    private final String desc;

    private final Boolean ignoredCase;

    public MenuModel(String key) {
        this(key, true);
    }

    public MenuModel(String key, Boolean ignoredCase) {
        this(key, null, ignoredCase);
    }

    public MenuModel(String key, String desc) {
        this(key, desc, true);
    }

    public MenuModel(String key, String desc, Boolean ignoredCase) {
        this.key = key; this.desc = desc; this.ignoredCase = ignoredCase;
    }

    public static MenuModel of(String key) {
        return new MenuModel(key);
    }

    public static MenuModel of(String key, Boolean ignoredCase) {
        return new MenuModel(key, ignoredCase);
    }

    public static MenuModel of(String key, String desc) {
        return new MenuModel(key, desc);
    }

    public static MenuModel of(String key, String desc, Boolean ignoredCase) {
        return new MenuModel(key, desc, ignoredCase);
    }

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public Boolean getIgnoredCase() {
        return ignoredCase;
    }
}
