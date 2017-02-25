package _2016year.Wrapper;

/**
 * Created by lcz on 2016/11/12.
 */
public class TestWrapper {
    public static void main(String[] args) {
        Component component = new ConcreteDecorate1(
                new ConcreteDecorate2(new ConcreteComponent()));
           component.doSomething();
    }
}
