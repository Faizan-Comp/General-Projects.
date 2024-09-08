public class Main {
    public static void main(String[] args) {

        Rabbit rabbit = new Rabbit();
        Hawk hawk = new Hawk();
        Fish fish = new Fish();
        fish.hunt();
        fish.flee();
        hawk.hunt();
        rabbit.flee();

    }
}