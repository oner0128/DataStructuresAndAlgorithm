package trees;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hrong on 2016/11/17.
 */
public class E10_directory {
    List<String> dirs=new ArrayList<>();
    List<String> files=new ArrayList<>();
    public E10_directory(String path) {
        File dir=new File(path);
        find(dir);
    }
    private void find(File file){
        if (file.isDirectory()){
            dirs.add(file.getName());
            for (File f :file.listFiles()){
                find(f);
            }
        }else {files.add(file.getName());}
    }
    public void print(){
        System.out.println("----dir------");
        System.out.println(dirs);
        System.out.println("----file-----");
        System.out.println(files);
    }

    public static void main(String[] args) {
        E10_directory directory=new E10_directory("C:\\Users\\hrong\\Desktop\\周界");
        directory.print();
    }
}
