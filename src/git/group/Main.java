package git.group;
import git.group.List.TList;


public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println("1");
        TList<Integer> intlist = new TList<Integer>();
        intlist.addNode(0);
        intlist.addNode(1);
        intlist.addNode(2);
        intlist.addNode(3);
        intlist.addNode(4);
        System.out.println(intlist.addNode(9));
        System.out.println(intlist.addNodeIndex(10,2));
        System.out.println(intlist.addNodeIndex(10,1));
        System.out.println(intlist.addNodeIndex(10,5));
        intlist.showList();
        System.out.printf("\nC: "+ intlist.countNodes());
        System.out.println("\nSZ: "+ intlist.getSize());

        intlist.dropNodeIndex(2);
        intlist.dropNodeIndex(2);
        intlist.dropNodeIndex(2);
        intlist.dropNodeIndex(2);

        intlist.showList();
        System.out.printf("\nC: "+ intlist.countNodes());
        System.out.println("\nSZ: "+ intlist.getSize());

        System.out.println("dataind: " + intlist.searchNodeIndex(3));
    }
}
