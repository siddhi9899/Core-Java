// A Java program to demonstrate simple lambda expressions
import java.util.ArrayList;
import java.util.function.Consumer;
class TestLambdaArrayList
{
    public static void main(String args[])
    {
        // Creating an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

 		Consumer<Integer> cons = (Integer n) -> System.out.println(n);

        // Using lambda expression to print all elements
        // of arrL
        //arrL.forEach(n -> System.out.println(n));
        arrL.forEach(cons);

        // Using lambda expression to print even elements
        // of arrL
        arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); });
    }
}