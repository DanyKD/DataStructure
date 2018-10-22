package exercise;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LinkedListTest {

    @org.junit.Test(expected = NullPointerException.class)
    public void whenLinkedListIsEmpty() {
        LinkedList l = new LinkedList ();
        Object o=l.get(0);
        o.toString();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBand() {
        LinkedList l = new LinkedList ();
        l.add(1);
        Object o=l.get(2);
        o.toString();
    }
    @Test
    public void CorrectGet(){
        LinkedList l = new LinkedList ();
        l.add(1);
        int res=l.get(0);
        assertEquals(1,res );
    }
    @Test
    public void testCorrectAdd(){

        LinkedList l = new LinkedList ();
        l.add (1);
        assertEquals (1,l.get (0));
    }
    @Test
    public void testNullSize(){

        LinkedList l = new LinkedList ();
        assertEquals (0,l.size());
    }

    @Test
    public void testCorrectSize(){

        LinkedList l = new LinkedList ();
        l.add (1);
        l.add (2);
        l.add (3);
        assertEquals (3,l.size());
    }

    @Test
    public void testNullConcat(){
        LinkedList l = new LinkedList ();
        LinkedList l1 = new LinkedList ();
        assertEquals (null,l.concat(l));
    }

    @Test
    public void testNullFirstConcat(){
        LinkedList l = new LinkedList ();
        LinkedList l1 = new LinkedList ();
        l1.add(2);
        l1.add (3);
        l1.add (4);
        l.concat(l1);
        assertEquals (4,l.get (2));
    }

    @Test
    public void testCorrectConcat(){
        LinkedList l = new LinkedList ();
        LinkedList l1 = new LinkedList ();
        l.add (1);
        l1.add(2);
        l1.add (4);
        l1.add (3);
        l.concat(l1);
        assertEquals (4,l.get (2));
    }
    @Test
    public void testNullReverse(){
        LinkedList l = new LinkedList ();
        assertEquals (null, l.reverse ());
    }
    @Test
    public void testCorrectReverse(){
        LinkedList l = new LinkedList ();
        l.add (1);
        l.add (2);
        l.add (3);
        l.add (4);
        l.reverse ();
        assertEquals (4,l.get (0) );
    }


}
