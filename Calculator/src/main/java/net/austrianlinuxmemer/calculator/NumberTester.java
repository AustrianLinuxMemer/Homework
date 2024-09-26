package net.austrianlinuxmemer.calculator;

public class NumberTester {
    NumberTest oddTester;
    NumberTest primeTester;
    NumberTest palindromeTester;
    public NumberTester(String fileName) {

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
}
