package net.austrianlinuxmemer.calculator;

import java.util.List;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> strings = List.of(args);
        strings.forEach((String s) -> System.out.println(s));
    }
}
