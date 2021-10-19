package git.group;
import git.group.Builder.Builder;
import git.group.Builder.BuilderInteger;
import git.group.Builder.BuilderString;
import git.group.Comparator.Comparator;
import git.group.Comparator.ComparatorString;
import git.group.List.TList;
import git.group.View.ConsoleApp;

import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        ConsoleApp consoleApp = new ConsoleApp();
        while (flag == false) {
            System.out.println("Введите тип списка");
            flag = consoleApp.toBuilder(sc.nextLine());
        }
        consoleApp.run();



//        int size = 8;
//        Builder builder = new BuilderString();
//        TList list = new TList(builder);
//
//        for (int i =0; i < size; i++)
//            list.pushFront(builder.createObject());
//
//            list.add(builder.parseObject("test"),size / 2);
//            int res = list.find(builder.parseObject("test"));
//            list.delete(res);
//
//            res = list.find(builder.parseObject("test"));
//
//            //<sort>
//                //before
//                    System.out.println("BEFORE");
//                    for (int i=0;i<8;i++) System.out.println(list.find(i));
//
//                list.sort();
//
//                //after
//                    System.out.println("AFTER");
//                    for (int i=0;i<size;i++) System.out.println(list.find(i));
//            //</sort>
//
//
//        for (int i =0; i < size; i++)
//            list.delete(0);
    }



}
