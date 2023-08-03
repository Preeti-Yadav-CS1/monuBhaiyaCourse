public class LinkedList_client{
    public static void main(String[] args) throws Exception {
        LinkedList ll= new LinkedList();
        // ll.addFrist(1);
        // ll.addFrist(2);
        // ll.addFrist(3);
        // ll.addFrist(4);
        // ll.display();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.display();
        int size= ll.length();
        System.out.println(size);
        LinkedList.Node d= ll.getNode(2);
        System.out.println(d);
        ll.atIndex(7, 2);
        ll.display();
        int x= ll.getElement(2);
        System.out.println(x);
        // ll.removeFrist();
        // ll.display();
        // ll.removeLast();
        // ll.display();
        ll.removeAt(2);
        ll.display();

    }
}