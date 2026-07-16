package ir.farsroidx.exam.core.actions;

@FunctionalInterface
public interface MenuAction extends ir.farsroidx.exam.core.actions.Action {

    void execute(String key);

}
