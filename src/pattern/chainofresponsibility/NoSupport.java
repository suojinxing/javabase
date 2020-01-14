package pattern.chainofresponsibility;

/**
 * 这个类不解决任何问题，总是返回false
 */
public class NoSupport extends Support{
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
