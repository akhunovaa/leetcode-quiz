package other;

public class Phone {

    private int identifier;
    private String phoneNumber;

    public Phone(int identifier, String phoneNumber) {
        this.identifier = identifier;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "identifier=" + identifier +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
