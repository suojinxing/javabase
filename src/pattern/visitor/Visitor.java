package pattern.visitor;

/**
 * 访问者
 */
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
