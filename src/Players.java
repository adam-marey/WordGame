public class Players extends Person {
    private int money;

    public Players(String firstName, String lastName) {
        super(firstName, lastName);
        this.money = 1000;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return super.getFirstName() + " has $" + money;
    }
}
