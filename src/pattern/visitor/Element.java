package pattern.visitor;

/**
 * 被访问者的接口
 */
public interface Element {
    void accept(Visitor visitor);
}
