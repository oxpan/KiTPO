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
}
