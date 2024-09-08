enum Planet{
    MERCURY(1, 1282820),
    VENUS(2, 282828),
    EARTH(3, 122),
    MARS(4, 22999),
    JUPITER(5, 282.2902),
    SATURN(6, 289282),
    URANUS(7, 22882),
    NEPTUNE(8, 77777),
    PLUTO(9, 99999);

    int number;
    double age;
    Planet(int number, double age){
        this.number = number;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {

        Planet myPlanet = Planet.EARTH;
        Live(myPlanet);
    }

    static void Live(Planet myPlanet) {
        switch(myPlanet) {
            case EARTH:
                System.out.println("You can live here.");
                System.out.println("This is planet number " + myPlanet.number +
                        " with an age of " + myPlanet.age);
            break;
            default:
                System.out.println("You can't live here.");
                System.out.println("This is planet number " + myPlanet.number +
                        " with an age of " + myPlanet.age);
            break;
        }
    }
}