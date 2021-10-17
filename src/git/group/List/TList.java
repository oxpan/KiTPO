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

    public boolean delete(int index)
    {
        if (size < 0) return false;

        Node toDel,toDelPrev;

        if (head == null)
        {
            System.out.println("List is empty");
            return false;
        }
        else
        {
            if (head != tail)
            {
                toDel = head;
                toDelPrev = null;

                //поиск ноды по ид
                for (int i = 0; i < index; i++)
                {
                    toDelPrev = toDel;
                    toDel = toDel.next;
                }

                if (toDelPrev != null)
                {
                    toDelPrev.next = toDel.next;
                    toDel = null;
                }
                //Попали в голову
                else
                {
                    head = toDel.next;
                    toDel = null;
                }
            }
            else
            {
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


    public boolean sort()
    {
        quickSort(0,size-1);

        return true;
    }

    private Node findNode(int id)
    {
        //Ищем ноду б
        Node res = head;
        for (int i = 0; i < id; i++){
            res = res.next;
        }
        return res;
    }

    public void swap (int q, int z)
    {
        //q должно быть обязательно меньше z
        //Если это условие нарушается, то делаем обмен индексов
        if (q>z)
        {
            int buf = q;
            q=z;
            z=buf;
        }


        //Ищем ноду q
        Node nq = findNode(q);

        //Ищем ноду z
        Node nz = findNode(z);

        Node buf;

        Node nqPrev = findNode(q-1);
        Node nzPrev = findNode(z-1);

        if(z-q ==1) buf = nq;
        else  buf = nq.next;

        nq.next = nz.next;
        nz.next = buf;

        if(q>0)
        {
            nqPrev.next=nz;
        }

        if(z-q >1) nzPrev.next = nq;

        if(q==0) head = nz;
    }

    private void quickSort(int low, int high) {
        if (size == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Object opora = find(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(find(i),opora)==-1) {
                i++;
            }

            while (comparator.compare(find(j),opora)==1) {
                j--;
            }

            if (i <= j)
            {
                //меняем местами
                swap(i,j);

                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }

}
