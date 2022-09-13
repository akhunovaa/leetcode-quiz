package other;

public class MobilePhone extends Phone {

    private final String station;

    public MobilePhone(int identifier, String phoneNumber) {
        super(identifier, phoneNumber);
        this.station = null;
    }

    public MobilePhone(int identifier, String phoneNumber, String station) {
        super(identifier, phoneNumber);
        this.station = station;
    }

}
