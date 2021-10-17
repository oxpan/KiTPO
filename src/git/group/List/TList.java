package git.group.List;


//Saive template list
public class TList<T>{
    private class Node<T>{
        public  Node<T> next;// указатель на следующий элемент
        public T data;

        public Node(){}
        public Node(T data){
            this.data = data;
            this.next = null;

        }
    }

    public Node<T> head = null;//nachalo
    public Node<T> tail = null;//endlist
    public int size = 0;
    public int size_limit = 20;

    public boolean addNode(T data) {//vstavka v end
        if (size < size_limit) {
            Node<T> nNode = new Node<>(data);

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

    public boolean addNodeIndex(T data, int index){//dobav po index
        if (size < size_limit) {
            Node<T> nNode = new Node<>(data);

            if (head == null) {
                head = nNode;
                tail = nNode;
            } else {
                Node<T> temp, current;
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

    public boolean dropNodeIndex(int index){
//        if (size <= 0)
//            return false;

        Node<T> temp,current;

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

    public T searchNodeIndex(int index){
        T dataNode;
        Node<T> current = head;

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

    public boolean showList(){
        Node<T> current = head;

        if (head == null){
            System.out.println("List is empty");
            return false;
        }

        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.printf("");
        return true;
    }

    public int countNodes(){//kolichestvo yzlov
        int count = 0;
        Node<T> current = head;

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
}
