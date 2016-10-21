package introduction;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 * Created by hrong on 2016/10/21.
 */
public class E13_genericCollection {
    private int length;
    private Object[] objects;

    public E13_genericCollection(Object[] objects) {
        this.objects=objects;
        this.length=objects.length;
    }
    public boolean isEmpty(){
        if (length==0)return true;
        else return false;
    }
    public void makeEmpty(){
        for (int i = 0; i < length; i++) {
            objects[i]=null;
        }
    }
    public void insert(Object object,int index){
        Object[] newObjects=new Object[length+1];
        System.arraycopy(objects,0,newObjects,0,index);
        newObjects[index]=object;
        System.arraycopy(objects,index,newObjects,index+1,length-index);
    }
    public boolean isPresent(Object object){
        return equals(object);
    }
}
