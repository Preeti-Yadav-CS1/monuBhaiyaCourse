class LinkedList{
    private Node head;
    // private Node next;
    private Node tail;
    private int size;
    class Node{
        int data;
        public LinkedList.Node next;
        Node(int data){
            this.data= data;
            next= null;
        }
    }

    void addFrist(int item){
        Node curr= new Node(item);
        if(this.size==0){
            head=curr;
            tail=curr;
            size++;
        }else{
            curr.next=head;
            head=curr;
            size++;
        }
        
    }
    void addLast(int item){
        if(size==0){
            addFrist(item);
        }else{
            Node curr= new Node(item);
            tail.next=curr;
            tail=curr;
            size++;
        }
    }
    int length(){
        return size;
    }
    Node getNode(int k) throws Exception{
        if(k<0||k>=size){
            throw new Exception("size out of bound");
            // System.out.println("size out of bound");
            // return -1;
        }
        Node temp= head;
        for(int i=0;i<k-1;i++){
            temp= temp.next;
        }
        return temp;
    }

    void atIndex(int item,int k) throws Exception{
        if(k<0||k>=size){
            throw new Exception("size out of bound");
        }
        if(k==0){
            addFrist(item);
        }else if(size==k){
            addLast(item);
        }else{
            Node curr= new Node(item);
            Node temp=head;
            for(int i=1;i<k-1;i++){
                temp=temp.next;
            }
            Node nextElement= temp.next;
            temp.next= curr;
            curr.next= nextElement;
        }
    }
    int getFrist(){
        return head.data;
    }
    int getLast(){
        return tail.data;
    }
    int getElement(int k) throws Exception{
        // using loop
        // if(k==0){
        //     return getFrist();
        // }else if(k==size){
        //     return getLast();
        // }
        // Node temp= head;
        // for(int i=1;i<k;i++){
        //     temp= temp.next;
        // }
        // return temp.data;
        return getNode(k).data;
    }

    void removeFrist(){
        if(head==null){
            return;
        }
        head= head.next;
        size--;
    }
    void removeLast(){
        if(head==null){
            return;
        }
        Node temp= head;
        for(int i=0;i<size-1;i++){
            temp= temp.next;
        }
        temp.next=null;
        tail=temp;
    }
    void removeAt(int k){
        if(k==0){
            removeFrist();
        }else if(k==size){
            removeLast();
        }
        Node temp= head;
        for(int i=1;i<k-1;i++){
            temp= temp.next;
        }
        temp.next= temp.next.next;
    }
    public void display(){
        if(head==null){
            return;
        }
        Node temp= head;
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp= temp.next;
        }
        System.out.println("null");
    }
}

