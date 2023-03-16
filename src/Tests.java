import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void testReturnReversedArray() {
        String str = "7654321";
        String[] expected = {"1", "2", "3", "4", "5", "6", "7"};
        FileProcessor.returnReversedArray(str);
        assertEquals(FileProcessor.returnReversedArray(str), expected);
    }

    @Test
    public void testPrintOneLine() {
        String[] str = {"1", "2", "3", "4"};
        String expected = "1234";
        assertEquals(FileProcessor.printOneLine(str), expected);
    }

    @Test
    public void testAddtoListandPrintLinkedList() {
        String[] str = {"1", "2", "3", "4"};
        LinkedList expected = new LinkedList();
        expected.insertNode(1);
        expected.insertNode(2);
        expected.insertNode(3);
        expected.insertNode(4);
        String test = FileProcessor.printLinkedList(FileProcessor.addToList(str)); //1 2 3 4
        assertEquals(test, FileProcessor.printLinkedList(expected));
    }

    @Test
    public void testListtoNum(){
        LinkedList test = new LinkedList();
        test.insertNode(5);
        test.insertNode(0);
        test.insertNode(1);
        assertEquals(FileProcessor.listToNum(test), 501);
    }

    @Test
    public void testAddition1(){
        LinkedList l1 = new LinkedList();
        l1.insertNode(1);
        LinkedList l2 = new LinkedList();
        l2.insertNode(1);
        LinkedList expected = new LinkedList();
        expected.insertNode(2);
        String test = FileProcessor.printLinkedList(FileProcessor.Addition(l1, l2));
        assertEquals(test, "2");
    }

    @Test
    public void testAddition2(){
        LinkedList l1 = new LinkedList();
        l1.insertNode(2); //12
        l1.insertNode(1);
        LinkedList l2 = new LinkedList();
        l2.insertNode(9);
        String test = FileProcessor.printLinkedList(FileProcessor.Addition(l1, l2));
        assertEquals(test, "21");
        System.out.println(test);
    }

    @Test
    public void testMultiplication1(){
        LinkedList l1 = new LinkedList();
        l1.insertNode(0);
        l1.insertNode(2); //20
        LinkedList l2 = new LinkedList();
        l2.insertNode(5);
        String test = FileProcessor.printLinkedList(FileProcessor.Multiplication(l1, l2));
        assertEquals(test, "100");
        System.out.println(test);
    }

    @Test
    public void testMultiplication2(){
        LinkedList l1 = new LinkedList();
        l1.insertNode(0);
        l1.insertNode(0);
        l1.insertNode(1); //20
        LinkedList l2 = new LinkedList();
        l2.insertNode(5);
        String test = FileProcessor.printLinkedList(FileProcessor.Multiplication(l1, l2));
        assertEquals(test, "500");
        System.out.println(test);
    }

    @Test
    public void testPower1(){
        LinkedList l1 = new LinkedList();
        l1.insertNode(2);
        LinkedList l2 = new LinkedList();
        l2.insertNode(5);
        String test = FileProcessor.printLinkedList(FileProcessor.Power(l1, l2));
        assertEquals(test, "32");
        System.out.println(test);
    }

    @Test
    public void testPower2(){
        LinkedList l1 = new LinkedList();
        l1.insertNode(2);
        LinkedList l2 = new LinkedList();
        l2.insertNode(0);
        l2.insertNode(4);
        String test = FileProcessor.printLinkedList(FileProcessor.Power(l1, l2));
        assertEquals(test, "1099511627776");
        System.out.println(test);
    }

}
