package other;

public class Phone {

    private final int identifier;
    private final String phoneNumber;

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
