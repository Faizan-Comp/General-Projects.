import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for(int i = 0; i < 10000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        startTime = System.nanoTime();
        //linkedList.get(0); --LinkedList is Slower.
        //linkedList.get(500000); -- LinkedList is much Slower.
        //linkedList.get(999999); -- LinkedList is much Slower.
        //linkedList.remove(0); -- LinkedList is much Faster.
        //linkedList.remove(500000); -- LinkedList is Slower.
        //linkedList.remove(999999); -- LinkedList is Slower.
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        //arrayList.get(0); -- ArrayList is Faster.
        ///arrayList.get(500000); -- ArrayList is much Faster.
        //arrayList.get(999999); -- ArrayList is much Faster.
        //arrayList.remove(0); -- ArrayList is much Slower.
        //arrayList.remove(500000); -- ArrayList is Faster.
        //arrayList.remove(999999); -- ArrayList is Faster.
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList:\t" + elapsedTime + " ns");
    }
}