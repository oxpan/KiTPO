package git.group.List;
import git.group.Builder.Builder;
import git.group.Comparator.Comparator;

import java.io.Serializable;


public class TList implements Serializable
{
    private class Node implements Serializable
    {
        public Node next;
        public Object data;

        public Node(){}
        public Node(Object data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private Builder builder;
    private Comparator comparator;

    public TList(Builder builder)
    {
        this.builder = builder;
        this.comparator = builder.getComparator();
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean clear()
    {
        if (head == null)
            return false;

        while (head != null) delete(0);

        return true;
    }

    public boolean pushFront(Object obj){// vstavka v front

        Node nNode = new Node(obj);

        if(head == null)
        {
            head = nNode;
            tail = nNode;
        }
        else
        {
            Node temp = head;
            head = nNode;
            head.next = temp;
        }
        size++;
        return true;
    }

    public boolean pushEnd(Object data)
    {
        Node nNode = new Node(data);

        if (head == null) {
            head = nNode;
            tail = nNode;
        }
        else
        {
            tail.next = nNode;
            tail = tail.next;
        }
        size++;
        return true;
    }

    private void pushEnd(TList toInsert)
    {
        if(toInsert!=null)
        {
            tail.next=toInsert.head;
            tail = toInsert.tail;
            size += toInsert.size;
        }
    }

    public boolean add(Object data, int index)
    {
        Node nNode = new Node(data);

        if (head == null)
        {
            head = nNode;
            tail = nNode;
        }
        else
        {
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

    public boolean delete(int index)
    {
        if (size < 0 || index<0) return false;

        Node toDel,toDelPrev = null;

        if (head == null)
        {
            System.out.println("List is empty");
            return false;
        }
        else
        {
            if (head != tail)
            {
                //?????????? ???????? ?? ???? ??????????????????????????????
                if(index>0)
                {
                    toDelPrev = findNode(index-1);
                    toDel = toDelPrev.next;
                }
                else toDel = head;

                if (toDelPrev != null)
                {
                    toDelPrev.next = toDel.next;
                    toDel = null;
                }
                //???????????? ?? ????????????
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

    public Object find(int index)
    {
        Object dataNode;
        Node current = head;

        if (index == 0)
        {
            dataNode = current.data;
            return dataNode;
        }

        for (int i = 0; i < index; i++) current = current.next;
        dataNode = current.data;
        return dataNode;
    }

    public int find(Object obj)
    {
        Node current = head;
        int index = 0;

        if (head == null)
            return -1;
        else
        {
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

    public void forEach(DoIt func)
    {
        if (head == null)
            return;
        Node cur = head;

        for(int i=0;i<size;i++)
        {
            func.doIt(cur.data);
            cur = cur.next;
        }
    }

    public void sortOld()
    {
        quickSort(0,size-1);
    }

    public boolean sort()
    {
        TList r = quicksort(this);
        this.head = r.head;
        this.tail = r.tail;
        return true;
    }

    private void swap (int q, int z)
    {
        //q ???????????? ???????? ?????????????????????? ???????????? z
        //???????? ?????? ?????????????? ????????????????????, ???? ???????????? ?????????? ????????????????
        if (q==z) return;
        else if (q>z)
        {
            int buf = q;
            q=z;
            z=buf;
        }
        Node nqPrev, nq;
        //???????? ???????? z
        Node nzPrev = findNode(z-1);
        Node nz = nzPrev.next;
        //???????? ???????? q
        if(q>0)
        {
            nqPrev = findNode(q-1);
            nq = nqPrev.next;
            nqPrev.next=nz;
        }
        else nq = findNode(q);
        Node buf;
        if(z-q ==1) buf = nq;
        else  buf = nq.next;
        nq.next = nz.next;
        nz.next = buf;
        if(z-q >1) nzPrev.next = nq;
        //???????? ???????????????????????? ???????????? ?????? ?????????????????? ????????????????
        if(q==0) head = nz;
        if(z==size-1) tail = nq;
    }

    private void quickSort(int low, int high) {

        if (size == 0)  return;

        if (low >= high) return;

        // ?????????????? ??????????????
        int middle = low + (high - low) / 2;
        Object opora = find(middle);

        // ?????????????? ???? ???? ?????? ????????????????????????
        int i = low, j = high;
        while (i <= j)
        {
            while (comparator.compare(find(i),opora)==-1) i++;

            while (comparator.compare(find(j),opora)==1) j--;

            if (i <= j)
            {
                swap(i,j);
                i++;
                j--;
            }
        }
        // ?????????????????????? ???????????????????? ???????????? ?? ?????????????? ??????????????????????
        if (low < j) quickSort(low, j);
        if (high > i) quickSort(i, high);
    }

    private TList quicksort(TList list)
    {
        if(list == null)
            return list;
        Node head_ = list.head;
        Node it = head_.next;
        if(it==null)
            return list;
        TList lesser = null;
        TList greater = null;
        while(it != null)
        {
            int comp =comparator.compare(it.data,head_.data);
            if(comp<0 || comp ==0)
            {
                if(lesser==null)
                    lesser = new TList(builder);
                lesser.pushEnd(it.data);
            }
            else
            {
                if(greater==null)
                    greater = new TList(builder);
                greater.pushEnd(it.data);
            }
            it = it.next;
        }

        lesser = quicksort(lesser);
        greater = quicksort(greater);

        TList buf = new TList(builder);
        buf.pushEnd(head_.data);
        buf.pushEnd(greater);
        if(lesser==null)
            return buf;
        lesser.pushEnd(buf);
        return lesser;
    }

    private Node findNode(int id)
    {
        Node res = head;
        for (int i = 0; i < id; i++) res = res.next;
        return res;
    }

    //GET
    //SET
    public int getSize(){ return this.size; }

    public Builder getBuilder() { return builder; }

    public boolean setBuilder(Builder builder)
    {
        if(size == 0)
        {
            this.builder = builder;
            this.comparator = builder.getComparator();
            return true;
        }
        return false;
    };
}
