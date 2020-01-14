package pattern.chainofresponsibility;

public abstract class Support {
    private String name; // 解决问题实例的名字
    private Support next; // 要推卸给的对象

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next){
        this.next = next;
        return next;
    }

    /*
     * 解决问题的步骤
     */
    public final void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }else if(next != null){
            next.support(trouble);
        }else{
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }

    protected abstract boolean resolve(Trouble trouble); // 解决问题的方法

    protected void done(Trouble trouble){
        System.out.println(trouble + "已经被解决 by" + this);
    }

    protected void fail(Trouble trouble){
        System.out.println(trouble + "不能解决这个问题！无能为力。");
    }
}
