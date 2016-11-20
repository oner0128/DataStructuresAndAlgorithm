package trees;

/**
 * Created by hrong on 2016/11/20.
 */
public class AvlNode<AnyType> {
    AvlNode<AnyType> left, right;
    int height;
    AnyType element;

    public AvlNode(AvlNode<AnyType> left, AvlNode<AnyType> right, AnyType element) {
        this.left = left;
        this.right = right;
        this.element = element;
        height = 0;
    }

    public AvlNode(AnyType element) {
        this(null, null, element);
    }
}
