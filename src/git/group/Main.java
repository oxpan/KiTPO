package git.group;
import git.group.Builder.Builder;
import git.group.Builder.BuilderString;
import git.group.Comparator.Comparator;
import git.group.Comparator.ComparatorString;
import git.group.List.TList;

import java.io.InputStreamReader;
import java.io.StringBufferInputStream;


public class Main {

    public static void main(String[] args) {
//	// write your code here
//    //  System.out.println("1");
//        TList<Integer> intlist = new TList<Integer>();
//        intlist.addNode(0);
//        intlist.addNode(1);
//        intlist.addNode(2);
//        intlist.addNode(3);
//        intlist.addNode(4);
//        System.out.println(intlist.addNode(9));
//        System.out.println(intlist.addNodeIndex(10,2));
//        System.out.println(intlist.addNodeIndex(10,1));
//        System.out.println(intlist.addNodeIndex(10,5));
//        intlist.showList();
//        System.out.printf("\nC: "+ intlist.countNodes());
//        System.out.println("\nSZ: "+ intlist.getSize());
//
//        intlist.dropNodeIndex(2);
//        intlist.dropNodeIndex(2);
//        intlist.dropNodeIndex(2);
//        intlist.dropNodeIndex(2);
//
//        intlist.showList();
//        System.out.printf("\nC: "+ intlist.countNodes());
//        System.out.println("\nSZ: "+ intlist.getSize());
//
//        System.out.println("dataind: " + intlist.searchNodeIndex(3));


//        Comparator comparator = new ComparatorString();
//
//        String str1 = "abrft";
//        String str2 = "cdeqw";
//
//        int res = comparator.compare(str1,str2);
//
//        System.out.println(res);
//
//
//        Builder b = new BuilderString();
//
//        Object obj = b.createObject();
//
//        String str = "test";
//        StringBufferInputStream stringBufferInputStream = new StringBufferInputStream(str);
//        InputStreamReader i = new InputStreamReader(stringBufferInputStream);
//
//        b.readObject(i);
        Builder builder = new BuilderString();
        TList list = new TList(builder);

        for (int i =0; i < 3; i++){
            list.pushFront(builder.createObject());
        }
        for (int i =0; i < 3; i++){
            list.delete(0);
        }

    }
}
