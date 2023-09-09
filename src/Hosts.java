public class Hosts {
    private String firstName;
    private String lastName;
    private String gamePhrase;

    public Hosts(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setGamePhrase(String gamePhrase) {
        this.gamePhrase = gamePhrase;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
