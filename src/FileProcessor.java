import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                if(!(line.isEmpty())){
                    //as long as the line isn't empty, make a reversed string array of line
                    //then make array back into string to check which operation it contains
                    //as well as to split the string into and array to create
                    //2 linked lists (between the op)
                    line = line.replaceAll("\\s+", "");
                    String[] revline = returnReversedArray(line);
                    String revstr = String.join("", revline);
                    if(revstr.contains("+")){
                        //run addition
                        String[] newrevstr = revstr.split("\\+");
                        String revline1 = newrevstr[0];
                        String revline2 = newrevstr[1];
                        String[] rev1 = revline1.split("");
                        String[] rev2 = revline2.split("");
                        LinkedList LL1 = addToList(rev1);
                        LinkedList LL2 = addToList(rev2);
                        LinkedList add = Addition(LL2, LL1);
                        System.out.println(printLinkedList(LL2) + " + " + printLinkedList(LL1) + " = " + printLinkedList(add));
                    }
                    else if(revstr.contains("*")){
                        //run multiplication
                        String[] newrevstr = revstr.split("\\*");
                        String revline1 = newrevstr[0];
                        String revline2 = newrevstr[1];
                        String[] rev1 = revline1.split("");
                        String[] rev2 = revline2.split("");
                        LinkedList LL1 = addToList(rev1);
                        LinkedList LL2 = addToList(rev2);
                        LinkedList mult = Multiplication(LL2, LL1);
                        System.out.println(printLinkedList(LL2) + " * " + printLinkedList(LL1) + " = " + printLinkedList(mult));
                    }
                    else if (revstr.contains("^")) {
                        //run power
                        String[] newrevstr = revstr.split("\\^");
                        String revline1 = newrevstr[0];
                        String revline2 = newrevstr[1];
                        String[] rev1 = revline1.split("");
                        String[] rev2 = revline2.split("");
                        LinkedList LL1 = addToList(rev1);
                        LinkedList LL2 = addToList(rev2);
                        LinkedList pow = Power(LL2, LL1);
                        System.out.println(printLinkedList(LL2) + " ^ " + printLinkedList(LL1) + " = " + printLinkedList(pow));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    public static String[] returnReversedArray(String nums){
        String[] temp = nums.split("");

        String[] res = new String[temp.length];
        int counter = 0;
        for(int j = temp.length-1; j >= 0; j--){
            res[counter] = temp[j];
            counter++;
        }
        return res;
    }


    public static String printOneLine(String[] nums){
        String res = "";
        for(String num : nums){
            res += num;
        }
        return res;
    }

    public static LinkedList addToList(String[] nums){
        LinkedList res = new LinkedList();
        for(String num : nums){
            if(num.equals("0") || num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4") || num.equals("5") || num.equals("5") || num.equals("6") || num.equals("7") || num.equals("8") || num.equals("9")){
                int temp = Integer.valueOf(num);
                res.insertNode(temp);
            }
        }
        return res;
    }

    public static String printLinkedList(LinkedList nums){
        String res = "";
        Node current = nums.getHead();
        while(!(current.getNext() == null)){
            res += Integer.toString(current.getData());
            //res += " ";
            current = current.getNext();
        }
        res += Integer.toString(current.getData());
        String finalres = new StringBuffer(res).reverse().toString();
        return finalres;
    }

    public static LinkedList Addition(LinkedList list1, LinkedList list2){
        LinkedList res = new LinkedList();
        while(list1.size() != list2.size()){
            if(list1.size() > list2.size()){
                list2.insertNode(0);
            }
            else if(list2.size() > list1.size()){
                list1.insertNode(0);
            }
        }
        Node curr1 = list1.getHead();
        Node curr2 = list2.getHead();
        while(curr1.getNext() != null){
            int temp = curr1.getData() + curr2.getData();
            if(temp < 10){
                res.insertNode(temp);
            } else{
                if(curr1.getNext() == null){
                    list1.insertNode(0);
                    list2.insertNode(0);
                }
                temp -= 10;
                res.insertNode(temp);
                curr1.getNext().setData(curr1.getNext().getData()+1);
            }
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }

        int temp = curr1.getData() + curr2.getData();
        if(temp < 10){
            res.insertNode(temp);
        } else{
            if(curr1.getNext() == null){
                list1.insertNode(0);
                list2.insertNode(0);
            }
            temp -= 10;
            res.insertNode(temp);
            curr1.getNext().setData(curr1.getNext().getData()+1);
            res.insertNode(curr1.getNext().getData());
        }
        return res;
    }

    public static LinkedList multHelper(int one, int two){
        int i = 1;
        LinkedList res = new LinkedList();
        LinkedList temp = new LinkedList();
        res.insertNode(one);
        temp.insertNode(one);
        while(i < two){
            res = Addition(res, temp);
            i++;
        }
        return res;
    }

    public static LinkedList Multiplication(LinkedList list1, LinkedList list2){
        LinkedList res = new LinkedList();

        Node curr1 = list1.getHead();
        for(int i = 0; i < list1.size(); i++){
            Node curr2 = list2.getHead();
            LinkedList temp = new LinkedList();
            int carry = 0;
            for(int j = 0; j < list2.size(); j++){
                int mult = Integer.valueOf(printLinkedList(multHelper(curr1.getData(), curr2.getData())));
                carry = mult / 10;
                mult %= 10;
                temp.insertNode(mult);
                curr2 = curr2.getNext();
            }
            if(carry != 0){
                temp.insertNode(carry);
            }
            for(int k = 0; k < i; k++){
                temp.addtoFront(0);
            }
            res = Addition(res, temp);
            curr1 = curr1.getNext();
        }
        return res;
    }

    public static long powerHelper(long x, long n){
        if(n == 0){
            return 1;
        } else if(n == 1){
            return x;
        }

        if(n % 2 == 0){
            long temp = powerHelper(x, n / 2);
            return temp * temp;
        } else{
            long temp = powerHelper(x, (n - 1) / 2);
            return x * temp * temp;
        }
    }

    public static LinkedList Power(LinkedList list1, LinkedList list2){
        long x = Integer.valueOf(printLinkedList(list1));
        long n = Integer.valueOf(printLinkedList(list2));
        long temp = powerHelper(x, n);
        String str = String.valueOf(temp);
        String[] str2 = returnReversedArray(str);
        LinkedList res = addToList(str2);
        return res;
    }

    public static int listToNum(LinkedList nums){
        String temp = "";
        Node current = nums.getHead();
        while(current.getNext() != null){
            temp += String.valueOf(current.getData());
            current = current.getNext();
        }
        temp += String.valueOf(current.getData());
        return Integer.valueOf(temp);
    }
}
