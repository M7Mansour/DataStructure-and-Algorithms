
public class Lists {

    public static void main(String[] args) {
        MyValue student1 = new MyValue("Mohammad1" , 1 , 4.351);
        MyValue student2 = new MyValue("Mohammad2" , 2 , 4.352);
        MyValue student3 = new MyValue("Mohammad3" , 3 , 4.353);
        MyValue student4 = new MyValue("Mohammad4" , 4 , 4.354);
        MyValue student5 = new MyValue("Mohammad5" , 5 , 4.355);
        
        
        MyNodeList list = new MyNodeList();
        list.addToBack(student5);
        list.addToBack(student5);
        list.addToBack(student4);
        list.addToBack(student3);
        list.addToBack(student2);
        list.addToBack(student2);
        list.addToBack(student2);
        list.addToBack(student1);

        


        //list.sortInc();
        //list.insert(student3, 0);
        System.out.println(list.toString());
        
    }
    
}
class MyValue {
    private String name ;
    private int id ;
    private double GPA ;
    
    public MyValue(String name , int id , double GPA){
        this.name = name ;
        this.id = id ;
        this.GPA = GPA ;
    }

    public void setName(String name){
        this.name = name ;
    }
    public String getName(){
        return this.name;
    }
    
    public void setId(int id){
        this.id = id ;
    }
    public int getId(){
        return this.id;
    }
    
    public void setGPA(double GPA){
        this.GPA = GPA ;
    }
    public double getGPA(){
        return this.GPA;
    }
    
    @Override
    public String toString(){
        return ("Name : " + name + " , ID : " + id + " , GPA : " + GPA);
    }
}

class MyNode {
    private MyValue value;
    private MyNode next ;
    
    public MyNode(){
        
    }
    
    public MyNode (MyValue value){
        this.value = value ;
    }
    public void setValue(MyValue value){
        this.value = value ;
    }
    public MyValue getValue(){
        return this.value;
    }
    public void setNext(MyNode next){
        this.next = next ;
    }
    public MyNode getNext(){
        return this.next;
    }
    @Override
    public String toString(){
        return(value.toString() );
    }
    
}

class MyNodeList {
    private MyNode head ;
    private MyNode tail ;
    private int size ;
    
    public MyNodeList(){
        
    }
    
    public MyNode getHead(){
        return this.head;
    }

    public MyNode getNext(){
        return this.tail;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addToFront(MyValue addedNode){
        MyNode node = new MyNode(addedNode);
            node.setNext(head);
            head = node ;
            if(size == 0)
                tail = head ;
            size++;
    }
    
    public void addToBack(MyValue addedNode){
        if(size != 0){
            MyNode node = new MyNode(addedNode);
            tail.setNext(node);
            tail = node ;
            size++;
        }
        else addToFront(addedNode);
        
    }
    
    public void insert(MyValue addedNode,int index){
        if(index == 0)
            addToFront(addedNode);
        else if(index == size)
                addToBack(addedNode);
        else if(index > 0){
            MyNode node = new MyNode(addedNode);
            MyNode temp = get(index - 1);
            node.setNext(temp.getNext());
            temp.setNext(node);
            size++;
        }
    }
    
    public  void deleteNode(MyNode node) {
    if(node == null)
        return;
    if(node != head ){
        MyNode temp = head ;
        while(temp.getNext() != node)
            temp = temp.getNext();
        temp.setNext(node.getNext());
    }
    else head = node.getNext();
}
    
    public void reverse() {
    if(size <= 1)
        return ;
    MyNode temp = tail;
    MyNode prevTemp = get(0) ;
    for(int i = size - 2 ;i >= 0 ;i--){
        prevTemp = get(i);

        temp.setNext(prevTemp);
        temp = prevTemp;
    }
    prevTemp.setNext(null);
    head = tail;
    tail = prevTemp;
}
    
    public MyNode get(int index){
        if(size <= 0 || index >= size)
            return null;
        else {
            MyNode temp = head ;
            for (int i = 0; i < index; i++) 
                temp = temp.getNext();
            
            return temp;
        }
            
    }
    
    public void removeFront(){
        if(size > 1){
            head = head.getNext();
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
            tail = walk();
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
    
    public MyNode walk(){
        MyNode temp = head ;
        while(temp.getNext() != tail && size > 1)
            temp = temp.getNext();
        return temp ;
    }
    
    public void sortInc(){
        boolean cont = true ;
        MyNode temp = new MyNode();
        MyNode tempH = head;
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
    
    @Override 
    public String toString(){
        if(size == 0)
            return "The list is empty :)";
        String list = "";
        MyNode temp = head ;
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

class MyCircularlyNodeList {
    private MyNode tail ;
    private int size ;
    
    public MyCircularlyNodeList(){
        
    }

    public MyNode getNext(){
        return this.tail;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addToFront(MyValue addedNode){
        MyNode node = new MyNode(addedNode);
        if(size != 0){
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        else {
            tail = node;
            tail.setNext(tail);
        }
        size++;
        
    }
    
    public void addToBack(MyValue addedNode){
        MyNode node = new MyNode(addedNode);
        if(size != 0){
            node.setNext(tail.getNext());
            tail.setNext(node);
            tail = node ;
        }
        else {
            tail = node;
            tail.setNext(tail);
        }
        size++;
    }
    
    public void insert(MyValue addedNode,int index){
        if(index == 0)
            addToFront(addedNode);
        else if(index == size)
                addToBack(addedNode);
        else if(index > 0){
            MyNode node = new MyNode(addedNode);
            MyNode temp = get(index - 1);
            node.setNext(temp.getNext());
            temp.setNext(node);
            size++;
        }
    }
    
    public MyNode get(int index){
        if(size <= 0 || index >= size)
            return null;
        else {
            MyNode temp = tail.getNext() ;
            for (int i = 0; i < index; i++) 
                temp = temp.getNext();
            
            return temp;
        }
            
    }
    
    public void removeFront(){
        if(size > 1){
            tail.setNext(tail.getNext().getNext());
            size--;
        }
        else {
            tail = null;
            if(size != 0)
                size--;
        }
        
    }
    
    public void removeBack(){
        if(size > 1){
            MyNode temp = walk();
            temp.setNext(tail.getNext());
            tail = temp;
            size--;
        }
        else {
            tail = null;
            if(size != 0)
                size--;
        }
        
    }
    
    public void rotate(){
        if(tail != null)
            tail = tail.getNext();
    }
    
    public MyNode walk(){
        MyNode temp = tail.getNext() ;
        while(temp.getNext() != tail && size > 1)
            temp = temp.getNext();
        
        return temp ;
    }
    
    @Override 
    public String toString(){
        if(size == 0)
            return "The list is empty :)";
        String list = "";
        MyNode temp = tail.getNext() ;
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