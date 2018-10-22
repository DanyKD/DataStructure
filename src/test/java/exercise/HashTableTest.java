package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HashTableTest {

    @Test
    public void testPutAndGet() {
        HashTable ht = new HashTable ();
        ht.put("kth", 16);
        int res = (int) ht.get("kth");
        assertEquals(16, res);
    }
    @Test
    public void testNullValue(){
        HashTable ht = new HashTable ();
        ht.put("kth",null);
        Object res = ht.get("kth");
        assertEquals(null,res );

    }

    @Test (expected = NullPointerException.class)
    public void testNullKey(){
        HashTable ht = new HashTable ();
        ht.put(null,5);
        Object res = ht.get(null);
        res.toString ();
    }
    @Test
    public void testUniqueKey() {
        HashTable ht = new HashTable ();
        ht.put("kth", 16);
        ht.put("kth", 15);
        int res = (int) ht.get("kth");
        assertEquals(15, res);
    }
}
