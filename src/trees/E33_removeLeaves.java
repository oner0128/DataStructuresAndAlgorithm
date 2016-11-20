package trees;

/**
 * Created by hrong on 2016/11/20.
 */
public class E33_removeLeaves {
    static AvlNode removeLeaves(AvlNode t){
        if (t==null||(t.left==null&&t.right==null))return null;
        t.left=removeLeaves(t.left);
        t.right=removeLeaves(t.right);
        return t;
    }
}
