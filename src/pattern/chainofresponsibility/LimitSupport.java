package pattern.chainofresponsibility;

public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) { // 解决问题的方法
        if (trouble.getNumber() < limit) {
            return true;
        }
        return false;
    }
}
