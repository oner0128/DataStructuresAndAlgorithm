package trees;

/**
 * Created by hrong on 2016/11/20.
 */
public class BinaryNode<AnyType> {
    BinaryNode<AnyType> left,right;
    AnyType element;

    public BinaryNode(BinaryNode<AnyType> left, BinaryNode<AnyType> right, AnyType element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public BinaryNode(AnyType element) {
        this(null,null,element);
    }
}
