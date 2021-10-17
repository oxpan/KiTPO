package git.group.List;


import git.group.Builder.Builder;
import git.group.Comparator.Comparator;

//Saive template list
public class TList{
    private class Node{
        public  Node next;// указатель на следующий элемент
        public Object data;

        public Node(){}
        public Node(Object data){
            this.data = data;
            this.next = null;

        }
    }



    private Node head;// //nachalo
    private Node tail;// //endlist
    private int size;//
    private int size_limit;//
    Builder builder;
    Comparator comparator;




    public TList(Builder builder)
    {
        this.builder = builder;
        this.comparator = builder.getComparator();
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.size_limit = 20;
    }

    public boolean pushFront(Object obj){// vstavka v front
        if(size < size_limit){
            Node nNode = new Node(obj);

            if(head == null){
                head = nNode;
                tail = nNode;
            }
            else{
                Node temp = head;
                head = nNode;
                head.next = temp;
            }
            size++;
            return true;
        }
        return  false;
    }

    public boolean pushEnd(Object data) {//vstavka v end
        if (size < size_limit) {
            Node nNode = new Node(data);

            if (head == null) {
                head = nNode;
                tail = nNode;
            } else {
                tail.next = nNode;//sleduuwii na tekuwii
                tail = nNode;//tekuwii
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean add(Object data, int index){//dobav po index
        if (size < size_limit) {
            Node nNode = new Node(data);

            if (head == null) {
                head = nNode;
                tail = nNode;
            } else {
                Node temp, current;
                temp = head;
                current = null;

                for (int i = 0; i < index; i++) {
                    current = temp;
                    temp = temp.next;
                }

                current.next = nNode;
                nNode.next = temp;
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean delete(int index){
        //if (size < 0)
//            return false;

        Node temp,current;

        if (head == null){
            System.out.println("List is empty");
            return false;
        }else {
            if (head != tail){
                temp = head;
                current = null;

                for (int i = 0; i < index;i++){
                    current = temp;
                    temp = temp.next;
                }
                if (current != null){
                    current.next = temp.next;
                    temp = null;
                }else {
                    head = tail = temp.next;
                    temp = null;
                }
            }else {
                head = tail = null;
            }
        }
        size--;
        return true;
    }

    public Object find(int index){
        Object dataNode;
        Node current = head;

        if (index == 0){
            dataNode = current.data;
            return dataNode;
        }

        for (int i = 0; i < index; i++){
            current = current.next;
        }

        dataNode = current.data;

        return dataNode;
    }
    public int find(Object obj){
        Node current = head;
        int index = 0;

        if (head == null){
            //throw exception("No List");
            return -15;
        }
        else {
            while (current != null){
                if(current.data == obj){
                    return index;
                }
                index++;
                current = current.next;
            }
        }
        return  -1;
    }

    public boolean showList(){
        Node current = head;

        if (head == null){
            System.out.println("List is empty");
            return false;
        }

        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("");
        return true;
    }

    private int countNodes(){//kolichestvo yzlov
        int count = 0;
        Node current = head;

        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    ///zona getersSeters--------
    public int getSize(){
        return this.size;
    }
    public int getSize_limit(){return this.size_limit;}
    public boolean setSize_limit(int limit){
        if (limit <= 0 || limit <= size)
            return false;

        this.size_limit = limit;
        return true;
    }


    public boolean sort(){//sorting
        if(head == null)
            return  false;


        return false;
        ///netupaya sort
    }

}
