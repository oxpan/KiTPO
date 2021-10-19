package git.group.View;

import git.group.Builder.Builder;
import git.group.Builder.BuilderInteger;
import git.group.Builder.BuilderString;
import git.group.List.TList;

import java.io.*;
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
        flag_menu = true;
    }

    public boolean toBuilder(String name)
    {

        try {
            builder = settingBuilder(name);
        }catch (Exception e)
        {
            return false;
        }

        list = new TList(builder);
        return true;
    }

    private Builder settingBuilder(String name)throws Exception
    {
        if (name.equals(BuilderString.typename))
        {
//            builder = new BuilderString();
            return new BuilderString();

        }else if (name.equals(BuilderInteger.typename))
        {
//            builder = new BuilderInteger();
            return new BuilderInteger();
        } else
        {
//            System.out.println("OSHIBKA: нет такого типа");
            Exception e = new Exception("OSHIBKA: нет такого типа");
            throw e;

//            return false;
        }


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
                    System.out.println("Введите кол-во лементов");
                    int elem = in.nextInt();

                    testDriweStringList(elem);
                    break;
                case 9:
                    list.clear();
                    break;
                case 10:
                    System.out.println("Введите тип списка ");
                    try
                    {
                        Builder old = settingBuilder(builder.getName());
                        builder = settingBuilder(in.next());
                        if(!list.setBuilder(builder))
                        {
                            System.out.println("Список не пустой. Очистите его перед сменой типа.");
                            builder = old;
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getCause());
                    }
                    break;

                case 11:
                    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.bin")))
                    {

                        out.writeObject(list);
                        System.out.println("Успешная запись");
                    }
                    catch(Exception e) {System.out.println("Ошибка записи");}

                    break;

                case 12:
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("list.bin")))
                    {
                        TList loaded = (TList) in.readObject();
                        builder = settingBuilder(loaded.getBuilder().getName());
                        list = loaded;
                        System.out.println("Успешное чтение");
                    }
                    catch(Exception e) {e.printStackTrace(); System.out.println("Ошибка чтения");}
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
        list.forEach((name)->{
            System.out.println(name);
        });
    }
    private void drawList(TList otherlist)
    {
        otherlist.forEach((name)->{
            System.out.println(name);
        });
    }


    private void testDriweStringList(int maxElement)
    {

        TList testlist = new TList(builder);



        for (int i = 0; i < maxElement; i++)
            testlist.pushEnd(builder.createObject());
        System.out.println("\n\nСгенерированый список");
        drawList(testlist);

        System.out.println("\n\nПоиск каждого четвертого елемента");
        for (int i = 0; i < maxElement; i = i + 4)
        {
            System.out.println(testlist.find(i));
        }

        System.out.println("\n\nПроиизошла сортировка");
        testlist.sort();
        drawList(testlist);

        testlist.clear();

        System.out.println("Список удален");

    }


    private void ConsolMenu()
    {
        System.out.println("----------------------------------");
        System.out.println("1 - Добавить в начало списка");
        System.out.println("2 - Добавить в конец списка");
        System.out.println("3 - Добавить по индексу в список");
        System.out.println("4 - Удалить по индексу из списка");
        System.out.println("5 - Поиск по индексу");
        System.out.println("6 - Сортировка списка (quickSort)");
        System.out.println("7 - Вывод списка");
        System.out.println("8 - **testdrive** ");
        System.out.println("9 - Очистить список");
        System.out.println("10 - Изменить тип списка");
        System.out.println("11 - Записать в файл список");
        System.out.println("12 - Прочитать из файла список");
        System.out.println("0 - Выйти");
        System.out.println("----------------------------------");
    }


}
