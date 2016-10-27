package ListsStacksAndQueues;

/**
 * Created by hrong on 2016/10/27.
 */
public class E31_singleStack<AnyType> {
    private Node<AnyType> head;
    private class Node<AnyType>{
        Node<AnyType> next;
        AnyType data;

        public Node(Node<AnyType> next, AnyType data) {
            this.next = next;
            this.data = data;
        }
    }
    public E31_singleStack() {
        head=null;
    }
    public E31_singleStack(AnyType anyType) {
        push(anyType);
    }
    public void push(AnyType anyType){
        Node<AnyType> topNode=new Node<>(head,anyType);
        head=topNode;
    }
    public void pop(){
        head=head.next;
    }
    public AnyType top(){
        return head.data;
    }
}
