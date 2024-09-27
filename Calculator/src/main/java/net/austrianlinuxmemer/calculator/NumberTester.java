package net.austrianlinuxmemer.calculator;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NumberTester {
    NumberTest oddTester;
    NumberTest primeTester;
    NumberTest palindromeTester;
    List<Case> cases;
    public NumberTester(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            this.cases = reader.lines().skip(1).map(Case::new).toList();
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }
    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }
    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }
    public void testFile() {}
    public static class Case {
        public Case(String caseString) throws NumberFormatException, IndexOutOfBoundsException {
            String[] numbers = caseString.split(" ");
            this.mode = Integer.parseInt(numbers[0]);
            this.number = Integer.parseInt(numbers[1]);
        }
        int mode;
        int number;
    }
}
