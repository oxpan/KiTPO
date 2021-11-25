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
        sc.close();
    }
    private static void testSort()
    {
        int n = 150;
        int min = 100;
        int max = 20000;
        int step = (max-min)/100;



        BuilderInteger builder = new BuilderInteger();
        TList list1 = new TList(builder);
        TList list2 = new TList(builder);
        int[] sizes = new int[n];

        sizes[0] = min;
        for(int i=1;i<n;i++)
            sizes[i] = sizes[i-1] + step;

        long[] time_differences = new long[sizes.length];
        long[] time_optim = new long[sizes.length];
        for(int i=0;i<sizes.length;i++)
        {
            for(int j=0;j<sizes[i];j++)
            {
                Object elem =builder.createObject();
                list1.pushFront(elem);
                list2.pushFront(elem);
            }
            long nonOptimizedSort = System.currentTimeMillis();
            list1.sortOld();
            nonOptimizedSort = System.currentTimeMillis() - nonOptimizedSort;
            long optimizedSort = System.currentTimeMillis();
            list2.sort();
            optimizedSort = System.currentTimeMillis() - optimizedSort;
            time_optim[i] = optimizedSort;

            time_differences[i] = nonOptimizedSort - optimizedSort;

            list1.clear();
            list2.clear();
        }
        System.out.println("Функция разницы во времени между старой и новой сортировками");
        System.out.println("Ось X: (шт.)");
        System.out.println(Arrays.toString(sizes));
        System.out.println("Ось Y: (мс)");
        System.out.println(Arrays.toString(time_differences));
        System.out.println("Время работы потимизированной сортировки: (мс)");
        System.out.println(Arrays.toString(time_optim));
    }
}
