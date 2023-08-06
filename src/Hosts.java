public class Hosts extends Person {
    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void randomizeNum() {
        Numbers.generateNumber();
        System.out.println("Generated random number for testing: " + Numbers.getRandomNum());
    }
}
