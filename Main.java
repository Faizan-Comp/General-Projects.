public class Main {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'A', 'B', 'C', 'D', 'E', 'F'};
        String[] stringArray = {"A", "B", "C", "D", "E", "F"};

        /*
        To be able to iterate through the array / print it, we need to create specific enhanced
        for loops for every array. It's a long, arduous process.
         */

        //displayArray(intArray);
        //displayArray(doubleArray);
        //displayArray(charArray);
        //displayArray(stringArray);

        System.out.println(getFirstElement(intArray));
        System.out.println(getFirstElement(doubleArray));
        System.out.println(getFirstElement(charArray));
        System.out.println(getFirstElement(stringArray));

    }

    /*
    Rather than doing all of these methods, instead, we use a "generic" method.
    It is usually called T.
    To create a generic method, you add <X> before the return type, where X is anything.
     */

    public static <T> void displayArray(T[] array) {

        for(T x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static <T> T getFirstElement(T[] array) {
        return array[0];
    }
}