package git.group.View;

import git.group.Builder.Builder;
import git.group.Builder.BuilderString;
import git.group.List.TList;

import java.util.Scanner;


public class ConsoleApp {
    Scanner in = new Scanner(System.in);

    private Builder builder;
    private TList list;

    private boolean flag_menu;
    private int switch_menu;
    private int tmp_index;


    public ConsoleApp()
    {
        this.builder = new BuilderString();
        list = new TList(builder);
        flag_menu = true;
    }

    public void run()
    {
        while (flag_menu)
        {
            ConsolMenu();
            System.out.print(">>");
            switch_menu = in.nextInt();
            switch (switch_menu) {
                case 1:
                    list.pushFront(builder.createObject());
                    break;
                case 2:
                    list.pushEnd(builder.createObject());
                    break;
                case 3:
                    System.out.println("Введите индек для добавления");
                    System.out.print(">>");
                    tmp_index = in.nextInt();
                    list.add(builder.createObject(),tmp_index);
                    break;
                case 4:
                    System.out.println("Введите индек для удаления");
                    System.out.print(">>");
                    tmp_index = in.nextInt();
                    list.delete(tmp_index);
                    break;
                case 5:
                    System.out.println("Введите индек для поиска элемента");
                    System.out.print(">>");
                    tmp_index = in.nextInt();
                    System.out.println("element: "+ list.find(tmp_index));
                    break;
                case 6:
                    list.sort();
                    break;
                case 7:
                    drawList();
                    break;
                case 8:
                    testDriweStringList();
                    break;
                case 0:
                    flag_menu = false;
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("ochepyatka");
                    break;
            }
        }

    }

    private void drawList()
    {

    }
    private void testDriweStringList()
    {
//        builder = new BuilderString();
        TList testlist = new TList(builder);


//        vasi ahuennii realizachii
        for (int i = 0; i < 30; i++){}

    }


    private void ConsolMenu()
    {
        System.out.println("----------------------------------");
        System.out.println("1 - Добавление элемента в начало списка");
        System.out.println("2 - Добавление элемента в конец списка");
        System.out.println("3 - Добавление элемента по индексу в список");
        System.out.println("4 - Удаление элемента по индексу из списка");
        System.out.println("5 - Поиск элемента по индексу");
        System.out.println("6 - Сортировка списка (quickSort)");
        System.out.println("7 - Вывод списока");
        System.out.println("8 - **testdrive** - StringList");
        System.out.println("0 - выхлд из ConsoleView");
        System.out.println("----------------------------------");
    }


}
