public class LinkedList
{
    private Node head;

    public void setHead(Node head) { this.head = head; }

    public Node getHead() { return head; }

    public void addtoFront(int data){
        Node prevhead = head;
        head = new Node(data, prevhead);
    }

    public void insertNode(int data){
        Node temp = new Node(data, null);
        if(head == null){
            head = temp;
        } else{
            Node current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }

    public int size(){
        if(head == null){
            return 0;
        }
        int counter = 1;
        Node current = head;
        while(current.getNext() != null){
            counter++;
            current = current.getNext();
        }
        return counter;
    }
}
