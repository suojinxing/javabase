package pattern.chainofresponsibility;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) { // 直接拒奇数问题
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}
