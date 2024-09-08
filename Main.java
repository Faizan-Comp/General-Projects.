import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MyGenericClass<Integer,Integer> myInt = new MyGenericClass<>(1,2);
        MyGenericClass<Double,Double> myDouble = new MyGenericClass<>(3.14,1.13);
        //MyGenericClass<Character,Character> myChar = new MyGenericClass<>('@','$');
        //MyGenericClass<String,Character> myString = new MyGenericClass<>("Hello",'_');


        System.out.println(myInt.getValue());
        System.out.println(myDouble.getValue());
        //System.out.println(myChar.getValue());
        //System.out.println(myString.getValue());

    }
}