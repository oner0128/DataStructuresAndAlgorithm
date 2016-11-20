package trees;

import java.util.Stack;

/**
 * Created by hrong on 2016/11/20.
 */
public class E26_RotationTwice {
    private static class AvlNode<AnyType>{
        AvlNode<AnyType> left,right;
        int height;
        AnyType element;

        public AvlNode(AvlNode<AnyType> left, AvlNode<AnyType> right, AnyType element) {
            this.left = left;
            this.right = right;
            this.element = element;
            height=0;
        }

        public AvlNode(AnyType element) {
            this(null,null,element);
        }
    }
    static AvlNode doubleRotateWithLeft(AvlNode k3){
        AvlNode k1,k2;

        k2=k3.left;
        k1=k2.right;

        k2.right=k1.left;
        k3.left=k1.right;
        k1.left=k2;
        k1.right=k3;
        k1.height=Math.max(height(k1.left),height(k1.left))+1;
        k2.height=Math.max(height(k2.left),height(k2.left))+1;
        k3.height=Math.max(height(k3.left),height(k3.left))+1;
        return k3;
    }

    private static int height(AvlNode avlNode) {
        int height1=-1,height2=-1;
        if (avlNode==null)return -1;
        else if (avlNode.left!=null){
            height1=height(avlNode.left)+1;
        }else if (avlNode.right!=null){
            height2=height(avlNode.right)+1;
        }
        return Math.max(height1,height2);
    }
}
