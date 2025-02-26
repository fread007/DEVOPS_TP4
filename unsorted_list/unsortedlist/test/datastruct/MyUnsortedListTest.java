package datastruct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MyUnsortedListTest {

    @Test
    void testIsEmpty() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue(list.isEmpty(),"Empty list should be empty");
    }

    @Test
    void testIsEmpty2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertFalse(list.isEmpty(),"Non-empty list should not be empty");
    }



    @Test
    void testSize() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals(0, list.size());
    }

    @Test
    void testSize2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals(3, list.size(),"Size of list of 3 elements");
    }

    @Test
    void testEquals() {
        MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3);
        assertEquals(list1, list2,"Lists with the same elements should be equal");
    }

    @Test
    void testEquals2() {
        MyUnsortedList<Integer> list1 = MyUnsortedList.of();
        MyUnsortedList<Integer> list2 = MyUnsortedList.of();
        assertEquals(list1, list2,"Empty lists should be equal");
    }

    @Test
    void testEquals3() {
        MyUnsortedList<Integer> list1 = MyUnsortedList.of();
        assertNotEquals(list1, new Object(), "List should not be equal to an object of a different type");
    }

    @Test
    void testEquals4() {
        MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 4);
        assertNotEquals(list1, list2,"Lists with different elements should not be equal");
    }

    @Test
    void testEquals5() {
        MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2);
        assertNotEquals(list1, list2,"Lists with different sizes should not be equal");
    }

    @Test
    void testEquals6() {
        MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3, 4);
        assertNotEquals(list1, list2,"Lists with different sizes should not be equal");
    }

    @Test
    void testPrepend() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        list.prepend(0);
        assertEquals(MyUnsortedList.of(0, 1, 2, 3), list,"Prepend should add an element to the front of the list");
    }

    @Test
    void testPrepend2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.prepend(2);
        assertEquals(MyUnsortedList.of(2), list,"Prepend should add an element to the front of the list");
    }

    @Test
    void testAppend() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        assertEquals(MyUnsortedList.of(1), list,"Append should add an element to the end of the list");
        list.append(2);
        assertEquals(MyUnsortedList.of(1, 2), list,"Append should add an element to the end of the list");
    }

    @Test
    void testInsert() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.insert(1, 0);
        assertEquals(MyUnsortedList.of(1), list,"Inserting at index 0 should add an element to the front of the list");
        list.insert(2, 0);
        assertEquals(MyUnsortedList.of(2, 1), list,"Inserting at index 0 should add an element to the front of the list");
        list.insert(3, 1);
        assertEquals(MyUnsortedList.of(2, 3, 1), list,"Inserting at index 1 should add an element to the middle of the list");
    }

    @Test
    void testInsert2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, -1), "Inserting at a negative index should throw an exception");
    }

    @Test
    void testInsert3() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, 10), "Inserting at an index greater than the size should throw an exception");
    }

    @Test
    void testRemove() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        list.remove(1);
        assertEquals(MyUnsortedList.of(1, 3), list,"Remove should remove an element at the specified index");
        list.remove(0);
        assertEquals(MyUnsortedList.of(3), list,"Remove should remove an element at the specified index");
        list.remove(0);
        assertEquals(MyUnsortedList.of(), list,"Remove should remove an element at the specified index");
    }

    @Test
    void testRemove2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1);
        list.remove(0);
        assertEquals(MyUnsortedList.of(), list,"Remove should remove an element at the specified index");
    }

    @Test
    void testRemove3() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0), "Removing from an empty list should throw an exception");
    }

    @Test
    void testPopLast() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals(3, list.popLast(), "Pop last should remove the last element");
        assertEquals(2, list.popLast(), "Pop last should remove the last element");
        assertEquals(1, list.popLast(), "Pop last should remove the last element");
        assertEquals(0, list.size(), "Pop last should remove the last element");
    }

    @Test
    void testPopLast2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1);
        assertEquals(1, list.popLast(), "Pop last should remove the last element");
    }

    @Test()
    void testPopLast3() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertThrows(EmptyListException.class, list::popLast, "Pop last on an empty list should throw an exception");

    }

    @Test()
    void testPop() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals(1, list.pop(), "Pop should remove the first element");
        assertEquals(2, list.pop(), "Pop should remove the first element");
        assertEquals(3, list.pop(), "Pop should remove the first element");
    }

    @Test()
    void testPop2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertThrows(EmptyListException.class, list::pop, "Pop on an empty list should throw an exception");
    }

    @Test
    void testToString() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", list.toString(), "toString should return a string representation of the list");
    }

    @Test
    void testToString2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals("MyUnsortedList { size = 0, [] }", list.toString(), "toString should return a string representation of the list");
    }
}