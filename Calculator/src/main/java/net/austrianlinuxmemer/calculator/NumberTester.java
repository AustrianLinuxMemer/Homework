package net.austrianlinuxmemer.calculator;

public class NumberTester {
    NumberTest oddTester;
    NumberTest primeTester;
    public NumberTester(String fileName) {

    }
    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }
    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }
}
