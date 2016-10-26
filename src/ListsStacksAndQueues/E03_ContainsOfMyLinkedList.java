package ListsStacksAndQueues;

/**
 * Created by hrong on 2016/10/24.
 */
public class E03_ContainsOfMyLinkedList<AnyType> {
    private static class Node<AnyType> {
        AnyType data;
        Node next;
        Node prev;

        public Node( AnyType data,Node<AnyType> pre, Node<AnyType> next) {
            this.prev = pre;
            this.data = data;
            this.next = next;
        }
    }
    Node<AnyType> beginer, end;
    int theSize = 0;
    //自己写的
    public <AnyType> boolean  contains(AnyType anyType) {
        Node<AnyType> node = beginer.next;
        for (int i = 0; i < theSize; i++) {
            if (anyType.equals(node.data)) return true;
            node = node.next;
        }
        return false;
    }
    //答案，利用while中的判断语句令节点不断推进，在最后返回时判断
    public <AnyType> boolean  contains2(AnyType anyType) {
        Node<AnyType> node = beginer.next;
        while (node!=end&&!node.data.equals(anyType)){
            node = node.next;
        }
        return node!=end;
    }
}
