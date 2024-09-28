package net.austrianlinuxmemer.calculator;

import net.austrianlinuxmemer.calculator.calculators.ComplexCalculator;
import net.austrianlinuxmemer.calculator.calculators.RationalCalculator;
import net.austrianlinuxmemer.calculator.calculators.VectorCalculator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Usage: calculator <-c | -r | -v> <-a | -s | -m | -d> num1_a num1_b num2_a num2_b");
            System.exit(2);
        }
        if (args[0].equals("-v") && (args[1].equals("-m") || args[1].equals("-d"))) {
            System.out.printf("The combination out of %s and %s is not supported", args[0], args[1]);
            System.exit(2);
        }
        Optional<AbstractCalculator> potentialCalculator = Optional.empty();
        Optional<String> PotentialNumberOutputFormat = Optional.empty();
        switch(args[0]) {
            case "-c":
                potentialCalculator = Optional.of(new ComplexCalculator());
                PotentialNumberOutputFormat = Optional.of("%f + %fi\n");
                break;
            case "-r":
                potentialCalculator = Optional.of(new RationalCalculator());
                PotentialNumberOutputFormat = Optional.of("%f / %f\n");
                break;
            case "-v":
                potentialCalculator = Optional.of(new VectorCalculator());
                PotentialNumberOutputFormat = Optional.of("(%f , %f)\n");
                break;
            default:
                System.out.println("The requested calculator does not exist");
                System.exit(2);
                break;
        }
        Optional<Number> potentialNumberA = Optional.empty();
        Optional<Number> potentialNumberB = Optional.empty();
        try {
            potentialNumberA = Optional.of(new Number(Double.parseDouble(args[2]), Double.parseDouble(args[3])));
            potentialNumberB = Optional.of(new Number(Double.parseDouble(args[4]), Double.parseDouble(args[5])));
        } catch (NumberFormatException e) {
            System.out.println("One or more numbers couldn't be parsed");
            System.exit(2);
        }
        AbstractCalculator calculator = potentialCalculator.get();
        Number a = potentialNumberA.get();
        Number b = potentialNumberB.get();
        String outputFormat = PotentialNumberOutputFormat.get();
        try {
            switch (args[1]) {
                case "-a":
                    printNumber(calculator.add(a, b), outputFormat);
                    System.exit(0);
                    break;
                case "-s":
                    printNumber(calculator.subtract(a, b), outputFormat);
                    System.exit(0);
                    break;
                case "-m":
                    printNumber(calculator.multiply(a, b), outputFormat);
                    System.exit(0);
                    break;
                case "-d":
                    printNumber(calculator.divide(a, b), outputFormat);
                    System.exit(0);
                    break;
                default:
                    System.out.println("The operation does not exist");
                    System.exit(2);
            }
        } catch (ArithmeticException e) {
            System.out.println("The operation couldn't be executed, it triggered an ArithmeticException");
            System.exit(2);
        }
    }
    private static void printNumber(Number number, String format) {
        System.out.printf(format, number.getA(), number.getB());
    }
}
