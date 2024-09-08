import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> foods = new ArrayList<>();
        foods.add("Apple");
        foods.add("Banana");
        foods.add("Bread");
        foods.add("Cake");
        foods.add("Pizza");

        /*
        To iterate through the collection, use a while loop or an enhanced for loop with
        the condition of has String [Enhanced For] or hasNext() [While Loop].
         */
        for (String food : foods) {
            System.out.println(food);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(48);
        numbers.add(3473);
        numbers.add(1234);
        numbers.add(-309);

        Iterator<Integer> it = numbers.iterator();

        while(it.hasNext()) {
            int i = it.next();
            if(i > 0) {
                System.out.println(i);
            }
            else if(i < 0) {
                it.remove();
            }
        }
        System.out.println(numbers);
    }
}