package trees;

/**
 * Created by hrong on 2016/11/20.
 * a引用根节点统计节点数
 * b统计树叶的片数
 * c满节点的个数
 */
public class E31_NodeNumbers {
    static int countNodes(AvlNode root){
        if (root==null)return 0;
        return 1+ countNodes(root.left)+ countNodes(root.right);
    }
    static int countLeaves(AvlNode root){
        if (root==null)return 0;
        if (root.left==null&&root.right==null)return 1;
        return countLeaves(root.left)+ countLeaves(root.right);
    }
    static int countFullNodes(AvlNode root){
        if (root==null)return 0;
        //if (root.left!=null&&root.right!=null)return 1;
        //当遇到一个满节点后不再递归，这是错误的，因为可能满节点的儿子也有可能是满节点，跟计算树叶有区别
        int tlsFull=(root.left!=null&&root.right!=null)?1:0;
        return tlsFull+countFullNodes(root.left)+ countFullNodes(root.right);
    }
}
