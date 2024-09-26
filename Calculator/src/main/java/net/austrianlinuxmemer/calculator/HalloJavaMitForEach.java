package net.austrianlinuxmemer.calculator;

import java.util.List;
import java.util.function.Consumer;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> strings = List.of(args);
        strings.forEach((String s) -> System.out.println(s));
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach(System.out::println);
    }
}
