package ru.spbstu.telematics.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedListTest {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        linkedList.clear();
    }

    @Test
    public void sizeTest() {
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Assert.assertTrue(linkedList.size()==mylinkedList.size());
    }

    @Test
    public void isEmptyTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Assert.assertEquals(linkedList.isEmpty(),mylinkedList.isEmpty());
        mylinkedList.clear();
        linkedList.clear();
        Assert.assertEquals(linkedList.isEmpty(),mylinkedList.isEmpty());
    }

    @Test
    public void containsTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Assert.assertEquals(linkedList.contains(2),mylinkedList.contains(2));
        Assert.assertEquals(linkedList.contains(5),mylinkedList.contains(5));
    }

    @Test
    public void iteratorTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        linkedList.add(1);
        mylinkedList.add(151);
        linkedList.add(151);
        ListIterator<Integer> javaIterator = (ListIterator<Integer>) linkedList.iterator();
        ListIterator myIterator = (ListIterator) mylinkedList.iterator();
        Assert.assertTrue(myIterator.hasNext());
        Assert.assertEquals(javaIterator.next(), myIterator.next());
        Assert.assertTrue(myIterator.hasNext());
        Assert.assertEquals(javaIterator.next(), myIterator.next());
        Assert.assertFalse(myIterator.hasNext());
    }

    @Test
    public void toArrayTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Assert.assertArrayEquals(mylinkedList.toArray(),linkedList.toArray());
    }

    @Test
    public void toArrayIntoCollectionTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Integer[] list1 = new Integer[101];
        Integer[] list2 = new Integer[101];
        linkedList.toArray(list1);
        mylinkedList.toArray(list2);
        Assert.assertArrayEquals(list1,list2);
    }

    @Test
    public void addTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        for(int i=0;i<mylinkedList.size();i++){
            Assert.assertEquals(linkedList.get(i),mylinkedList.toArray()[i]);
        }
    }

    @Test
    public void removeTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        mylinkedList.remove(new Integer(3));
        linkedList.remove(new Integer(3));
        mylinkedList.remove(new Integer(5));
        linkedList.remove(new Integer(5));
        Assert.assertArrayEquals(mylinkedList.toArray(),linkedList.toArray());
    }

    @Test
    public void containsAllTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        Integer[] list1 = new Integer[3];
        Integer[] list2 = new Integer[3];
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        for(int i=0;i<3;i++){
            list1[i]=i+1;
            list2[i]=3-i;
        }
        Assert.assertTrue(mylinkedList.containsAll(Arrays.asList(list1))==linkedList.containsAll(Arrays.asList(list1)));
        Assert.assertTrue(mylinkedList.containsAll(Arrays.asList(list2))==linkedList.containsAll(Arrays.asList(list2)));
    }

    @Test
    public void addAllTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+1;
        }
        mylinkedList.addAll(Arrays.asList(list1));
        linkedList.addAll(Arrays.asList(list1));
        Assert.assertArrayEquals(linkedList.toArray(),mylinkedList.toArray());
    }

    @Test
    public void addAllPosTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+1;
        }
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        mylinkedList.addAll(1,Arrays.asList(list1));
        linkedList.addAll(1,Arrays.asList(list1));
        Assert.assertArrayEquals(linkedList.toArray(),mylinkedList.toArray());
    }

    @Test
    public void removeAllTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+1;
        }
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        mylinkedList.add(4);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        mylinkedList.removeAll(Arrays.asList(list1));
        linkedList.removeAll(Arrays.asList(list1));
        Assert.assertArrayEquals(linkedList.toArray(),mylinkedList.toArray());
    }

    @Test
    public void retainAllTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        Object[] myArray = linkedList.toArray();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        mylinkedList.add(4);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+2;
        }
        linkedList.retainAll(Arrays.asList(list1));
        mylinkedList.retainAll(Arrays.asList(list1));
        Assert.assertArrayEquals(linkedList.toArray(),mylinkedList.toArray());
    }


    @Test
    public void clearTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        Object[] myArray = linkedList.toArray();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.clear();
        mylinkedList.clear();
        Assert.assertEquals(linkedList.size(),mylinkedList.size());
    }

    @Test
    public void getTest(){
        MyLinkedList mylinkedList=new MyLinkedList();
        mylinkedList.add(1);
        mylinkedList.add(3);
        mylinkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Assert.assertEquals(mylinkedList.get(2),linkedList.get(2));
    }


}
