
public class DoublyList {

   
    public static void main(String[] args) {
        MyValue student1 = new MyValue("Mohammad1" , 1201806061 , 4.351);
        MyValue student2 = new MyValue("Mohammad2" , 1201806062 , 4.352);
        MyValue student3 = new MyValue("Mohammad3" , 1201806063 , 4.353);
        MyValue student4 = new MyValue("Mohammad4" , 1201806064 , 4.354);
        MyValue student5 = new MyValue("Mohammad5" , 1201806065 , 4.355);
        
        
        MyDoubleNodeList list = new MyDoubleNodeList();
        list.addToFront(student2);
        list.addToBack(student3);
        list.addToBack(student4);
        list.addToFront(student1);
        list.addToBack(student5);
        
        list.removeBack();
        list.removeBack();
        list.removeBack();
        list.removeFront();
        list.removeBack();
        list.removeBack();
        list.removeBack();
        list.removeBack();
        
        list.addToFront(student2);
        list.addToBack(student3);
        list.addToBack(student4);
        list.addToFront(student1);
        list.addToBack(student5);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(7));
        System.out.println(list.get(8));
        System.out.println(list.get(9));
        list.removeFront();
        list.removeFront();
        list.removeFront();
        list.removeFront();
        list.removeFront();
        list.removeFront();
        list.addToBack(student5);
        list.addToBack(student5);
        list.addToBack(student4);
        list.addToBack(student3);
        list.addToBack(student2);
        list.addToBack(student2);
        list.addToBack(student2);
        list.addToBack(student1);
        list.addToBack(student1);
        list.insert(student3, 3);
        list.sortInc();
        list.insert(student3, 3);
        
        
        
        
        System.out.println(list.toString());
    }
    
}



class MyDoubleNode {
    private MyValue value;
    private MyDoubleNode next ;
    private MyDoubleNode prev;
    
    public MyDoubleNode(){
        
    }
    public MyDoubleNode (MyValue value){
        this.value = value ;
    }
    public void setValue(MyValue value){
        this.value = value ;
    }
    public MyValue getValue(){
        return this.value;
    }
    public void setNext(MyDoubleNode next){
        this.next = next ;
    }
    public MyDoubleNode getNext(){
        return this.next;
    }
    public void setPrev(MyDoubleNode prev){
        this.prev = prev ;
    }
    public MyDoubleNode getPrev(){
        return this.prev;
    }
    @Override
    public String toString(){
        return(value.toString());
    }
    
}

class MyDoubleNodeList {
    private MyDoubleNode head ;
    private MyDoubleNode tail ;
    private int size ;
    
    public MyDoubleNodeList(){
        
    }
    
    public MyDoubleNode getHead(){
        return this.head;
    }

    public MyDoubleNode getNext(){
        return this.tail;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addToFront(MyValue addedNode){
        MyDoubleNode node = new MyDoubleNode(addedNode);
            node.setNext(head);
            if(size != 0)
                head.setPrev(node);
            head = node ;
            if(size == 0)
                tail = head ;
            size++;
    }
    
    public void addToBack(MyValue addedNode){
        MyDoubleNode node = new MyDoubleNode(addedNode);
        if(size != 0){
            tail.setNext(node);
            node.setPrev(tail);
            tail = node ;
        }
        else addToFront(addedNode);
        size++;
    }
    
    public void sortInc(){
        boolean cont = true ;
        MyDoubleNode temp = new MyDoubleNode();
        MyDoubleNode tempH = head;
        while(cont){
            cont = false;
            while(tempH != tail){
                if(tempH.getValue().getId() > tempH.getNext().getValue().getId() && size > 1){
                    temp.setValue(tempH.getValue());
                    tempH.setValue(tempH.getNext().getValue());
                    tempH.getNext().setValue(temp.getValue());
                    cont = true ;
                }
                tempH = tempH.getNext();
            }
            tempH = head;
        }
    }
    
    public void insert(MyValue addedNode,int index){
        if(index == 0)
            addToFront(addedNode);
        else if(index == size)
                addToBack(addedNode);
        else if(index > 0){
            MyDoubleNode node = new MyDoubleNode(addedNode);
            MyDoubleNode temp = get(index - 1);
            node.setNext(temp.getNext());
            node.setPrev(temp);
            temp.setNext(node);
            node.getNext().setPrev(node);
            size++;
        }
    }
    
    public MyDoubleNode get(int index){
        if(size <= 0 || index >= size)
            return null;
        else {
            MyDoubleNode temp = head ;
            for (int i = 0; i < index; i++) 
                temp = temp.getNext();
            
            return temp;
        }
            
    }
    
    public void removeFront(){
        if(size > 1){
            head = head.getNext();
            head.getPrev().setNext(null);
            head.setPrev(null);
            size--;
        }
        else {
            head = null;
            tail = null;
            if(size != 0)
                size--;
        }
        
    }
    
    public void removeBack(){
        if(size > 1){
            tail = tail.getPrev();
            tail.getNext().setPrev(null);
            tail.setNext(null);
            size--;
        }
        else {
            head = null;
            tail = null;
            if(size != 0)
                size--;
        }
        
    }
    
    @Override 
    public String toString(){
        if(size == 0)
            return "The list is empty :)";
        String list = "";
        MyDoubleNode temp = head ;
        while((temp != tail && temp != null)){
            list += temp.getValue().toString() + " | \n";
            temp = temp.getNext();
        }
        list += tail.getValue().toString() + " \n";
        return list ;
    }
    
    public boolean isEmpty(){
        return size == 0 ;
    }
}