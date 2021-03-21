package interview.thirteen;

public enum Values {

    A(1), B(2), C(3);

    Values(int i) {
        System.out.print(i);
    }

    static {
        System.out.print("static");
    }
}
