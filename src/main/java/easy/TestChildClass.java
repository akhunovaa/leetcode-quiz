package easy;

public class TestChildClass extends TestParentClass{

    @Override
    public void doSomethingTest(ParentClass parentClass) {
        System.out.println("Do something with parent class...");
    }
}
