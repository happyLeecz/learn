package _2016year.Wrapper;

/**
 * Created by lcz on 2016/11/12.
 */
public class ConcreteDecorate2 extends Decorate {

    public ConcreteDecorate2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doSomethingElse();
    }
    public void doSomethingElse(){
        System.out.println("CCCCCCCCCCCCCC");
    }
}
