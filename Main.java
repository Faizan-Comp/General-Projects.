import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*
        The most simple and common type of list, an Array List.
         */
         ArrayList<String> people = new ArrayList<String>();

         people.add("John");
         people.add("Dave");
         people.add("Jack");

         people.remove("Dave");
         people.remove(1);

         if (people.contains("John")) {
             System.out.println("John is in the list.");
         }

         if (people.isEmpty()) {
             System.out.println("Nothing is in the list.");
         }

         people.clear();

         /*
         Linked list. The difference between it and an array list is that elements are stored as
         nodes that connect its previous node and the next.
          */

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(0);
        list.remove(Integer.valueOf(3));
        list.clear();

    }
}