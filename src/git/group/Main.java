package git.group;
import git.group.Builder.Builder;
import git.group.Builder.BuilderInteger;
import git.group.Builder.BuilderString;
import git.group.Comparator.Comparator;
import git.group.Comparator.ComparatorInteger;
import git.group.Comparator.ComparatorString;
import git.group.List.TList;

import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.Arrays;


public class Main {

    public static void main(String[] args)
    {
        //<Тест  списка>
            int size = 8;
            Builder builder = new BuilderString();
            TList list = new TList(builder);

            for (int i =0; i < size; i++)
                list.pushFront(builder.createObject());

                list.add(builder.parseObject("test"),size / 2);
                int res = list.find(builder.parseObject("test"));
                list.delete(res);

                res = list.find(builder.parseObject("test"));

                //<sort>
                    //before
                        System.out.println("BEFORE");
                        for (int i=0;i<8;i++) System.out.println(list.find(i));

                    list.sort();

                    //after
                        System.out.println("AFTER");
                        for (int i=0;i<size;i++) System.out.println(list.find(i));
                //</sort>


            for (int i =0; i < size; i++)
                list.delete(0);
        //</Тест  списка>
        //<Тест comparator>
            Comparator comp = new ComparatorInteger();
            Integer x = new Integer(5);
            Integer y = new Integer(189);

            int retcode = comp.compare(x,y);
        //</Тест comparator>

        //<Тест Builder>
            Builder builder1 = new BuilderInteger();
            Integer testVal = (Integer) builder1.createObject();

            InputStreamReader in = new InputStreamReader(new StringBufferInputStream ("26767"));
            testVal = (Integer) builder1.readObject(in);

            testVal = (Integer) builder1.parseObject("7894566");

        //</Тест Builder>

        //<Тест списка Integer>
            list.setBuilder(builder1);

            for (int i =0; i < size; i++)
                list.pushFront(builder1.createObject());

                //<sort>
                    //before
                        System.out.println("BEFORE");
                        for (int i=0;i<8;i++) System.out.println(list.find(i));

                    list.sort();

                    //after
                        System.out.println("AFTER");
                        for (int i=0;i<size;i++) System.out.println(list.find(i));
                //</sort>

            for (int i =0; i < size; i++)
                list.delete(0);

        //</Тест списка Integer>


    }


}
