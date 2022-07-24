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

}
