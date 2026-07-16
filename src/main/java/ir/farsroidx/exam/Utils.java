package ir.farsroidx.exam;

import ir.farsroidx.exam.actions.Action;
import ir.farsroidx.exam.actions.MenuAction;
import ir.farsroidx.exam.actions.VoidAction;
import ir.farsroidx.exam.exceptions.ForceCloseException;

import java.util.Objects;
import java.util.Scanner;

@SuppressWarnings("ALL")
public final class Utils {

    public static final String RESET = "\u001B[0m";

    private static final Scanner scanner = new Scanner(System.in);

    public static void cls() {
        println();
        println();
        println("-".repeat(80), TextStyle.DIM);
        println();
    }

    public static void print(Object o, TextColor color) {
        print(o, color, (TextStyle[]) null);
    }

    public static void print(Object o, TextStyle... styles) {
        print(o, null, styles);
    }

    public static void print(Object o, TextColor color, TextStyle... styles) {
        print( makeStyledText(o, color, styles) );
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static void println(Object o, TextColor color) {
        println(o, color, (TextStyle[]) null);
    }

    public static void println(Object o, TextStyle... styles) {
        println(o, null, styles);
    }

    public static void println(Object o, TextColor color, TextStyle... styles) {
        println( makeStyledText(o, color, styles) );
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void println() {
        System.out.println();
    }

    public static void whileRun(MenuAction action) {
        whileTrue(null, action);
    }

    public static void whileRun(Menu menu, MenuAction action) {
        whileTrue(menu, action);
    }

    public static void whileRun(VoidAction action) {
        whileTrue(null, action);
    }

    public static void whileRun(Menu menu, VoidAction action) {
        whileTrue(menu, action);
    }

    private static void whileTrue(Menu menu, Action action) {

        Objects.requireNonNull(action, "Action can not be null.");

        VoidAction voidAction = null;
        MenuAction menuAction = null;

        if (menu == null) {

            if (!(action instanceof VoidAction)) {

                throw new IllegalArgumentException(
                    "When menu is null, action must be an instance of EmptyAction."
                );
            }

            voidAction = (VoidAction) action;

        } else {

            if (!(action instanceof MenuAction)) {

                throw new IllegalArgumentException(
                    "When menu is not null, action must be an instance of OptionAction."
                );
            }

            menuAction = (MenuAction) action;
        }

        String key = null;

        while (true) {

            try {

                cls();

                if (menu != null) {
                    key = menu.show();
                }

                if (voidAction != null) {
                    voidAction.execute();
                } else {
                    menuAction.execute(key);
                }

            } catch (ForceCloseException e) {
                println();
                println("You closed the program. Have a nice day :)", TextColor.BLUE);
                break;

            } catch (Exception e) {
                println();
                println("[WAS_STOPPED_BY_ERROR] " + e.getMessage(), TextColor.RED);
                break;
            }
        }
    }

    public static String input() { return input(null, String.class); }

    public static String input(String message) { return input(message, String.class); }

    public static <T> T input(Class<T> type) { return input(null, type); }

    public static <T> T input(String message, Class<T> type) {

        if(message != null) {
            print(message, TextColor.YELLOW, TextStyle.UNDERLINE);
            print(" ");
        }

        String input = scanner.nextLine();

        try {

            if (type == String.class) {

                return type.cast(input);

            } else if (type == Integer.class) {

                return type.cast(Integer.parseInt(input));

            } else if (type == Double.class) {

                return type.cast(Double.parseDouble(input));

            } else if (type == Float.class) {

                return type.cast(Float.parseFloat(input));

            } else if (type == Long.class) {

                return type.cast(Long.parseLong(input));

            } else if (type == Boolean.class) {

                if (input.equals("0")) {

                    return type.cast(false);

                } else if (input.equals("1")) {

                    return type.cast(true);
                }

                return type.cast(Boolean.parseBoolean(input));
            }

            throw new IllegalArgumentException("Unsupported type: " + type.getName());

        } catch (Exception e) {

            throw new RuntimeException("Invalid input for type " + type.getSimpleName(), e);
        }
    }

    public static void exit() throws ForceCloseException { throw new ForceCloseException(); }

    private static String makeStyledText(Object o, TextColor color, TextStyle... styles) {

        String value = Objects.toString(o);

        StringBuilder builder = new StringBuilder();

        if (color != null) {
            builder.append(color.getCode());
        }

        if (styles != null) {

            for (TextStyle style : styles) {

                if (style != null) {
                    builder.append(style.getCode());
                }
            }
        }

        builder.append(value).append(RESET);

        return builder.toString();
    }
}
