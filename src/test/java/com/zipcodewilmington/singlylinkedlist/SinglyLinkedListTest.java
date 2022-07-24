package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testAdd(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);

        Assert.assertTrue(node.add(9));
    }

    @Test
    public void testSize(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);
        int expected = 2;

        Assert.assertEquals(expected, node.size());
    }

    @Test
    public void testGet(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);
        int expected = 9;

        Assert.assertEquals(expected, node.get(1));
    }

    @Test
    public void testRemove(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);
        node.remove(1);
        int expected = node.size();
        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContains(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);
        boolean expected = true;

        Assert.assertEquals(expected, node.contains(9));
    }

    @Test
    public void testFind(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);
        int expected = 1;

        Assert.assertEquals(expected, node.find(9));
    }

    @Test
    public void testFind_FailureReturnMinusOne(){
        SinglyLinkedList node = new SinglyLinkedList();
        node.add(5);
        node.add(9);
        int expected = -1;

        Assert.assertEquals(expected, node.find(7));
    }




}
