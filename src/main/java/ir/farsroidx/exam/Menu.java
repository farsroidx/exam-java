package ir.farsroidx.exam;

import ir.farsroidx.exam.models.MenuModel;

import java.util.List;

import static ir.farsroidx.exam.Utils.*;

@SuppressWarnings("ALL")
public final class Menu {

    private static final String MENU_STRUCTURE = "\t[%s]\t%s";

    private final String title;

    private final List<MenuModel> menus;

    public Menu(MenuModel... menus) {
        this(null, menus);
    }

    public Menu(String title, MenuModel... menus) {
        this.title = title;
        this.menus = List.of(menus);
    }

    public static Menu of(MenuModel... menus) {
        return new Menu(menus);
    }

    public static Menu of(String title, MenuModel... menus) {
        return new Menu(title, menus);
    }

    public String show() {

        println();

        if (title != null) {
            println(title, TextStyle.BOLD, TextStyle.ITALIC);
        }

        for(MenuModel menu : menus) {

            println(
                String.format(MENU_STRUCTURE, menu.getKey(), (menu.getDesc() != null ? menu.getDesc() : ""))
                    .stripTrailing(),
                TextColor.CYAN
            );
        }

        println();

        String key = input("please choose an option:");

        println();

        MenuModel model = menus.stream()
            .filter(i -> i.getIgnoredCase() ? i.getKey().equalsIgnoreCase(key) : i.getKey().equals(key))
            .findFirst()
            .orElse(null);

        if (model != null) return model.getKey();

        println("Invalid option! please try again.", TextColor.RED, TextStyle.BOLD);

        cls();

        return show();
    }
}
