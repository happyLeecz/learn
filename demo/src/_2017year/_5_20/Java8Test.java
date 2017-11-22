package _2017year._5_20;

import java.time.Clock;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by lcz on 2017/5/20.
 */
public class Java8Test {

    public static void main(String[] args) {
        Predicate<String> predicate = (str) -> str.length()>3;
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get().getClass().toString());
        Consumer<String> consumer = (str)-> System.out.println(str.substring(2));
        consumer.accept("123");
        Optional<String> optional = Optional.of("123");
        optional.isPresent();
        optional.get();
        optional.orElse("321");
        List<String> list = new ArrayList<>();
        list.stream().sorted().reduce((s1,s2)->s1+"#"+s2);
        Map<Integer,String> map = new HashMap<>();
//        map.computeIfAbsent();
//        map.computeIfPresent();
//        map.remove();
//        map.getOrDefault();
//        map.merge();

        Clock

    }
}
