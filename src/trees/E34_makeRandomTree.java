package trees;

import java.util.Random;

/**
 * Created by hrong on 2016/11/20.
 */
public class E34_makeRandomTree {
    static Random random=new Random();
    static BinaryNode makeRandomTree(int start,int end){
        BinaryNode t=null;
        int randomValue=randInt(start,end);
        if (start<=end){
            t=new BinaryNode(makeRandomTree(start,randomValue-1),makeRandomTree(randomValue+1,end),randomValue);
        }
        return t;
    }
    static int randInt(int lower,int upper){
        return lower+random.nextInt(upper-lower);
    }

    public static void main(String[] args) {
        while (true)
        System.out.println(randInt(100,105));
    }
}
