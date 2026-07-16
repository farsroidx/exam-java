package ir.farsroidx.exam.actions;

@FunctionalInterface
public interface MenuAction extends Action {

    void execute(String key);

}
