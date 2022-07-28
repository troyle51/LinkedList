package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    private Node head;
    private static int counter;

    //Inner Node Class
    private class Node {
        Object data;
        Node next;

        //Constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }
        public Object getData(){
            return data;
        }
        public void setData(Object dataValue){
            data = dataValue;
        }
        //get next data aka the tail of node
        public Node getNext(){
            return next;
        }

        public void setNext(Node nextValue){
            next = nextValue;
        }
    }

    private static int getCounter(){
        return counter;
    }
    private static void incrementCounter(){
        counter++;
    }
    private void decrementCounter(){
        counter--;
    }


    public boolean add(Object data){

        boolean valueAdded = false;

        if(head == null){
            head = new Node(data);
            valueAdded = true;
        }
        Node temp = new Node(data);
        Node current = head;

        if(current != null){
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
            valueAdded = true;
        }
        incrementCounter();
        return valueAdded;
    }

    public int size(){
        return getCounter();
    }

    public Object get(int index){
        if (index < 0) {
            return null;
        }
        Node current = null;
        if(head != null){
            current = head.getNext();
            for (int i = 0; i < index; i++){
                if(current.getNext() == null)
                    return null;
                    current = current.getNext();

            }
            return current.getData();
        }
        return current;
    }

    public boolean remove(int index){
        if(index < 1 || index > size()){
            return false;
        }
        Node current = head;
        if(head != null){
            for(int i = 0; i < index; i++){
                if(current.getNext() == null)
                    return false;
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            decrementCounter();
            return true;
        }
        return false;
    }

    public boolean contains(Object value){
        for (int i = 0; i < size(); i++){
            if(get(i) == value){
                return true;
            }
        }
        return false;
    }

    public int find(Object value){
        for (int i = 0; i < size(); i++){
            if(get(i) == value){
                int index = i;
                return index;
            }
        }
        return -1;
    }

    public void sort(){
        Node current = head, index = null;

        Object temp;
        if(head == null){
            return;
        } else {
            while (current != null){
                index = current.next;
                while(index != null){
                    if((Integer)current.data > (Integer)index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public SinglyLinkedList copy(){
        SinglyLinkedList copy = new SinglyLinkedList();

        Node p, nodeBefore;
        copy.head = new Node(head.data, null);
        p = head.next;
        nodeBefore = copy.head;

        while(p != null){
            nodeBefore.next = new Node(p.data, null);
            nodeBefore = nodeBefore.next;
            p = p.next;
        }
        return copy;
    }

    public void display(){
        Node current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
