package _2016year.Wrapper;

/**
 * Created by lcz on 2016/11/12.
 */
public class Decorate implements Component {
    private Component component;

    public Decorate(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
