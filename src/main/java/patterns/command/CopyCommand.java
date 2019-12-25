package patterns.command;

public class CopyCommand extends Command {

    Content c;

    @Override
    public void doit() {
        c.msg += c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() / 2);
    }
}
