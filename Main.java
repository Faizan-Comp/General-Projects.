import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Animal animal;
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to create a cat object (1) or a Dog object (2)?");
        int choice = s.nextInt();
        if (choice == 1) {
            animal = new Dog();
            animal.speak();
        }
        else if(choice == 2) {
            animal = new Cat();
            animal.speak();
        }
        else {
            animal = new Animal();
            animal.speak();
        }
    }
}