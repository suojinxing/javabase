package pattern.visitor;


import java.util.Iterator;

/**
 * 访问数据结构，并展示一览
 */
public class ListVisitor extends Visitor {
    private String currentdir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir += "/" + directory.getName();
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
